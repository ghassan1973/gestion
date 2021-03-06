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
				<div class="col-xs-12 col-sm-8 col-md-9 col-lg-10"
					id="content-wrapper">
					<div class="row">
						<div class="col-lg-12 header-bar">
							<ol class="breadcrumb">
								<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
								<li><a
									href="${pageContext.request.contextPath}/projectType">ProjectType</a></li>
								<li class="active"><span>Create ProjectType</span></li>
							</ol>
							<h3>Create ProjectType</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form:form role="form" method="POST" modelAttribute="projectType"
								action="${pageContext.request.contextPath}/projectType/save"
								data-parsley-validate="">
								<input type="hidden" name="id"
									value="${projectType.projectTypeId}" />
								<div class="col-md-12">
									<div class="row">
										<div class="col-lg-12">

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_projecttypename" class="small">Project
														Type Name <span
														class="obligatoire" style="color: red">*</span></label> <input type="text" name="ProjectTypeName"
														class="form-control" id="project_type_name_input"
														placeholder="Enter ProjectTypeName"
														value="${projectType.projectTypeName}" autofocus required/>
												</div>
											</div>



										</div>
									</div>
								</div>


								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/projectType">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_projectType_btn">Apply</button>
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
