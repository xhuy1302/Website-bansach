package clientController;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.KhachHangDAO;
import model.KhachHang;

@WebServlet("/ChangeImg")
public class ChangeImg extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ChangeImg()
	{
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String errorMessage = "";

		// Retrieve the customer (KhachHang) from the session
		HttpSession session   = request.getSession();
		KhachHang   khachHang = (KhachHang) session.getAttribute("KhachHang");

		if(khachHang == null)
		{
			errorMessage = "Bạn chưa đăng nhập vào hệ thống!";
			request.setAttribute("baoLoi", errorMessage);
			request.getRequestDispatcher("/Homepage/Home.jsp").forward(request, response);
			return;
		}

		try
		{
			// Define the folder to save uploaded avatar images
			String folderPath = getServletContext().getRealPath("/assets/img/avatar");
			System.out.println("Avatar save path: " + folderPath);

			// Create the folder if it does not exist
			File folder = new File(folderPath);
			if(!folder.exists())
			{
				folder.mkdirs();
			}

			// Set file size limits
			int maxFileSize = 5 * 1024 * 1024; // 5MB
			int maxMemSize  = 5 * 1024 * 1024;

			// Check if the request contains multipart content
			if(ServletFileUpload.isMultipartContent(request))
			{
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(maxMemSize);

				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(maxFileSize);

				List<FileItem> items = upload.parseRequest(request);

				for (FileItem item : items)
				{
					if(!item.isFormField())
					{ // Process file upload
						String originalFileName = item.getName();
						if(originalFileName == null || originalFileName.trim().isEmpty())
						{
							continue;
						}

						// Check file extension (Optional: Only allow certain image types)
						String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase();
						if(!fileExtension.matches("jpg|jpeg|png|gif"))
						{
							errorMessage = "Chỉ hỗ trợ ảnh định dạng JPG, JPEG, PNG, GIF!";
							request.setAttribute("baoLoi", errorMessage);
							request.getRequestDispatcher("/Homepage/ProfileClient.jsp").forward(request, response);
							return;
						}

						// Generate a unique filename
						String fileName = System.currentTimeMillis() + "_" + originalFileName;
						File   saveFile = new File(folderPath, fileName);

						// Save the file
						item.write(saveFile);

						// Update the KhachHang object and database
						khachHang.setDuongdananh(fileName);
						KhachHangDAO khachHangDAO = new KhachHangDAO();
						khachHangDAO.updateImage(khachHang);

						// Update the session with the latest KhachHang object
						session.setAttribute("KhachHang", khachHang);
					}
				}
			}
			else
			{
				errorMessage = "Yêu cầu không hợp lệ. Vui lòng thử lại.";
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
			errorMessage = "Đã xảy ra lỗi trong quá trình xử lý ảnh. Vui lòng thử lại.";
		}

		if(!errorMessage.isEmpty())
		{
			request.setAttribute("baoLoi", errorMessage);
		}

		// Determine the next page based on the role of the user
		String nextPage = "/Homepage/ChangePassword.jsp"; // Default page

		// Check if user is admin or user
		if("admin".equals(khachHang.getRole()))
		{
			nextPage = "/Dashboard/Profile.jsp"; // Redirect to admin profile page
		}
		else if("user".equals(khachHang.getRole()))
		{
			nextPage = "/Homepage/ProfileClient.jsp"; // Redirect to user profile page
		}

		// Forward to the appropriate page
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
}
