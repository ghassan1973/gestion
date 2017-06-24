<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<jsp:include page="./../head.jsp" />
<body class="skin-blue">
	<div id="admin-panel">
		<jsp:include page="./../header.jsp" />
		<div class="container-fluid">
			<div class="row row-offcanvas row-offcanvas-left">
				<jsp:include page="./../sidebar.jsp" />
				<!-- Content-->
				<div class="col-xs-12 col-sm-8 col-md-9 col-lg-10"
					id="content-wrapper">
					<div class="row">
						<div class="col-lg-12 header-bar">
							<ol class="breadcrumb">
								<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
								<li><a href="${pageContext.request.contextPath}/user">User</a></li>
								<li class="active"><span>Create User</span></li>
							</ol>
							<h3>Create User</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form:form role="form" method="POST" modelAttribute="user"
								action="${pageContext.request.contextPath}/user/save"
								data-parsley-validate="">
								<input type="hidden" name="id" value="${user.userId}" />
								<div class="col-md-12">
									<div class="row">
										<div class="col-lg-12">

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_firstname" class="small">First Name</label>
													<input type="text" name="FirstName" class="form-control"
														id="first_name_input" placeholder="Enter FirstName"
														value="${user.firstName}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_lastname" class="small">Last Name</label> <input
														type="text" name="LastName" class="form-control"
														id="last_name_input" placeholder="Enter LastName"
														value="${user.lastName}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_email" class="small">Email Address</label>
													<input type="text" name="Email" class="form-control"
														id="email_input" placeholder="Enter Email"
														value="${user.email}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_password" class="small">Password</label> <input
														type="text" name="Password" class="form-control"
														id="password_input" placeholder="Enter Password"
														value="${user.password}" />
												</div>
											</div>


											<div class="col-md-6">
												<div class="form-group" id="roles_dropdown_parent">
													<label for="sel_roles" class="small">Role</label> <select
														class="form-control custom" name="roles_rel"
														multiple="true" id="roles_dropdown">
														<c:forEach items="${all_role}" var="item">
															<option value="${item.roleId}"
																${fn:contains(user.roles, item) ? 'selected' : ''}>${item.roleName}</option>
														</c:forEach>
													</select>

												</div>
											</div>

										</div>
									</div>
								</div>


								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/user">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_user_btn">Submit</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="./../include_js.jsp" />
</body>
</html>
