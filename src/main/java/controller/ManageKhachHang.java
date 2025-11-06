package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;

@WebServlet("/ManageKhachHang")
public class ManageKhachHang extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ManageKhachHang()
	{
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Hiển thị danh sách khách hàng
		KhachHangDAO    khachHangDAO = new KhachHangDAO();
		List<KhachHang> listkh       = khachHangDAO.selectAll();
		request.setAttribute("listkhp", listkh);

		// Chuyển tiếp đến trang JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Dashboard/Account.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String chucNang = request.getParameter("chucNang");

		if(chucNang == null || chucNang.isEmpty())
		{
			response.sendRedirect(request.getContextPath() + "/Dashboard/Account.jsp");
			return;
		}

		KhachHangDAO khachHangDAO = new KhachHangDAO();

		switch (chucNang)
		{
			case "Xoa":
			{
				String makhachhang = request.getParameter("makhachhang");

				if(makhachhang != null)
				{
					KhachHang kh = new KhachHang();
					kh.setMakhachhang(makhachhang);

					int result = khachHangDAO.delete(kh);

					if(result > 0)
					{
						request.setAttribute("message", "Xóa tài khoản thành công.");
						System.out.println("Del Success");
					}
					else
					{
						request.setAttribute("message", "Không thể xóa tài khoản.");
						System.out.println("Del Failed");
					}
				}
				break;
			}
			case "Sua":
			{
				String makhachhang    = request.getParameter("makhachhang");
				String hovaten        = request.getParameter("hovaten");
				String email          = request.getParameter("email");
				String sodienthoai    = request.getParameter("sodienthoai");
				String diachi         = request.getParameter("diachi");
				String matkhau        = request.getParameter("matkhau");
				String tendangnhap    = request.getParameter("tendangnhap");
				String gioitinh       = request.getParameter("gioitinh");
				String diachinhanhang = request.getParameter("diachinhanhang");
				String diachigiaohang = request.getParameter("diachigiaohang");
				String dangkynhantin  = request.getParameter("dangkynhantin");
				String role           = request.getParameter("role");
				String ngaysinhStr    = request.getParameter("ngaysinh");

				if(makhachhang != null && tendangnhap != null && matkhau != null && sodienthoai != null && email != null && role != null)
				{
					Date ngaysinh = null;
					try
					{
						// Chuyển đổi ngaysinh từ String sang Date
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày sinh
						ngaysinh = sdf.parse(ngaysinhStr);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					// Mã hóa mật khẩu trước khi lưu
					String matkhauMaHoa = MaHoa.maHoaMD5(matkhau);

					KhachHang kh     = new KhachHang(makhachhang, tendangnhap, matkhauMaHoa, hovaten, gioitinh, diachi, diachigiaohang, diachinhanhang, ngaysinh, sodienthoai, email, false, role);
					int       result = khachHangDAO.update2(kh);

					if(result > 0)
					{
						request.setAttribute("message", "Cập nhật tài khoản thành công.");
						System.out.println("Edit Success");
					}
					else
					{
						request.setAttribute("message", "Không thể cập nhật tài khoản.");
						System.out.println("Edit Failed");
					}
				}
				break;
			}
			case "Them":
			{
				String makhachhang = request.getParameter("makhachhang");
				String tendangnhap = request.getParameter("tendangnhap");
				String matkhau     = request.getParameter("matkhau");
				String sodienthoai = request.getParameter("sodienthoai");
				String email       = request.getParameter("email");

				if(makhachhang != null && tendangnhap != null && matkhau != null && sodienthoai != null && email != null)
				{
					// Mã hóa mật khẩu trước khi lưu
					String matkhauMaHoa = MaHoa.maHoaMD5(matkhau);

					KhachHang kh     = new KhachHang(makhachhang, tendangnhap, matkhauMaHoa, sodienthoai, email);
					int       result = khachHangDAO.insert(kh);

					if(result > 0)
					{
						request.setAttribute("message", "Thêm tài khoản mới thành công.");
						System.out.println("Add Success");
					}
					else
					{
						request.setAttribute("message", "Không thể thêm tài khoản mới.");
						System.out.println("Add Failed");
					}
				}
				break;
			}
			default:
			{
				System.out.println("Chức năng không hợp lệ: " + chucNang);
				break;
			}
		}

		// Quay lại trang danh sách tài khoản
		doGet(request, response);
	}
}
