<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${empty listsp}">
	<c:redirect url="/ManageSanPham" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Product Management</title>
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
			<h1>Products management</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item">
						<a href="Dashboard/Index.jsp">Home</a>
					</li>
					<li class="breadcrumb-item">Products Management</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="product-management">
			<div class="row">
				<div class="col-12">
					<div class="table-responsive">
						<div class="card card-block card-stretch card-height">
							<div class="card-header d-flex justify-content-between align-items-center mb-0">
								<div class="header-title">
									<h5 class="card-title">Products Management</h5>
								</div>

								<div class="card-header-toolbar d-flex justify-content-between align-items-center">
									<!-- Search Bar on the Left -->
									<div class="d-flex align-items-center me-3">
										<label class="me-2 mb-0">Search:</label>
										<input type="search" class="form-control form-control-sm" placeholder="Search Products..." aria-controls="datatable">
									</div>

									<!-- "Add Product" Button -->
									<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addProductModal">
										<i class="fas fa-plus-circle me-2"></i>
										Add Product
									</button>
								</div>
							</div>

							<div class="card-body">
								<div class="table-responsive">

									<!-- Product Table -->
									<table class="table mb-0 table-borderless table-striped">
										<thead>
											<tr>
												<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Product ID</th>
												<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Product Name</th>
												<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Price</th>
												<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Stock</th>
												<th scope="col" class="text-center" style="border-right: 1px solid #ddd;">Preview Picture</th>
												<th scope="col" class="text-center">Action</th>
											</tr>
										</thead>
										<tbody id="productTableBody">
											<c:forEach var="product" items="${listsp}">
												<jsp:include page="Parts/ProductRow.jsp">
													<jsp:param name="productId" value="${product.idProduct}" />
													<jsp:param name="productName" value="${product.nameProduct}" />
													<jsp:param name="price" value="${product.priceProduct}" />
													<jsp:param name="stock" value="${product.quantity}" />
													<jsp:param name="imagePath" value="${pageContext.request.contextPath}${product.imageProduct}" />
												</jsp:include>

												<!-- Edit Product Modal -->
												<div class="modal fade" id="editProductModal_${product.idProduct}" tabindex="-1" aria-labelledby="editProductModalLabel" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header bg-primary text-white">
																<h5 class="modal-title" id="editProductModalLabel">
																	<i class="fas fa-box-edit me-2"></i>
																	Edit Product
																</h5>
																<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body">
																<form action="ManageSanPham" method="POST">
																	<input type="hidden" name="chucNang" value="Sua">
																	<input type="hidden" name="idProduct" value="${product.idProduct}">
																	<div class="mb-3">
																		<label for="editProductName" class="form-label">Product Name</label>
																		<input type="text" class="form-control" id="editProductName" name="nameProduct" value="${product.nameProduct}" placeholder="Enter product name" required>
																	</div>
																	<div class="mb-3">
																		<label for="editProductPrice" class="form-label">Price</label>
																		<input type="number" class="form-control" id="editProductPrice" name="priceProduct" value="${product.priceProduct}" placeholder="Enter price" required>
																	</div>
																	<div class="mb-3">
																		<label for="editProductQuantity" class="form-label">Quantity</label>
																		<input type="number" class="form-control" id="editProductQuantity" name="quantity" value="${product.quantity}" placeholder="Enter quantity" required>
																	</div>
																	<button type="submit" class="btn btn-primary w-100">Save Changes</button>
																</form>
															</div>
														</div>
													</div>
												</div>

												<!-- Delete Product Modal -->
												<div class="modal fade" id="deleteProductModal_${product.idProduct}" tabindex="-1" aria-labelledby="deleteProductModalLabel" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header bg-danger text-white">
																<h5 class="modal-title" id="deleteProductModalLabel">
																	<i class="fas fa-exclamation-triangle me-2"></i>
																	Confirm Deletion
																</h5>
																<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body text-center">
																Are you sure you want to delete product:
																<strong>${product.nameProduct}</strong>
																?
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
																<form action="${pageContext.request.contextPath}/ManageSanPham" method="post">
																	<input type="hidden" name="chucNang" value="Xoa">
																	<input type="hidden" name="idProduct" value="${product.idProduct}">
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

			<!-- Add Product Modal -->
			<div class="modal fade" id="addProductModal" tabindex="-1" aria-labelledby="addProductModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header bg-primary text-white">
							<h5 class="modal-title" id="addProductModalLabel">
								<i class="fas fa-box-open me-2"></i>
								Add New Product
							</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form id="addProductForm" method="POST" action="<%=request.getContextPath()%>/ManageSanPham">
								<input type="hidden" name="chucNang" value="Them">
								<div class="mb-3">
									<label for="productName" class="form-label">Product Name</label>
									<input type="text" class="form-control" id="productName" name="nameProduct" placeholder="Enter product name" required>
								</div>
								<div class="mb-3">
									<label for="productPrice" class="form-label">Price</label>
									<input type="number" class="form-control" id="productPrice" name="priceProduct" placeholder="Enter price" required>
								</div>
								<div class="mb-3">
									<label for="productQuantity" class="form-label">Quantity</label>
									<input type="number" class="form-control" id="productQuantity" name="quantity" placeholder="Enter quantity" required>
								</div>
								<button type="submit" class="btn btn-primary w-100">Add Product</button>
							</form>
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
        const tableBody = document.getElementById("productTableBody");
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