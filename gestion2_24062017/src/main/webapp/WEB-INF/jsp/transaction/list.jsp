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
								<li><a
									href="${pageContext.request.contextPath}/transaction">Transaction</a></li>
								<li class="active"><span>Transaction List</span></li>
							</ol>
							<h3>Transaction List</h3>
						</div>
					</div>
					<div class="main-box">
						<form class="form-horizontal"
							action="${pageContext.request.contextPath}/transaction/search"
							method="post">
							<div class="form-group">
								<div class="clearfix">
									<div class="col-lg-3 padding-b-15">
										<label class="small" for="TransactionName">Transaction
											Name</label> <input id="transaction_name" type="text"
											class="form-control" placeholder="Transaction Name"
											name="transactionName" value="${search.transactionName}" />
									</div>
								</div>
								<div class="col-lg-12">
									<button type="submit" class="btn btn-success" id="search_btn">Seach</button>
									<a href="${pageContext.request.contextPath}/transaction/create"
										class="btn btn-info pull-right">Create Transaction</a>
								</div>
							</div>
						</form>
						<div class="table-responsive">
							<table id="mytable"
								class="table table-striped table-hover table-row checkboxNew">
								<thead>
									<tr>
										<th>#</th>
										<th class="small">TransactionName</th>
										<th class="small">Date</th>
										<th class="small">Amount</th>
										<th class="small">PieceNum</th>
										<th class="small">Comment</th>
										<th class="small">InOut</th>
										<th>&nbsp;</th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}" varStatus="loop">
										<tr class=" repeated">
											<td>${loop.index + 1}.</td>
											<td>${item.transactionName}</td>
											<td>${item.date}</td>
											<td>${item.amount}</td>
											<td>${item.pieceNum}</td>
											<td>${item.comment}</td>
											<td>${item.inOut}</td>
											<td>
												<p data-placement="top" data-toggle="tooltip" title="Edit">
													<a class="btn btn-success btn-xs edit_transaction_link"
														href="${pageContext.request.contextPath}/transaction/${item.transactionId}/edit"><span
														class="glyphicon glyphicon-pencil"></span>&nbsp;</a>
												</p>
											</td>
											<td>
												<p data-placement="top" data-toggle="tooltip" title="Delete">
													<a
														class="btn btn-danger btn-xs delete_transaction_link delete_link"
														data-title="Delete"
														href="${pageContext.request.contextPath}/transaction/${item.transactionId}/delete"><span
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
										href="${pageContext.request.contextPath}/transaction?page=${i}">
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
