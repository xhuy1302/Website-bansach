<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Your Cart and Checkout</title>

<!-- Vendor CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/bootstrap-icons/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/main_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/responsive.css">

<!-- Main CSS -->
<link href="${pageContext.request.contextPath}/assets/css/GpMain.css" rel="stylesheet">

<style>
.btn:hover {
	transform: scale(1.02);
	transition: 0.3s;
}

.table-primary th {
	background-color: #6c63ff;
	color: #fff;
}

img {
	width: 100px;
	height: 100px;
	object-fit: cover;
}
</style>
</head>

<body>
	<div class="super_container">

		<!-- Header Section -->
		<div class="main_nav_container">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-right">
						<div class="logo_container">
							<a href="${pageContext.request.contextPath}/Homepage/Home.jsp">
								Group
								<span>13</span>
							</a>
						</div>
						<nav class="navbar">
							<ul class="navbar_menu">
								<li>
									<a href="${pageContext.request.contextPath}/Homepage/Home.jsp">home</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/Homepage/TheLoai.jsp">shop</a>
								</li>
								<li>
									<a href="#">promotion</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/Homepage/LienHe.jsp">contact</a>
								</li>
							</ul>
							<ul class="navbar_user">
								<li>
									<!-- Tìm kiếm -->
									<form action="Search" method="get" class="d-flex align-items-center">
										<input type="text" name="query" class="form-control me-2" placeholder="Search..." style="max-width: 200px; border-radius: 4px;">
										<button type="submit" class="btn btn-outline-secondary">
											<i class="fa fa-search"></i>
										</button>
									</form>
								</li>
							</ul>
							<div class="hamburger_container">
								<i class="fa fa-bars" aria-hidden="true"></i>
							</div>
						</nav>
					</div>
				</div>
			</div>
		</div>

		<!-- Cart Section -->
		<section id="cart" class="cart section">
			<div class="container">
				<h2 class="text-center mt-5 text-primary">
					<i class="bi bi-cart4"></i>
					Your Cart
				</h2>
				<p class="text-center text-muted">Please review the products before proceeding to checkout.</p>

				<!-- Cart Table -->
				<div class="table-responsive mt-4">
					<table class="table table-bordered text-center align-middle">
						<thead class="table-primary">
							<tr>
								<th>Image</th>
								<th>Product Name</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Total Price</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${gioHangList}">
								<tr>
									<td>
										<img src="${item.image}" alt="${item.tensanpham}">
									</td>
									<td class="fw-bold">${item.tensanpham}</td>
									<td>
										<fmt:formatNumber value="${item.gia}" type="currency" />
									</td>
									<td>
										<form action="${pageContext.request.contextPath}/updateCart" method="post" class="d-flex align-items-center">
											<input type="hidden" name="productId" value="${item.masanpham}">
											<input type="number" name="quantity" value="${item.soluong}" min="1" class="form-control text-center" style="width: 80px;">
											<button type="submit" class="btn btn-sm btn-success ms-2">
												<i class="bi bi-arrow-repeat"></i>
											</button>
										</form>
									</td>
									<td class="text-success">
										<fmt:formatNumber value="${item.gia * item.soluong}" type="currency" />
									</td>
									<td>
										<form action="${pageContext.request.contextPath}/DeleteGioHang" method="post">
											<input type="hidden" name="productId" value="${item.masanpham}">
											<button type="submit" class="btn btn-sm btn-danger">
												<i class="bi bi-trash"></i>
												Remove
											</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th colspan="4" class="text-end">Total:</th>
								<th class="text-success fw-bold">
									<fmt:formatNumber value="${totalPrice}" type="currency" />
								</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</section>

		<!-- Payment Form -->
		<section id="checkout" class="checkout section">
			<div class="container mt-5">
				<h2 class="text-center text-primary">
					<i class="bi bi-cash-coin"></i>
					Payment Details
				</h2>
				<form action="${pageContext.request.contextPath}/processPayment" method="post" class="mt-4">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group mb-3">
								<label for="customerName" class="form-label">Full Name:</label>
								<input type="text" name="customerName" id="customerName" class="form-control" placeholder="Enter your full name" required>
							</div>
							<div class="form-group mb-3">
								<label for="email" class="form-label">Email:</label>
								<input type="email" name="email" id="email" class="form-control" placeholder="Enter your email address" required>
							</div>
							<div class="form-group mb-3">
								<label for="phone" class="form-label">Phone:</label>
								<input type="tel" name="phone" id="phone" class="form-control" placeholder="Enter your phone number" required>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group mb-3">
								<label for="address" class="form-label">Address:</label>
								<textarea name="address" id="address" class="form-control" rows="4" placeholder="Enter your shipping address" required></textarea>
							</div>
							<div class="form-group mb-3">
								<label for="paymentMethod" class="form-label">Payment Method:</label>
								<select name="paymentMethod" id="paymentMethod" class="form-select" required>
									<option value="credit_card">Credit Card</option>
									<option value="paypal">PayPal</option>
									<option value="cash_on_delivery">Cash on Delivery</option>
								</select>
							</div>
						</div>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary btn-lg">
							<i class="bi bi-check-circle"></i>
							Confirm Payment
						</button>
					</div>
				</form>
			</div>
		</section>

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

	<a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center">
		<i class="bi bi-arrow-up-short"></i>
	</a>

	<!-- Vendor JS -->
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>