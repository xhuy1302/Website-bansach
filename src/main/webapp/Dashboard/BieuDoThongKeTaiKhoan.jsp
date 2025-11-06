<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>
<%@ page import="database.KhachHangDAO"%>
<%@ page import="model.KhachHang"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="keywords" content="">
<title>Account Statistics by Month</title>

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
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<!-- Template Main CSS File -->
<link href="${pageContext.request.contextPath}/assets/css/NiceAdminMain.css" rel="stylesheet">
<style>
.pagination .page-link {
	color: #007bff; /* Màu xanh đẹp */
	border: 1px solid #dee2e6;
	transition: background-color 0.3s, color 0.3s;
}

.pagination .page-item.active .page-link {
	background-color: #007bff;
	color: #fff;
	border-color: #007bff;
}

.pagination .page-link:hover {
	background-color: #f8f9fa;
	color: #0056b3;
}

.card {
	border-radius: 12px;
	padding: 15px;
	transition: transform 0.3s ease, box-shadow 0.3s ease;
	background-color: #ff4c4c; /* Màu nền đỏ */
	width: 250px; /* Giảm kích thước thẻ */
	margin: 0 auto; /* Canh giữa thẻ */
}

.card:hover {
	transform: scale(1.05);
	box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
}

.card-title {
	font-size: 20px;
	color: #fff; /* Màu chữ trắng */
	font-weight: bold;
}

.card-text {
	font-size: 30px;
	color: #fff; /* Màu chữ trắng */
	font-weight: bold;
}

.card-body {
	padding: 15px;
	text-align: center;
}
</style>
</head>
<body>
	<!-- Tách riêng header ra file Header.jsp -->
	<jsp:include page="Parts/Header.jsp" />

	<!-- Tách riêng sidebar ra file Sidebar.jsp -->
	<jsp:include page="Parts/Sidebar.jsp" />

	<!-- Nội dung chính (Account Management) -->

	<main id="main" class="main">

		<%
		// Lấy thống kê số tài khoản theo tháng từ DAO
		KhachHangDAO khDAO = new KhachHangDAO();
		int[] monthlyStats = khDAO.getAccountStatisticsByMonth(); // Giả sử hàm này trả về mảng gồm số tài khoản theo từng tháng (12 tháng)

		// Kiểm tra giá trị trả về của monthlyStats
		if (monthlyStats == null || monthlyStats.length < 12) {
			monthlyStats = new int[12]; // Đảm bảo có đủ 12 tháng
		}
		%>
		<%
		// Tính tổng số tài khoản từ mảng monthlyStats
		int totalAccounts = 0;
		for (int i = 0; i < monthlyStats.length; i++) {
			totalAccounts += monthlyStats[i];
		}
		%>
		<div class="container py-4">
			<div class="pagetitle">
				<h1>Account Statistics by Month</h1>
				<nav>
					<ol class="breadcrumb">
						<li class="breadcrumb-item">
							<a href="${pageContext.request.contextPath}/Dashboard/Index.jsp">Home</a>
						</li>
						<li class="breadcrumb-item active">Account Statistics by Month</li>
					</ol>
				</nav>
			</div>

			<!-- Hiển thị tổng số tài khoản -->
			<div class="card text-center mb-4" style="background-color: #ff4c4c; border-radius: 12px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); width: 250px; margin: 0 auto;">
				<div class="card-body">
					<h4 class="card-title" style="font-size: 20px; color: #fff; font-weight: bold;">Total Accounts</h4>
					<h2 class="card-text" style="font-size: 30px; color: #fff; font-weight: bold;">
						<%=totalAccounts%>
					</h2>
				</div>
			</div>

			<!-- Biểu đồ -->
			<canvas id="accountStatsChart" width="400" height="200"></canvas>
		</div>
	</main>

	<!-- Vendor JS Files -->

	<script>
		document.addEventListener("DOMContentLoaded", function() {
			// Dữ liệu cho biểu đồ
			var data = {
				labels : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul',
						'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ], // Tên các tháng
				datasets : [ {
					label : 'User Accounts per Month',
					data : [
	<%=monthlyStats[0]%>
		,
	<%=monthlyStats[1]%>
		,
	<%=monthlyStats[2]%>
		,
	<%=monthlyStats[3]%>
		,
	<%=monthlyStats[4]%>
		,
	<%=monthlyStats[5]%>
		,
	<%=monthlyStats[6]%>
		,
	<%=monthlyStats[7]%>
		,
	<%=monthlyStats[8]%>
		,
	<%=monthlyStats[9]%>
		,
	<%=monthlyStats[10]%>
		,
	<%=monthlyStats[11]%>
		], // Dữ liệu từ Java
					backgroundColor : '#36a2eb', // Màu sắc cột
					borderColor : '#36a2eb', // Màu viền cột
					borderWidth : 1
				} ]
			};

			// Tạo biểu đồ cột
			var ctx = document.getElementById('accountStatsChart').getContext(
					'2d');
			var accountStatsChart = new Chart(ctx, {
				type : 'bar', // Loại biểu đồ (bar)
				data : data,
				options : {
					responsive : true,
					plugins : {
						legend : {
							position : 'top',
						},
						tooltip : {
							callbacks : {
								label : function(tooltipItem) {
									return tooltipItem.label + ': '
											+ tooltipItem.raw + ' accounts';
								}
							}
						}
					},
					scales : {
						y : {
							beginAtZero : true
						// Đảm bảo trục Y bắt đầu từ 0
						}
					}
				}
			});
		});
	</script>

	<!-- Template Main JS File -->
	<script src="${pageContext.request.contextPath}/assets/js/NiceAdminMain.js"></script>

	<!-- ======= Footer ======= -->
	<!-- Back to top button -->
	<a href="#" class="back-to-top d-flex align-items-center justify-content-center">
		<i class="bi bi-arrow-up-short"></i>
	</a>

	<!-- Vendor JS Files -->
	<script src="../assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="../assets/vendor/chart.js/chart.umd.js"></script>
	<script src="../assets/vendor/echarts/echarts.min.js"></script>
	<script src="../assets/vendor/quill/quill.js"></script>
	<script src="../assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="../assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="../assets/vendor/php-email-form/validate.js"></script>

	<!-- Main JS File -->
	<script src="../assets/js/NiceAdminMain.js"></script>
</body>
</html>
