<%@ page contentType="text/html; charset=UTF-8"%>
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
								<li class="active"><span>Order Lines</span></li>
							</ol>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form:form role="form" method="POST" modelAttribute="orderLines"
								action="${pageContext.request.contextPath}/orderLines/save"
								data-parsley-validate="">
								<input type="hidden" name="id"
									value="${orderLines.orderLinesId}" />
								<div class="col-md-12">
									<div class="row">
										<div class="col-lg-12">

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_orderlinesname" class="small">Name
														<span class="obligatoire" style="color: red">*</span>
													</label> <input type="text" name="OrderLinesName"
														class="form-control" id="order_lines_name_input"
														placeholder="Name" value="${orderLines.orderLinesName}"
														autofocus required />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_quantity" class="small">Quantity</label> <input
														type="text" name="Quantity" class="form-control"
														id="quantity_input" placeholder="Enter Quantity"
														value="${orderLines.quantity}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_unitprice" class="small">Unit Price</label>
													<input type="text" name="UnitPrice" class="form-control"
														id="unit_price_input" placeholder="Enter UnitPrice"
														value="${orderLines.unitPrice}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_discount" class="small">Discount</label> <input
														type="text" name="Discount" class="form-control"
														id="discount_input" placeholder="Enter Discount"
														value="${orderLines.discount}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="product_dropdown_parent">
													<label for="sel_product" class="small">Product</label> <select
														class="form-control custom" name="product_rel"
														id="product_dropdown">
														<option></option>
														<c:forEach items="${all_product}" var="item">
															<option value="${item.productId}"
																${fn:contains(orderLines.product, item) ? 'selected' : ''}>${item.productName}</option>
														</c:forEach>
													</select>
												</div>
											</div>


											<div class="col-md-6">
												<div class="form-group" id="order_dropdown_parent">
													<label for="sel_order" class="small">Order</label> <select
														class="form-control custom" name="order_rel"
														id="order_dropdown">
														<option></option>
														<c:forEach items="${all_order}" var="item">
															<option value="${item.orderId}"
																${fn:contains(orderLines.order, item) ? 'selected' : ''}>${item.orderName}</option>
														</c:forEach>
													</select>
												</div>
											</div>


											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_comment" class="small">Comment</label> <input
														type="text" name="Comment" class="form-control"
														id="comment_input" placeholder="Enter Comment"
														value="${orderLines.comment}" />
												</div>
											</div>

										</div>
									</div>
								</div>


								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/orderLines">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_orderLines_btn">Apply</button>
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
