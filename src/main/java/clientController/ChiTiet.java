package clientController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientDatabase.ProductDAO;
import clientModel.Product;

@WebServlet("/ChiTiet")
public class ChiTiet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ChiTiet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String     idProduct  = request.getParameter("pid");
		ProductDAO productdao = new ProductDAO();
		Product    p          = productdao.selectChiTietById(idProduct);
		request.setAttribute("ChiTiet", p);
		request.getRequestDispatcher("/Homepage/SanPham.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
