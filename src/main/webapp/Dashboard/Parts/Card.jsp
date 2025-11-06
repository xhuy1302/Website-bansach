<!-- Tách riêng các Card của trang Dashboard ra để tiện quản lý và sửa đổi -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ======= Card Template ======= -->
<div class="card info-card ${param.cardType}">
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
			${param.title}
			<span>| ${param.subtitle}</span>
		</h5>
		<div class="d-flex align-items-center">
			<div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
				<i class="bi ${param.icon}"></i>
			</div>
			<div class="ps-3">
				<h6>${param.value}</h6>
				<span class="${param.growthClass} small pt-1 fw-bold">${param.growthPercentage}</span>
				<span class="text-muted small pt-2 ps-1">${param.growthText}</span>
			</div>
		</div>
	</div>
</div>