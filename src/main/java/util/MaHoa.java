package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MaHoa
{

	/**
	 * Mã hóa chuỗi bằng thuật toán MD5.
	 *
	 * @param input Chuỗi cần mã hóa.
	 * @return Chuỗi đã được mã hóa dưới dạng hexadecimal, hoặc null nếu có lỗi xảy ra.
	 */
	public static String maHoaMD5(String input)
	{
		try
		{
			// Tạo đối tượng MessageDigest với thuật toán MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// Chuyển chuỗi đầu vào thành mảng byte và tính toán hash
			byte[] hashBytes = md.digest(input.getBytes());

			// Chuyển đổi mảng byte thành chuỗi hexadecimal
			StringBuilder sb = new StringBuilder();
			for (byte b : hashBytes)
			{
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args)
	{
		// Test hàm mã hóa MD5
		String input  = "123456";
		String hashed = maHoaMD5(input);
		System.out.println("Chuỗi gốc: " + input);
		System.out.println("Chuỗi mã hóa MD5: " + hashed);
	}
}
