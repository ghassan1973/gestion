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
				<div class="col-xs-12 col-sm-8 col-md-9 col-lg-12">
					<div class="row">
						<div class="col-lg-12 header-bar">
							<ol class="breadcrumb">
								<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
								<li class="active"><span>Project Status</span></li>
							</ol>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form:form role="form" method="POST"
								modelAttribute="projectStatus"
								action="${pageContext.request.contextPath}/projectStatus/save"
								data-parsley-validate="">
								<input type="hidden" name="id"
									value="${projectStatus.projectStatusId}" />
								<div class="col-md-12">
									<div class="row">
										<div class="col-lg-12">

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_projectstatusname" class="small">Name <span
														class="obligatoire" style="color: red">*</span></label> <input type="text" name="ProjectStatusName"
														class="form-control" id="project_status_name_input"
														placeholder="Enter Name"
														value="${projectStatus.projectStatusName}" autofocus required/>
												</div>
											</div>



										</div>
									</div>
								</div>


								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/projectStatus">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_projectStatus_btn">Apply</button>
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
