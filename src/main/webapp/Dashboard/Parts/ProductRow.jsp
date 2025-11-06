<!-- Tách riêng các Product của trang Dashboard ra để tái sử dụng -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ======= Product Template ======= -->
<tr>
	<td class="text-center" style="border-right: 1px solid #ddd;">${param.productId}</td>
	<td style="border-right: 1px solid #ddd;">${param.productName}</td>
	<td class="text-center" style="border-right: 1px solid #ddd;">${param.price}</td>
	<td class="text-center" style="border-right: 1px solid #ddd;">${param.stock}</td>
	<td class="text-center" style="border-right: 1px solid #ddd;">
		<img src="${param.imagePath}" alt="${param.productName}" class="rounded img-fluid" width="88" height="124" />
	</td>

	<td class="text-center">
		<button class="btn btn-sm btn-outline-success me-2" data-bs-toggle="modal" data-bs-target="#editProductModal_${param.productId}">Edit</button>
		<button class="btn btn-sm btn-outline-danger" data-bs-toggle="modal" data-bs-target="#deleteProductModal_${param.productId}">Delete</button>
	</td>
</tr>