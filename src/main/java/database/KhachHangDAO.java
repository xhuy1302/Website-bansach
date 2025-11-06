package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang>
{
	private final JDBCUtil connectionPool = JDBCUtil.getInstance();

	public ArrayList<KhachHang> data = new ArrayList<>();

	public ArrayList<KhachHang> selectAll20()
	{
		ArrayList<KhachHang> resultList = new ArrayList<>();
		Connection           con        = null;

		try
		{
			con = connectionPool.getConnection("selectAll");
			String            sql = "SELECT * FROM KhachHang LIMIT 20 OFFSET 0";
			PreparedStatement st  = con.prepareStatement(sql);
			ResultSet         rs  = st.executeQuery();

			while (rs.next())
			{
				KhachHang kh = new KhachHang(rs.getString("makhachhang"), rs.getString("tendangnhap"), rs.getString("matkhau"), rs.getString("hovaten"), rs.getString("gioitinh"), rs.getString("diachi"), rs.getString("diachinhanhang"),
				        rs.getString("diachimuahang"), rs.getDate("ngaysinh"), rs.getString("sodienthoai"), rs.getString("email"), rs.getBoolean("dangkynhanbantin"), rs.getString("role"), rs.getString("duongdananh"));
				resultList.add(kh);
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
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
		}

		return resultList;
	}

	@Override
	public ArrayList<KhachHang> selectAll()
	{
		ArrayList<KhachHang> resultList = new ArrayList<>();
		Connection           con        = null;

		try
		{
			con = connectionPool.getConnection("selectAll");
			String            sql = "SELECT * FROM KhachHang";
			PreparedStatement st  = con.prepareStatement(sql);
			ResultSet         rs  = st.executeQuery();

			while (rs.next())
			{
				KhachHang kh = new KhachHang(rs.getString("makhachhang"), rs.getString("tendangnhap"), rs.getString("matkhau"), rs.getString("hovaten"), rs.getString("gioitinh"), rs.getString("diachi"), rs.getString("diachinhanhang"),
				        rs.getString("diachimuahang"), rs.getDate("ngaysinh"), rs.getString("sodienthoai"), rs.getString("email"), rs.getBoolean("dangkynhanbantin"), rs.getString("role"), rs.getString("duongdananh"));
				resultList.add(kh);
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
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
		}

		return resultList;
	}

	@Override
	public KhachHang selectById(KhachHang khachHang)
	{
		KhachHang  kh  = null;
		Connection con = null;

		try
		{
			con = connectionPool.getConnection("selectByID");
			String            sql = "SELECT * FROM KhachHang WHERE makhachhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, khachHang.getMakhachhang());
			ResultSet rs = st.executeQuery();

			if(rs.next())
			{
				kh = new KhachHang(rs.getString("makhachhang"), rs.getString("tendangnhap"), rs.getString("matkhau"), rs.getString("hovaten"), rs.getString("gioitinh"), rs.getString("diachi"), rs.getString("diachinhanhang"),
				        rs.getString("diachimuahang"), rs.getDate("ngaysinh"), rs.getString("sodienthoai"), rs.getString("email"), rs.getBoolean("dangkynhanbantin"), rs.getString("role"), rs.getString("duongdananh"));
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "selectById");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return kh;
	}

	public KhachHang selectByIDandPassword(KhachHang khachHang)
	{
		KhachHang  kh  = null;
		Connection con = null;

		try
		{
			con = connectionPool.getConnection("selectByIdandPassword");
			String            sql = "SELECT * FROM KhachHang WHERE tendangnhap = ? and matkhau = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, khachHang.getTendangnhap());
			st.setString(2, khachHang.getMatkhau());
			ResultSet rs = st.executeQuery();

			if(rs.next())
			{
				kh = new KhachHang(rs.getString("makhachhang"), rs.getString("tendangnhap"), rs.getString("matkhau"), rs.getString("hovaten"), rs.getString("gioitinh"), rs.getString("diachi"), rs.getString("diachinhanhang"),
				        rs.getString("diachimuahang"), rs.getDate("ngaysinh"), rs.getString("sodienthoai"), rs.getString("email"), rs.getBoolean("dangkynhanbantin"), rs.getString("role"), rs.getString("duongdananh"));
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "selectByIDandPassword");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return kh;
	}

	@Override
	public int insert(KhachHang kh)
	{
		int        result = 0;
		Connection con    = null;

		try
		{
			con = connectionPool.getConnection("insert");
			String            sql = "INSERT INTO KhachHang (makhachhang, tendangnhap, matkhau, hovaten, gioitinh, diachi, diachinhanhang, diachimuahang, ngaysinh, sodienthoai, email, dangkynhanbantin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);

			st.setString(1, kh.getMakhachhang());
			st.setString(2, kh.getTendangnhap());
			st.setString(3, kh.getMatkhau());
			st.setString(4, kh.getHovaten());
			st.setString(5, kh.getGioitinh());
			st.setString(6, kh.getDiachi());
			st.setString(7, kh.getDiachinhanhang());
			st.setString(8, kh.getDiachimuahang());
			st.setDate(9, (Date) kh.getNgaysinh());
			st.setString(10, kh.getSodienthoai());
			st.setString(11, kh.getEmail());
			st.setBoolean(12, kh.isDangKyNhanBangTin());

			result = st.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "insert");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public int insertdangky(KhachHang kh)
	{
		int        result = 0;
		Connection con    = null;

		try
		{
			con = connectionPool.getConnection("insertdangky");
			String            sql = "INSERT INTO KhachHang (makhachhang, tendangnhap, matkhau, hovaten,email) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);

			st.setString(1, kh.getMakhachhang());
			st.setString(2, kh.getTendangnhap());
			st.setString(3, kh.getMatkhau());
			st.setString(4, kh.getHovaten());
			st.setString(5, kh.getGioitinh());

			st.setString(6, kh.getEmail());

			result = st.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "insertdangky");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arr)
	{
		int        count = 0;
		Connection con   = null;

		try
		{
			con = connectionPool.getConnection("insertAll");
			String            sql = "INSERT INTO KhachHang (makhachhang, tendangnhap, matkhau, hovaten, gioitinh, diachi, diachinhanhang, diachimuahang, ngaysinh, sodienthoai, email, dangkynhanbantin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);

			for (KhachHang kh : arr)
			{
				st.setString(1, kh.getMakhachhang());
				st.setString(2, kh.getTendangnhap());
				st.setString(3, kh.getMatkhau());
				st.setString(4, kh.getHovaten());
				st.setString(5, kh.getGioitinh());
				st.setString(6, kh.getDiachi());
				st.setString(7, kh.getDiachinhanhang());
				st.setString(8, kh.getDiachimuahang());
				st.setDate(9, (Date) kh.getNgaysinh());
				st.setString(10, kh.getSodienthoai());
				st.setString(11, kh.getEmail());
				st.setBoolean(12, kh.isDangKyNhanBangTin());
				count += st.executeUpdate();
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "insertAll");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return count;
	}

	@Override
	public int delete(KhachHang kh)
	{
		int        result = 0;
		Connection con    = null;

		try
		{
			con = connectionPool.getConnection("delete");
			String            sql = "DELETE FROM KhachHang WHERE makhachhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, kh.getMakhachhang());
			result = st.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "delete");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr)
	{
		int        count = 0;
		Connection con   = null;

		try
		{
			con = connectionPool.getConnection("deleteAll");
			String            sql = "DELETE FROM KhachHang WHERE makhachhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);

			for (KhachHang kh : arr)
			{
				st.setString(1, kh.getMakhachhang());
				count += st.executeUpdate();
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "deleteAll");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return count;
	}

	@Override
	public int update(KhachHang kh)
	{
		int        result = 0;
		Connection con    = null;

		try
		{
			con = connectionPool.getConnection("update");
			String            sql = "UPDATE KhachHang SET tendangnhap = ?, matkhau = ?, hovaten = ?, gioitinh = ?, diachi = ?, diachinhanhang = ?, diachimuahang = ?, ngaysinh = ?, sodienthoai = ?, email = ?, dangkynhanbantin = ? , role = ? WHERE makhachhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);

			st.setString(1, kh.getTendangnhap());
			st.setString(2, kh.getMatkhau());
			st.setString(3, kh.getHovaten());
			st.setString(4, kh.getGioitinh());
			st.setString(5, kh.getDiachi());
			st.setString(6, kh.getDiachinhanhang());
			st.setString(7, kh.getDiachimuahang());
			st.setDate(8, (Date) kh.getNgaysinh());
			st.setString(9, kh.getSodienthoai());
			st.setString(10, kh.getEmail());
			st.setBoolean(11, kh.isDangKyNhanBangTin());
			st.setString(12, kh.getRole());
			st.setString(13, kh.getMakhachhang());

			result = st.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "update");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public int update2(KhachHang kh)
	{
		int        result = 0;
		Connection con    = null;

		try
		{
			con = connectionPool.getConnection("update");
			String            sql = "UPDATE KhachHang SET tendangnhap = ?, matkhau = ?, sodienthoai = ?, email = ?, role = ? WHERE makhachhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);

			st.setString(1, kh.getTendangnhap());
			st.setString(2, kh.getMatkhau());
			st.setString(3, kh.getSodienthoai());
			st.setString(4, kh.getEmail());
			st.setString(5, kh.getRole());
			st.setString(6, kh.getMakhachhang());

			result = st.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "update");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public int updateClient(KhachHang kh)
	{
		int        result = 0;
		Connection con    = null;

		try
		{
			con = connectionPool.getConnection("updateClient");
			String            sql = "UPDATE KhachHang SET  hovaten = ?,gioitinh = ? , diachi = ?, diachinhanhang = ?,  ngaysinh = ?,sodienthoai = ?, email = ? WHERE makhachhang = ?";
			PreparedStatement st  = con.prepareStatement(sql);

			st.setString(1, kh.getHovaten());
			st.setString(2, kh.getGioitinh());
			st.setString(3, kh.getDiachi());
			st.setString(4, kh.getDiachinhanhang());
			st.setDate(5, (Date) kh.getNgaysinh());
			st.setString(6, kh.getSodienthoai());
			st.setString(7, kh.getEmail());
			st.setString(8, kh.getMakhachhang());

			result = st.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "update");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public int updateImage(KhachHang t)
	{
		int ketQua = 0;
		try
		{
			// Bước 1: tạo kết nối đến CSDL
			Connection con = connectionPool.getConnection("updateimg");

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE khachhang SET duongdananh = ? WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getDuongdananh());
			st.setString(2, t.getMakhachhang());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			connectionPool.closeConnection(con, "updateimg");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public boolean changePassword(KhachHang kh)
	{
		int        kq  = 0;
		Connection con = null;
		try
		{
			// Bước 1: tạo kết nối đến CSDL
			con = connectionPool.getConnection("updateClient");

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE KhachHang SET  matkhau = ? WHERE makhachhang = ?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, kh.getMatkhau());
			st.setString(2, kh.getMakhachhang());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			kq = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + kq + " dòng bị thay đổi!");

			// Bước 5:
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "update");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return kq > 0;
	}

	public boolean kiemTraTenDangNhap(String tenDangNhap)
	{
		boolean    ketQua = false;
		Connection con    = null;

		try
		{
			// Bước 1: Lấy kết nối từ Connection Pool
			con = connectionPool.getConnection("kiemTraTenDangNhap");

			// Bước 2: Tạo đối tượng statement
			String            sql = "SELECT * FROM KhachHang WHERE tendangnhap = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, tenDangNhap);

			// Bước 3: Thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4: Kiểm tra kết quả trả về
			if(rs.next())
			{
				ketQua = true;
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			// Bước 5: Trả lại kết nối về Connection Pool
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "kiemTraTenDangNhap");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return ketQua;
	}

	public int[] getAccountStatisticsByMonth()
	{
		int[]  monthlyStats = new int[12];                                                                                                                   // Mảng để lưu số tài khoản cho mỗi tháng
		String sql          = "SELECT MONTH(created_at) AS month, COUNT(*) AS count " + "FROM khachhang " + "GROUP BY MONTH(created_at) " + "ORDER BY month";
		try (Connection conn = connectionPool.getConnection("bdc"); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery())
		{

			while (rs.next())
			{
				int month = rs.getInt("month") - 1; // Lấy tháng (0-based index)
				int count = rs.getInt("count");
				monthlyStats[month] = count; // Lưu số tài khoản vào mảng
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return monthlyStats;
	}

	public KhachHang selectByIdCl(String makhachhang)
	{
		KhachHang         kh   = null;
		Connection        con  = null;
		PreparedStatement stmt = null;
		ResultSet         rs   = null;

		try
		{
			// Lấy kết nối từ connection pool
			con = connectionPool.getConnection("selectById");

			// SQL query để lấy thông tin khách hàng theo mã khách hàng
			String sql = "SELECT * FROM KhachHang WHERE makhachhang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, makhachhang); // Gán giá trị cho tham số

			rs = stmt.executeQuery();

			// Kiểm tra kết quả trả về
			if(rs.next())
			{
				// Khởi tạo đối tượng KhachHang và gán dữ liệu từ ResultSet
				kh = new KhachHang(rs.getString("makhachhang"), rs.getString("tendangnhap"), rs.getString("matkhau"), rs.getString("hovaten"), rs.getString("gioitinh"), rs.getString("diachigiaohang"), rs.getString("diachinhanhang"),
				        rs.getString("diachi"), rs.getDate("ngaysinh"), rs.getString("sodienthoai"), rs.getString("email"), rs.getBoolean("dangkynhantin"), rs.getString("role"), rs.getString("duongdananh"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(rs != null)
			{
				try
				{
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try
				{
					connectionPool.closeConnection(con, "selectById");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return kh;
	}

}
