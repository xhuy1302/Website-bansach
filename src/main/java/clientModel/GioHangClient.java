package clientModel;

import java.util.Date;
import java.io.Serializable;

public class GioHangClient implements Serializable
{
	private int    magiohang;
	private String masanpham;
	private String tensanpham;
	private int    soluong;
	private int    gia;
	private Date   datesanpham;
	private String image;

	// Constructor
	public GioHangClient()
	{
	}

	public GioHangClient(int magiohang, String masanpham, String tensanpham, int soluong, int gia, Date datesanpham, String image)
	{
		this.magiohang   = magiohang;
		this.masanpham   = masanpham;
		this.tensanpham  = tensanpham;
		this.soluong     = soluong;
		this.gia         = gia;
		this.datesanpham = datesanpham;
		this.image       = image;
	}

	// Getters and Setters
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

	public int getSoluong()
	{
		return soluong;
	}

	public void setSoluong(int soluong)
	{
		this.soluong = soluong;
	}

	public int getGia()
	{
		return gia;
	}

	public void setGia(int gia)
	{
		this.gia = gia;
	}

	public Date getDatesanpham()
	{
		return datesanpham;
	}

	public void setDatesanpham(Date datesanpham)
	{
		this.datesanpham = datesanpham;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}
}
