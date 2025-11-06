package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SanPham;
import model.TacGia;
import model.TheLoai;

public class SanPhamDAO implements DAOInterface<SanPham>
{
	private final JDBCUtil connectionPool = JDBCUtil.getInstance();

	@SuppressWarnings("unused")
	private static SanPham     SanPham;
	@SuppressWarnings("unused")
	private ArrayList<SanPham> data = new ArrayList<SanPham>();

	@Override
	public ArrayList<SanPham> selectAll()
	{
		ArrayList<SanPham> list = new ArrayList<>();
		try
		{
			Connection        con = connectionPool.getConnection("selectAll");
			String            sql = "SELECT * FROM SanPham";
			PreparedStatement st  = con.prepareStatement(sql);
			ResultSet         rs  = st.executeQuery();

			while (rs.next())
			{
				TacGia  tacGia  = new TacGia(rs.getString("matacgia"), null, null, null);
				TheLoai theLoai = new TheLoai(rs.getString("matheloai"), null);
				SanPham sp      = new SanPham(rs.getString("masanpham"), rs.getString("tensanpham"), tacGia, rs.getInt("namxuatban"), rs.getDouble("giaban"), rs.getDouble("gianhap"), rs.getDouble("giagoc"), rs.getInt("soluong"), theLoai,
				        rs.getString("ngonngu"), rs.getString("mota"));
				list.add(sp);
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
	public SanPham selectById(SanPham t)
	{
		SanPham sp = null;
		try
		{
			Connection        con = connectionPool.getConnection("selectById");
			String            sql = "SELECT * FROM SanPham WHERE masanpham = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getMasanpham());
			ResultSet rs = st.executeQuery();

			if(rs.next())
			{
				TacGia  tacGia  = new TacGia(rs.getString("matacgia"), null, null, null);
				TheLoai theLoai = new TheLoai(rs.getString("matheloai"), null);
				sp = new SanPham(rs.getString("masanpham"), rs.getString("tensanpham"), tacGia, rs.getInt("namxuatban"), rs.getDouble("giaban"), rs.getDouble("gianhap"), rs.getDouble("giagoc"), rs.getInt("soluong"), theLoai, rs.getString("ngonngu"),
				        rs.getString("mota"));
			}
			connectionPool.closeConnection(con, "selectById");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return sp;
	}

	@Override
	public int insert(SanPham t)
	{
		int ketqua = 0;
		try
		{
			// 1tạo kết nối cơ sở dự liệu
			Connection con = connectionPool.getConnection("insert");

			// 2 tạo câu lệnh statement
			String            sql = "insert into SanPham values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st  = con.prepareStatement(sql);
			//
			st.setString(1, t.getMasanpham());
			st.setString(2, t.getTensanpham());
			st.setString(3, t.getTacgia().getMatacgia());
			st.setInt(4, t.getNamxuatban());
			st.setDouble(5, t.getGiaban());
			st.setDouble(6, t.getGianhap());
			st.setDouble(7, t.getGiagoc());
			st.setInt(8, t.getSoluong());
			st.setString(9, t.getTheloai().getmatheloai());
			st.setString(10, t.getNgonngu());
			st.setString(11, t.getMota());
			ketqua = st.executeUpdate();

			connectionPool.closeConnection(con, "insert");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int insertAll(ArrayList<SanPham> arr)
	{
		int ketqua = 0;
		try
		{
			// buoc 1tạo kết nối cơ sở dữ liệu
			Connection con = connectionPool.getConnection("insertAll");

			// buoc 2 tạo đối tượng statement
			String            sql = "insert into SanPham values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st  = con.prepareStatement(sql);
			// buoc 3 lap qua tata ca cac phan tu va them tung cai
			for (SanPham sp : arr)
			{
				st.setString(1, sp.getMasanpham());
				st.setString(2, sp.getTensanpham());
				st.setString(3, sp.getTacgia().getMatacgia());
				st.setInt(4, sp.getNamxuatban());
				st.setDouble(5, sp.getGiaban());
				st.setDouble(6, sp.getGianhap());
				st.setDouble(7, sp.getGiagoc());
				st.setInt(8, sp.getSoluong());
				st.setString(9, sp.getTheloai().getmatheloai());
				st.setString(10, sp.getNgonngu());
				st.setString(11, sp.getMota());
				ketqua += st.executeUpdate();
				// buoc 4 đóng kết nối
				connectionPool.closeConnection(con, "insertAll");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ketqua;

	}

	@Override
	public int delete(SanPham sp)
	{
		int ketqua = 0;
		try
		{
			Connection        con = connectionPool.getConnection("delete");
			String            sql = "DELETE FROM SanPham WHERE masanpham = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, sp.getMasanpham());
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
	public int deleteAll(ArrayList<SanPham> arr)
	{
		int count = 0;
		try
		{
			Connection        con = connectionPool.getConnection("deleteAll");
			String            sql = "DELETE FROM SanPham WHERE masanpham = ?";
			PreparedStatement st  = con.prepareStatement(sql);

			for (SanPham sp : arr)
			{
				st.setString(1, sp.getMasanpham());
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
	public int update(SanPham t)
	{
		int ketqua = 0;
		try
		{
			Connection        con = connectionPool.getConnection("update");
			String            sql = "UPDATE SanPham SET tensanpham = ?, matacgia = ?, namxuatban = ?, giaban = ?, gianhap = ?, " + "giagoc = ?, soluong = ?, matheloai = ?, ngonngu = ?, mota = ? WHERE masanpham = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getTensanpham());
			st.setString(2, t.getTacgia().getMatacgia());
			st.setInt(3, t.getNamxuatban());
			st.setDouble(4, t.getGiaban());
			st.setDouble(5, t.getGianhap());
			st.setDouble(6, t.getGiagoc());
			st.setInt(7, t.getSoluong());
			st.setString(8, t.getTheloai().getmatheloai());
			st.setString(9, t.getNgonngu());
			st.setString(10, t.getMota());
			st.setString(11, t.getMasanpham());

			ketqua = st.executeUpdate();
			connectionPool.closeConnection(con, "update");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ketqua;
	}

}