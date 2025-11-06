package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KhachHangDAO;
import model.KhachHang;

@WebServlet("/Dashboard/Quanlytaikhoan")
public class Quanlytaikhoan extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public Quanlytaikhoan()
	{
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// Lấy chức năng từ tham số
		String chucNang = request.getParameter("chucNang");

		if(chucNang == null || chucNang.isEmpty())
		{
			// Assuming the correct path is relative to the web context
			response.sendRedirect(request.getContextPath() + "/Dashboard/Account.jsp");
			return;
		}

		// Khởi tạo DAO để xử lý DB
		KhachHangDAO khachHangDAO = new KhachHangDAO();

		switch (chucNang)
		{
			case "Xoa":
			{
				// Xử lý xóa tài khoản
				String makhachhang = request.getParameter("makhachhang");

				if(makhachhang != null)
				{
					KhachHang kh = new KhachHang();
					kh.setMakhachhang(makhachhang);

					int result = khachHangDAO.delete(kh);

					if(result > 0)
					{
						// Thông báo xóa thành công
						request.setAttribute("message", "Xóa tài khoản thành công.");
					}
					else
					{
						// Thông báo lỗi nếu không xóa được
						request.setAttribute("message", "Không thể xóa tài khoản.");
					}
				}
				// Chuyển hướng lại trang Account.jsp với thông báo
				request.getRequestDispatcher("/Dashboard/Account.jsp").forward(request, response);
				break;
			}
			case "Sua":
			{
				// Xử lý sửa tài khoản
				String makhachhang = request.getParameter("makhachhang");
				String tendangnhap = request.getParameter("tendangnhap");
				String matkhau     = request.getParameter("matkhau");
				String sodienthoai = request.getParameter("sodienthoai");
				String email       = request.getParameter("email");

				if(makhachhang != null && tendangnhap != null && matkhau != null && sodienthoai != null && email != null)
				{
					KhachHang kh = new KhachHang(makhachhang, tendangnhap, matkhau, sodienthoai, email);
					khachHangDAO.update(kh);
				}
				response.sendRedirect(request.getContextPath() + "/Dashboard/Account.jsp");
				break;
			}
			case "Them":
			{
				// Xử lý thêm tài khoản
				String makhachhang = request.getParameter("makhachhang");
				String tendangnhap = request.getParameter("tendangnhap");
				String matkhau     = request.getParameter("matkhau");
				String sodienthoai = request.getParameter("sodienthoai");
				String email       = request.getParameter("email");
				if(makhachhang != null && tendangnhap != null && matkhau != null && sodienthoai != null && email != null)
				{
					KhachHang kh = new KhachHang(makhachhang, tendangnhap, matkhau, sodienthoai, email);
					khachHangDAO.insert(kh);
				}
				response.sendRedirect(request.getContextPath() + "/Dashboard/Account.jsp");
				break;
			}
			default:
			{
				// Xử lý chức năng không hợp lệ
				System.out.println("Chức năng không hợp lệ: " + chucNang);
				response.sendRedirect(request.getContextPath() + "/Dashboard/Account.jsp");
				break;
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Chuyển hướng GET sang POST để xử lý
		doPost(request, response);
	}
}
