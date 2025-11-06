package clientModel;

public class Product
{
	private int    idProduct;
	private String nameProduct;
	private String imageProduct;
	private double priceProduct;
	private String title;
	private String descriptions;
	private int    quantity;    // Thêm thuộc tính số lượng
	private String matheloai;

	public Product(int idProduct, String nameProduct, String imageProduct, double priceProduct, String title, String descriptions, int quantity, String matheloai)
	{
		// Thêm tham số quantity vào constructor
		super();
		this.idProduct    = idProduct;
		this.nameProduct  = nameProduct;
		this.imageProduct = imageProduct;
		this.priceProduct = priceProduct;
		this.title        = title;
		this.descriptions = descriptions;
		this.quantity     = quantity;    // Khởi tạo số lượng
		this.matheloai    = matheloai;
	}

	public Product()
	{
		super();
	}

	public Product(int idProduct, String nameProduct, double priceProduct, int quantity)
	{
		this.idProduct    = idProduct;
		this.nameProduct  = nameProduct;
		this.priceProduct = priceProduct;
		this.quantity     = quantity;
	}

	public int getIdProduct()
	{
		return idProduct;
	}

	public void setIdProduct(int idProduct)
	{
		this.idProduct = idProduct;
	}

	public String getNameProduct()
	{
		return nameProduct;
	}

	public void setNameProduct(String nameProduct)
	{
		this.nameProduct = nameProduct;
	}

	public String getImageProduct()
	{
		return imageProduct;
	}

	public void setImageProduct(String imageProduct)
	{
		this.imageProduct = imageProduct;
	}

	public double getPriceProduct()
	{
		return priceProduct;
	}

	public void setPriceProduct(double priceProduct)
	{
		this.priceProduct = priceProduct;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescriptions()
	{
		return descriptions;
	}

	public void setDescriptions(String descriptions)
	{
		this.descriptions = descriptions;
	}

	public int getQuantity()
	{
		return quantity; // Getter cho quantity
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity; // Setter cho quantity
	}

	public String getMatheloai()
	{
		return matheloai;
	}

	public void setMatheloai(String matheloai)
	{
		this.matheloai = matheloai;
	}

	@Override
	public String toString()
	{
		return "Product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", imageProduct=" + imageProduct + ", priceProduct=" + priceProduct + ", title=" + title + ", descriptions=" + descriptions + ", quantity=" + quantity
		        + ", matheloai=" + matheloai + "]";
	}
}
