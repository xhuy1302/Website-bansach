<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.KhachHang"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Profile Client</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Colo Shop Template">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/themify-icons/themify-icons.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/jquery-ui-1.12.1.custom/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/single_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/single_responsive.css">
</head>

<body>
	<%
	KhachHang khachHang = (KhachHang) session.getAttribute("KhachHang");
	if(khachHang == null)
	{
		// Nếu khách hàng không có trong session, có thể chuyển hướng tới trang login
		response.sendRedirect("${pageContext.request.contextPath}/Homepage/DangNhap.jsp");
		return; // Dừng việc tiếp tục xử lý trang này
	}
	%>
	<div class="super_container">
		<!-- Tách riêng header ra file Header.jsp -->
		<jsp:include page="Parts/Header.jsp" />
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
								<a href="${pageContext.request.contextPath}/Homepage/ProfileClient.jsp">
									<i class="fa fa-angle-right" aria-hidden="true"></i>
									Profile
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="p-10">
				<div class="main-body">
					<div class="row gutters-sm">
						<div class="col-md-4 mb-3">
							<div class="card">
								<div class="card-body">
									<div class="d-flex flex-column align-items-center text-center">
										<img src="${pageContext.request.contextPath}/assets/img/avatar/<%= khachHang.getDuongdananh() %>" alt="Advatar" class="avatar-square" width="300">
										<div class="mt-3">
											<%
											if(khachHang != null)
											{
											%>
											<h4><%=khachHang.getHovaten()%></h4>
											<%
											}
											else
											{
											%>
											<p>Error: Khách hàng không có thông tin.</p>
											<%
											}
											%>
											<p class="text-secondary mb-1">Welcome to Bookstore 13</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-8">
							<div class="card mb-3">
								<div class="card-body">
									<div class="row">
										<div class="col-sm-3">
											<h6 class="mb-0">Full name</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<%=khachHang.getHovaten()%>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h6 class="mb-0">Gender</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<%=khachHang.getGioitinh()%>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h6 class="mb-0">Date of birth</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<%=khachHang.getNgaysinh()%>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h6 class="mb-0">Email</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<%=khachHang.getEmail()%>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h6 class="mb-0">Phone</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<%=khachHang.getSodienthoai()%>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h6 class="mb-0">Address</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<%=khachHang.getDiachi()%>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<h6 class="mb-0">Delivery address</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<%=khachHang.getDiachinhanhang()%>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-12">
											<a class="btn btn-info " href="${pageContext.request.contextPath}/Homepage/EditClient.jsp">Edit</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
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
							<form action="post">
								<div class="newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center">
									<input id="newsletter_email" type="email" placeholder="Your email" required="required" data-error="Valid email is required.">
									<button id="newsletter_submit" type="submit" class="newsletter_submit_btn trans_300" value="Submit">subscribe</button>
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
							<div class="footer_nav_container d-flex flex-sm-row flex-column align-items-center justify-content-lg-start justify-content-center text-center">
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
						</div>
						<div class="col-lg-6">
							<div class="footer_social d-flex flex-row align-items-center justify-content-lg-end justify-content-center">
								<ul>
									<li>
										<a href="#">
											<i class="fa fa-facebook" aria-hidden="true"></i>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-twitter" aria-hidden="true"></i>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-instagram" aria-hidden="true"></i>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-skype" aria-hidden="true"></i>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-pinterest" aria-hidden="true"></i>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</footer>
		</div>

		<script src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/css/bootstrap4/popper.js"></script>
		<script src="${pageContext.request.contextPath}/assets/css/bootstrap4/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/vendor/Isotope/isotope.pkgd.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/owl.carousel.js"></script>
		<script src="${pageContext.request.contextPath}/assets/vendor/easing/easing.js"></script>
		<script src="${pageContext.request.contextPath}/assets/vendor/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/single_custom.js"></script>
</body>

</html>
