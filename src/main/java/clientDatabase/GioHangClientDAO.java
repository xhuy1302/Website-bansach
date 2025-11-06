package clientDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clientModel.GioHangClient;
import database.DAOInterface;
import database.JDBCUtil;

public class GioHangClientDAO implements DAOInterface<GioHangClient>
{
	private final JDBCUtil connectionPool = JDBCUtil.getInstance();

	@Override
	public ArrayList<GioHangClient> selectAll()
	{
		ArrayList<GioHangClient> list = new ArrayList<>();
		Connection               con  = null;
		try
		{
			con = connectionPool.getConnection("selectAll");
			String            sql = "SELECT * FROM GioHangClient";
			PreparedStatement ps  = con.prepareStatement(sql);
			ResultSet         rs  = ps.executeQuery();

			while (rs.next())
			{
				GioHangClient gioHang = new GioHangClient();
				gioHang.setMagiohang(rs.getInt("magiohang"));
				gioHang.setMasanpham(rs.getString("masanpham"));
				gioHang.setTensanpham(rs.getString("tensanpham"));
				gioHang.setSoluong(rs.getInt("soluong"));
				gioHang.setGia(rs.getInt("gia"));
				gioHang.setDatesanpham(rs.getDate("datesanpham"));
				gioHang.setImage(rs.getString("image"));
				list.add(gioHang);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public GioHangClient selectById(GioHangClient t)
	{
		GioHangClient gioHang = null;
		Connection    con     = null;
		try
		{
			con = connectionPool.getConnection("selectById");
			String            sql = "SELECT * FROM GioHangClient WHERE magiohang = ?";
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setInt(1, t.getMagiohang());
			ResultSet rs = ps.executeQuery();

			if(rs.next())
			{
				gioHang = new GioHangClient();
				gioHang.setMagiohang(rs.getInt("magiohang"));
				gioHang.setMasanpham(rs.getString("masanpham"));
				gioHang.setTensanpham(rs.getString("tensanpham"));
				gioHang.setSoluong(rs.getInt("soluong"));
				gioHang.setGia(rs.getInt("gia"));
				gioHang.setDatesanpham(rs.getDate("datesanpham"));
				gioHang.setImage(rs.getString("image"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return gioHang;
	}

	@Override
	public int insert(GioHangClient t)
	{
		Connection con = null;
		try
		{
			con = connectionPool.getConnection("insert");
			String            sql = "INSERT INTO GioHangClient (masanpham, tensanpham, soluong, gia, datesanpham, image) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setString(1, t.getMasanpham());
			ps.setString(2, t.getTensanpham());
			ps.setInt(3, t.getSoluong());
			ps.setInt(4, t.getGia());
			ps.setDate(5, new java.sql.Date(t.getDatesanpham().getTime()));
			ps.setString(6, t.getImage());

			return ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<GioHangClient> arr)
	{
		int count = 0;
		for (GioHangClient gioHang : arr)
		{
			count += insert(gioHang);
		}
		return count;
	}

	@Override
	public int delete(GioHangClient t)
	{
		Connection con = null;
		try
		{
			con = connectionPool.getConnection("delete");
			String            sql = "DELETE FROM GioHangClient WHERE magiohang = ?";
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setInt(1, t.getMagiohang());

			return ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<GioHangClient> arr)
	{
		int count = 0;
		for (GioHangClient gioHang : arr)
		{
			count += delete(gioHang);
		}
		return count;
	}

	@Override
	public int update(GioHangClient t)
	{
		Connection con = null;
		try
		{
			con = connectionPool.getConnection("update");
			String            sql = "UPDATE GioHangClient SET masanpham = ?, tensanpham = ?, soluong = ?, gia = ?, datesanpham = ?, image = ? WHERE magiohang = ?";
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setString(1, t.getMasanpham());
			ps.setString(2, t.getTensanpham());
			ps.setInt(3, t.getSoluong());
			ps.setInt(4, t.getGia());
			ps.setDate(5, new java.sql.Date(t.getDatesanpham().getTime()));
			ps.setString(6, t.getImage());
			ps.setInt(7, t.getMagiohang());

			return ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
}
