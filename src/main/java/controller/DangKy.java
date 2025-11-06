package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;

@WebServlet(name = "Homepage/DangKy", urlPatterns =
{ "/dang-ky" })
public class DangKy extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public DangKy()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String tendangnhap     = request.getParameter("tendangnhap");
		String matkhau         = request.getParameter("matkhau");
		String nhaplaimatkhau  = request.getParameter("nhaplaimatkhau");
		String hovaten         = request.getParameter("hovaten");
		String gioitinh        = request.getParameter("gioitinh");
		String ngaysinh        = request.getParameter("ngaysinh");
		String diachikhachhang = request.getParameter("diachikhachhang");
		String diachimuahang   = request.getParameter("diachimuahang");
		String diachinhanhang  = request.getParameter("diachinhanhang");
		String dienthoai       = request.getParameter("dienthoai");
		String email           = request.getParameter("email");
		String dongy           = request.getParameter("dongy");
		String role            = request.getParameter("role");

		// Lưu thông tin vào request để giữ lại khi gặp lỗi
		request.setAttribute("tendangnhap", tendangnhap);
		request.setAttribute("matkhau", matkhau);
		request.setAttribute("nhaplaimatkhau", nhaplaimatkhau);
		request.setAttribute("hovaten", hovaten);
		request.setAttribute("gioitinh", gioitinh);
		request.setAttribute("ngaysinh", ngaysinh);
		request.setAttribute("diachikhachhang", diachikhachhang);
		request.setAttribute("diachimuahang", diachimuahang);
		request.setAttribute("diachinhanhang", diachinhanhang);
		request.setAttribute("dienthoai", dienthoai);
		request.setAttribute("email", email);
		request.setAttribute("dongy", dongy);

		String baoloi = "";

		// Kiểm tra mật khẩu
		if(!matkhau.equals(nhaplaimatkhau))
		{
			baoloi += "Mật khẩu không khớp. ";
		}

		// Kiểm tra tên đăng nhập đã tồn tại
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		if(khachHangDAO.kiemTraTenDangNhap(tendangnhap))
		{
			baoloi += "Tên đăng nhập đã tồn tại. ";
		}

		// Kiểm tra ngày sinh có hợp lệ hay không
		Date ngaySinhDate = null;
		if(ngaysinh != null && !ngaysinh.trim().isEmpty())
		{
			try
			{
				ngaySinhDate = Date.valueOf(ngaysinh); // Chuyển thành Date nếu hợp lệ
			}
			catch (IllegalArgumentException e)
			{
				baoloi += "Ngày sinh không hợp lệ. Định dạng phải là YYYY-MM-DD. ";
			}
		}
		else
		{
			baoloi += "Ngày sinh không được để trống. ";
		}

		request.setAttribute("baoloi", baoloi);
		String url = "";

		if(baoloi.length() > 0)
		{
			url = "/Homepage/DangKy.jsp";
		}
		else
		{
			// Mã hóa mật khẩu bằng MD5
			String matkhauMaHoa = MaHoa.maHoaMD5(matkhau);

			// Tạo đối tượng KhachHang và lưu vào cơ sở dữ liệu
			Random    rd          = new Random();
			String    makhachhang = System.currentTimeMillis() + rd.nextInt(1000) + "";
			KhachHang kh          = new KhachHang(makhachhang, tendangnhap, matkhauMaHoa, hovaten, gioitinh, diachikhachhang, diachinhanhang, diachimuahang, ngaySinhDate, dienthoai, email, false, role);
			khachHangDAO.insert(kh);

			url = "/Homepage/DangNhap.jsp"; // Đăng ký thành công, chuyển đến trang đăng nhập
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
