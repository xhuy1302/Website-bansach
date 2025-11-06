package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DonHangDAO;
import model.DonHang;

@WebServlet("/ManageDonHang")
public class ManageDonHang extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ManageDonHang()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DonHangDAO    donHangDAO = new DonHangDAO();
		List<DonHang> listdh     = donHangDAO.selectAll();

		request.setAttribute("listdh", listdh);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Dashboard/Order.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String chucNang = request.getParameter("chucNang");

		if(chucNang == null || chucNang.isEmpty())
		{
			response.sendRedirect(request.getContextPath() + "/Dashboard/Order.jsp");
			return;
		}

		DonHangDAO donHangDAO = new DonHangDAO();

		switch (chucNang)
		{
			case "Xoa":
			{
				String madonhang = request.getParameter("madonhang");
				if(madonhang != null && !madonhang.isEmpty())
				{
					try
					{
						DonHang dh = new DonHang();
						dh.setMadonhang(madonhang);

						int result = donHangDAO.delete(dh);

						if(result > 0)
						{
							request.setAttribute("message", "Xóa đơn hàng thành công.");
							System.out.println("Del Success");
						}
						else
						{
							request.setAttribute("message", "Không thể xóa đơn hàng.");
							System.out.println("Del Failed");
						}
					}
					catch (Exception e)
					{
						request.setAttribute("message", "Mã đơn hàng không hợp lệ.");
						System.out.println("Invalid order ID");
					}
				}
				else
				{
					request.setAttribute("message", "Mã đơn hàng không được để trống.");
					System.out.println("Order ID is missing");
				}
				break;
			}

			case "Sua":
			{
				String madonhang         = request.getParameter("madonhang");
				String hinhthucthanhtoan = request.getParameter("hinhthucthanhtoan");
				String trangthai         = request.getParameter("trangthai");

				if(hinhthucthanhtoan != null && !hinhthucthanhtoan.isEmpty() && trangthai != null && !trangthai.isEmpty())
				{
					try
					{
						DonHang temp = new DonHang(madonhang);
						DonHang dh   = donHangDAO.selectById(temp);

						if(dh != null)
						{
							dh.setHinhthucthanhtoan(hinhthucthanhtoan);
							dh.setTrangthai(trangthai);

							int result = donHangDAO.update(dh);

							if(result > 0)
							{
								request.setAttribute("message", "Cập nhật đơn hàng thành công.");
								System.out.println("Edit Success");
							}
							else
							{
								request.setAttribute("message", "Không thể cập nhật đơn hàng.");
								System.out.println("Edit Failed");
							}
						}
						else
						{
							request.setAttribute("message", "Đơn hàng không tồn tại.");
							System.out.println("Order not found");
						}
					}
					catch (Exception e)
					{
						request.setAttribute("message", "Dữ liệu không hợp lệ.");
						System.out.println("Invalid format");
						e.printStackTrace();
					}
				}
				else
				{
					request.setAttribute("message", "Vui lòng điền đầy đủ thông tin đơn hàng.");
					System.out.println("Missing required order information");
				}
				break;
			}

			case "Xem":
			{
				String madonhang = request.getParameter("madonhang");

				if(madonhang != null && !madonhang.isEmpty())
				{
					DonHang temp = new DonHang(madonhang);
					DonHang dh   = donHangDAO.selectById(temp);

					if(dh != null)
					{
						request.setAttribute("dh", dh);
						request.setAttribute("message", "Xem đơn hàng thành công.");
						System.out.println("Peek Success");
					}
					else
					{
						request.setAttribute("message", "Xem đơn hàng thất bại.");
						System.out.println("Peek Failed");
					}
				}
				else
				{
					request.setAttribute("message", "Không đọc được đơn hàng.");
					System.out.println("No order found");
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
