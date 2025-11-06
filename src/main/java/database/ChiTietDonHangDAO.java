package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ChiTietDonHang;
import model.DonHang;
import model.SanPham;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang>
{
	private final JDBCUtil connectionPool = JDBCUtil.getInstance();

	@Override
	public ArrayList<ChiTietDonHang> selectAll()
	{
		ArrayList<ChiTietDonHang> list = new ArrayList<>();
		try
		{
			Connection        con = connectionPool.getConnection("selectAll");
			String            sql = "SELECT * FROM ChiTietDonHang";
			PreparedStatement st  = con.prepareStatement(sql);
			ResultSet         rs  = st.executeQuery();

			while (rs.next())
			{
				DonHang        donhang = new DonHang(rs.getString("madonhang"), null, null, null, null, null, null, 0, 0, null, null);
				SanPham        sanpham = new SanPham();
				ChiTietDonHang chiTiet = new ChiTietDonHang(rs.getString("machitietdonhang"), donhang, sanpham, rs.getDouble("soluong"), rs.getDouble("giagoc"), rs.getDouble("giamgia"), rs.getDouble("giaban"), rs.getDouble("thuevat"),
				        rs.getDouble("tongtien"));
				list.add(chiTiet);
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
	public ChiTietDonHang selectById(ChiTietDonHang t)
	{
		ChiTietDonHang chiTiet = null;
		try
		{
			Connection        con = connectionPool.getConnection("selectById");
			String            sql = "SELECT * FROM ChiTietDonHang WHERE machitietdonhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getMachitietdonhang());
			ResultSet rs = st.executeQuery();

			if(rs.next())
			{
				DonHang donhang = new DonHang(rs.getString("madonhang"), null, null, null, null, null, null, 0, 0, null, null);
				SanPham sanpham = new SanPham(rs.getString("masanpham"), sql, null, 0, 0, 0, 0, 0, null, sql, sql);
				chiTiet = new ChiTietDonHang(rs.getString("machitietdonhang"), donhang, sanpham, rs.getDouble("soluong"), rs.getDouble("giagoc"), rs.getDouble("giamgia"), rs.getDouble("giaban"), rs.getDouble("thuevat"), rs.getDouble("tongtien"));
			}
			connectionPool.closeConnection(con, "selectById");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return chiTiet;
	}

	@Override
	public int insert(ChiTietDonHang t)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("insert");
			String            sql = "INSERT INTO ChiTietDonHang (machitietdonhang, madonhang, masanpham, soluong, giagoc, giamgia, giaban, thuevat, tongtien) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getMachitietdonhang());
			st.setString(2, t.getDonhang().getMadonhang());
			st.setString(3, t.getSanpham().getMasanpham());
			st.setDouble(4, t.getSoluong());
			st.setDouble(5, t.getGiagoc());
			st.setDouble(6, t.getGiamgia());
			st.setDouble(7, t.getGiaban());
			st.setDouble(8, t.getThuevat());
			st.setDouble(9, t.getTongtien());

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
	public int insertAll(ArrayList<ChiTietDonHang> arr)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("insertAll");
			String            sql = "INSERT INTO ChiTietDonHang (machitietdonhang, madonhang, masanpham, soluong, giagoc, giamgia, giaban, thuevat, tongtien) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);

			for (ChiTietDonHang chiTiet : arr)
			{
				st.setString(1, chiTiet.getMachitietdonhang());
				st.setString(2, chiTiet.getDonhang().getMadonhang());
				st.setString(3, chiTiet.getSanpham().getMasanpham());
				st.setDouble(4, chiTiet.getSoluong());
				st.setDouble(5, chiTiet.getGiagoc());
				st.setDouble(6, chiTiet.getGiamgia());
				st.setDouble(7, chiTiet.getGiaban());
				st.setDouble(8, chiTiet.getThuevat());
				st.setDouble(9, chiTiet.getTongtien());

				result += st.executeUpdate();
			}
			connectionPool.closeConnection(con, "insertAll");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(ChiTietDonHang t)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("delete");
			String            sql = "DELETE FROM ChiTietDonHang WHERE machitietdonhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getMachitietdonhang());
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
	public int deleteAll(ArrayList<ChiTietDonHang> arr)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("deleteAll");
			String            sql = "DELETE FROM ChiTietDonHang WHERE machitietdonhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);

			for (ChiTietDonHang chiTiet : arr)
			{
				st.setString(1, chiTiet.getMachitietdonhang());
				result += st.executeUpdate();
			}
			connectionPool.closeConnection(con, "deleteAll");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(ChiTietDonHang t)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("update");
			String            sql = "UPDATE ChiTietDonHang SET madonhang = ?, masanpham = ?, soluong = ?, giagoc = ?, giamgia = ?, " + "giaban = ?, thuevat = ?, tongtien = ? WHERE machitietdonhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getDonhang().getMadonhang());
			st.setString(2, t.getSanpham().getMasanpham());
			st.setDouble(3, t.getSoluong());
			st.setDouble(4, t.getGiagoc());
			st.setDouble(5, t.getGiamgia());
			st.setDouble(6, t.getGiaban());
			st.setDouble(7, t.getThuevat());
			st.setDouble(8, t.getTongtien());
			st.setString(9, t.getMachitietdonhang());

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
