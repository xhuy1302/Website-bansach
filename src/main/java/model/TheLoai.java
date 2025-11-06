package model;

public class TheLoai
{
	private String matheloai;
	private String tentheloai;

	public TheLoai(String matheloai, String tentheloai)
	{
		super();
		this.matheloai  = matheloai;
		this.tentheloai = tentheloai;
	}

	public TheLoai()
	{
		super();
	}

	public String getmatheloai()
	{
		return matheloai;
	}

	public void setmatheloai(String matheloai)
	{
		this.matheloai = matheloai;
	}

	public String gettentheloai()
	{
		return tentheloai;
	}

	public void settentheloai(String tentheloai)
	{
		this.tentheloai = tentheloai;
	}

	@Override
	public String toString()
	{
		return "TheLoai [matheloai=" + matheloai + ", tentheloai=" + tentheloai + "]";
	}

}
