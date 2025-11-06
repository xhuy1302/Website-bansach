package clientController;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import clientDatabase.ProductDAO;
import clientModel.Product;

@WebServlet("/addProduct")
public class addProduct extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public addProduct()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ProductDAO productDAO = new ProductDAO();
		request.setAttribute("products", productDAO.selectAll());
		request.getRequestDispatcher("/Dashboard/Products.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String productId      = request.getParameter("masanpham");
		String productName    = request.getParameter("tensanpham");
		String priceString    = request.getParameter("giaban");
		String quantityString = request.getParameter("soluong");

		// Lấy file ảnh
		Part imagePart = request.getPart("hinhanh");

		// Kiểm tra xem các trường bắt buộc có bị bỏ trống không
		if(productName == null || productName.trim().isEmpty() || priceString == null || priceString.trim().isEmpty() || quantityString == null || quantityString.trim().isEmpty() || imagePart == null || imagePart.getSize() == 0)
		{
			response.getWriter().append("Please fill in all required fields.");
			return;
		}

		try
		{
			double price    = Double.parseDouble(priceString);
			int    quantity = Integer.parseInt(quantityString);

			String fileName   = imagePart.getSubmittedFileName();
			String uploadDir  = getServletContext().getRealPath("") + File.separator + "uploads";
			File   uploadFile = new File(uploadDir);

			if(!uploadFile.exists())
			{
				uploadFile.mkdir();
			}

			imagePart.write(uploadDir + File.separator + fileName);

			Product newProduct = new Product();
			if(productId != null && !productId.trim().isEmpty())
			{
				newProduct.setIdProduct(Integer.parseInt(productId)); // Set Product ID if provided
			}
			newProduct.setNameProduct(productName);
			newProduct.setPriceProduct(price);
			newProduct.setQuantity(quantity);
			newProduct.setImageProduct(fileName); // Lưu tên file ảnh vào đối tượng sản phẩm

			ProductDAO productDAO = new ProductDAO();
			int        result     = productDAO.insert(newProduct);

			if(result > 0)
			{
				// Truyền lại danh sách sản phẩm và hiển thị lên trang Products.jsp
				request.setAttribute("products", productDAO.selectAll());
				request.getRequestDispatcher("/Dashboard/Product.jsp").forward(request, response);
			}
			else
			{
				response.getWriter().append("Error occurred while adding product.");
			}
		}
		catch (NumberFormatException e)
		{
			response.getWriter().append("Invalid number format for price or quantity.");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			response.getWriter().append("An error occurred while uploading the image.");
		}
	}
}