<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<jsp:include page="./../head.jsp" />

<body class="skin-blue login-page">
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div id="login-box">
					<div class="row">
						<div class="col-xs-12">
							<header> Gestion2 </header>
							<div id="login-box-inner">
								<form action="${pageContext.request.contextPath}/signup"
									role="form" method="post">
									<c:if test="${not empty $message}">
										<div class="alert alert-info">$message</div>
									</c:if>
									<c:if test="${not empty $error}">
										<div class="alert alert-danger">$error</div>
									</c:if>
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input type="text" placeholder="First Name"
											class="form-control" name="firstName" id="first_name">
									</div>
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input type="text" placeholder="Last Name"
											class="form-control" name="lastName" id="last_name">
									</div>
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-envelope"></i></span> <input type="text"
											placeholder="Email address" class="form-control" name="email"
											id="email">
									</div>
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-key"></i></span>
										<input type="password" placeholder="password"
											class="form-control" name="password" id="password">
									</div>
									<div class="row">
										<div class="col-xs-12">
											<div class="checkbox-nice">
												<input type="checkbox" id="terms-cond" name="accept_terms"
													value="1"> <label for="terms-cond">I accept
													terms and conditions</label>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												<button class="btn btn-success col-xs-12" type="submit"
													id="register_btn">Register</button>
											</div>
										</div>
								</form>
							</div>
							<h6 class="text-center">
								Already have an account? <a
									href="${pageContext.request.contextPath}/login" id="login_link">Login
									now</a>
							</h6>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./../include_js.jsp" />
</body>
</html>
