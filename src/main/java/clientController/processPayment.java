package clientController;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DonHangDAO;
import database.KhachHangDAO;
import model.DonHang;
import model.KhachHang;

@WebServlet("/processPayment")
public class processPayment extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public processPayment()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String customerName  = request.getParameter("customerName");
		String email         = request.getParameter("email");
		String phone         = request.getParameter("phone");
		String address       = request.getParameter("address");
		String paymentMethod = request.getParameter("paymentMethod");

		// tao ma don han
		String orderCode = generateShortCode();

		DonHang donHang = new DonHang();
		donHang.setMadonhang(orderCode);
		donHang.setDiachinhanhang(address);
		donHang.setHinhthucthanhtoan(paymentMethod);
		donHang.setTrangthai("Pending");
		donHang.setTrangthaithanhtoan("Unpaid");
		donHang.setSotiendathanhtoan(0);
		donHang.setNgaydathang(new Date(System.currentTimeMillis()));

		KhachHang khachHang = new KhachHang();
		khachHang.setMakhachhang(generateShortCode());
		khachHang.setTendangnhap(customerName);
		khachHang.setEmail(email);
		khachHang.setSodienthoai(phone);
		donHang.setKhachhang(khachHang);

		DonHangDAO   donHangDAO   = new DonHangDAO();
		KhachHangDAO khachHangDAO = new KhachHangDAO();

		khachHangDAO.insert(khachHang);
		donHangDAO.insert(donHang);

		response.sendRedirect("Homepage/orderConfirmation.jsp");
	}

	private String generateShortCode()
	{
		String        characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random        random     = new Random();
		StringBuilder shortCode  = new StringBuilder();
		for (int i = 0; i < 8; i++)
		{
			int index = random.nextInt(characters.length());
			shortCode.append(characters.charAt(index));
		}
		return shortCode.toString();
	}
}
