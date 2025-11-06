package database;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool
{
	// Method lấy kết nối từ Connection Pool
	Connection getConnection(String objectName) throws SQLException, InterruptedException;

	// Method đóng kết nối khi đã sử dụng xong
	void closeConnection(Connection con, String objectName) throws SQLException;
}
