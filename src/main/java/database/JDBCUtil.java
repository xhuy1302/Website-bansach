package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUtil implements ConnectionPool
{
	private static final Logger logger = Logger.getLogger(JDBCUtil.class.getName());

	private final Queue<Connection> connectionPool;
	private static JDBCUtil         instance;

	// Bộ đếm số lượng Connection đang có trong Pool
	private int currentConnectionCount = 0;

	// Method khởi tạo, tạo kết nối với thông tin Database từ file Config
	private JDBCUtil()
	{
		connectionPool = new LinkedList<>();
		try
		{
			// Load driver
			Class.forName(DatabaseConfig.DB_DRIVER);

			// Khởi tạo Connection Pool với số lượng kết nối = MIN
			for (int i = 0; i < DatabaseConfig.DB_MIN_CONNECTIONS; i++)
			{
				addNewConnectionToPool();
			}
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * // Sử dụng Thread-Safe Singleton (Không hoạt động) public static JDBCUtil getInstance() { // Kiểm
	 * tra xem JDBCUtil đã được khởi tạo hay chưa if(instance == null) { // Gọi hàm khởi tạo JDBCUtil
	 * instance = new JDBCUtil(); }
	 * 
	 * // Trả về instance được khởi tạo (Nếu thoả mãn điều kiện) hoặc instance đã có sẵn return
	 * instance; }
	 */

	// Sử dụng Double-checked locking Singleton
	public static JDBCUtil getInstance()
	{
		// Kiểm tra xem JDBCUtil đã được khởi tạo hay chưa
		if(instance == null)
		{
			// Đồng bộ luồng để đảm bảo chỉ có một đối tượng JDBCUtil duy nhất
			synchronized (JDBCUtil.class)
			{
				// Sau khi đồng bộ, kiểm tra điều kiện lần 2 (Double-checked locking)
				if(instance == null)
				{
					// Gọi hàm khởi tạo JDBCUtil
					instance = new JDBCUtil();
				}
			}
		}

		// Trả về instance được khởi tạo (Nếu thoả mãn Double-checked locking) hoặc instance đã có sẵn
		return instance;
	}

	// Method thêm kết nối mới vào Connection Pool
	private void addNewConnectionToPool() throws SQLException
	{
		// Kiểm tra xem Connection Pool đã đầy hay chưa
		if(currentConnectionCount < DatabaseConfig.DB_MAX_CONNECTIONS)
		{
			// Nếu chưa đầy, tạo kết nối mới và thêm vào Pool
			Connection connection = DriverManager.getConnection(DatabaseConfig.CONNECTION_URL, DatabaseConfig.USER_NAME, DatabaseConfig.PASSWORD);
			connectionPool.add(connection);

			// Tăng bộ đếm
			currentConnectionCount++;
		}
	}

	@Override
	// Method lấy kết nối từ Connection Pool
	public synchronized Connection getConnection(String objectName) throws SQLException
	{
		// Điều kiện: Connection Pool không còn kết nối để lấy, Số lượng kết nối đã đạt tối đa
		while (connectionPool.isEmpty() && currentConnectionCount >= DatabaseConfig.DB_MAX_CONNECTIONS)
		{
			// Tạm dừng luồng cho đến khi có kết nối để lấy
			logger.log(Level.INFO, "{0} is waiting for a connection...", new Object[]
			{ objectName });
			try
			{
				// Tạm dừng luồng cho đến khi có thông báo (Từ Method closeConnection)
				wait();
			}
			catch (InterruptedException e)
			{
				// Ngắt luồng nếu xảy ra lỗi, trả lại kết nối NULL
				logger.info(objectName + " was interrupted while waiting for a connection.");
				Thread.currentThread().interrupt();
				return null;
			}
		}

		// Trong trường hợp Connection Pool không còn kết nối để lấy, và số lượng kết nối chưa đạt tối đa
		if(connectionPool.isEmpty() && currentConnectionCount < DatabaseConfig.DB_MAX_CONNECTIONS)
		{
			// Gọi method addNewConnectionToPool để thêm kết nối mới vào Connection Pool
			addNewConnectionToPool();
		}

		// Trong trường hợp CP vẫn còn kết nối để lấy, hoặc thêm kết nối mới vào CP thành công:
		// Trả về kết nối lấy từ Pool
		Connection connection = connectionPool.poll();
		logger.log(Level.INFO, "{0} obtained connection: {1}", new Object[]
		{ objectName, connection });
		return connection;
	}

	@Override
	// Method đóng kết nối khi đã sử dụng xong
	public synchronized void closeConnection(Connection con, String objectName) throws SQLException
	{
		// Nếu kết nối nhận được từ Method khả dụng
		if(con != null)
		{
			// Kiểm tra xem Connection Pool còn chỗ chứa kết nối không
			if(connectionPool.size() < DatabaseConfig.DB_MAX_CONNECTIONS)
			{
				// Nếu còn, trả lại kết nối về Pool
				connectionPool.add(con);
				logger.log(Level.INFO, "{0} released connection: {1}", new Object[]
				{ objectName, con });

				// Thông báo (Đến method getConnection) rằng đã có kết nối khả dụng
				notifyAll();
			}
			// Nếu Connection Pool không còn chỗ để chứa kết nối
			else
			{
				// Trực tiếp đóng kết nối thay vì trả về Pool & giảm bộ đếm
				con.close();
				currentConnectionCount--;
			}
		}
	}

	// Method đóng toàn bộ kết nối
	public synchronized void closeAllConnections()
	{
		// Lặp cho đến khi Connection Pool không còn kết nối nào nữa
		while (!connectionPool.isEmpty())
		{
			try
			{
				// Lấy kết nối ra khỏi Pool
				Connection conn = connectionPool.poll();

				// Nếu kết nối lấy ra không rỗng (Khả dụng)
				if(conn != null)
				{
					// Trực tiếp đóng kết nối & giảm bộ đếm
					conn.close();
					currentConnectionCount--;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}