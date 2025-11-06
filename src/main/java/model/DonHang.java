package model;

import java.util.Date;

public class DonHang
{
	private String    madonhang;
	private KhachHang khachhang;
	private String    diachimuahang;
	private String    diachinhanhang;
	private String    trangthai;
	private String    hinhthucthanhtoan;
	private String    trangthaithanhtoan;
	private double    sotiendathanhtoan;
	private double    sotienconthieu;
	private Date      ngaydathang;
	private Date      ngaygiaohang;

	public DonHang(
	        String madonhang, KhachHang khachhang, String diachimuahang, String diachinhanhang, String trangthai, String hinhthucthanhtoan, String trangthaithanhtoan, double sotiendathanhtoan, double sotienconthieu, Date ngaydathang,
	        Date ngaygiaohang
	)
	{
		super();
		this.madonhang          = madonhang;
		this.khachhang          = khachhang;
		this.diachimuahang      = diachimuahang;
		this.diachinhanhang     = diachinhanhang;
		this.trangthai          = trangthai;
		this.hinhthucthanhtoan  = hinhthucthanhtoan;
		this.trangthaithanhtoan = trangthaithanhtoan;
		this.sotiendathanhtoan  = sotiendathanhtoan;
		this.sotienconthieu     = sotienconthieu;
		this.ngaydathang        = ngaydathang;
		this.ngaygiaohang       = ngaygiaohang;
	}

	public DonHang()
	{
		super();
	}

	public DonHang(String hinhthucthanhtoan, String trangthai)
	{
		this.hinhthucthanhtoan = hinhthucthanhtoan;
		this.trangthai         = trangthai;
	}

	public DonHang(String madonhang)
	{
		this.madonhang = madonhang;
	}

	public String getMadonhang()
	{
		return madonhang;
	}

	public void setMadonhang(String madonhang)
	{
		this.madonhang = madonhang;
	}

	public KhachHang getKhachhang()
	{
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang)
	{
		this.khachhang = khachhang;
	}

	public String getDiachimuahang()
	{
		return diachimuahang;
	}

	public void setDiachimuahang(String diachimuahang)
	{
		this.diachimuahang = diachimuahang;
	}

	public String getDiachinhanhang()
	{
		return diachinhanhang;
	}

	public void setDiachinhanhang(String diachinhanhang)
	{
		this.diachinhanhang = diachinhanhang;
	}

	public String getTrangthai()
	{
		return trangthai;
	}

	public void setTrangthai(String trangthai)
	{
		this.trangthai = trangthai;
	}

	public String getHinhthucthanhtoan()
	{
		return hinhthucthanhtoan;
	}

	public void setHinhthucthanhtoan(String hinhthucthanhtoan)
	{
		this.hinhthucthanhtoan = hinhthucthanhtoan;
	}

	public String getTrangthaithanhtoan()
	{
		return trangthaithanhtoan;
	}

	public void setTrangthaithanhtoan(String trangthaithanhtoan)
	{
		this.trangthaithanhtoan = trangthaithanhtoan;
	}

	public double getSotiendathanhtoan()
	{
		return sotiendathanhtoan;
	}

	public void setSotiendathanhtoan(double sotiendathanhtoan)
	{
		this.sotiendathanhtoan = sotiendathanhtoan;
	}

	public double getSotienconthieu()
	{
		return sotienconthieu;
	}

	public void setSotienconthieu(double sotienconthieu)
	{
		this.sotienconthieu = sotienconthieu;
	}

	public Date getNgaydathang()
	{
		return ngaydathang;
	}

	public void setNgaydathang(Date ngaydathang)
	{
		this.ngaydathang = ngaydathang;
	}

	public Date getNgaygiaohang()
	{
		return ngaygiaohang;
	}

	public void setNgaygiaohang(Date ngaygiaohang)
	{
		this.ngaygiaohang = ngaygiaohang;
	}

}
