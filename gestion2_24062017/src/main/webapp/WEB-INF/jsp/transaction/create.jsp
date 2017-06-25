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
				<div class="col-xs-12 col-sm-8 col-md-9 col-lg-12"
					>
					<div class="row">
						<div class="col-lg-12 header-bar">
							<ol class="breadcrumb">
								<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
								<li><a
									href="${pageContext.request.contextPath}/transaction">Transaction</a></li>
								<li class="active"><span>Create Transaction</span></li>
							</ol>
							<h3>Create Transaction</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form:form role="form" method="POST" modelAttribute="transaction"
								action="${pageContext.request.contextPath}/transaction/save"
								data-parsley-validate="">
								<input type="hidden" name="id"
									value="${transaction.transactionId}" />
								<div class="col-md-12">
									<div class="row">
										<div class="col-lg-12">

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_transactionname" class="small">Transaction
														Name</label> <input type="text" name="TransactionName"
														class="form-control" id="transaction_name_input"
														placeholder="Enter TransactionName"
														value="${transaction.transactionName}" autofocus/>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="order_dropdown_parent">
													<label for="sel_order" class="small">Order</label> <select
														class="form-control custom" name="order_rel"
														id="order_dropdown">
														<c:forEach items="${all_order}" var="item">
															<option value="${item.orderId}"
																${fn:contains(transaction.order, item) ? 'selected' : ''}>${item.orderName}</option>
														</c:forEach>
													</select>
												</div>
											</div>


											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_date" class="small">Date</label> <input
														type="text" name="Date"
														class="form-control datetimepicker" id="date_input"
														placeholder="Enter Date" value="${transaction.date}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_amount" class="small">Amount</label> <input
														type="text" name="Amount" class="form-control"
														id="amount_input" placeholder="Enter Amount"
														value="${transaction.amount}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_piecenum" class="small">Piece
														Number</label> <input type="text" name="PieceNum"
														class="form-control" id="piece_num_input"
														placeholder="Enter PieceNum"
														value="${transaction.pieceNum}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="currency_dropdown_parent">
													<label for="sel_currency" class="small">Currency</label> <select
														class="form-control custom" name="currency_rel"
														id="currency_dropdown">
														<c:forEach items="${all_currency}" var="item">
															<option value="${item.currencyId}"
																${fn:contains(transaction.currency, item) ? 'selected' : ''}>${item.currencyName}</option>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="mode_dropdown_parent">
													<label for="sel_mode" class="small">ModePayment</label> <select
														class="form-control custom" name="modePayment_rel"
														id="mode_dropdown">
														<c:forEach items="${all_modePayment}" var="item">
															<option value="${item.modePaymentId}"
																${fn:contains(transaction.modePayment, item) ? 'selected' : ''}>${item.modePaymentName}</option>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_comment" class="small">Comment</label> <input
														type="text" name="Comment" class="form-control"
														id="comment_input" placeholder="Enter Comment"
														value="${transaction.comment}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_inout" class="small">In(Take) /
														Out(Payment)</label> <select name="InOut" class="form-control"
														placeholder="Enter InOut" id="in_out_input">
														<option value="Out (Payment)"
															${fn:contains(transaction.inOut, "Out (Payment)") ? 'selected' : ''}>Out
															(Payment)</option>
														<option value="In (Take)"
															${fn:contains(transaction.inOut, "In (Take)") ? 'selected' : ''}>In
															(Take)</option>
													</select>
												</div>
											</div>

										</div>
									</div>
								</div>


								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/transaction">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_transaction_btn">Submit</button>
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
