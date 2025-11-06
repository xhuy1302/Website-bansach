<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thanh toán thành công</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f9fa;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 600px;
	margin: 50px auto;
	padding: 30px;
	background-color: white;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.container h1 {
	color: #28a745;
	font-size: 36px;
}

.container p {
	font-size: 18px;
	color: #555;
}

.icon {
	font-size: 80px;
	color: #28a745;
}

.btn {
	display: inline-block;
	padding: 12px 20px;
	font-size: 16px;
	color: white;
	background-color: #007bff;
	text-decoration: none;
	border-radius: 5px;
	margin-top: 20px;
	transition: background-color 0.3s;
}

.btn:hover {
	background-color: #0056b3;
}

.btn:focus {
	outline: none;
}
</style>
</head>
<body>
	<div class="container">
		<div class="icon">&#x2714;</div>
		<!-- Check mark icon -->
		<h1>Đặt Hàng Thành Công</h1>
		<p>Cảm ơn bạn đã mua hàng! Đơn hàng của bạn đang được xử lý. Bạn sẽ nhận được email xác nhận trong thời gian sớm nhất.</p>
		<a href="Home.jsp" class="btn">Quay lại trang chủ</a>
	</div>
</body>
</html>
