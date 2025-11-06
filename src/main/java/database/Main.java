package database;

import java.util.ArrayList;

import model.TacGia;

public class Main
{

	public static void main(String[] args)
	{
		TacGiaDAO tacGiaDAO = new TacGiaDAO();

		// Test hàm selectAll
		System.out.println("Danh sách tất cả tác giả:");
		ArrayList<TacGia> allTacGia = tacGiaDAO.selectAll();
		for (TacGia tg : allTacGia)
		{
			System.out.println(tg);
		}

		// Test hàm selectById
		System.out.println("\nThông tin tác giả có mã TG01:");
		TacGia tacGia = new TacGia();
		tacGia.setMatacgia("TG01"); // Thay TG01 bằng mã tác giả cụ thể
		TacGia resultTacGia = tacGiaDAO.selectById(tacGia);

		if(resultTacGia != null)
		{
			System.out.println(resultTacGia);
		}
		else
		{
			System.out.println("Tác giả không tồn tại.");
		}
	}
}
