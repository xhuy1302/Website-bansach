package clientController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clientModel.GioHang;
import clientModel.GioHangClient;
import model.SanPham;

@WebServlet("/DeleteGioHang")
public class DeleteGioHang extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public DeleteGioHang()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String productId = request.getParameter("productId");

		HttpSession         session = request.getSession();
		List<GioHangClient> cart    = (List<GioHangClient>) session.getAttribute("gioHangList");

		if(cart != null)
		{
			cart.removeIf(item -> item.getMasanpham().equals(productId)); // Xóa sản phẩm khỏi giỏ hàng
			session.setAttribute("gioHangList", cart); // Cập nhật lại giỏ hàng trong session
		}

		// Sau khi xóa, chuyển hướng lại về trang giỏ hàng
		// response.sendRedirect(request.getContextPath() + "/giohang.jsp");
		request.getRequestDispatcher("/Homepage/GioHang.jsp").forward(request, response);
	}
}
