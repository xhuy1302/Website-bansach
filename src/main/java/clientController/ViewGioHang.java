package clientController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clientModel.GioHangClient;

@WebServlet("/ViewGioHang")
public class ViewGioHang extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ViewGioHang()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			// Lấy giỏ hàng từ session
			HttpSession         session     = request.getSession();
			List<GioHangClient> gioHangList = (List<GioHangClient>) session.getAttribute("gioHangList");

			// Kiểm tra nếu giỏ hàng trống
			if(gioHangList == null || gioHangList.isEmpty())
			{
				request.setAttribute("error", "Giỏ hàng của bạn hiện tại trống.");
				request.getRequestDispatcher("/Homepage/Home.jsp").forward(request, response);
				return;
			}

			// Tính tổng giá trị của giỏ hàng
			double totalPrice    = 0;
			int    totalQuantity = 0; // Tổng số lượng sản phẩm trong giỏ hàng

			for (GioHangClient item : gioHangList)
			{
				totalPrice    += item.getGia() * item.getSoluong();
				totalQuantity += item.getSoluong();                // Cộng dồn số lượng sản phẩm
			}

			// Đưa danh sách giỏ hàng, tổng giá trị và tổng số lượng vào request
			request.setAttribute("gioHangList", gioHangList);
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("totalQuantity", totalQuantity); // Thêm tổng số lượng

			// Chuyển đến trang giỏ hàng
			request.getRequestDispatcher("/Homepage/GioHang.jsp").forward(request, response);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			request.setAttribute("error", "Không thể tải giỏ hàng.");
			request.getRequestDispatcher("/Homepage/Home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
