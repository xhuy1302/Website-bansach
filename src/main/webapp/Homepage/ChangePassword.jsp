<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.KhachHang"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Change password</title>
<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/single_styles.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/single_responsive.css">
<style>
.input-container {
	position: relative;
}

.password-input {
	padding-right: 30px; /* Tạo khoảng trống cho icon */
}

.eye-icon {
	position: absolute;
	right: 10px;
	top: 50%;
	transform: translateY(-50%);
	cursor: pointer;
}

.eye-icon i {
	color: #6c757d;
}

.eye-icon:hover i {
	color: #000;
}
</style>
</head>
<body>

	<div class="super_container">
		<!-- Header -->
		<jsp:include page="Parts/Header.jsp" />

		<!-- Main content -->
		<div class="container single_product_container">
			<div class="row">
				<div class="col">
					<!-- Breadcrumbs -->
					<div class="breadcrumbs d-flex flex-row align-items-center">
						<ul>
							<li>
								<a href="${pageContext.request.contextPath}/Homepage/Home.jsp">Home</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/Homepage/ChangePassword.jsp">
									<i class="fa fa-angle-right" aria-hidden="true"></i>
									Change password
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- Edit form -->
				<%
				KhachHang khachHang = (KhachHang) session.getAttribute("KhachHang");
				if (khachHang == null) {
				%>
				<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
				<%
				} else {
				String baoLoi = request.getAttribute("baoLoi") != null ? request.getAttribute("baoLoi").toString() : "";
				%>
				<div class="col-lg-8">
					<div class="card">
						<div class="card-body">
							<span style="color: red">
								<%=baoLoi%>
							</span>
							<form action="${pageContext.request.contextPath}/ManageChangePassWordClient" method="POST">
								<input type="hidden" name="makhachhang" value="<%=khachHang.getMakhachhang()%>">
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">Current password</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<div class="input-container">
											<input type="text" class="form-control password-input" name="matkhauhientai" id="currentPassword">
										</div>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">New password</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<div class="input-container">
											<input type="password" class="form-control password-input" name="matkhaumoi" id="newPassword">
											<span class="eye-icon" onclick="togglePassword('newPassword', this)">
												<i class="fa fa-eye"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-sm-3">
										<h6 class="mb-0">Re-enter new password</h6>
									</div>
									<div class="col-sm-9 text-secondary">
										<div class="input-container">
											<input type="password" class="form-control password-input" name="matkhaumoinhaplai" id="confirmPassword">
											<span class="eye-icon" onclick="togglePassword('confirmPassword', this)">
												<i class="fa fa-eye"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="row justify-content-center">
									<button type="submit" name="action" value="Save" class="btn btn-primary">Save Changes</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<%
				}
				%>
				<!-- Newsletter -->
				<div class="newsletter">
					<div class="container">
						<div class="row">
							<div class="col-lg-6">
								<div class="newsletter_text d-flex flex-column justify-content-center align-items-lg-start align-items-md-center text-center">
									<h4>Newsletter</h4>
									<p>Subscribe to our newsletter and get 20% off your first purchase</p>
								</div>
							</div>
							<div class="col-lg-6">
								<form action="${pageContext.request.contextPath}/NewsletterServlet" method="POST">
									<div class="newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center">
										<input id="newsletter_email" type="email" name="email" placeholder="Your email" required="required">
										<button id="newsletter_submit" type="submit" class="newsletter_submit_btn trans_300">Subscribe</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

				<!-- Footer -->
				<footer class="footer">
					<div class="container">
						<div class="row">
							<div class="col-lg-6">
								<ul class="footer_nav">
									<li>
										<a href="#">Blog</a>
									</li>
									<li>
										<a href="#">FAQs</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/Homepage/LienHe.jsp">Contact us</a>
									</li>
								</ul>
							</div>
							<div class="col-lg-6">
								<ul class="footer_social">
									<li>
										<a href="#">
											<i class="fa fa-facebook"></i>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-twitter"></i>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-instagram"></i>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</footer>
			</div>

			<!-- Scripts -->
			<script>
				// Hàm bật/tắt hiển thị mật khẩu
				function togglePassword(inputId, iconSpan) {
					const inputField = document.getElementById(inputId);
					const icon = iconSpan.querySelector("i");
					if (inputField.type === "password") {
						inputField.type = "text";
						icon.classList.remove("fa-eye");
						icon.classList.add("fa-eye-slash");
					} else {
						inputField.type = "password";
						icon.classList.remove("fa-eye-slash");
						icon.classList.add("fa-eye");
					}
				}
			</script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/css/bootstrap4/popper.js"></script>
			<script src="${pageContext.request.contextPath}/assets/css/bootstrap4/bootstrap.min.js"></script>
</body>
</html>
