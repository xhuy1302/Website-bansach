package clientModel;

public class GioHang
{
	private int    magiohang;
	private String masanpham;
	private String tensanpham;
	private double gia;
	private int    soluong;
	private String image;     // Thêm thuộc tính image

	public GioHang(int magiohang, String masanpham, String tensanpham, double gia, int soluong, String image)
	{
		super();
		this.magiohang  = magiohang;
		this.masanpham  = masanpham;
		this.tensanpham = tensanpham;
		this.gia        = gia;
		this.soluong    = soluong;
		this.image      = image;     // Khởi tạo image
	}

	public GioHang()
	{
		super();
	}

	public int getMagiohang()
	{
		return magiohang;
	}

	public void setMagiohang(int magiohang)
	{
		this.magiohang = magiohang;
	}

	public String getMasanpham()
	{
		return masanpham;
	}

	public void setMasanpham(String masanpham)
	{
		this.masanpham = masanpham;
	}

	public String getTensanpham()
	{
		return tensanpham;
	}

	public void setTensanpham(String tensanpham)
	{
		this.tensanpham = tensanpham;
	}

	public double getGia()
	{
		return gia;
	}

	public void setGia(double gia)
	{
		this.gia = gia;
	}

	public int getSoluong()
	{
		return soluong;
	}

	public void setSoluong(int soluong)
	{
		this.soluong = soluong;
	}

	public String getImage()
	{ // Getter for image
		return image;
	}

	public void setImage(String image)
	{ // Setter for image
		this.image = image;
	}
}
