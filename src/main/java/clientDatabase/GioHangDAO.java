package clientDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clientModel.GioHang;
import database.ConnectionPool;
import database.DAOInterface;
import database.JDBCUtil;

public class GioHangDAO implements DAOInterface<GioHang>
{
	private final JDBCUtil connectionPool = JDBCUtil.getInstance();

	public ArrayList<GioHang> data = new ArrayList<>();

	@Override
	public ArrayList<GioHang> selectAll()
	{
		ArrayList<GioHang> gioHangs = new ArrayList<>();
		Connection         con      = null;

		try
		{
			con = connectionPool.getConnection("selectAll");
			String            sql = "SELECT * FROM GioHangClient";
			PreparedStatement ps  = con.prepareStatement(sql);
			ResultSet         rs  = ps.executeQuery();

			while (rs.next())
			{
				GioHang gh = new GioHang();
				gh.setMasanpham(rs.getString("masanpham"));
				gh.setTensanpham(rs.getString("tensanpham"));
				gh.setSoluong(rs.getInt("soluong"));
				gh.setImage(rs.getString("image")); // Set the image property
				gioHangs.add(gh);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				connectionPool.closeConnection(con, "selectAll");
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		return gioHangs;
	}

	@Override
	public GioHang selectById(GioHang t)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(GioHang gh)
	{
		int        result = 0;
		Connection con    = null;

		try
		{
			con = connectionPool.getConnection("insert");
			String            sql = "INSERT INTO GioHangClient(masanpham, tensanpham, gia, soluong, image) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, gh.getMasanpham());
			st.setString(2, gh.getTensanpham());
			st.setDouble(3, gh.getGia());
			st.setInt(4, gh.getSoluong());
			st.setString(5, gh.getImage()); // Set the image

			result = st.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result; // Return the result of the insert operation
	}

	@Override
	public int insertAll(ArrayList<GioHang> arr)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(GioHang t)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<GioHang> arr)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GioHang t)
	{
		int ketqua = 0;
		try
		{
			Connection        con = connectionPool.getConnection("update");
			String            sql = "UPDATE GioHangClient SET tensanpham = ?, image = ?, gia = ?, soluong = ? WHERE masanpham = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getTensanpham()); // Cập nhật tên sản phẩm
			st.setString(2, t.getImage()); // Cập nhật hình ảnh
			st.setDouble(3, t.getGia()); // Cập nhật giá
			st.setInt(4, t.getSoluong()); // Cập nhật số lượng
			st.setString(5, t.getMasanpham()); // Điều kiện WHERE dựa vào mã sản phẩm

			ketqua = st.executeUpdate();
			connectionPool.closeConnection(con, "update");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ketqua; //
	}

}
