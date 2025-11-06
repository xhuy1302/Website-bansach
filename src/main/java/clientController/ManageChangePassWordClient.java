package clientController;

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

@WebServlet("/ManageChangePassWordClient")
public class ManageChangePassWordClient extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ManageChangePassWordClient()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String matkhauhientai    = request.getParameter("matkhauhientai");
		String matkhaumoi        = request.getParameter("matkhaumoi");
		String matkhaumoinhaplai = request.getParameter("matkhaumoinhaplai");

		String matkhauhientai_md5 = MaHoa.maHoaMD5(matkhauhientai);

		String baoLoi = "";
		HttpSession session = request.getSession();

		KhachHang khachHang = (KhachHang) session.getAttribute("KhachHang");
		if (khachHang == null)
		{
			// Xử lý khi đối tượng khachHang không có trong session
			baoLoi = "Bạn chưa đăng nhập vào hệ thống!";
			request.setAttribute("baoLoi", baoLoi);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Homepage/ChangePassword.jsp");
			rd.forward(request, response);
			return;
		}
		else
		{
			// Nếu khách hàng đã đăng nhập
			if (!matkhauhientai_md5.equals(khachHang.getMatkhau()))
			{
				baoLoi = "Mật khẩu hiện tại không chính xác!";
			}
			else
			{
				if (!matkhaumoi.equals(matkhaumoinhaplai))
				{
					baoLoi = "Mật khẩu nhập lại không khớp!";
				}
				else
				{
					// Mã hóa mật khẩu mới và cập nhật
					String matKhauMoi_md5 = MaHoa.maHoaMD5(matkhaumoi);
					khachHang.setMatkhau(matKhauMoi_md5);
					KhachHangDAO khd = new KhachHangDAO();

					if (khd.changePassword(khachHang))
					{
						// Đặt thông báo thành công vào session và chuyển hướng đến DangNhap.jsp
						session.setAttribute("successMessage", "Mật khẩu đã thay đổi thành công! Vui lòng đăng nhập lại.");
						session.removeAttribute("KhachHang"); // Đăng xuất người dùng
						response.sendRedirect(request.getContextPath() + "/Homepage/DangNhap.jsp");
						return;
					}
					else
					{
						baoLoi = "Quá trình thay đổi mật khẩu không thành công!";
					}
				}
			}
		}

		// Nếu có lỗi, chuyển tiếp về ChangePassword.jsp
		request.setAttribute("baoLoi", baoLoi);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Homepage/ChangePassword.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
