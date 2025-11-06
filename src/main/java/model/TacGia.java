package model;

import java.util.Date;
import java.util.Objects;

public class TacGia
{
	private String matacgia;
	private String tentacgia;
	private Date   ngaysinh;
	private String tieusu;

	public TacGia(String matacgia, String tentacgia, Date ngaysinh, String tieusu)
	{
		super();
		this.matacgia  = matacgia;
		this.tentacgia = tentacgia;
		this.ngaysinh  = ngaysinh;
		this.tieusu    = tieusu;
	}

	public TacGia()
	{
		super();
	}

	public String getMatacgia()
	{
		return matacgia;
	}

	public void setMatacgia(String matacgia)
	{
		this.matacgia = matacgia;
	}

	public String getTentacgia()
	{
		return tentacgia;
	}

	public void setTentacgia(String tentacgia)
	{
		this.tentacgia = tentacgia;
	}

	public Date getNgaysinh()
	{
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh)
	{
		this.ngaysinh = ngaysinh;
	}

	public String getTieusu()
	{
		return tieusu;
	}

	public void setTieusu(String tieusu)
	{
		this.tieusu = tieusu;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(matacgia, ngaysinh, tentacgia, tieusu);
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		TacGia other = (TacGia) obj;
		return Objects.equals(matacgia, other.matacgia) && Objects.equals(ngaysinh, other.ngaysinh) && Objects.equals(tentacgia, other.tentacgia) && Objects.equals(tieusu, other.tieusu);
	}

	@Override
	public String toString()
	{
		return "TacGia [matacgia=" + matacgia + ", tentacgia=" + tentacgia + ", ngaysinh=" + ngaysinh + ", tieusu=" + tieusu + "]";
	}

}
