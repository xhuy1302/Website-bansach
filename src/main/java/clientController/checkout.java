package clientController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientModel.Product;

@WebServlet("/checkout")
public class checkout extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public checkout()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Product> gioHangList = (List<Product>) request.getSession().getAttribute("gioHangList");
		if(gioHangList != null)
		{
			request.setAttribute("gioHangListForCheckout", gioHangList);
		}
		response.sendRedirect("Homepage/ThanhToan.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
