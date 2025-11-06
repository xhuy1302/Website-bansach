package clientController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;

@WebServlet("/ManageKhachHangClient")
public class ManageKhachHangClient extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ManageKhachHangClient()
	{
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		KhachHangDAO khachHangDAO = new KhachHangDAO();

		// Lấy các tham số từ form
		String makhachhang    = request.getParameter("makhachhang");
		String hovaten        = request.getParameter("hovaten");
		String email          = request.getParameter("email");
		String sodienthoai    = request.getParameter("sodienthoai");
		String diachi         = request.getParameter("diachi");
		String matkhau        = request.getParameter("matkhau");
		String tendangnhap    = request.getParameter("tendangnhap");
		String gioitinh       = request.getParameter("gioitinh");
		String diachinhanhang = request.getParameter("diachinhanhang");
		String diachimuahang  = request.getParameter("diachimuahang");
		String dangkynhantin  = request.getParameter("dangkynhantin");
		String role           = request.getParameter("role");
		String ngaysinhStr    = request.getParameter("ngaysinh");

		if(hovaten != null && gioitinh != null && diachi != null && diachinhanhang != null && sodienthoai != null && email != null)
		{
			// Chuyển đổi ngày sinh từ String sang java.util.Date
			Date ngaysinh = null;
			try
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				ngaysinh = sdf.parse(ngaysinhStr);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				request.setAttribute("message", "Định dạng ngày sinh không hợp lệ.");
				request.getRequestDispatcher("/Homepage/EditClient.jsp").forward(request, response);
				return; // Dừng nếu có lỗi
			}

			// Chuyển đổi java.util.Date sang java.sql.Date
			java.sql.Date sqlNgaysinh = new java.sql.Date(ngaysinh.getTime());

			// Lấy khách hàng từ session để cập nhật thông tin
			HttpSession session   = request.getSession();
			KhachHang   khachHang = (KhachHang) session.getAttribute("KhachHang");

			// Cập nhật thông tin khách hàng bằng các setter
			khachHang.setHovaten(hovaten);
			khachHang.setGioitinh(gioitinh);
			khachHang.setNgaysinh(sqlNgaysinh);
			khachHang.setEmail(email);
			khachHang.setSodienthoai(sodienthoai);
			khachHang.setDiachi(diachi);
			khachHang.setDiachinhanhang(diachinhanhang);
			khachHang.setDiachimuahang(diachimuahang);
			khachHang.setTendangnhap(tendangnhap);
			khachHang.setMatkhau(matkhau);
			khachHang.setRole(role);

			// Cập nhật khách hàng vào cơ sở dữ liệu
			int result = khachHangDAO.updateClient(khachHang);

			if(result > 0)
			{
				// Cập nhật lại khách hàng trong session
				session.setAttribute("KhachHang", khachHang);
				request.setAttribute("message", "Cập nhật tài khoản thành công.");
			}
			else
			{
				request.setAttribute("message", "Không thể cập nhật tài khoản.");
			}

			// Chuyển hướng về ProfileClient.jsp sau khi cập nhật thành công
			response.sendRedirect(request.getContextPath() + "/Homepage/DangNhap.jsp");
		}
		else
		{
			request.setAttribute("message", "Vui lòng điền đầy đủ thông tin.");
			request.getRequestDispatcher("/Homepage/EditClient.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Nếu có cần thiết, có thể thêm code để lấy thông tin khách hàng từ cơ sở dữ liệu
		HttpSession session   = request.getSession();
		KhachHang   khachHang = (KhachHang) session.getAttribute("KhachHang");

		// Chuyển tiếp đến ProfileClient.jsp sau khi đảm bảo session đã được cập nhật
		response.sendRedirect(request.getContextPath() + "/Homepage/DangNhap.jsp");
	}

}
