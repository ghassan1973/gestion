<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
								<li class="active"><span>Region</span></li>
							</ol>
						</div>
					</div>
					<div class="main-box">
						<form class="form-horizontal"
							action="${pageContext.request.contextPath}/region/search"
							method="post">
							<div class="form-group">
								<div class="clearfix">
									<div class="col-lg-3 padding-b-15">
										<label class="small" for="RegionName">Name</label> <input
											id="region_name" type="text" class="form-control"
											placeholder="Name" name="regionName"
											value="${search.regionName}" />
									</div>
								</div>
								<div class="col-lg-12">
									<button type="submit" class="btn btn-success" id="search_btn">
										<span class="glyphicon glyphicon-search"></span>&nbsp;
									</button>
								</div>
							</div>
						</form>
						<div class="table-responsive">
							<table id="mytable"
								class="table table-striped table-hover table-row checkboxNew">
								<thead>
									<tr>
										<th>#</th>
										<th class="small">RegionName</th>
										<th colspan=2><a
											href="${pageContext.request.contextPath}/region/create"
											class="btn btn-info pull-right"><span
												class="glyphicon glyphicon-plus"></span>&nbsp;</a></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}" varStatus="loop">
										<tr class=" repeated">
											<td>${loop.index + 1}.</td>
											<td>${item.regionName}</td>
											<td colspan=2 align="right">
												<p data-placement="top" data-toggle="tooltip" title="Edit">
													<a class="btn btn-success btn-xs edit_region_link"
														href="${pageContext.request.contextPath}/region/${item.regionId}/edit"><span
														class="glyphicon glyphicon-pencil"></span>&nbsp;</a>
													<a
														class="btn btn-danger btn-xs delete_region_link delete_link"
														data-title="Delete"
														href="${pageContext.request.contextPath}/region/${item.regionId}/delete"><span
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
										href="${pageContext.request.contextPath}/region?page=${i}">
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
