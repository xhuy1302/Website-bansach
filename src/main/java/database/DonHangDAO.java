package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;

public class DonHangDAO implements DAOInterface<DonHang>
{
	private final JDBCUtil connectionPool = JDBCUtil.getInstance();

	@Override
	public ArrayList<DonHang> selectAll()
	{
		ArrayList<DonHang> list = new ArrayList<>();
		try
		{
			Connection        con = connectionPool.getConnection("selectAll");
			String            sql = "SELECT * FROM DonHang";
			PreparedStatement st  = con.prepareStatement(sql);
			ResultSet         rs  = st.executeQuery();

			while (rs.next())
			{
				KhachHang khachhang = new KhachHang(rs.getString("makhachhang"), null, null, null, sql, sql, sql, sql, null, sql, sql, false, null);
				DonHang   donHang   = new DonHang(rs.getString("madonhang"), khachhang, rs.getString("diachimuahang"), rs.getString("diachinhanhang"), rs.getString("trangthai"), rs.getString("hinhthucthanhtoan"), rs.getString("trangthaithanhtoan"),
				        rs.getDouble("sotiendathanhtoan"), rs.getDouble("sotienconthieu"), rs.getDate("ngaydathang"), rs.getDate("ngaygiaohang"));
				list.add(donHang);
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
	public DonHang selectById(DonHang t)
	{
		DonHang donHang = null;
		try
		{
			Connection        con = connectionPool.getConnection("selectById");
			String            sql = "SELECT * FROM DonHang WHERE madonhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getMadonhang());
			ResultSet rs = st.executeQuery();

			if(rs.next())
			{
				KhachHang khachhang = new KhachHang(rs.getString("makhachhang"), null, null, null, sql, sql, sql, sql, null, sql, sql, false, null);
				donHang = new DonHang(rs.getString("madonhang"), khachhang, rs.getString("diachimuahang"), rs.getString("diachinhanhang"), rs.getString("trangthai"), rs.getString("hinhthucthanhtoan"), rs.getString("trangthaithanhtoan"),
				        rs.getDouble("sotiendathanhtoan"), rs.getDouble("sotienconthieu"), rs.getDate("ngaydathang"), rs.getDate("ngaygiaohang"));
			}
			connectionPool.closeConnection(con, "selectById");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return donHang;
	}

	@Override

	public int insert(DonHang t)
	{
		int ketqua = 0;
		try
		{
			// Kết nối với cơ sở dữ liệu
			Connection con = connectionPool.getConnection("insert");

			String sql = "INSERT INTO DonHang (madonhang, makhachhang, diachimuahang, diachinhanhang, trangthai, " + "hinhthucthanhtoan, trangthaithanhtoan, sotiendathanhtoan, sotienconthieu, ngaydathang, ngaygiaohang) "
			        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMadonhang());
			st.setString(2, t.getKhachhang().getMakhachhang());
			st.setString(3, t.getDiachimuahang());
			st.setString(4, t.getDiachinhanhang());
			st.setString(5, t.getTrangthai());
			st.setString(6, t.getHinhthucthanhtoan());
			st.setString(7, t.getTrangthaithanhtoan());
			st.setDouble(8, t.getSotiendathanhtoan());
			st.setDouble(9, t.getSotienconthieu());

			// Kiểm tra nếu ngaygiaohang là null, nếu có thì gán ngày hiện tại
			Date ngayDatHang  = (t.getNgaydathang() != null) ? new java.sql.Date(t.getNgaydathang().getTime()) : null;
			Date ngayGiaoHang = (t.getNgaygiaohang() != null) ? new java.sql.Date(t.getNgaygiaohang().getTime()) : null;

			st.setDate(10, ngayDatHang);
			st.setDate(11, ngayGiaoHang);

			// Thực thi câu lệnh
			ketqua = st.executeUpdate();

			// Đóng kết nối
			connectionPool.closeConnection(con, "insert");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(DonHang t)
	{
		int ketqua = 0;
		try
		{
			Connection con = connectionPool.getConnection("update");

			String            sql = "UPDATE DonHang SET makhachhang = ?, diachimuahang = ?, diachinhanhang = ?, trangthai = ?, " + "hinhthucthanhtoan = ?, trangthaithanhtoan = ?, sotiendathanhtoan = ?, sotienconthieu = ?, "
			        + "ngaydathang = ?, ngaygiaohang = ? WHERE madonhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getKhachhang().getMakhachhang());
			st.setString(2, t.getDiachimuahang());
			st.setString(3, t.getDiachinhanhang());
			st.setString(4, t.getTrangthai());
			st.setString(5, t.getHinhthucthanhtoan());
			st.setString(6, t.getTrangthaithanhtoan());
			st.setDouble(7, t.getSotiendathanhtoan());
			st.setDouble(8, t.getSotienconthieu());
			st.setDate(9, (Date) t.getNgaydathang());
			st.setDate(10, (Date) t.getNgaygiaohang());
			st.setString(11, t.getMadonhang());

			ketqua = st.executeUpdate();
			connectionPool.closeConnection(con, "update");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(DonHang t)
	{
		int ketqua = 0;
		try
		{
			Connection con = connectionPool.getConnection("delete");

			String            sql = "DELETE FROM DonHang WHERE madonhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getMadonhang());
			ketqua = st.executeUpdate();
			connectionPool.closeConnection(con, "delete");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr)
	{
		int count = 0;
		try
		{
			Connection        con = connectionPool.getConnection("deleteAll");
			String            sql = "DELETE FROM DonHang WHERE madonhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);

			for (DonHang donHang : arr)
			{
				st.setString(1, donHang.getMadonhang());
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
	public int insertAll(ArrayList<DonHang> arr)
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
