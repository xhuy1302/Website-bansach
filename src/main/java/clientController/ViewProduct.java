package clientController;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clientDatabase.ProductDAO;
import clientModel.Product;
import database.TheLoaiDAO;
import model.TheLoai;

@WebServlet("/Product")
public class ViewProduct extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ViewProduct()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ProductDAO    productDAO = new ProductDAO();
		List<Product> listP      = productDAO.selectAll();

		// Lấy danh sách sản phẩm từ cơ sở dữ liệu
		List<Product> list = productDAO.selectAll();
		System.out.println("Product List Size: " + list.size());
		for (Product p : list)
		{
			System.out.println(p);
		}

		List<Product> listnew = productDAO.getLatestProducts();
		for (Product p2 : listnew)
		{
			System.out.println(p2);
		}

		TheLoaiDAO theloaidao = new TheLoaiDAO();

		// Lấy list theloai tu co sở dữ liệu
		List<TheLoai> listT = theloaidao.selectAll();
		for (TheLoai t : listT)
		{
			System.out.print(t);
		}

		// Gắn danh sách vào request và chuyển tiếp tới JSP
		request.setAttribute("listnew", listnew);

		request.setAttribute("listT", listT);

		request.setAttribute("listP", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Homepage/Home.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
