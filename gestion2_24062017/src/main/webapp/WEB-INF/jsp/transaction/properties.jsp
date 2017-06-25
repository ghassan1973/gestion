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
								<li class="active"><span>Transaction</span></li>
							</ol>
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
													<label for="txt_transactionname" class="small">
														Name <span class="obligatoire" style="color: red">*</span>
													</label><input type="text" name="TransactionName"
														class="form-control" id="transaction_name_input"
														placeholder="Enter Name"
														value="${transaction.transactionName}" autofocus required />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="order_dropdown_parent">
													<label for="sel_order" class="small">Order</label> <select
														class="form-control custom" name="order_rel"
														id="order_dropdown">
														<option vlue="0"></option>
														<c:forEach items="${all_order}" var="item">
															<option value="${item.orderId}"
																${fn:contains(transaction.order, item) ? 'selected' : ''}>${item.orderName}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<div class="col-lg-12">
											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_date" class="small">Date <span
														class="obligatoire" style="color: red">*</span></label> <input
														type="text" name="Date"
														class="form-control datetimepicker" id="date_input"
														placeholder="Enter Date" value="${transaction.date}"
														required />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_amount" class="small">Amount <span
														class="obligatoire" style="color: red">*</span></label> <input
														type="text" name="Amount" class="form-control"
														id="amount_input" placeholder="Enter Amount"
														value="${transaction.amount}" required
														pattern="[-+]?[0-9]*[.,]?[0-9]*[.]?[0-9]+" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_piecenum" class="small">Piece
														Number</label> <input type="text" name="Piece Number"
														class="form-control" id="piece_num_input"
														placeholder="Enter Piece Number"
														value="${transaction.pieceNum}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="currency_dropdown_parent">
													<label for="sel_currency" class="small">Currency <span
														class="obligatoire" style="color: red">*</span></label> <select
														required class="form-control custom" name="currency_rel"
														id="currency_dropdown">
														<option></option>
														<c:forEach items="${all_currency}" var="item">
															<option value="${item.currencyId}"
																${fn:contains(transaction.currency, item) ? 'selected' : ''}>${item.currencyName}</option>
														</c:forEach>
													</select>
												</div>
											</div>

										</div>
										<div class="col-lg-12">
											<div class="col-md-6">
												<div class="form-group" id="mode_dropdown_parent">
													<label for="sel_mode" class="small">Mode Payment</label> <select
														required class="form-control custom"
														name="modePayment_rel" id="mode_dropdown">
														<option></option>
														<c:forEach items="${all_modePayment}" var="item">
															<option value="${item.modePaymentId}"
																${fn:contains(transaction.modePayment, item) ? 'selected' : ''}>${item.modePaymentName}</option>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_inout" class="small">In(Take) /
														Out(Payment) <span class="obligatoire" style="color: red">*</span>
													</label> <select required name="InOut" class="form-control"
														placeholder="Enter InOut" id="in_out_input">
														<option></option>
														<option value="Out (Payment)"
															${fn:contains(transaction.inOut, "Out (Payment)") ? 'selected' : ''}>Out
															(Payment)</option>
														<option value="In (Take)"
															${fn:contains(transaction.inOut, "In (Take)") ? 'selected' : ''}>In
															(Take)</option>
													</select>
												</div>
											</div>

											<div class="col-md-12">
												<div class="form-group">
													<label for="txt_comment" class="small">Comment</label>
													<textarea rows="4" cols="50" name="Comment" class="form-control"
														id="comment_input" placeholder="Enter Comment"
														value="${transaction.comment}" >
														</textarea>
												</div>
											</div>
										</div>
									</div>
							</div>


								<div class="box-footer col-md-1.5 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/transaction">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_transaction_btn">Apply</button>
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
