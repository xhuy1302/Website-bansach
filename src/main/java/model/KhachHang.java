package model;

import java.util.Date;

public class KhachHang
{
	private String  makhachhang;
	private String  tendangnhap;
	private String  matkhau;
	private String  hovaten;
	private String  gioitinh;
	private String  diachi;
	private String  diachinhanhang;
	private String  diachimuahang;
	private Date    ngaysinh;
	private String  sodienthoai;
	private String  email;
	private boolean dangkinhanbantin;
	private String  role;
	private String  duongdananh;

	public KhachHang(
	        String makhachhang, String tendangnhap, String matkhau, String hovaten, String gioitinh, String diachi, String diachinhanhang, String diachimuahang, Date ngaysinh, String sodienthoai, String email, boolean dangkinhanbantin, String role
	)
	{
		super();
		this.makhachhang      = makhachhang;
		this.tendangnhap      = tendangnhap;
		this.matkhau          = matkhau;
		this.hovaten          = hovaten;
		this.gioitinh         = gioitinh;
		this.diachi           = diachi;
		this.diachinhanhang   = diachinhanhang;
		this.diachimuahang    = diachimuahang;
		this.ngaysinh         = ngaysinh;
		this.sodienthoai      = sodienthoai;
		this.email            = email;
		this.dangkinhanbantin = dangkinhanbantin;
		this.role             = role;
	}

	public KhachHang(
	        String makhachhang, String tendangnhap, String matkhau, String hovaten, String gioitinh, String diachi, String diachinhanhang, String diachimuahang, Date ngaysinh, String sodienthoai, String email, boolean dangkinhanbantin, String role,
	        String duongdananh
	)
	{
		super();
		this.makhachhang      = makhachhang;
		this.tendangnhap      = tendangnhap;
		this.matkhau          = matkhau;
		this.hovaten          = hovaten;
		this.gioitinh         = gioitinh;
		this.diachi           = diachi;
		this.diachinhanhang   = diachinhanhang;
		this.diachimuahang    = diachimuahang;
		this.ngaysinh         = ngaysinh;
		this.sodienthoai      = sodienthoai;
		this.email            = email;
		this.dangkinhanbantin = dangkinhanbantin;
		this.role             = role;
		this.duongdananh      = duongdananh;
	}

	public KhachHang(
	        String makhachhang, String tendangnhap, String matkhau, String sodienthoai, String email

	)
	{
		super();
		this.makhachhang = makhachhang;
		this.tendangnhap = tendangnhap;
		this.matkhau     = matkhau;
		this.sodienthoai = sodienthoai;
		this.email       = email;
	}

	public KhachHang()
	{
		super();
	}

	public KhachHang(String makhachhang, String tendangnhap, String matkhau, String sodienthoai, String email, String role)
	{
		this.makhachhang = makhachhang;
		this.tendangnhap = tendangnhap;
		this.matkhau     = matkhau;
		this.sodienthoai = sodienthoai;
		this.email       = email;
		this.role        = role;
	}

	public String getMakhachhang()
	{
		return makhachhang;
	}

	public void setMakhachhang(String makhachhang)
	{
		this.makhachhang = makhachhang;
	}

	public String getTendangnhap()
	{
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap)
	{
		this.tendangnhap = tendangnhap;
	}

	public String getMatkhau()
	{
		return matkhau;
	}

	public void setMatkhau(String matkhau)
	{
		this.matkhau = matkhau;
	}

	public String getHovaten()
	{
		return hovaten;
	}

	public void setHovaten(String hovaten)
	{
		this.hovaten = hovaten;
	}

	public String getGioitinh()
	{
		return gioitinh;
	}

	public void setGioitinh(String gioitinh)
	{
		this.gioitinh = gioitinh;
	}

	public String getDiachi()
	{
		return diachi;
	}

	public void setDiachi(String diachi)
	{
		this.diachi = diachi;
	}

	public String getDiachinhanhang()
	{
		return diachinhanhang;
	}

	public void setDiachinhanhang(String diachinhanhang)
	{
		this.diachinhanhang = diachinhanhang;
	}

	public String getDiachimuahang()
	{
		return diachimuahang;
	}

	public void setDiachimuahang(String diachimuahang)
	{
		this.diachimuahang = diachimuahang;
	}

	public Date getNgaysinh()
	{
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh)
	{
		this.ngaysinh = ngaysinh;
	}

	public String getSodienthoai()
	{
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai)
	{
		this.sodienthoai = sodienthoai;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public boolean isDangkinhanbantin()
	{
		return dangkinhanbantin;
	}

	public void setDangkinhanbantin(boolean dangkinhanbantin)
	{
		this.dangkinhanbantin = dangkinhanbantin;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public String getDuongdananh()
	{
		return duongdananh;
	}

	public void setDuongdananh(String duongdananh)
	{
		this.duongdananh = duongdananh;
	}

	@Override
	public String toString()
	{
		return "KhachHang [makhachhang=" + makhachhang + ", tendangnhap=" + tendangnhap + ", matkhau=" + matkhau + ", hovaten=" + hovaten + ", gioitinh=" + gioitinh + ", diachi=" + diachi + ", diachinhanhang=" + diachinhanhang + ", diachimuahang="
		        + diachimuahang + ", ngaysinh=" + ngaysinh + ", sodienthoai=" + sodienthoai + ", email=" + email + ", dangkinhanbantin=" + dangkinhanbantin + "]";
	}

	public boolean isDangKyNhanBangTin()
	{
		// TODO Auto-generated method stub
		return false;
	}
}
