<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Đăng Ký</title>
<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<style>
#msg, .msg {
	color: red;
}
</style>
</head>

<body>
	<%
	String baoloi = request.getAttribute("baoloi") + "";
	baoloi = (baoloi.equals("null")) ? "" : baoloi;

	String tendangnhap = request.getAttribute("tendangnhap") + "";
	tendangnhap = (tendangnhap.equals("null")) ? "" : tendangnhap;

	String matkhau = request.getAttribute("matkhau") + "";
	matkhau = (matkhau.equals("null")) ? "" : matkhau;

	String nhaplaimatkhau = request.getAttribute("nhaplaimatkhau") + "";
	nhaplaimatkhau = (nhaplaimatkhau.equals("null")) ? "" : nhaplaimatkhau;

	String hovaten = request.getAttribute("hovaten") + "";
	hovaten = (hovaten.equals("null")) ? "" : hovaten;

	String gioitinh = request.getAttribute("gioitinh") + "";
	gioitinh = (gioitinh.equals("null")) ? "" : gioitinh;

	String ngaysinh = request.getAttribute("ngaysinh") + "";
	ngaysinh = (ngaysinh.equals("null")) ? "" : ngaysinh;

	String diachimuahang = request.getAttribute("diachimuahang") + "";
	diachimuahang = (diachimuahang.equals("null")) ? "" : diachimuahang;

	String diachikhachhang = request.getAttribute("diachikhachhang") + "";
	diachikhachhang = (diachikhachhang.equals("null")) ? "" : diachikhachhang;

	String diachinhanhang = request.getAttribute("diachinhanhang") + "";
	diachinhanhang = (diachinhanhang.equals("null")) ? "" : diachinhanhang;

	String dienthoai = request.getAttribute("dienthoai") + "";
	dienthoai = (dienthoai.equals("null")) ? "" : dienthoai;

	String email = request.getAttribute("email") + "";
	email = (email.equals("null")) ? "" : email;
	%>

	<section class="vh-100" style="background-color: #eee;">
		<div class="container h-100">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
									<h1 class="text-center fw-bold mb-5 mx-1 mx-md-4 mt-4">Account Register</h1>

									<form class="mx-1 mx-md-4" action="${pageContext.request.contextPath}/dang-ky" method="post">

										<!-- Tên đăng nhập -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="tendangnhap">Username</label>
											<input class="form-control" type="text" id="tendangnhap" name="tendangnhap" required value="<%=tendangnhap%>">
										</div>

										<!-- Mật khẩu -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="matkhau">Password</label>
											<input class="form-control" type="password" id="matkhau" name="matkhau" required onkeyup="kiemtramatkhau()">
										</div>

										<!-- Nhập lại mật khẩu -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="nhaplaimatkhau">Confirm password</label>
											<input class="form-control" type="password" id="nhaplaimatkhau" name="nhaplaimatkhau" required onkeyup="kiemtramatkhau()">
											<span id="msg"></span>
										</div>

										<h4 class="mt-3">Personal information</h4>

										<!-- Họ và tên -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="hovaten">Fullname</label>
											<input class="form-control" type="text" id="hovaten" name="hovaten" value="<%=hovaten%>">
										</div>

										<!-- Giới tính -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="gioitinh">Gender</label>
											<select class="form-select" name="gioitinh">
												<option value="1">Male</option>
												<option value="2">Female</option>
												<option value="3">Others</option>
											</select>
										</div>

										<!-- Ngày sinh -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="ngaysinh">Birthday</label>
											<input class="form-control" type="date" id="ngaysinh" name="ngaysinh" value="<%=ngaysinh%>">
										</div>

										<h4 class="mt-3">Address</h4>

										<!-- Địa chỉ khách hàng -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="diachikhachhang">Address</label>
											<input class="form-control" type="text" id="diachikhachhang" name="diachikhachhang" value="<%=diachikhachhang%>">
										</div>

										<!-- Địa chỉ mua hàng -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="diachimuahang">Shopping address</label>
											<input class="form-control" type="text" id="diachimuahang" name="diachimuahang" value="<%=diachimuahang%>">
										</div>

										<!-- Địa chỉ nhận hàng -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="diachinhanhang">Delivery address</label>
											<input class="form-control" type="text" id="diachinhanhang" name="diachinhanhang" value="<%=diachinhanhang%>">
										</div>

										<!-- Số điện thoại -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="dienthoai">Phone number</label>
											<input class="form-control" type="number" id="dienthoai" name="dienthoai" value="<%=dienthoai%>">
										</div>

										<!-- Email -->
										<div class="d-flex flex-column align-items-start mb-4">
											<label class="form-label" for="email">Email</label>
											<input class="form-control" type="email" id="email" name="email" value="<%=email%>">
										</div>

										<!-- Đồng ý điều khoản -->
										<div class="mt-3">
											<input type="checkbox" class="form-check-input" id="dongy">
											<label for="dongy" class="form-check-label">
												<b>Agree to our term of service?</b>
											</label>
										</div>

										<!-- Đồng ý nhận email -->
										<div class="mt-3">
											<input type="checkbox" class="form-check-input" id="dongynhanemail">
											<label for="dongynhanemail" class="form-check-label">
												<b>Receive our email?</b>
											</label>
										</div>

										<!-- Nút đăng ký -->
										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary btn-lg">Register</button>
										</div>
									</form>

								</div>
								<div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
									<img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp" class="img-fluid" alt="Sample image">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- Vendor JS Files -->
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Customize JS -->
	<script>
		function kiemtramatkhau() {
			matkhau = document.getElementById("matkhau").value;
			nhaplaimatkhau = document.getElementById("nhaplaimatkhau").value;
			if (matkhau != nhaplaimatkhau) {
				document.getElementById("msg").innerHTML = "mật khẩu không khớp";
				return false;
			} else {
				document.getElementById("msg").innerHTML = " ";
				return true;
			}
		}
		// dùng javascript chỉ đến hiển thị các phần có trên trang jsp thôi 
		// còn nếu dùng cơ sở dữ liệu thì phải dùng đến 

		function kiemtradongy() {

		}
	</script>
</body>
</html>