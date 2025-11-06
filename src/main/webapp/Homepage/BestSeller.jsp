<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Trang chủ</title>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta name="description" content="">
<meta name="keywords" content="">

<!-- Favicons -->
<link href="${pageContext.request.contextPath}/assets/img/favicon.png" rel="icon">
<link href="${pageContext.request.contextPath}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Fonts -->
<link href="https://fonts.googleapis.com" rel="preconnect">
<link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/aos/aos.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">

<!-- Main CSS File -->
<link href="${pageContext.request.contextPath}/assets/css/GpMain.css" rel="stylesheet">
</head>
<body class="index-page">
	<!-- Tách riêng header ra file Header.jsp -->
	<jsp:include page="Parts/Header.jsp" />

	<main class="main">

		<!-- Hero Section -->
		<section id="hero" class="hero section dark-background">
			<img src="${pageContext.request.contextPath}/assets/img/background/HeroBG.jpg" alt="" data-aos="fade-in">
			<div class="container">
				<div class="row justify-content-center text-center" data-aos="fade-up" data-aos-delay="100">
					<div class="col-xl-6 col-lg-8">
						<h2>Group 13 Books Selling Website</h2>
						<p>Popular books of the store</p>
					</div>
				</div>

				<div class="row gy-4 mt-5 justify-content-center" data-aos="fade-up" data-aos-delay="200">
					<div class="col-xl-2 col-md-4" data-aos="fade-up" data-aos-delay="300">
						<div class="icon-box">
							<i class="bi bi-journal-bookmark"></i>
							<h3>
								<a href="">Foreign</a>
							</h3>
						</div>
					</div>

					<div class="col-xl-2 col-md-4" data-aos="fade-up" data-aos-delay="400">
						<div class="icon-box">
							<i class="bi bi-motherboard"></i>
							<h3>
								<a href="">ITs</a>
							</h3>
						</div>
					</div>

					<div class="col-xl-2 col-md-4" data-aos="fade-up" data-aos-delay="500">
						<div class="icon-box">
							<i class="bi bi-vector-pen"></i>
							<h3>
								<a href="">Literature</a>
							</h3>
						</div>
					</div>

					<div class="col-xl-2 col-md-4" data-aos="fade-up" data-aos-delay="600">
						<div class="icon-box">
							<i class="bi bi-pencil-square"></i>
							<h3>
								<a href="">Light Novel</a>
							</h3>
						</div>
					</div>

					<div class="col-xl-2 col-md-4" data-aos="fade-up" data-aos-delay="700">
						<div class="icon-box">
							<i class="bi bi-gem"></i>
							<h3>
								<a href="">Life Skill</a>
							</h3>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- /Hero Section -->

		<!-- Bestseller section -->
		<section id="bestseller" class="bestseller section">
			<!-- Section Title -->
			<div class="container section-title" data-aos="fade-up">
				<h2>Bestsellers</h2>
				<p>Discover our top-selling books and don't miss out!</p>
			</div>
			<!-- End Section Title -->

			<div class="container">
				<div class="row gy-4">
					<!-- Bestseller Item -->
					<div class="col-lg-4 col-md-6 bestseller-item" data-aos="fade-up" data-aos-delay="100">
						<div class="bestseller-card text-left border p-4 d-flex flex-column" style="height: 100%; min-height: 500px; border-radius: 20px;">
							<div class="img-container" style="height: 300px; overflow: hidden; border-radius: 15px;">
								<img src="${pageContext.request.contextPath}/assets/img/books/Literature/2024_06_11_10_32_29_1-390x510.jpg" alt="The Lost World" class="img-fluid w-100 h-100" style="object-fit: cover;">
							</div>
							<h3 class="mt-3" style="font-weight: 600; font-size: 1.2em; color: #333;">The Lost World</h3>
							<div class="price-section mt-3">
								<p class="price fw-bold text-danger" style="font-size: 1.5em;">$15.99</p>
								<p class="discount-badge text-white d-inline-block" style="background-color: red; padding: 6px 12px; border-radius: 5px; font-size: 0.9em;">20% OFF</p>
								<p class="text-muted mt-2" style="text-decoration: line-through; font-size: 1em;">$19.99</p>
								<p class="sold text-muted mt-2" style="font-size: 0.9em;">Sold: 500</p>
							</div>
						</div>
					</div>
					<!-- End Bestseller Item -->

					<!-- Bestseller Item -->
					<div class="col-lg-4 col-md-6 bestseller-item" data-aos="fade-up" data-aos-delay="200">
						<div class="bestseller-card text-left border p-4 d-flex flex-column" style="height: 100%; min-height: 500px; border-radius: 20px;">
							<div class="img-container" style="height: 300px; overflow: hidden; border-radius: 15px;">
								<img src="${pageContext.request.contextPath}/assets/img/books/IT/chat-gpt-va-10-ung-dung-ai-dinh.jpg" alt="The Lost River" class="img-fluid w-100 h-100" style="object-fit: cover;">
							</div>
							<h3 class="mt-3" style="font-weight: 600; font-size: 1.2em; color: #333;">The Lost River</h3>
							<div class="price-section mt-3">
								<p class="price fw-bold text-danger" style="font-size: 1.5em;">$11.99</p>
								<p class="discount-badge text-white d-inline-block" style="background-color: red; padding: 6px 12px; border-radius: 5px; font-size: 0.9em;">40% OFF</p>
								<p class="text-muted mt-2" style="text-decoration: line-through; font-size: 1em;">$19.99</p>
								<p class="sold text-muted mt-2" style="font-size: 0.9em;">Sold: 350</p>
							</div>
						</div>
					</div>
					<!-- End Bestseller Item -->

					<!-- Bestseller Item -->
					<div class="col-lg-4 col-md-6 bestseller-item" data-aos="fade-up" data-aos-delay="300">
						<div class="bestseller-card text-left border p-4 d-flex flex-column" style="height: 100%; min-height: 500px; border-radius: 20px;">
							<div class="img-container" style="height: 300px; overflow: hidden; border-radius: 15px;">
								<img src="${pageContext.request.contextPath}/assets/img/books/Novel/bia_thuong_toan_cau_tien_hoa_1_5.jpg" alt="The Great Adventure" class="img-fluid w-100 h-100" style="object-fit: cover;">
							</div>
							<h3 class="mt-3" style="font-weight: 600; font-size: 1.2em; color: #333;">The Great Adventure</h3>
							<div class="price-section mt-3">
								<p class="price fw-bold text-danger" style="font-size: 1.5em;">$21.99</p>
								<p class="discount-badge text-white d-inline-block" style="background-color: red; padding: 6px 12px; border-radius: 5px; font-size: 0.9em;">12% OFF</p>
								<p class="text-muted mt-2" style="text-decoration: line-through; font-size: 1em;">$24.99</p>
								<p class="sold text-muted mt-2" style="font-size: 0.9em;">Sold: 200</p>
							</div>
						</div>
					</div>
					<!-- End Bestseller Item -->
				</div>

				<!-- View More Button -->
				<div class="d-flex justify-content-end mt-4">
					<a href="#" class="btn view-more-btn">View More Bestsellers</a>
				</div>
			</div>
		</section>
		<style>
