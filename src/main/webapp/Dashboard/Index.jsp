<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Dashboard</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="${pageContext.request.contextPath}/assets/img/favicon.png" rel="icon">
<link href="${pageContext.request.contextPath}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/simple-datatables/style.css" rel="stylesheet">

<!-- Main CSS File -->
<link href="${pageContext.request.contextPath}/assets/css/NiceAdminMain.css" rel="stylesheet">

</head>

<body>
	<!-- Tách riêng header ra file Header.jsp -->
	<jsp:include page="Parts/Header.jsp" />

	<!-- Tách riêng sidebar ra file Sidebar.jsp -->
	<jsp:include page="Parts/Sidebar.jsp" />

	<main id="main" class="main">
		<div class="pagetitle">
			<h1>Dashboard</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item">
						<a href="Index.jsp">Home</a>
					</li>
					<li class="breadcrumb-item active">Dashboard</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<!-- Sales and Revenue Section -->
				<div class="col-12">
					<h4>Sales and Revenue</h4>
					<div class="row g-3">
						<!-- Sales Card -->
						<div class="col-xxl-4 col-md-6">
							<jsp:include page="Parts/Card.jsp">
								<jsp:param name="cardType" value="sales-card" />
								<jsp:param name="title" value="Sales" />
								<jsp:param name="subtitle" value="Today" />
								<jsp:param name="icon" value="bi-cart-check" />
								<jsp:param name="value" value="145" />
								<jsp:param name="growthClass" value="text-success" />
								<jsp:param name="growthPercentage" value="12%" />
								<jsp:param name="growthText" value="increase" />
							</jsp:include>
						</div>

						<!-- Total Revenue Card -->
						<div class="col-xxl-4 col-md-6">
							<jsp:include page="Parts/Card.jsp">
								<jsp:param name="cardType" value="revenue-card" />
								<jsp:param name="title" value="Revenue" />
								<jsp:param name="subtitle" value="This Month" />
								<jsp:param name="icon" value="bi-cash-stack" />
								<jsp:param name="value" value="$3,264" />
								<jsp:param name="growthClass" value="text-success" />
								<jsp:param name="growthPercentage" value="8%" />
								<jsp:param name="growthText" value="increase" />
							</jsp:include>
						</div>
					</div>
				</div>

				<!-- Order and Product Section -->
				<div class="col-12">
					<h4>Orders and Products</h4>
					<div class="row g-3">
						<!-- Total Orders Card -->
						<div class="col-xxl-4 col-md-6">
							<jsp:include page="Parts/Card.jsp">
								<jsp:param name="cardType" value="order-card" />
								<jsp:param name="title" value="Total Orders" />
								<jsp:param name="subtitle" value="Today" />
								<jsp:param name="icon" value="bi-box-arrow-in-right" />
								<jsp:param name="value" value="52" />
								<jsp:param name="growthClass" value="text-success" />
								<jsp:param name="growthPercentage" value="5%" />
								<jsp:param name="growthText" value="increase" />
							</jsp:include>
						</div>
						<!-- Total Products Sold Card -->
						<div class="col-xxl-4 col-md-6">
							<jsp:include page="Parts/Card.jsp">
								<jsp:param name="cardType" value="product-card" />
								<jsp:param name="title" value="Total Products Sold" />
								<jsp:param name="subtitle" value="Today" />
								<jsp:param name="icon" value="bi-book" />
								<jsp:param name="value" value="43" />
								<jsp:param name="growthClass" value="text-success" />
								<jsp:param name="growthPercentage" value="8%" />
								<jsp:param name="growthText" value="increase" />
							</jsp:include>
						</div>
					</div>
				</div>

				<!-- Customer and Interaction Section -->
				<div class="col-12">
					<h4>Customer Interactions</h4>
					<div class="row g-3">
						<!-- Customer Growth Card -->
						<div class="col-xxl-4 col-md-6">
							<jsp:include page="Parts/Card.jsp">
								<jsp:param name="cardType" value="customers-card" />
								<jsp:param name="title" value="Customers" />
								<jsp:param name="subtitle" value="This Year" />
								<jsp:param name="icon" value="bi-person-add" />
								<jsp:param name="value" value="1244" />
								<jsp:param name="growthClass" value="text-danger" />
								<jsp:param name="growthPercentage" value="12%" />
								<jsp:param name="growthText" value="decrease" />
							</jsp:include>
						</div>
						<!-- New Customer Card -->
						<div class="col-xxl-4 col-md-6">
							<jsp:include page="Parts/Card.jsp">
								<jsp:param name="cardType" value="new-customers-card" />
								<jsp:param name="title" value="New Customers" />
								<jsp:param name="subtitle" value="This Year" />
								<jsp:param name="icon" value="bi-person-plus" />
								<jsp:param name="value" value="136" />
								<jsp:param name="growthClass" value="text-success" />
								<jsp:param name="growthPercentage" value="5%" />
								<jsp:param name="growthText" value="increase" />
							</jsp:include>
						</div>
					</div>
				</div>

				<!-- Operational Section -->
				<div class="col-12">
					<h4>Operational Insights</h4>
					<div class="row g-3">
						<!-- New Arrivals Card -->
						<div class="col-xxl-4 col-md-4">
							<jsp:include page="Parts/Card.jsp">
								<jsp:param name="cardType" value="new-arrivals-card" />
								<jsp:param name="title" value="New Arrivals" />
								<jsp:param name="subtitle" value="This Week" />
								<jsp:param name="icon" value="bi-card-heading" />
								<jsp:param name="value" value="20" />
								<jsp:param name="growthClass" value="text-primary" />
								<jsp:param name="growthPercentage" value="5%" />
								<jsp:param name="growthText" value="increase" />
							</jsp:include>
						</div>
						<!-- Bestsellers Card -->
						<div class="col-xxl-4 col-md-4">
							<jsp:include page="Parts/Card.jsp">
								<jsp:param name="cardType" value="bestsellers-card" />
								<jsp:param name="title" value="Bestsellers" />
								<jsp:param name="subtitle" value="This Month" />
								<jsp:param name="icon" value="bi-star-fill" />
								<jsp:param name="value" value="10" />
								<jsp:param name="growthClass" value="text-success" />
								<jsp:param name="growthPercentage" value="15%" />
								<jsp:param name="growthText" value="increase" />
							</jsp:include>
						</div>
						<!-- Top Selling Books Card -->
						<div class="col-xxl-4 col-md-4">
							<jsp:include page="Parts/Card.jsp">
								<jsp:param name="cardType" value="top-selling-books-card" />
								<jsp:param name="title" value="Top Selling Books" />
								<jsp:param name="subtitle" value="This Month" />
								<jsp:param name="icon" value="bi-book" />
								<jsp:param name="value" value="5" />
								<jsp:param name="growthClass" value="text-danger" />
								<jsp:param name="growthPercentage" value="5%" />
								<jsp:param name="growthText" value="decrease" />
							</jsp:include>
						</div>
					</div>
				</div>
			</div>

			<!-- Reports -->
			<div class="col-12">
				<div class="card">

					<div class="filter">
						<a class="icon" href="#" data-bs-toggle="dropdown">
							<i class="bi bi-three-dots"></i>
						</a>
						<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
							<li class="dropdown-header text-start">
								<h6>Filter</h6>
							</li>

							<li>
								<a class="dropdown-item" href="#">Today</a>
							</li>
							<li>
								<a class="dropdown-item" href="#">This Month</a>
							</li>
							<li>
								<a class="dropdown-item" href="#">This Year</a>
							</li>
						</ul>
					</div>

					<div class="card-body">
						<h5 class="card-title">
							Reports
							<span>/Today</span>
						</h5>

						<!-- Line Chart -->
						<div id="reportsChart"></div>

						<script>
                    document.addEventListener("DOMContentLoaded", () => {
                      new ApexCharts(document.querySelector("#reportsChart"), {
                        series: [{
                          name: 'Sales',
                          data: [31, 40, 28, 51, 42, 82, 56],
                        }, {
                          name: 'Revenue',
                          data: [11, 32, 45, 32, 34, 52, 41]
                        }, {
                          name: 'Customers',
                          data: [15, 11, 32, 18, 9, 24, 11]
                        }],
                        chart: {
                          height: 350,
                          type: 'area',
                          toolbar: {
                            show: false
                          },
                        },
                        markers: {
                          size: 4
                        },
                        colors: ['#4154f1', '#2eca6a', '#ff771d'],
                        fill: {
                          type: "gradient",
                          gradient: {
                            shadeIntensity: 1,
                            opacityFrom: 0.3,
                            opacityTo: 0.4,
                            stops: [0, 90, 100]
                          }
                        },
                        dataLabels: {
                          enabled: false
                        },
                        stroke: {
                          curve: 'smooth',
                          width: 2
                        },
                        xaxis: {
                          type: 'datetime',
                          categories: ["2018-09-19T00:00:00.000Z", "2018-09-19T01:30:00.000Z", "2018-09-19T02:30:00.000Z", "2018-09-19T03:30:00.000Z", "2018-09-19T04:30:00.000Z", "2018-09-19T05:30:00.000Z", "2018-09-19T06:30:00.000Z"]
                        },
                        tooltip: {
                          x: {
                            format: 'dd/MM/yy HH:mm'
                          },
                        }
                      }).render();
                    });
                  </script>
						<!-- End Line Chart -->
					</div>
				</div>
			</div>
			<!-- End Reports -->
		</section>
	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<!-- Back to top button -->
	<a href="#" class="back-to-top d-flex align-items-center justify-content-center">
		<i class="bi bi-arrow-up-short"></i>
	</a>

	<!-- Vendor JS Files -->
	<script src="${pageContext.request.contextPath}/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/chart.js/chart.umd.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/echarts/echarts.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/quill/quill.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/php-email-form/validate.js"></script>

	<!-- Main JS File -->
	<script src="${pageContext.request.contextPath}/assets/js/NiceAdminMain.js"></script>
</body>
</html>