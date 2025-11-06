<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${empty listdh}">
	<c:redirect url="/ManageDonHang" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Order Management</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- fontsomeaws -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

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
<style>
.pagination .page-link {
	color: #007bff;
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
</style>
</head>

<body>
	<!-- Tách riêng header ra file Header.jsp -->
	<jsp:include page="Parts/Header.jsp" />

	<!-- Tách riêng sidebar ra file Sidebar.jsp -->
	<jsp:include page="Parts/Sidebar.jsp" />

	<main id="main" class="main">
		<!-- Page Title -->
		<div class="pagetitle">
			<h1>Order management</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item">
						<a href="Dashboard/Index.jsp">Home</a>
					</li>
					<li class="breadcrumb-item">Order Management</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="order-management">
			<!-- Orders List Table -->
			<div class="row">
				<div class="col-12">
					<div class="table-responsive">
						<div class="card card-block card-stretch card-height">
							<div class="card-header d-flex justify-content-between align-items-center mb-0">
								<div class="header-title">
									<h5 class="card-title">Orders Management</h5>
								</div>
								<div class="card-header-toolbar d-flex justify-content-between align-items-center">
									<!-- Search Bar on the Left -->
									<div class="d-flex align-items-center me-3">
										<label class="me-2 mb-0">Search:</label>
										<input type="search" class="form-control form-control-sm" placeholder="Search Orders..." aria-controls="datatable">
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table mb-0 table-borderless table-striped">
										<thead>
											<tr>
												<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Order ID</th>
												<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Client ID</th>
												<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Payment Method</th>
												<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Status</th>
												<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Order Date</th>
												<th scope="col" class="text-center">Action</th>
											</tr>
										</thead>
										<tbody id="orderTableBody">
											<c:forEach var="donHang" items="${listdh}">
												<jsp:include page="Parts/OrderRow.jsp">
													<jsp:param name="orderId" value="${donHang.madonhang}" />
													<jsp:param name="client" value="${donHang.khachhang.makhachhang}" />
													<jsp:param name="paymentMethod" value="${donHang.hinhthucthanhtoan}" />
													<jsp:param name="status" value="${donHang.trangthai}" />
													<jsp:param name="orderDate" value="${donHang.ngaydathang}" />
												</jsp:include>

												<!-- View Order Modal -->
												<div class="modal fade" id="viewOrderModal_${donHang.madonhang}" tabindex="-1" aria-labelledby="viewOrderModalLabel" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header bg-info text-white">
																<h5 class="modal-title" id="viewOrderModalLabel">
																	<i class="fas fa-eye me-2"></i>
																	View Order Details
																</h5>
																<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body">
																<div class="mb-3 row">
																	<label class="col-sm-4 col-form-label">Order ID:</label>
																	<div class="col-sm-8">
																		<p class="form-control-plaintext">${donHang.madonhang}</p>
																	</div>
																</div>
																<div class="mb-3 row">
																	<label class="col-sm-4 col-form-label">Order Status:</label>
																	<div class="col-sm-8">
																		<p class="form-control-plaintext">${donHang.trangthai}</p>
																	</div>
																</div>
																<div class="mb-3 row">
																	<label class="col-sm-4 col-form-label">Customer ID:</label>
																	<div class="col-sm-8">
																		<p class="form-control-plaintext">${donHang.khachhang.makhachhang}</p>
																	</div>
																</div>
																<div class="mb-3 row">
																	<label class="col-sm-4 col-form-label">Order Date:</label>
																	<div class="col-sm-8">
																		<p class="form-control-plaintext">${donHang.ngaydathang}</p>
																	</div>
																</div>
																<div class="mb-3 row">
																	<label class="col-sm-4 col-form-label">Purchase Address:</label>
																	<div class="col-sm-8">
																		<p class="form-control-plaintext">${donHang.diachimuahang}</p>
																	</div>
																</div>
																<div class="mb-3 row">
																	<label class="col-sm-4 col-form-label">Delivery Address:</label>
																	<div class="col-sm-8">
																		<p class="form-control-plaintext">${donHang.diachinhanhang}</p>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>

												<!-- Edit Order Modal -->
												<div class="modal fade" id="editOrderModal_${donHang.madonhang}" tabindex="-1" aria-labelledby="editOrderModalLabel_${donHang.madonhang}" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header bg-warning text-white">
																<h5 class="modal-title" id="editOrderModalLabel_${donHang.madonhang}">
																	<i class="fas fa-edit me-2"></i>
																	Edit Order
																</h5>
																<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body">
																<form action="${pageContext.request.contextPath}/ManageDonHang" method="post">
																	<input type="hidden" name="chucNang" value="Sua">
																	<div class="mb-3 row">
																		<label for="editOrderId_${donHang.madonhang}" class="col-sm-4 col-form-label">Order ID:</label>
																		<div class="col-sm-8">
																			<input type="text" class="form-control-plaintext" id="editOrderId_${donHang.madonhang}" name="madonhang" value="${donHang.madonhang}" readonly>
																		</div>
																	</div>
																	<div class="mb-3 row">
																		<label for="editCustomerId_${donHang.madonhang}" class="col-sm-4 col-form-label">Customer ID:</label>
																		<div class="col-sm-8">
																			<input type="text" class="form-control-plaintext" id="editCustomerId_${donHang.madonhang}" value="${donHang.khachhang.makhachhang}" readonly>
																		</div>
																	</div>
																	<div class="mb-3 row">
																		<label for="editOrderDate_${donHang.madonhang}" class="col-sm-4 col-form-label">Order Date:</label>
																		<div class="col-sm-8">
																			<input type="date" class="form-control-plaintext" id="editOrderDate_${donHang.madonhang}" value="${donHang.ngaydathang}" readonly>
																		</div>
																	</div>
																	<div class="mb-3 row">
																		<label for="editPaymentMethod_${donHang.madonhang}" class="col-sm-4 col-form-label">Payment Method:</label>
																		<div class="col-sm-8">
																			<input type="text" class="form-control" id="editPaymentMethod_${donHang.madonhang}" name="hinhthucthanhtoan" value="${donHang.hinhthucthanhtoan}" required>
																		</div>
																	</div>
																	<div class="mb-3 row">
																		<label for="editOrderStatus_${donHang.madonhang}" class="col-sm-4 col-form-label">Status:</label>
																		<div class="col-sm-8">
																			<select class="form-select" id="editOrderStatus_${donHang.madonhang}" name="trangthai" required>
																				<option value="Pending" ${donHang.trangthai == 'Pending' ? 'selected' : ''}>Pending</option>
																				<option value="Processing" ${donHang.trangthai == 'Processing' ? 'selected' : ''}>Processing</option>
																				<option value="Shipped" ${donHang.trangthai == 'Shipped' ? 'selected' : ''}>Shipped</option>
																				<option value="Delivered" ${donHang.trangthai == 'Delivered' ? 'selected' : ''}>Delivered</option>
																				<option value="Completed" ${donHang.trangthai == 'Completed' ? 'selected' : ''}>Completed</option>
																				<option value="Cancelled" ${donHang.trangthai == 'Cancelled' ? 'selected' : ''}>Cancelled</option>
																			</select>
																		</div>
																	</div>
																	<button type="submit" class="btn btn-warning w-100">Save Changes</button>
																</form>
															</div>
														</div>
													</div>
												</div>

												<!-- Delete Order Modal -->
												<div class="modal fade" id="deleteOrderModal_${donHang.madonhang}" tabindex="-1" aria-labelledby="deleteOrderModalLabel_${donHang.madonhang}" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header bg-danger text-white">
																<h5 class="modal-title" id="deleteOrderModalLabel_${donHang.madonhang}">
																	<i class="fas fa-trash me-2"></i>
																	Confirm Order Deletion
																</h5>
																<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body text-center">
																<p>Are you sure you want to delete this order?</p>
																<p>
																	<strong>
																		Order ID:
																		<span>${donHang.madonhang}</span>
																	</strong>
																</p>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
																<!-- Form for deleting the order -->
																<form action="${pageContext.request.contextPath}/ManageDonHang" method="post" class="d-inline">
																	<input type="hidden" name="chucNang" value="Xoa">
																	<input type="hidden" name="madonhang" value="${donHang.madonhang}">
																	<button type="submit" class="btn btn-danger">Delete</button>
																</form>
															</div>
														</div>
													</div>
												</div>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<!-- End #main -->

	<a href="#" class="back-to-top d-flex align-items-center justify-content-center">
		<i class="bi bi-arrow-up-short"></i>
	</a>

	<!-- Vendor JS Files -->
	<script>
    document.addEventListener("DOMContentLoaded", function () {
        const rowsPerPage = 5; // Số dòng mỗi trang
        const tableBody = document.getElementById("orderTableBody");
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