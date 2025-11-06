package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia>
{
	private final JDBCUtil connectionPool = JDBCUtil.getInstance();

	@Override
	public int insert(TacGia t)
	{
		int KetQua = 0;
		try
		{
			Connection        con = connectionPool.getConnection("insert");
			String            sql = "INSERT INTO TacGia (matacgia, tentacgia, ngaysinh, tieusu) VALUES (?, ?, ?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getMatacgia());
			st.setString(2, t.getTentacgia());
			st.setDate(3, (Date) t.getNgaysinh());
			st.setString(4, t.getTieusu());
			KetQua = st.executeUpdate();
			connectionPool.closeConnection(con, "insert");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return KetQua;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arr)
	{
		int count = 0;
		try
		{
			Connection        con = connectionPool.getConnection("insertAll");
			String            sql = "INSERT INTO TacGia (matacgia, tentacgia, ngaysinh, tieusu) VALUES (?, ?, ?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);
			for (TacGia t : arr)
			{
				st.setString(1, t.getMatacgia());
				st.setString(2, t.getTentacgia());
				st.setDate(3, (Date) t.getNgaysinh());
				st.setString(4, t.getTieusu());
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
	public int delete(TacGia t)
	{
		int KetQua = 0;
		try
		{
			Connection        con = connectionPool.getConnection("delete");
			String            sql = "DELETE FROM TacGia WHERE matacgia = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getMatacgia());
			KetQua = st.executeUpdate();
			connectionPool.closeConnection(con, "delete");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return KetQua;
	}

	@Override
	public int deleteAll(ArrayList<TacGia> arr)
	{
		int count = 0;
		try
		{
			Connection        con = connectionPool.getConnection("deleteAll");
			String            sql = "DELETE FROM TacGia WHERE matacgia = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			for (TacGia t : arr)
			{
				st.setString(1, t.getMatacgia());
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
	public int update(TacGia t)
	{
		int KetQua = 0;
		try
		{
			Connection con = connectionPool.getConnection("update");

			String            sql = "UPDATE TacGia SET tentacgia = ?, ngaysinh = ?, tieusu = ? WHERE matacgia = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getTentacgia());
			st.setDate(2, (Date) t.getNgaysinh());
			st.setString(3, t.getTieusu());
			st.setString(4, t.getMatacgia());

			KetQua = st.executeUpdate();

			connectionPool.closeConnection(con, "update");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return KetQua;
	}

	@Override
	public ArrayList<TacGia> selectAll()
	{
		ArrayList<TacGia> KetQua = new ArrayList<TacGia>();

		try
		{
			Connection con = connectionPool.getConnection("selectAll");

			String            sql = "SELECT * FROM TacGia";
			PreparedStatement st  = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next())
			{
				String maTacGia = rs.getString("matacgia");
				@SuppressWarnings("unused")
				String hoVaTen  = rs.getString("tentacgia");
				Date   ngaySinh = rs.getDate("ngaysinh");
				String tieuSu   = rs.getString("tieusu");

				TacGia tg = new TacGia(maTacGia, maTacGia, ngaySinh, tieuSu);
				KetQua.add(tg);
			}

			connectionPool.closeConnection(con, "selectAll");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return KetQua;
	}

	@Override
	public TacGia selectById(TacGia t)
	{
		TacGia KetQua = null;

		try
		{
			Connection con = connectionPool.getConnection("selectById");

			String            sql = "SELECT * FROM TacGia WHERE matacgia = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getMatacgia());

			ResultSet rs = st.executeQuery();

			if(rs.next())
			{
				String maTacGia = rs.getString("matacgia");
				String hoVaTen  = rs.getString("hovaten");
				Date   ngaySinh = rs.getDate("ngaysinh");
				String tieuSu   = rs.getString("tieusu");

				KetQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
			}

			connectionPool.closeConnection(con, "selectById");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return KetQua;
	}

	// test

	public static void main(String[] args)
	{
		TacGiaDAO tacGiaDAO = new TacGiaDAO();

		TacGia newTacGia = new TacGia("TG07", "Nguyễn Ngọc Hưng", Date.valueOf("2004-1-1"), "Tác giả nổi tiếng trong lĩnh vực văn học.");

		@SuppressWarnings("unused")
		int result = tacGiaDAO.insert(newTacGia);
	}
}
