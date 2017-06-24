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
				<div class="col-xs-12 col-sm-8 col-md-9 col-lg-10"
					id="content-wrapper">
					<div class="row">
						<div class="col-lg-12 header-bar">
							<ol class="breadcrumb">
								<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
								<li><a href="${pageContext.request.contextPath}/orderLines">OrderLines</a></li>
								<li class="active"><span>OrderLines List</span></li>
							</ol>
							<h3>OrderLines List</h3>
						</div>
					</div>
					<div class="main-box">
						<form class="form-horizontal"
							action="${pageContext.request.contextPath}/orderLines/search"
							method="post">
							<div class="form-group">
								<div class="clearfix">
									<div class="col-lg-3 padding-b-15">
										<label class="small" for="OrderLinesName">Order Lines
											Name</label> <input id="order_lines_name" type="text"
											class="form-control" placeholder="Order Lines Name"
											name="orderLinesName" value="${search.orderLinesName}" />
									</div>
								</div>
								<div class="col-lg-12">
									<button type="submit" class="btn btn-success" id="search_btn">Seach</button>
									<a href="${pageContext.request.contextPath}/orderLines/create"
										class="btn btn-info pull-right">Create OrderLines</a>
								</div>
							</div>
						</form>
						<div class="table-responsive">
							<table id="mytable"
								class="table table-striped table-hover table-row checkboxNew">
								<thead>
									<tr>
										<th>#</th>
										<th class="small">OrderLinesName</th>
										<th class="small">Quantity</th>
										<th class="small">UnitPrice</th>
										<th class="small">Discount</th>
										<th class="small">Comment</th>
										<th>&nbsp;</th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}" varStatus="loop">
										<tr class=" repeated">
											<td>${loop.index + 1}.</td>
											<td>${item.orderLinesName}</td>
											<td>${item.quantity}</td>
											<td>${item.unitPrice}</td>
											<td>${item.discount}</td>
											<td>${item.product}</td>
											<td>${item.order}</td>
											<td>${item.comment}</td>
											<td>
												<p data-placement="top" data-toggle="tooltip" title="Edit">
													<a class="btn btn-success btn-xs edit_orderLines_link"
														href="${pageContext.request.contextPath}/orderLines/${item.orderLinesId}/edit"><span
														class="glyphicon glyphicon-pencil"></span>&nbsp;</a>
												</p>
											</td>
											<td>
												<p data-placement="top" data-toggle="tooltip" title="Delete">
													<a
														class="btn btn-danger btn-xs delete_orderLines_link delete_link"
														data-title="Delete"
														href="${pageContext.request.contextPath}/orderLines/${item.orderLinesId}/delete"><span
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
										href="${pageContext.request.contextPath}/orderLines?page=${i}">
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
