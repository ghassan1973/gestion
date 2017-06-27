<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<jsp:include page="./../head.jsp" />
<body class="skin-blue">
	<div id="admin-panel">
		<jsp:include page="./../header.jsp" />
		<div class="container-fluid">
			<div class="row row-offcanvas row-offcanvas-left">
				<jsp:include page="./../sidebar.jsp" />
				<jsp:include page="search.jsp" />
				<!-- Content-->
				<div class="col-xs-12 col-sm-8 col-md-9 col-lg-10">
					<div class="row">
						<div class="col-lg-12 header-bar">
							<ol class="breadcrumb">
								<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
								<li class="active"><span>Project</span></li>
							</ol>
						</div>
					</div>
					<div class="main-box">
						<div class="table-responsive">
							<table id="mytable"
								class="table table-striped table-hover table-row checkboxNew">
								<thead>
									<tr>
										<th>#</th>
										<th class="small">Name</th>
										<!-- 
										<th class="small">Region</th>
										<th class="small">Type</th>
										<th class="small">Status</th>
-->
										<th class="small">Start Date</th>
										<th class="small">Cost</th>
										<th class="small">Sale</th>
										<th class="small">Rest T oPay</th>
										<th class="small">Margin</th>
										<th colspan=2>
											<p data-placement="top" data-toggle="tooltip" title="Create">
												<a href="${pageContext.request.contextPath}/project/create"
													class="btn btn-info pull-right">+</a>
											</p>
										</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}" varStatus="loop">
										<tr class=" repeated">
											<td>${loop.index + 1}.</td>
											<td>${item.projectName}</td>
											<!--
											<td>${item.region.regionName}</td>
											<td>${item.projectType.projectTypeName}</td>
											<td>${item.projectStatus.projectStatusName}</td>
-->
											<td>${item.startDate}</td>
											<td>${item.cost}</td>
											<td>${item.sale}</td>
											<td>${item.restToPay}</td>
											<td>${item.margin}</td>
											<td colspan=2 align="right">
												<p data-placement="top">
													<a data-toggle="tooltip" title="Edit"
														class="btn btn-success btn-xs edit_project_link"
														href="${pageContext.request.contextPath}/project/${item.projectId}/edit"><span
														class="glyphicon glyphicon-pencil"></span>&nbsp;</a> <a
														data-toggle="tooltip" title="Delete"
														class="btn btn-danger btn-xs delete_project_link delete_link"
														data-title="Delete"
														href="${pageContext.request.contextPath}/project/${item.projectId}/delete"><span
														class="glyphicon glyphicon-trash"></span>&nbsp;</a>
												</p>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- Pagination toolbar -->
						<div class="clearfix">
							<div class="pull-left">
								<span>Showing page ${page.number + 1} of
									${page.totalPages}</span>
							</div>
							<ul class="pagination pull-right">
								<c:if test="${page.isFirstPage()}">
									<li class="disabled"><a href="#" class="prev"><i
											class="fa fa-chevron-left"></i>&nbsp;</a></li>
								</c:if>
								<c:if test="${not page.isFirstPage()}">
									<li><a href="#" class="prev"><i
											class="fa fa-chevron-left"></i>&nbsp;</a></li>
								</c:if>

								<c:forEach begin="1" end="${page.totalPages}" var="i">
									<li><a
										href="${pageContext.request.contextPath}/project?page=${i}">
											${i} </a></li>
								</c:forEach>
								<c:if test="${page.isLastPage()}">
									<li class="disabled"><a href="#" class="next"><i
											class="fa fa-chevron-right"></i>&nbsp;</a></li>
								</c:if>
								<c:if test="${not page.isLastPage()}">
									<li><a href="#" class="next"><i
											class="fa fa-chevron-right"></i>&nbsp;</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>

	<jsp:include page="./../include_js.jsp" />

</body>
</html>
