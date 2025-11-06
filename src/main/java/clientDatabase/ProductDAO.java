package clientDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import clientModel.Product;
import database.DAOInterface;
import database.JDBCUtil;

public class ProductDAO implements DAOInterface<Product>
{
	private final JDBCUtil connectionPool = JDBCUtil.getInstance();

	@Override
	public ArrayList<Product> selectAll()
	{
		ArrayList<Product> list = new ArrayList<>();
		try
		{
			Connection        con = connectionPool.getConnection("selectAll");
			String            sql = "SELECT * FROM ProductClient";
			PreparedStatement st  = con.prepareStatement(sql);
			ResultSet         rs  = st.executeQuery();

			while (rs.next())
			{
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
				list.add(product);
			}
			connectionPool.closeConnection(con, "selectAll");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	// lấy sản pham mới nhắt

	@Override
	public Product selectById(Product t)
	{
		Product product = null;
		try
		{
			Connection        con = connectionPool.getConnection("selectById");
			String            sql = "SELECT * FROM ProductClient WHERE idProduct = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setInt(1, t.getIdProduct());
			ResultSet rs = st.executeQuery();

			if(rs.next())
			{
				product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
			}
			connectionPool.closeConnection(con, "selectById");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public int insert(Product t)
	{
		int result = 0;
		try
		{
			ArrayList<String> imagePaths = new ArrayList<>();
			imagePaths.add("/assets/img/books/Light%20Novel/bia_bao_mau_1_d2c2fe39133d48d1aa.jpg");
			imagePaths.add("/assets/img/books/Life%20Skill/tam-ly-hoc-that-ky-dieu_131182_1.jpg");
			imagePaths.add("/assets/img/books/Literature/b_a_ha_noi_mu_rom_va_tem_phieu_4.jpg");

			Random random        = new Random();
			String selectedImage = imagePaths.get(random.nextInt(imagePaths.size()));

			Connection        con = connectionPool.getConnection("insert");
			String            sql = "INSERT INTO ProductClient (nameProduct, priceProduct, quantity, imageProduct) VALUES (?, ?, ?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getNameProduct());
			st.setDouble(2, t.getPriceProduct());
			st.setInt(3, t.getQuantity());
			st.setString(4, selectedImage);
			result = st.executeUpdate();
			connectionPool.closeConnection(con, "insert");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertAll(ArrayList<Product> arr)
	{
		int result = 0;
		try
		{
			ArrayList<String> imagePaths = new ArrayList<>();
			imagePaths.add("/assets/img/books/Light%20Novel/bia_bao_mau_1_d2c2fe39133d48d1aa.jpg");
			imagePaths.add("/assets/img/books/Life%20Skill/tam-ly-hoc-that-ky-dieu_131182_1.jpg");
			imagePaths.add("/assets/img/books/Literature/b_a_ha_noi_mu_rom_va_tem_phieu_4.jpg");

			Random random = new Random();

			Connection        con = connectionPool.getConnection("insertAll");
			String            sql = "INSERT INTO ProductClient (nameProduct, priceProduct, quantity, imageProduct) VALUES (?, ?, ?, ?)";
			PreparedStatement st  = con.prepareStatement(sql);

			for (Product product : arr)
			{
				String selectedImage = imagePaths.get(random.nextInt(imagePaths.size()));

				st.setString(1, product.getNameProduct());
				st.setDouble(2, product.getPriceProduct());
				st.setInt(3, product.getQuantity());
				st.setString(4, selectedImage);
				result += st.executeUpdate();
			}
			connectionPool.closeConnection(con, "insertAll");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Product t)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("delete");
			String            sql = "DELETE FROM ProductClient WHERE idProduct = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setInt(1, t.getIdProduct());
			result = st.executeUpdate();
			connectionPool.closeConnection(con, "delete");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteAll(ArrayList<Product> arr)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("deleteAll");
			String            sql = "DELETE FROM ProductClient WHERE idProduct = ?";
			PreparedStatement st  = con.prepareStatement(sql);

			for (Product product : arr)
			{
				st.setInt(1, product.getIdProduct());
				result += st.executeUpdate();
			}
			connectionPool.closeConnection(con, "deleteAll");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Product t)
	{
		int result = 0;
		try
		{
			Connection        con = connectionPool.getConnection("update");
			String            sql = "UPDATE ProductClient SET nameProduct = ?, priceProduct = ?, quantity = ? WHERE idProduct = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, t.getNameProduct());
			st.setDouble(2, t.getPriceProduct());
			st.setInt(3, t.getQuantity());
			st.setInt(4, t.getIdProduct());
			result = st.executeUpdate();
			connectionPool.closeConnection(con, "update");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args)
	{
		ProductDAO productdao = new ProductDAO();

		// Example: Test selectAll method
		try
		{
			List<Product> list = productdao.selectAll();
			if(list.isEmpty())
			{
				System.out.println("No products found.");
			}
			else
			{
				for (Product o : list)
				{
					System.out.println(o);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Product> getLatestProducts()
	{
		List<Product> list = new ArrayList<>();
		try
		{
			Connection con = connectionPool.getConnection("getLatestProducts");

			// Giả sử idProduct tăng dần khi thêm sản phẩm
			String            sql = "SELECT TOP 5 * \r\n" + "FROM ProductClient \r\n" + "ORDER BY idProduct DESC;\r\n" + "";
			PreparedStatement st  = con.prepareStatement(sql);
			ResultSet         rs  = st.executeQuery();

			while (rs.next())
			{
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
				list.add(product);
			}
			connectionPool.closeConnection(con, "getLatestProducts");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	// lay san pham dua vao ma the loai
	public List<Product> selectProductById(String id)
	{
		List<Product> list = new ArrayList<Product>();
		try
		{
			Connection        con = connectionPool.getConnection("selectById");
			String            sql = "SELECT * FROM ProductClient WHERE matheloai = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, id);
			// st.setInt(1, id.getIdProduct());
			ResultSet rs = st.executeQuery();

			while (rs.next())
			{
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
			connectionPool.closeConnection(con, "selectById");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public Product selectChiTietById(String idProduct)
	{
		Product product = null;
		try
		{
			Connection        con = connectionPool.getConnection("selectById");
			String            sql = "SELECT * FROM ProductClient WHERE idProduct = ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, idProduct);
			ResultSet rs = st.executeQuery();

			while (rs.next())
			{
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
			}
			connectionPool.closeConnection(con, "selectById");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> selectProductByName(String txtsearch)
	{
		List<Product> list = new ArrayList<Product>();
		try
		{
			Connection        con = connectionPool.getConnection("selectById");
			String            sql = "SELECT * FROM ProductClient WHERE nameProduct LIKE ?";
			PreparedStatement st  = con.prepareStatement(sql);
			st.setString(1, "%" + txtsearch + "%");
			// st.setInt(1, id.getIdProduct());
			ResultSet rs = st.executeQuery();

			while (rs.next())
			{
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
			connectionPool.closeConnection(con, "selectById");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
