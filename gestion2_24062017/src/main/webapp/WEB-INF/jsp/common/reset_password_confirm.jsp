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
								<div class="row">
									<div class="col-xs-12">
										<h5>We have sent you a mail with instructions to reset
											password.</h5>
										<h5>
											<a href="${pageContext.request.contextPath}/login"
												id="login_link">Click here for Login</a>
										</h5>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./../include_js.jsp" />

</body>
</html>
