<!-- Tách riêng các Account của trang Dashboard ra để tái sử dụng -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ======= Account Template ======= -->
<tr>
	<td class="text-center" style="border-right: 1px solid #ddd;">${param.userID}</td>
	<td class="text-center" style="border-right: 1px solid #ddd;">${param.username}</td>
	<td class="text-center" style="border-right: 1px solid #ddd;">${param.password}</td>
	<td class="text-center" style="border-right: 1px solid #ddd;">${param.email}</td>
	<td class="text-center" style="border-right: 1px solid #ddd;">${param.phoneNumber}</td>
	<td class="text-center" style="border-right: 1px solid #ddd;">
		<span class="badge bg-success text-uppercase">${param.role}</span>
	</td>
	<td class="text-center">
		<button class="btn btn-sm btn-outline-success" data-bs-toggle="modal" data-bs-target="#editAccountModal_${param.userID}">Edit</button>
		<button class="btn btn-sm btn-outline-danger" data-bs-toggle="modal" data-bs-target="#deleteAccountModal_${param.userID}">Delete</button>
	</td>
</tr>