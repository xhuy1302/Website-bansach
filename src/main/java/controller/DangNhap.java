package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;

@WebServlet("/dang-nhap")
public class DangNhap extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public DangNhap()
	{
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Always forward to the login page for GET requests
		RequestDispatcher rd = request.getRequestDispatcher("/Homepage/DangNhap.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Lấy thông tin đăng nhập từ form
		String tendangnhap = request.getParameter("tendangnhap");
		String matkhau     = request.getParameter("matkhau");
		String role        = request.getParameter("role");

		// Mã hóa mật khẩu bằng MD5
		String matkhauMaHoa = MaHoa.maHoaMD5(matkhau);

		// Tạo đối tượng KhachHang để kiểm tra
		KhachHang kh = new KhachHang();
		kh.setTendangnhap(tendangnhap);
		kh.setMatkhau(matkhauMaHoa); // Sử dụng mật khẩu đã mã hóa
		kh.setRole(role);

		// Sử dụng DAO để truy cập cơ sở dữ liệu
		KhachHangDAO khDAO     = new KhachHangDAO();
		KhachHang    khachhang = khDAO.selectByIDandPassword(kh);

		if(khachhang != null)
		{ // Đăng nhập thành công
			HttpSession session = request.getSession();
			session.setAttribute("KhachHang", khachhang);

			if("admin".equals(khachhang.getRole()))
			{
				// Chuyển hướng đến trang admin
				response.sendRedirect(request.getContextPath() + "/Dashboard/Index.jsp");
			}
			else
			{
				// Chuyển hướng đến trang chủ của người dùng
				response.sendRedirect(request.getContextPath() + "/Homepage/Home.jsp");
			}
		}
		else
		{ // Đăng nhập thất bại
			request.setAttribute("baoloi", "Tên đăng nhập hoặc mật khẩu không đúng");

			// Chuyển hướng lại trang đăng nhập
			RequestDispatcher rd = request.getRequestDispatcher("/Homepage/DangNhap.jsp");
			rd.forward(request, response);
		}
	}
}
