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
					<di						v class="row">
						<div class="col-lg-12 header-bar">
							<ol class="breadcrumb">
								<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
								<li><a href="${pageContext.request.contextPath}/project">Project</a></li>
								<li class="active"><span>Properties</span></li>
							</ol>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form:form role="form" method="POST" modelAttribute="project"
								action="${pageContext.request.contextPath}/project/save"
								data-parsley-validate="">
								<input type="hidden" name="id" value="${project.projectId}" />
								<div class="col-md-12">
									<div class="row">
										<div class="col-lg-12">
											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_projectname" class="small"> Name <span
														class="obligatoire" style="color: red">*</span></label> <input
														type="text" name="ProjectName" class="form-control"
														id="project_name_input" placeholder="Enter Project Name"
														value="${project.projectName}" autofocus required/>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="region_dropdown_parent">
													<label for="sel_region" class="small">Region</label> <select
														class="form-control custom" name="region_rel"
														id="region_dropdown" autofocus required>
														<option></option>
														<c:forEach items="${all_region}" var="item">
															<option value="${item.regionId}"
																${fn:contains(project.region, item) ? 'selected' : ''}>${item.regionName}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<div class="col-lg-12">
											<div class="col-md-6">
												<div class="form-group" id="projectType_dropdown_parent">
													<label for="sel_projecttype" class="small">Type</label> <select
														class="form-control custom" name="projectType_rel"
														id="projectType_dropdown" autofocus required>
														<option></option>
														<c:forEach items="${all_projectType}" var="item">
															<option value="${item.projectTypeId}"
																${fn:contains(project.projectType, item) ? 'selected' : ''}>${item.projectTypeName}</option>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="status_dropdown_parent">
													<label for="sel_status" class="small">Status</label> <select
														class="form-control custom" name="projectStatus_rel"
														id="status_dropdown">
														<option></option>
														<c:forEach items="${all_projectStatus}" var="item">
															<option value="${item.projectStatusId}"
																${fn:contains(project.projectStatus, item) ? 'selected' : ''}>${item.projectStatusName}</option>
														</c:forEach>
													</select>
												</div>
											</div>


											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_startdate" class="small">Start Date</label>
													<input type="text" name="StartDate"
														class="form-control datetimepicker" id="start_date_input"
														placeholder="Enter Start Date"
														value="${project.startDate}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_enddate" class="small">End Date</label> <input
														type="text" name="EndDate"
														class="form-control datetimepicker" id="end_date_input"
														placeholder="Enter End Date" value="${project.endDate}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_cost" class="small">Cost</label> <input
														type="text" name="Cost" class="form-control"
														id="cost_input" placeholder="Enter Cost"
														value="${project.cost}"
														pattern="[-+]?[0-9]*[.,]?[0-9]*[.]?[0-9]+" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_sale" class="small">Sale</label> <input
														type="text" name="Sale" class="form-control"
														id="sale_input" placeholder="Enter Sale"
														value="${project.sale}"
														pattern="[-+]?[0-9]*[.,]?[0-9]*[.]?[0-9]+" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_resttopay" class="small">Rest To
														Pay</label> <input type="text" name="RestToPay"
														class="form-control" id="rest_to_pay_input"
														placeholder="Enter Rest To Pay"
														value="${project.restToPay}"
														pattern="[-+]?[0-9]*[.,]?[0-9]*[.]?[0-9]+" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_margin" class="small">Margin</label> <input
														type="text" name="Margin" class="form-control"
														id="margin_input" placeholder="Enter Margin"
														value="${project.margin}"
														pattern="[-+]?[0-9]*[.,]?[0-9]*[.]?[0-9]+" />
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<br /> <br /> <br />
										</div>
									</div>
								</div>
								<div class="box-footer col-md-1.5 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/project">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_project_btn">Apply</button>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<br />
									</div>
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
