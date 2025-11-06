package database;

import java.sql.*;
import java.util.ArrayList;
import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>
{

	private final JDBCUtil connectionPool = JDBCUtil.getInstance();

	@Override
	public ArrayList<TheLoai> selectAll()
	{
		ArrayList<TheLoai> list = new ArrayList<>();
		try
		{
			Connection        con = connectionPool.getConnection("selectAll");
			String            sql = "SELECT * FROM TheLoai";
			PreparedStatement st  = con.prepareStatement(sql);
			ResultSet         rs  = st.executeQuery();

			while (rs.next())
			{
				TheLoai theLoai = new TheLoai(rs.getString("matheloai"), rs.getString("tentheloai"));
				list.add(theLoai);
			}
			connectionPool.closeConnection(con, "selectAll");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TheLoai selectById(TheLoai t)
	{
		TheLoai theLoai = null;
		try
		{
			Connection        con = connectionPool.getConnection("selectById");
			String            sql = "SELECT * FROM TheLoai WHERE matheloai = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getmatheloai());
			ResultSet rs = st.executeQuery();

			if(rs.next())
			{
				theLoai = new TheLoai(rs.getString("matheloai"), rs.getString("tentheloai"));
			}
			connectionPool.closeConnection(con, "selectById");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return theLoai;
	}

	@Override
	public int insert(TheLoai t)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("insert");
			String            sql = "INSERT INTO TheLoai (matheloai, tentheloai) VALUES (?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getmatheloai());
			st.setString(2, t.getmatheloai());

			result = st.executeUpdate();
			connectionPool.closeConnection(con, "insert");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertAll(ArrayList<TheLoai> arr)
	{
		int count = 0;
		try
		{
			Connection        con = connectionPool.getConnection("insertAll");
			String            sql = "INSERT INTO TheLoai (matheloai, tentheloai) VALUES (?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);

			for (TheLoai theLoai : arr)
			{
				st.setString(1, theLoai.getmatheloai());
				st.setString(2, theLoai.getmatheloai());
				count += st.executeUpdate();
			}
			connectionPool.closeConnection(con, "insertAll");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int delete(TheLoai t)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("delete");
			String            sql = "DELETE FROM TheLoai WHERE matheloai = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getmatheloai());

			result = st.executeUpdate();
			connectionPool.closeConnection(con, "delete");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteAll(ArrayList<TheLoai> arr)
	{
		int count = 0;
		try
		{
			Connection        con = connectionPool.getConnection("deleteAll");
			String            sql = "DELETE FROM TheLoai WHERE matheloai = ?";
			PreparedStatement st  = con.prepareStatement(sql);

			for (TheLoai theLoai : arr)
			{
				st.setString(1, theLoai.getmatheloai());
				count += st.executeUpdate();
			}
			connectionPool.closeConnection(con, "deleteAll");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int update(TheLoai t)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("update");
			String            sql = "UPDATE TheLoai SET tentheloai = ? WHERE matheloai = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getmatheloai());
			st.setString(2, t.getmatheloai());

			result = st.executeUpdate();
			connectionPool.closeConnection(con, "update");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
