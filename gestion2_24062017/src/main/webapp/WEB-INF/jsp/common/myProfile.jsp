<%@ page contentType="text/html; charset=UTF-8" %>
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
				<!--            CONTENT-->
				<div class="col-xs-12 col-sm-8 col-md-9 col-lg-10"
					id="content-wrapper">
					<div class="col-lg-12 header-bar">
						<ol class="breadcrumb">
							<li><a href="#">Home</a></li>
							<li><a href="#">Users</a></li>
							<li class="active"><span>User Profile</span></li>
						</ol>
						<h3>User Profile</h3>
						<c:if test="${not empty $error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
						<c:if test="${not empty $message}">
							<div class="alert alert-success">${message};</div>
						</c:if>
					</div>
					<div class="row">
						<div class="col-lg-3 col-md-12 col-sm-12">
							<div class="main-box clearfix">
								<h4>${me.firstName} ${me.lastName}</h4>
								<img class="profile-img img-responsive center-block" alt=""
									src="${pageContext.request.contextPath}/static/img/images.jpg">
								<div class="profile-label">
									<span class="label label-danger">Admin</span>
								</div>
								<h5 class="text-center">Member since: Jan 2012</h5>
							</div>
						</div>
						<div class="col-lg-9 col-md-12 col-sm-12">
							<div class="main-box">
								<h4>Your details</h4>
								<br />
								<form role="form" method="post"
									action="${pageContext.request.contextPath}/profile/update">
									<div class="form-group">
										<label class="small" for="exampleInputEmail1">First
											Name</label> <input type="text" class="form-control" id="first_name"
											name="firstName" placeholder="First Name"
											value="${user.firstName}">
									</div>
									<div class="form-group">
										<label class="small" for="exampleInputEmail1">Last
											Name</label> <input type="text" class="form-control" id="last_name"
											name="lastName" placeholder="Last Name"
											value="${user.lastName}">
									</div>
									<div class="form-group">
										<label class="small" for="exampleInputEmail1">Email</label> <input
											type="email" class="form-control" id="email"
											placeholder="Email" disabled value="${user.email}">
									</div>
									<div class="form-group">
										<label class="small" for="exampleInputPassword1">Password</label>
										<input type="text" class="form-control" id="password"
											name="password" placeholder="Password"
											value="${user.password}">
									</div>
									<div class="form-group">
										<button class="btn btn-success" type="submit" id="submit_btn">Update</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<jsp:include page="./../include_js.jsp" />


	<script type="text/javascript">
		$('.widget').click(function() {
			window.location.href = $(this).attr('data-href');
		})
	</script>
</body>
</html>
