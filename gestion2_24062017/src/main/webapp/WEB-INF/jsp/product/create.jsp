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
								<li><a href="${pageContext.request.contextPath}/product">Product</a></li>
								<li class="active"><span>Create Product</span></li>
							</ol>
							<h3>Create Product</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form:form role="form" method="POST" modelAttribute="product"
								action="${pageContext.request.contextPath}/product/save"
								data-parsley-validate="">
								<input type="hidden" name="id" value="${product.productId}" />
								<div class="col-md-12">
									<div class="row">
										<div class="col-lg-12">

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_productname" class="small">Product
														Name</label> <input type="text" name="ProductName"
														class="form-control" id="product_name_input"
														placeholder="Enter ProductName"
														value="${product.productName}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="family_dropdown_parent">
													<label for="sel_family" class="small">Family</label> <select
														class="form-control custom" name="family_rel"
														id="family_dropdown">
														<c:forEach items="${all_family}" var="item">
															<option value="${item.familyId}"
																${fn:contains(product.family, item) ? 'selected' : ''}>${item.familyName}</option>
														</c:forEach>
													</select>
												</div>
											</div>


											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_unitprice" class="small">Unit Price</label>
													<input type="text" name="UnitPrice" class="form-control"
														id="unit_price_input" placeholder="Enter UnitPrice"
														value="${product.unitPrice}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_tva1" class="small">Tva1</label> <input
														type="text" name="Tva1" class="form-control"
														id="tva1_input" placeholder="Enter Tva1"
														value="${product.tva1}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_tva2" class="small">Tva2</label> <input
														type="text" name="Tva2" class="form-control"
														id="tva2_input" placeholder="Enter Tva2"
														value="${product.tva2}" />
												</div>
											</div>



										</div>
									</div>
								</div>


								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/product">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_product_btn">Submit</button>
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
