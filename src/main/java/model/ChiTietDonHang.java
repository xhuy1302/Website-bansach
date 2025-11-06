package model;

public class ChiTietDonHang
{
	private String  machitietdonhang;
	private DonHang donhang;
	private SanPham sanpham;
	private double  soluong;
	private double  giagoc;
	private double  giamgia;
	private double  giaban;
	private double  thuevat;
	private double  tongtien;

	public ChiTietDonHang(String machitietdonhang, DonHang donhang, SanPham sanpham, double soluong, double giagoc, double giamgia, double giaban, double thuevat, double tongtien)
	{
		super();
		this.machitietdonhang = machitietdonhang;
		this.donhang          = donhang;
		this.sanpham          = sanpham;
		this.soluong          = soluong;
		this.giagoc           = giagoc;
		this.giamgia          = giamgia;
		this.giaban           = giaban;
		this.thuevat          = thuevat;
		this.tongtien         = tongtien;
	}

	public ChiTietDonHang()
	{
		super();
	}

	public String getMachitietdonhang()
	{
		return machitietdonhang;
	}

	public void setMachitietdonhang(String machitietdonhang)
	{
		this.machitietdonhang = machitietdonhang;
	}

	public DonHang getDonhang()
	{
		return donhang;
	}

	public void setDonhang(DonHang donhang)
	{
		this.donhang = donhang;
	}

	public SanPham getSanpham()
	{
		return sanpham;
	}

	public void setSanpham(SanPham sanpham)
	{
		this.sanpham = sanpham;
	}

	public double getSoluong()
	{
		return soluong;
	}

	public void setSoluong(double soluong)
	{
		this.soluong = soluong;
	}

	public double getGiagoc()
	{
		return giagoc;
	}

	public void setGiagoc(double giagoc)
	{
		this.giagoc = giagoc;
	}

	public double getGiamgia()
	{
		return giamgia;
	}

	public void setGiamgia(double giamgia)
	{
		this.giamgia = giamgia;
	}

	public double getGiaban()
	{
		return giaban;
	}

	public void setGiaban(double giaban)
	{
		this.giaban = giaban;
	}

	public double getThuevat()
	{
		return thuevat;
	}

	public void setThuevat(double thuevat)
	{
		this.thuevat = thuevat;
	}

	public double getTongtien()
	{
		return tongtien;
	}

	public void setTongtien(double tongtien)
	{
		this.tongtien = tongtien;
	}

}
