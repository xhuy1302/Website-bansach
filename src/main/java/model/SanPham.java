package model;

public class SanPham
{
	private String  masanpham;
	private String  tensanpham;
	private TacGia  tacgia;
	private int     namxuatban;
	private double  giaban;
	private double  gianhap;
	private double  giagoc;
	private int     soluong;
	private TheLoai theloai;
	private String  ngonngu;
	private String  mota;

	public SanPham(String masanpham, String tensanpham, TacGia tacgia, int namxuatban, double giaban, double gianhap, double giagoc, int soluong, TheLoai theloai, String ngonngu, String mota)
	{
		super();
		this.masanpham  = masanpham;
		this.tensanpham = tensanpham;
		this.tacgia     = tacgia;
		this.namxuatban = namxuatban;
		this.giaban     = giaban;
		this.gianhap    = gianhap;
		this.giagoc     = giagoc;
		this.soluong    = soluong;
		this.theloai    = theloai;
		this.ngonngu    = ngonngu;
		this.mota       = mota;
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

	public TacGia getTacgia()
	{
		return tacgia;
	}

	public void setTacgia(TacGia tacgia)
	{
		this.tacgia = tacgia;
	}

	public int getNamxuatban()
	{
		return namxuatban;
	}

	public void setNamxuatban(int namxuatban)
	{
		this.namxuatban = namxuatban;
	}

	public double getGiaban()
	{
		return giaban;
	}

	public void setGiaban(double giaban)
	{
		this.giaban = giaban;
	}

	public double getGianhap()
	{
		return gianhap;
	}

	public void setGianhap(double gianhap)
	{
		this.gianhap = gianhap;
	}

	public double getGiagoc()
	{
		return giagoc;
	}

	public void setGiagoc(double giagoc)
	{
		this.giagoc = giagoc;
	}

	public int getSoluong()
	{
		return soluong;
	}

	public void setSoluong(int soluong)
	{
		this.soluong = soluong;
	}

	public TheLoai getTheloai()
	{
		return theloai;
	}

	public void setTheloai(TheLoai theloai)
	{
		this.theloai = theloai;
	}

	public String getNgonngu()
	{
		return ngonngu;
	}

	public void setNgonngu(String ngonngu)
	{
		this.ngonngu = ngonngu;
	}

	public String getMota()
	{
		return mota;
	}

	public void setMota(String mota)
	{
		this.mota = mota;
	}

	public SanPham()
	{
		super();
	}

	public void setImagePath(String imagePath)
	{
		// TODO Auto-generated method stub

	}

}
