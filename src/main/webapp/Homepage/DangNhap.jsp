<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Nhập</title>

<!-- Favicons -->
<link href="${pageContext.request.contextPath}/assets/img/favicon.png" rel="icon">

<!-- Vendor CSS Files -->
<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

<!-- Main CSS File -->
<link href="${pageContext.request.contextPath}/assets/css/DangNhap.css" rel="stylesheet">

<style >
.alert {
    padding: 15px;
    margin: 20px 0;
    border-radius: 5px;
    font-size: 16px;
    font-weight: bold;
}

.alert-success {
    background-color: #d4edda;
    color: #155724;
    border: 1px solid #c3e6cb;
}

.alert-error {
    background-color: #f8d7da;
    color: #721c24;
    border: 1px solid #f5c6cb;
}
</style>
</head>
<body>
	<%
	String baoloi = request.getAttribute("baoloi") + "";
	baoloi = (baoloi.equals("null")) ? "" : baoloi;
	%>
<%
    String successMessage = (String) session.getAttribute("successMessage");
    String errorMessage = (String) request.getAttribute("baoLoi");
    if (successMessage != null) {
%>
        <div class="alert alert-success">
            <%= successMessage %>
        </div>
<%
        session.removeAttribute("successMessage");
    }
    if (errorMessage != null) {
%>
        <div class="alert alert-error">
            <%= errorMessage %>
        </div>
<%
    }
%>


		
	<main>
		<div class="container">
			<section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
							<div class="d-flex justify-content-center py-4"></div>
							<div class="card mb-3">
								<div class="card-body">
									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">Login into our shop</h5>
										<p class="text-center small">Enter your username and password to continue</p>
									</div>

									<form action="${pageContext.request.contextPath}/dang-nhap" method="post" class="row g-3 needs-validation" novalidate>
										<div class="col-12">
											<div id="baoloi" class="msg text-danger text-center mb-3">
												<%=baoloi%>
											</div>
											<label for="tendangnhap" class="form-label">Username</label>
											<div class="input-group has-validation">
												<span class="input-group-text">
													<i class="bi bi-person"></i>
												</span>
												<input type="text" name="tendangnhap" class="form-control" id="tendangnhap" required>
												<div class="invalid-feedback">Please enter your username</div>
											</div>
										</div>

										<div class="col-12">
											<label for="matkhau" class="form-label">Password</label>
											<div class="input-group has-validation">
												<span class="input-group-text">
													<i class="bi bi-lock"></i>
												</span>
												<input type="password" name="matkhau" class="form-control" id="matkhau" required>
												<div class="invalid-feedback">Please enter your password</div>
											</div>
										</div>

										<div class="col-12">
											<div class="form-check">
												<input class="form-check-input" type="checkbox" name="remember" value="true" id="rememberMe">
												<label class="form-check-label" for="rememberMe">Keep me sign in</label>
											</div>
										</div>

										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit">Login</button>
										</div>
										<div class="col-12">
											<p class="small mb-0">
												You don't have any account?
												<a href="${pageContext.request.contextPath}/Homepage/DangKy.jsp">Create a new one now!</a>
											</p>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</main>

	<!-- Vendor JS Files -->
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
