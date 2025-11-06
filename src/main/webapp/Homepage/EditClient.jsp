<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.KhachHang"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Client</title>
<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/single_styles.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/single_responsive.css">
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
								<a href="${pageContext.request.contextPath}/Homepage/ProfileClient.jsp">
									<i class="fa fa-angle-right" aria-hidden="true"></i>
									Profile
								</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/Homepage/EditClient.jsp">
									<i class="fa fa-angle-right" aria-hidden="true"></i>
									Edit
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<%
			KhachHang khachHang = (KhachHang) session.getAttribute("KhachHang");
			if(khachHang == null)
			{
				response.sendRedirect("Login.jsp");
				return;
			}
			%>
			<div class="main-body p-10">
				<div class="row">
					<!-- Profile picture -->
					<div class="col-lg-4">
						<div class="card">
							<div class="card-body">
								<div class="d-flex flex-column align-items-center text-center">
									<img src="${pageContext.request.contextPath}/assets/img/avatar/<%= khachHang.getDuongdananh() %>" alt="Avarta" class="avatar-square" width="300">
									<div class="mt-3">
										<h4><%=khachHang.getHovaten()%></h4>
										<p class="text-secondary mb-1">Welcome to Bookstore 13</p>
									</div>
								</div>
								<hr class="my-4">
							</div>
						</div>
					</div>
					<!-- Edit form -->
					<div class="col-lg-8">
						<div class="card">
							<div class="card-body">
								<form action="${pageContext.request.contextPath}/ManageKhachHangClient" method="POST">
									<input type="hidden" name="makhachhang" value="<%=khachHang.getMakhachhang()%>">
									<div class="row mb-3">
										<div class="col-sm-3">
											<h6 class="mb-0">Full Name</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<input type="text" class="form-control" name="hovaten" value="<%=khachHang.getHovaten()%>">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-sm-3">
											<h6 class="mb-0">Gender</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<input type="text" class="form-control" name="gioitinh" value="<%=khachHang.getGioitinh()%>">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-sm-3">
											<h6 class="mb-0">Date of birth</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<input type="text" class="form-control" name="ngaysinh" value="<%=khachHang.getNgaysinh()%>">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-sm-3">
											<h6 class="mb-0">Email</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<input type="email" class="form-control" name="email" value="<%=khachHang.getEmail()%>">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-sm-3">
											<h6 class="mb-0">Phone</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<input type="text" class="form-control" name="sodienthoai" value="<%=khachHang.getSodienthoai()%>">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-sm-3">
											<h6 class="mb-0">Address</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<input type="text" class="form-control" name="diachi" value="<%=khachHang.getDiachi()%>">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-sm-3">
											<h6 class="mb-0">Delivery address</h6>
										</div>
										<div class="col-sm-9 text-secondary">
											<input type="text" class="form-control" name="diachinhanhang" value="<%=khachHang.getDiachinhanhang()%>">
										</div>
									</div>
									<div class="row justify-content-center">
										<button type="submit" name="action" value="Save" class="btn btn-primary">Save Changes</button>
									</div>
								</form>
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
	<script src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/css/bootstrap4/popper.js"></script>
	<script src="${pageContext.request.contextPath}/assets/css/bootstrap4/bootstrap.min.js"></script>
</body>
</html>
