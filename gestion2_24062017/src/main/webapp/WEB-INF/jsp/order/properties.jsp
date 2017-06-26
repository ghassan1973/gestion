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
								<li class="active"><span>Order</span></li>
							</ol>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form:form role="form" method="POST" modelAttribute="order"
								action="${pageContext.request.contextPath}/order/save"
								data-parsley-validate="">
								<input type="hidden" name="id" value="${order.orderId}" />
								<div class="col-md-12">
									<div class="row">
										<div class="col-lg-12">

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_ordername" class="small">Name <span class="obligatoire" style="color: red">*</span></label>
													<input type="text" name="OrderName" class="form-control"
														id="order_name_input" placeholder="Enter Name"
														value="${order.orderName}" autofocus required/>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_date" class="small">Date <span class="obligatoire" style="color: red">*</span></label> <input
														type="text" name="Date"
														class="form-control datetimepicker" id="date_input"
														placeholder="Enter Date" value="${order.date}" required/>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_amount" class="small">Amount</label> <input
														type="text" name="Amount" class="form-control"
														id="amount_input" placeholder="Enter Amount"
														value="${order.amount}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_totalsettlement" class="small">Total
														Settlement(In or Out)</label> <input type="text"
														name="TotalSettlement" class="form-control"
														id="total_settlement_input"
														placeholder="Enter TotalSettlement"
														value="${order.totalSettlement}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_balance" class="small">Balance</label> <input
														type="text" name="Balance" class="form-control"
														id="balance_input" placeholder="Enter Balance"
														value="${order.balance}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="project_dropdown_parent">
													<label for="sel_project" class="small">Project</label> <select
														class="form-control custom" name="project_rel"
														id="project_dropdown">
														<option></option>
														<c:forEach items="${all_project}" var="item">
															<option value="${item.projectId}"
																${fn:contains(order.project, item) ? 'selected' : ''}>${item.projectName}</option>
														</c:forEach>
													</select>
												</div>
											</div>


										</div>
										<div class="col-lg-12">
											<div class="col-md-6">
												<div class="form-group" id="tier_dropdown_parent">
													<label for="sel_tier" class="small">Tier</label> <select
														class="form-control custom" name="tier_rel"
														id="tier_dropdown">
														<option></option>
														<c:forEach items="${all_tier}" var="item">
															<option value="${item.tierId}"
																${fn:contains(order.tier, item) ? 'selected' : ''}>${item.tierName}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<br /> <br /> <br /> <br /> <br /> <br />
										</div>
									</div>
								</div>
								<div class="box-footer col-md-1.5 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/order">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_order_btn">Apply</button>
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
