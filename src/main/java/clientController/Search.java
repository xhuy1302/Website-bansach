package clientController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientDatabase.ProductDAO;
import clientModel.Product;

@WebServlet("/Search")
public class Search extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public Search()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String        txtsearch  = request.getParameter("txt");              // lay duoc tt serch
		ProductDAO    productdao = new ProductDAO();
		List<Product> list       = productdao.selectProductByName(txtsearch);
		request.setAttribute("listP", list);
		request.getRequestDispatcher("/Homepage/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}