/* General Button Styling */
.view-more-btn {
	background: linear-gradient(90deg, #f56e6a, #f1b8b4);
	color: white;
	font-weight: bold;
	font-size: 1.2em;
	border: none;
	border-radius: 50px;
	padding: 12px 30px;
	transition: all 0.3s ease-in-out;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	text-transform: uppercase;
}

/* Hover Effects */
.view-more-btn:hover {
	background: linear-gradient(90deg, #f1b8b4, #f56e6a);
	box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
	transform: translateY(-3px);
}

/* Bestseller Card Improvements */
.bestseller-card {
	border: 1px solid #ddd;
	border-radius: 20px;
	overflow: hidden;
	background-color: #fff;
	transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
}

.bestseller-card:hover {
	transform: translateY(-5px);
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
}

/* Discount Badge */
.discount-badge {
	display: inline-block;
	font-size: 0.9em;
	font-weight: bold;
}

/* Price Section */
.price-section p {
	margin: 0;
}

.price-section .price {
	margin-bottom: 5px;
}

/* Product Info Styling */
.bestseller-card h3 {
	font-size: 1.3em;
	color: #333;
}

.bestseller-card .sold {
	color: #999;
	font-size: 0.9em;
}

/* Image Container Styling */
.img-container {
	position: relative;
	height: 250px;
	overflow: hidden;
	border-radius: 15px;
}

.img-container img {
	object-fit: cover;
	width: 100%;
	height: 100%;
}
</style>
		<!-- End Bestseller  -->

	</main>

	<!-- Scroll Top -->
	<a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center">
		<i class="bi bi-arrow-up-short"></i>
	</a>

	<!-- Preloader -->
	<div id="preloader"></div>

	<!-- Vendor JS Files -->
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/php-email-form/validate.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/aos/aos.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/purecounter/purecounter_vanilla.js"></script>

	<!-- Main JS File -->
	<script src="${pageContext.request.contextPath}/assets/js/GpMain.js"></script>
</body>
</html>