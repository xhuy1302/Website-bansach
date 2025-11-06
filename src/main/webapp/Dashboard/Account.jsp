<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${empty listkhp}">
	<c:redirect url="/ManageKhachHang" />
</c:if>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="keywords" content="">
<title>Accounts Management</title>

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

<!-- Template Main CSS File -->
<link href="${pageContext.request.contextPath}/assets/css/NiceAdminMain.css" rel="stylesheet">
</head>

<body>
	<!-- Include Header and Sidebar -->
	<jsp:include page="Parts/Header.jsp" />
	<jsp:include page="Parts/Sidebar.jsp" />

	<!-- Nội dung chính (Account Management) -->
	<main id="main" class="main">
		<div class="pagetitle">
			<h1>Accounts Management</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item">
						<a href="Dashboard/Index.jsp">Home</a>
					</li>
					<li class="breadcrumb-item active">Accounts Management</li>
				</ol>
			</nav>
		</div>

		<section class="account-management">
			<div class="container py-4">
				<h2 class="text-center mb-4">Accounts Management</h2>

				<!-- Add Account Button -->
				<div class="text-end mb-3">
					<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addAccountModal">
						<i class="fas fa-plus-circle me-2"></i>
						Add Account
					</button>
				</div>

				<!-- Account Table -->
				<table class="table table-hover align-middle bg-white shadow-sm rounded">
					<thead class="bg-primary text-white">
						<tr>
							<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Customer ID</th>
							<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Username</th>
							<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Password</th>
							<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Email</th>
							<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Phone</th>
							<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Role</th>
							<th scope="col" class="text-center">Action</th>
						</tr>
					</thead>
					<tbody id="accountTableBody">
						<c:forEach var="khachHang" items="${listkhp}">
							<jsp:include page="Parts/AccountRow.jsp">
								<jsp:param name="userID" value="${khachHang.makhachhang}" />
								<jsp:param name="username" value="${khachHang.tendangnhap}" />
								<jsp:param name="password" value="${khachHang.matkhau}" />
								<jsp:param name="email" value="${khachHang.email}" />
								<jsp:param name="phoneNumber" value="${khachHang.sodienthoai}" />
								<jsp:param name="role" value="${khachHang.role}" />
							</jsp:include>

							<!-- Edit Account Modal -->
							<div class="modal fade" id="editAccountModal_${khachHang.makhachhang}" tabindex="-1" aria-labelledby="editAccountModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header bg-primary text-white">
											<h5 class="modal-title">Edit Account</h5>
											<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<form action="ManageKhachHang" method="POST">
												<input type="hidden" name="makhachhang" value="${khachHang.makhachhang}">
												<input type="hidden" name="chucNang" value="Sua">
												<div class="mb-3">
													<label for="username_${khachHang.makhachhang}" class="form-label">Username</label>
													<input type="text" class="form-control" id="username_${khachHang.makhachhang}" name="tendangnhap" value="${khachHang.tendangnhap}" required>
												</div>
												<div class="mb-3">
													<label for="password_${khachHang.makhachhang}" class="form-label">Password</label>
													<input type="password" class="form-control" id="password_${khachHang.makhachhang}" name="matkhau" value="${khachHang.matkhau}" required>
												</div>
												<div class="mb-3">
													<label for="phone_${khachHang.makhachhang}" class="form-label">Phone</label>
													<input type="text" class="form-control" id="phone_${khachHang.makhachhang}" name="sodienthoai" value="${khachHang.sodienthoai}" required>
												</div>
												<div class="mb-3">
													<label for="email_${khachHang.makhachhang}" class="form-label">Email</label>
													<input type="email" class="form-control" id="email_${khachHang.makhachhang}" name="email" value="${khachHang.email}" required>
												</div>
												<div class="mb-3">
													<label for="role_${khachHang.makhachhang}" class="form-label">Role</label>
													<select class="form-control" id="role_${khachHang.makhachhang}" name="role" required>
														<option value="user" ${khachHang.role == 'user' ? 'selected' : ''}>User</option>
														<option value="admin" ${khachHang.role == 'admin' ? 'selected' : ''}>Admin</option>
													</select>
												</div>
												<button type="submit" class="btn btn-primary w-100">Save Changes</button>
											</form>
										</div>
									</div>
								</div>
							</div>

							<!-- Delete Account Modal -->
							<div class="modal fade" id="deleteAccountModal_${khachHang.makhachhang}" tabindex="-1" aria-labelledby="deleteAccountModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header bg-danger text-white">
											<h5 class="modal-title">Confirm Deletion</h5>
											<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body text-center">
											Are you sure you want to delete account:
											<strong>${khachHang.tendangnhap}</strong>
											?
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
											<form action="ManageKhachHang" method="POST">
												<input type="hidden" name="makhachhang" value="${khachHang.makhachhang}">
												<input type="hidden" name="chucNang" value="Xoa">
												<button type="submit" class="btn btn-danger">Confirm</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<!-- Add Account Modal -->
			<div class="modal fade" id="addAccountModal" tabindex="-1" aria-labelledby="addAccountModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header bg-primary text-white">
							<h5 class="modal-title" id="addAccountModalLabel">
								<i class="fas fa-user-plus me-2"></i>
								Add New Account
							</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form action="ManageKhachHang" method="POST">
								<input type="hidden" name="chucNang" value="Them">
								<div class="mb-3">
									<label for="newmakhachhang" class="form-label">Customer id</label>
									<input type="text" class="form-control" name="makhachhang" id="newmakhachhang" required>
								</div>
								<div class="mb-3">
									<label for="newUsername" class="form-label">Username</label>
									<input type="text" class="form-control" name="tendangnhap" id="newUsername" required>
								</div>
								<div class="mb-3">
									<label for="newPassword" class="form-label">Password</label>
									<input type="password" class="form-control" name="matkhau" id="newPassword" required>
								</div>
								<div class="mb-3">
									<label for="sodienthoai" class="form-label">Phone</label>
									<input type="number" class="form-control" name="sodienthoai" id="sodienthaoi" required>
								</div>
								<div class="mb-3">
									<label for="email" class="form-label">Email</label>
									<input type="email" class="form-control" name="email" id="email" required>
								</div>
								<button type="submit" class="btn btn-primary w-100">Add Account</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<!-- Modal Add Account -->
	<div class="modal fade" id="addAccountModal" tabindex="-1" aria-labelledby="addAccountModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary text-white">
					<h5 class="modal-title" id="addAccountModalLabel">
						<i class="fas fa-user-plus me-2"></i>
						Add New Account
					</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="Quanlytaikhoan" method="POST">
						<input type="hidden" name="chucNang" value="Them">
						<div class="mb-3">
							<label for="newmakhachhang" class="form-label">Customer id</label>
							<input type="text" class="form-control" name="makhachhang" id="newmakhachhang" required>
						</div>
						<div class="mb-3">
							<label for="newUsername" class="form-label">Username</label>
							<input type="text" class="form-control" name="tendangnhap" id="newUsername" required>
						</div>
						<div class="mb-3">
							<label for="newPassword" class="form-label">Password</label>
							<input type="password" class="form-control" name="matkhau" id="newPassword" required>
						</div>
						<div class="mb-3">
							<label for="sodienthoai" class="form-label">Phone</label>
							<input type="number" class="form-control" name="sodienthoai" id="sodienthaoi" required>
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email</label>
							<input type="email" class="form-control" name="email" id="email" required>
						</div>
						<button type="submit" class="btn btn-primary w-100">Add Account</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Back to Top Button -->
	<a href="#" class="back-to-top d-flex align-items-center justify-content-center">
		<i class="bi bi-arrow-up-short"></i>
	</a>

	<!-- Back to Top Button -->
	<a href="#" class="back-to-top d-flex align-items-center justify-content-center">
		<i class="bi bi-arrow-up-short"></i>
	</a>

	<!-- Vendor JS Files -->
	<script>
    document.addEventListener("DOMContentLoaded", function () {
        const rowsPerPage = 5; // Số dòng mỗi trang
        const tableBody = document.getElementById("accountTableBody");
        const rows = tableBody.getElementsByTagName("tr");
        const totalRows = rows.length;
        const totalPages = Math.ceil(totalRows / rowsPerPage);

        const pagination = document.createElement("ul");
        pagination.className = "pagination";

        function renderTable(page) {
            const start = (page - 1) * rowsPerPage;
            const end = start + rowsPerPage;

            // Hiển thị các dòng tương ứng
            for (let i = 0; i < totalRows; i++) {
                rows[i].style.display = i >= start && i < end ? "" : "none";
            }
        }

        function renderPagination() {
            for (let i = 1; i <= totalPages; i++) {
                const li = document.createElement("li");
                li.className = "page-item";
                li.innerHTML = `<a class="page-link" href="#">${i}</a>`;

                li.addEventListener("click", function (e) {
                    e.preventDefault();
                    renderTable(i);
                    document.querySelectorAll(".page-item").forEach(el => el.classList.remove("active"));
                    li.classList.add("active");
                });

                if (i === 1) li.classList.add("active"); // Trang đầu tiên được chọn mặc định
                pagination.appendChild(li);
            }
        }

        const paginationContainer = document.createElement("nav");
        paginationContainer.appendChild(pagination);
        tableBody.parentElement.insertAdjacentElement("afterend", paginationContainer);

        renderTable(1); // Hiển thị trang đầu tiên
        renderPagination();
    });
</script>
	<script src="${pageContext.request.contextPath}/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/chart.js/chart.umd.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/echarts/echarts.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/quill/quill.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="${pageContext.request.contextPath}/assets/js/NiceAdminMain.js"></script>
</body>
</html>