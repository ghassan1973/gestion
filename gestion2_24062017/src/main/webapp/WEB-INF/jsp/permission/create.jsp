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
								<li><a href="${pageContext.request.contextPath}/permission">Permission</a></li>
								<li class="active"><span>Create Permission</span></li>
							</ol>
							<h3>Create Permission</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form:form role="form" method="POST" modelAttribute="permission"
								action="${pageContext.request.contextPath}/permission/save"
								data-parsley-validate="">
								<input type="hidden" name="id"
									value="${permission.permissionId}" />
								<div class="col-md-12">
									<div class="row">
										<div class="col-lg-12"></div>
									</div>
								</div>


								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/permission">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_permission_btn">Submit</button>
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
