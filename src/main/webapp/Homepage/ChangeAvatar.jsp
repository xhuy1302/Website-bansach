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
				<%
				KhachHang khachHang = (KhachHang) session.getAttribute("KhachHang");
				if(khachHang == null)
				{
				%>
				<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
				<%
				}
				else
				{
				%>
				<div class="container">
					<%
					String baoLoi = request.getAttribute("baoLoi") + "";
					baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;

					String duongdananh = khachHang.getDuongdananh();
					%>
					<div class="container">
						<div class="red" id="baoLoi">
							<%=baoLoi%>
						</div>
						<%
						String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
						%>
						<form class="form" action="<%=url1%>/ChangeImg" method="post" enctype="multipart/form-data">
							<input type="hidden" name="hanhDong" value="thay-doi-anh" />
							<div class="row">
								<div class="col-sm-6">
									<h3>Update your profile picture</h3>
									<img src="<%=url1%>/assets/img/avatar/<%=duongdananh%>" alt="Avatar" class="avatar-square" width="300" />
									<div class="mb-3">
										<label for="duongdananh" class="form-label">Image path</label>
										<input type="file" class="form-control" id="duongdananh" name="duongdananh">
									</div>
									<input class="btn btn-primary form-control" type="submit" value="Save information" name="submit" id="submit" />
								</div>
							</div>
						</form>
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
</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/css/bootstrap4/popper.js"></script>
<script src="${pageContext.request.contextPath}/assets/css/bootstrap4/bootstrap.min.js"></script>
</html>