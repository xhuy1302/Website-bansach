<!-- Tách riêng Sidebar của trang Dashboard ra để tiện quản lý và sửa đổi -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
	<ul class="sidebar-nav" id="sidebar-nav">
		<!-- Dashboard Nav -->
		<li class="nav-item">
			<a class="nav-link collapsed" href="${pageContext.request.contextPath}/Dashboard/Index.jsp">
				<i class="bi bi-house-door"></i>
				<span>Dashboard</span>
			</a>
		</li>
		<!-- End Dashboard Nav -->

		<!-- Account Management Nav -->
		<li class="nav-item">
			<a class="nav-link collapsed" href="/Website-BanSach/ManageKhachHang">
				<i class="bi bi-people"></i>
				<span>Account Management</span>
			</a>
		</li>
		<!-- End Account Management Nav -->
		<!-- Account Statistics Nav -->
		<li class="nav-item">
			<a class="nav-link collapsed" href="${pageContext.request.contextPath}/Dashboard/BieuDoThongKeTaiKhoan.jsp">
				<i class="bi bi-bar-chart"></i>
				<span>Account Statistics</span>
			</a>
		</li>
		<!-- End Account Statistics Nav -->
		<!-- Products Management Page Nav -->
		<li class="nav-item">
			<a class="nav-link collapsed" href="/Website-BanSach/ManageSanPham">
				<i class="bi bi-box"></i>
				<span>Product Management</span>
			</a>
		</li>
		<!-- End Products Management Page Nav -->

		<!-- Orders Management Page Nav -->
		<li class="nav-item">
			<a class="nav-link collapsed" href="/Website-BanSach/ManageDonHang">
				<i class="bi bi-cart-check"></i>
				<span>Order Management</span>
			</a>
		</li>
		<!-- End Orders Management Page Nav -->
	</ul>
</aside>

<!-- End Sidebar-->