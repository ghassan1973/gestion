<%@ page contentType="text/html; charset=UTF-8" %>
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
									action="${pageContext.request.contextPath}/signin/forgot_password"
									role="form" method="post">
									<c:if test="${not empty $message}">
										<div class="alert alert-info">${message}</div>
									</c:if>
									<c:if test="${not empty $error}">
										<div class="alert alert-danger">${error}</div>
									</c:if>
									<h5>Enter your mail to get instructions on how to reset
										your password.</h5>
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-envelope"></i></span> <input type="text"
											placeholder="Email address" class="form-control" name="email"
											id="email">
									</div>
									<div class="row">
										<div class="col-xs-12">
											<button class="btn btn-success col-xs-12" type="submit"
												id="reset_pwd_btn">Reset Password</button>
										</div>
									</div>
								</form>
							</div>
							<h6 class="text-center">
								Do not have an account? <a
									href="${pageContext.request.contextPath}/register"
									id="register_link">Register now</a>
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
