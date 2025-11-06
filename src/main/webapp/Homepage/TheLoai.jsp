<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Thể loại</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Colo Shop Template">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/bootstrap-icons/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/vendor/jquery-ui-1.12.1.custom/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/categories_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/categories_responsive.css">
</head>

<body>
	<div class="super_container">
		<!-- Tách riêng header ra file Header.jsp -->
		<jsp:include page="Parts/Header.jsp" />

		<div class="container product_section_container">
			<div class="row">
				<div class="col product_section clearfix">

					<!-- Breadcrumbs -->
					<div class="breadcrumbs d-flex flex-row align-items-center">
						<ul>
							<li>
								<a href="${pageContext.request.contextPath}/Homepage/TrangChu.jsp">Home</a>
							</li>
							<li class="active">
								<a href="${pageContext.request.contextPath}/Homepage/TrangChu.jsp">
									<i class="fa fa-angle-right" aria-hidden="true"></i>
									Products
								</a>
							</li>
						</ul>
					</div>

					<!-- Sidebar -->
					<div class="sidebar">
						<div class="sidebar_section">
							<div class="sidebar_title">
								<h5>Product Category</h5>
							</div>
							<ul class="sidebar_categories">
								<li>
									<a href="#">Foreign</a>
								</li>
								<li class="active">
									<a href="#">
										<span>
											<i class="fa fa-angle-double-right" aria-hidden="true"></i>
										</span>
										IT
									</a>
								</li>
								<li>
									<a href="#">Life Skill</a>
								</li>
								<li>
									<a href="#">Light Novel</a>
								</li>
								<li>
									<a href="#">Literature</a>
								</li>
								<li>
									<a href="#">Novel</a>
								</li>
							</ul>
						</div>

						<!-- Price Range Filtering -->
						<div class="sidebar_section">
							<div class="sidebar_title">
								<h5>Filter by Price</h5>
							</div>
							<p>
								<input type="text" id="amount" readonly style="border: 0; color: #f6931f; font-weight: bold;">
							</p>
							<div id="slider-range"></div>
							<div class="filter_button">
								<span>filter</span>
							</div>
						</div>

						<!-- Sizes -->
						<div class="sidebar_section">
							<div class="sidebar_title">
								<h5>
									Rating (
									<i class="bi bi-star-fill"></i>
									)
								</h5>
							</div>
							<ul class="checkboxes">
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span> 0-1 </span>
								</li>
								<li class="active">
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span> 1-2 </span>
								</li>
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span> 2-3 </span>
								</li>
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span> 3-4 </span>
								</li>
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span> 4-5 </span>
								</li>
							</ul>
						</div>

						<!-- Color -->
						<div class="sidebar_section">
							<div class="sidebar_title">
								<h5>Book Type</h5>
							</div>
							<ul class="checkboxes">
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span>Classic</span>
								</li>
								<li class="active">
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span>Special Edition</span>
								</li>
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span>E-Book</span>
								</li>
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span>Audio Books</span>
								</li>
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span>Hardcover</span>
								</li>
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span>Paperback</span>
								</li>
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span>Limited Edition</span>
								</li>
								<li>
									<i class="fa fa-square-o" aria-hidden="true"></i>
									<span>Digital Bundle</span>
								</li>
							</ul>
							<div class="show_more">
								<span>
									<span>+</span>
									Show More
								</span>
							</div>
						</div>
					</div>

					<!-- Main Content -->

					<div class="main_content">

						<!-- Products -->
						<div class="products_iso">
							<div class="row">
								<div class="col">

									<!-- Product Sorting -->
									<div class="product_sorting_container product_sorting_container_top">
										<ul class="product_sorting">
											<li>
												<span class="type_sorting_text">Default Sorting</span>
												<i class="fa fa-angle-down"></i>
												<ul class="sorting_type">
													<li class="type_sorting_btn" data-isotope-option='{ "sortBy": "original-order" }'>
														<span>Default Sorting</span>
													</li>
													<li class="type_sorting_btn" data-isotope-option='{ "sortBy": "price" }'>
														<span>Price</span>
													</li>
													<li class="type_sorting_btn" data-isotope-option='{ "sortBy": "name" }'>
														<span>Product Name</span>
													</li>
												</ul>
											</li>
											<li>
												<span>Show</span>
												<span class="num_sorting_text">12</span>
												<i class="fa fa-angle-down"></i>
												<ul class="sorting_num">
													<li class="num_sorting_btn">
														<span>6</span>
													</li>
													<li class="num_sorting_btn">
														<span>12</span>
													</li>
													<li class="num_sorting_btn">
														<span>24</span>
													</li>
												</ul>
											</li>
										</ul>
										<div class="pages d-flex flex-row align-items-center">
											<div class="page_current">
												<span>1</span>
												<ul class="page_selection">
													<li>
														<a href="#">1</a>
													</li>
													<li>
														<a href="#">2</a>
													</li>
													<li>
														<a href="#">3</a>
													</li>
												</ul>
											</div>
											<div class="page_total">
												<span>of</span>
												3
											</div>
											<div id="next_page" class="page_next">
												<a href="#">
													<i class="fa fa-long-arrow-right" aria-hidden="true"></i>
												</a>
											</div>
										</div>

									</div>

									<!-- Product Grid -->
									<div class="product-grid">
										<jsp:include page="Parts/BookCard.jsp">
											<jsp:param name="category" value="literature" />
											<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/books/Literature/8935278607373_1.jpg" />
											<jsp:param name="productName" value="Phố xưa người cũ" />
											<jsp:param name="price" value="10.00" />
											<jsp:param name="newPrice" value="8.00" />
											<jsp:param name="productId" value="121" />
											<jsp:param name="bubbleText" value="-20%" />
											<jsp:param name="bubbleType" value="red" />
											<jsp:param name="addToCart" value="true" />
										</jsp:include>

										<jsp:include page="Parts/BookCard.jsp">
											<jsp:param name="category" value="literature" />
											<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/books/Literature/8935235240308.jpg" />
											<jsp:param name="productName" value="Những chuyện lạ ở Tokyo" />
											<jsp:param name="price" value="12.00" />
											<jsp:param name="productId" value="122" />
											<jsp:param name="bubbleText" value="new" />
											<jsp:param name="bubbleType" value="green" />
											<jsp:param name="addToCart" value="true" />
										</jsp:include>

										<jsp:include page="Parts/BookCard.jsp">
											<jsp:param name="category" value="lightnovel" />
											<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/books/Light Novel/bia_ngoai_ari1_1994aeafbbd9452fa.jpg" />
											<jsp:param name="productName" value="Arifureta – Từ tầm thường đến bất khả chiến bại" />
											<jsp:param name="price" value="12.00" />
											<jsp:param name="productId" value="123" />
											<jsp:param name="addToCart" value="true" />
										</jsp:include>

										<jsp:include page="Parts/BookCard.jsp">
											<jsp:param name="category" value="novel" />
											<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/books/Novel/bia_thuong_toan_cau_tien_hoa_1_5.jpg" />
											<jsp:param name="productName" value="Toàn cầu tiến hoá" />
											<jsp:param name="price" value="10.00" />
											<jsp:param name="productId" value="124" />
											<jsp:param name="bubbleText" value="sale" />
											<jsp:param name="bubbleType" value="red" />
											<jsp:param name="addToCart" value="true" />
										</jsp:include>

										<jsp:include page="Parts/BookCard.jsp">
											<jsp:param name="category" value="it" />
											<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/books/IT/hanh-trang-lap-trinh_105192_1.jpg" />
											<jsp:param name="productName" value="Hành trang lập trình" />
											<jsp:param name="price" value="18.00" />
											<jsp:param name="productId" value="125" />
											<jsp:param name="addToCart" value="true" />
										</jsp:include>

										<jsp:include page="Parts/BookCard.jsp">
											<jsp:param name="category" value="foreign" />
											<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/books/Foreign/-25-chuyen-de-ngu-phap-tieng-anh.jpg" />
											<jsp:param name="productName" value="25 chuyên đề ngữ pháp Tiếng Anh" />
											<jsp:param name="price" value="15.00" />
											<jsp:param name="newPrice" value="10.00" />
											<jsp:param name="productId" value="126" />
											<jsp:param name="bubbleText" value="-33%" />
											<jsp:param name="bubbleType" value="red" />
											<jsp:param name="addToCart" value="true" />
										</jsp:include>

										<jsp:include page="Parts/BookCard.jsp">
											<jsp:param name="category" value="it" />
											<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/books/IT/chat-gpt-va-10-ung-dung-ai-dinh.jpg" />
											<jsp:param name="productName" value="ChatGPT và 10 ứng dụng AI đình đám" />
											<jsp:param name="price" value="20.00" />
											<jsp:param name="productId" value="127" />
											<jsp:param name="addToCart" value="true" />
										</jsp:include>

										<jsp:include page="Parts/BookCard.jsp">
											<jsp:param name="category" value="it" />
											<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/books/IT/tu-hoc-c-va-sql-server-2008_1434.jpg" />
											<jsp:param name="productName" value="Tự học C# và hệ CSDL SQL Server" />
											<jsp:param name="price" value="25.00" />
											<jsp:param name="productId" value="128" />
											<jsp:param name="addToCart" value="true" />
										</jsp:include>

										<jsp:include page="Parts/BookCard.jsp">
											<jsp:param name="category" value="lifeskill" />
											<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/books/Life Skill/bia_hoc_cach_yeu_duong_voi_cong.jpg" />
											<jsp:param name="productName" value="Học cách yêu đương với công việc" />
											<jsp:param name="price" value="15.00" />
											<jsp:param name="productId" value="129" />
											<jsp:param name="bubbleText" value="sale" />
											<jsp:param name="bubbleType" value="red" />
											<jsp:param name="addToCart" value="true" />
										</jsp:include>

										<jsp:include page="Parts/BookCard.jsp">
											<jsp:param name="category" value="lifeskill" />
											<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/books/Life Skill/tu-duy-phan-bien-trong-the-gioi.jpg" />
											<jsp:param name="productName" value="Tư duy phản biện trong thế giới VUCA" />
											<jsp:param name="price" value="18.00" />
											<jsp:param name="productId" value="130" />
											<jsp:param name="addToCart" value="true" />
										</jsp:include>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Benefit -->
			<div class="benefit">
				<div class="container">
					<div class="row benefit_row">
						<div class="col-lg-3 benefit_col">
							<div class="benefit_item d-flex flex-row align-items-center">
								<div class="benefit_icon">
									<i class="fa fa-truck" aria-hidden="true"></i>
								</div>
								<div class="benefit_content">
									<h6>free shipping</h6>
									<p>Suffered Alteration in Some Form</p>
								</div>
							</div>
						</div>
						<div class="col-lg-3 benefit_col">
							<div class="benefit_item d-flex flex-row align-items-center">
								<div class="benefit_icon">
									<i class="fa fa-money" aria-hidden="true"></i>
								</div>
								<div class="benefit_content">
									<h6>cach on delivery</h6>
									<p>The Internet Tend To Repeat</p>
								</div>
							</div>
						</div>
						<div class="col-lg-3 benefit_col">
							<div class="benefit_item d-flex flex-row align-items-center">
								<div class="benefit_icon">
									<i class="fa fa-undo" aria-hidden="true"></i>
								</div>
								<div class="benefit_content">
									<h6>45 days return</h6>
									<p>Making it Look Like Readable</p>
								</div>
							</div>
						</div>
						<div class="col-lg-3 benefit_col">
							<div class="benefit_item d-flex flex-row align-items-center">
								<div class="benefit_icon">
									<i class="fa fa-clock-o" aria-hidden="true"></i>
								</div>
								<div class="benefit_content">
									<h6>opening all week</h6>
									<p>8AM - 09PM</p>
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
							<div class="newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center">
								<input id="newsletter_email" type="email" placeholder="Your email" required="required" data-error="Valid email is required.">
								<button id="newsletter_submit" type="submit" class="newsletter_submit_btn trans_300" value="Submit">subscribe</button>
							</div>
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
	</div>

	<script src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/css/bootstrap4/popper.js"></script>
	<script src="${pageContext.request.contextPath}/assets/css/bootstrap4/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/Isotope/isotope.pkgd.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/OwlCarousel2-2.2.1/owl.carousel.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/easing/easing.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/categories_custom.js"></script>
</body>

</html>
