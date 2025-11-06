package controller;

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

@WebServlet("/ManageSanPham")
public class ManageSanPham extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ManageSanPham()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Hiển thị danh sách sản phẩm
		ProductDAO    productDAO = new ProductDAO();
		List<Product> listsp     = productDAO.selectAll();

		// Chuyển tiếp đến trang JSP
		request.setAttribute("listsp", listsp);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Dashboard/Product.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String chucNang = request.getParameter("chucNang");

		if(chucNang == null || chucNang.isEmpty())
		{
			response.sendRedirect(request.getContextPath() + "/Dashboard/Product.jsp");
			return;
		}

		ProductDAO productDAO = new ProductDAO();

		switch (chucNang)
		{
			case "Xoa":
			{
				String idProductStr = request.getParameter("idProduct");
				if(idProductStr != null && !idProductStr.isEmpty())
				{
					try
					{
						int idProduct = Integer.parseInt(idProductStr);

						Product sp = new Product();
						sp.setIdProduct(idProduct);

						int result = productDAO.delete(sp);

						if(result > 0)
						{
							request.setAttribute("message", "Xóa sản phẩm thành công.");
							System.out.println("Del Success");
						}
						else
						{
							request.setAttribute("message", "Không thể xóa sản phẩm.");
							System.out.println("Del Failed");
						}
					}
					catch (NumberFormatException e)
					{
						request.setAttribute("message", "ID sản phẩm không hợp lệ.");
						System.out.println("Invalid product ID format");
					}
				}
				else
				{
					request.setAttribute("message", "ID sản phẩm không được để trống.");
					System.out.println("Product ID is missing");
				}
				break;
			}

			case "Sua":
			{
				String idProductStr    = request.getParameter("idProduct");
				String nameProduct     = request.getParameter("nameProduct");
				String priceProductStr = request.getParameter("priceProduct");
				String quantityStr     = request.getParameter("quantity");

				if(nameProduct != null && !nameProduct.isEmpty() && priceProductStr != null && !priceProductStr.isEmpty() && quantityStr != null && !quantityStr.isEmpty())
				{
					try
					{
						int    idProduct    = Integer.parseInt(idProductStr);
						double priceProduct = Double.parseDouble(priceProductStr);
						int    quantity     = Integer.parseInt(quantityStr);

						Product sp = new Product(idProduct, nameProduct, priceProduct, quantity);

						int result = productDAO.update(sp);

						if(result > 0)
						{
							request.setAttribute("message", "Cập nhật sản phẩm thành công.");
							System.out.println("Edit Success");
						}
						else
						{
							request.setAttribute("message", "Không thể cập nhật sản phẩm.");
							System.out.println("Edit Failed");
						}
					}
					catch (NumberFormatException e)
					{
						request.setAttribute("message", "Giá hoặc số lượng không hợp lệ.");
						System.out.println("Invalid price or quantity format");
					}
				}
				else
				{
					request.setAttribute("message", "Vui lòng điền đầy đủ thông tin sản phẩm.");
					System.out.println("Missing required product information");
				}
				break;
			}

			case "Them":
			{
				String nameProduct     = request.getParameter("nameProduct");
				String priceProductStr = request.getParameter("priceProduct");
				String quantityStr     = request.getParameter("quantity");

				if(nameProduct != null && !nameProduct.isEmpty() && priceProductStr != null && !priceProductStr.isEmpty() && quantityStr != null && !quantityStr.isEmpty())
				{
					try
					{
						int    idProduct    = 0;
						double priceProduct = Double.parseDouble(priceProductStr);
						int    quantity     = Integer.parseInt(quantityStr);

						Product sp = new Product(idProduct, nameProduct, priceProduct, quantity);

						int result = productDAO.insert(sp);

						if(result > 0)
						{
							request.setAttribute("message", "Thêm sản phẩm mới thành công.");
							System.out.println("Add Success");
						}
						else
						{
							request.setAttribute("message", "Không thể thêm sản phẩm mới.");
							System.out.println("Add Failed");
						}
					}
					catch (NumberFormatException e)
					{
						request.setAttribute("message", "Giá hoặc số lượng không hợp lệ.");
						System.out.println("Invalid price or quantity format");
					}
				}
				else
				{
					request.setAttribute("message", "Vui lòng điền đầy đủ thông tin sản phẩm.");
					System.out.println("Missing required product information");
				}
				break;
			}

			default:
			{
				System.out.println("Chức năng không hợp lệ: " + chucNang);
				break;
			}
		}

		doGet(request, response);
	}
}
