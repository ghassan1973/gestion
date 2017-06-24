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
								<form
									action="${pageContext.request.contextPath}/login/authenticate"
									role="form" method="post">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-envelope"></i></span> <input type="text"
											placeholder="Email address" class="form-control"
											name="username" id="email">
									</div>
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-key"></i></span>
										<input type="password" placeholder="password"
											class="form-control" name="password" id="password">
									</div>
									<div class="row">
										<div class="col-xs-12">
											<div class="checkbox-nice">
												<input type="checkbox" checked="checked" id="terms-cond">
												<label for="terms-cond">Remember me</label> <a
													class="pull-right"
													href="${pageContext.request.contextPath}/signin/forgot_password">Forgot
													Pasword</a>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-12">
											<button class="btn btn-success col-xs-12" type="submit"
												id="login_btn">login</button>
										</div>
									</div>
								</form>
							</div>
							<h6 class="text-center">
								Do not have an account? <a
									href="${pageContext.request.contextPath}/register">Register
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
