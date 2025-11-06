// Tạo luồng để test Connection Pool

package database;

import java.sql.Connection;

public class ConnectionPoolTest
{
	public static int THREADS = 7;

	public static void main(String[] args)
	{
		Runnable task = () ->
		{
			try
			{
				JDBCUtil   pool = JDBCUtil.getInstance();
				Connection conn = pool.getConnection("TaskThread");

				// Thiết lập thời gian mỗi luồng sử dụng Connection
				Thread.sleep(2500);

				pool.closeConnection(conn, "TaskThread");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		};

		// Tạo đa luồng để test
		for (int i = 0; i < THREADS; i++)
		{
			new Thread(task).start();
		}
	}
}
