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
								<li><a href="${pageContext.request.contextPath}/orderLines">OrderLines</a></li>
								<li class="active"><span>Create OrderLines</span></li>
							</ol>
							<h3>Create OrderLines</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form role="form" method="POST"
								action="${pageContext.request.contextPath}/orderLines/createOrderLines"
								data-parsley-validate="">
								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">


											<div class="form-group">
												<label for="txt_orderlinesname" class="small">Order
													Lines Name</label> <input type="text"
													placeholder="Order Lines Name" class="form-control"
													id="txt_orderlinesname" name="OrderLinesName"
													value="${model.orderLinesName}">
											</div>



											<div class="form-group">
												<label for="txt_quantity" class="small">Quantity</label> <input
													type="text" placeholder="Quantity" class="form-control"
													id="txt_quantity" name="Quantity" value="${model.quantity}">
											</div>



											<div class="form-group">
												<label for="txt_unitprice" class="small">Unit Price</label>
												<input type="text" placeholder="Unit Price"
													class="form-control" id="txt_unitprice" name="UnitPrice"
													value="${model.unitPrice}">
											</div>



											<div class="form-group">
												<label for="txt_discount" class="small">Discount</label> <input
													type="text" placeholder="Discount" class="form-control"
													id="txt_discount" name="Discount" value="${model.discount}">
											</div>



											<div class="form-group">
												<label for="sel_product" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="product_rel"
													id="sel_product">
													<?php
                                                        <c:forEach items="${all_product}" var="item">
<option value="${item.productId}" ${fn:contains(orderLines.product, item) ? 'selected' : ''} >${item.productName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>




											<div class="form-group">
												<label for="sel_order" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="order_rel"
													id="sel_order">
													<?php
                                                        <c:forEach items="${all_order}" var="item">
<option value="${item.orderId}" ${fn:contains(orderLines.order, item) ? 'selected' : ''} >${item.getNaturalKey()}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>




											<div class="form-group">
												<label for="txt_comment" class="small">Comment</label> <input
													type="text" placeholder="Comment" class="form-control"
													id="txt_comment" name="Comment" value="${model.comment}">
											</div>


										</div>
									</div>
								</div>

								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group">
												<label for="txt_quantity" class="small">Quantity</label> <input
													type="text" placeholder="Quantity" class="form-control"
													id="txt_quantity" name="Quantity" value="${model.quantity}">
											</div>
											<div class="form-group">
												<label for="txt_discount" class="small">Discount</label> <input
													type="text" placeholder="Discount" class="form-control"
													id="txt_discount" name="Discount" value="${model.discount}">
											</div>

											<div class="form-group" id="order_dropdown_parent">
												<label for="sel_order" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="Order"
													id="order_dropdown">
													<?php
                                                        <c:forEach items="${all_order}" var="item">
<option value="${item.orderId}" ${fn:contains(orderLines.order, item) ? 'selected' : ''} >${item.getNaturalKey()}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>

										</div>
									</div>
								</div>
								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="<?= $GLOBALS['context'] ?>/OrderLines">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_orderLines_btn">Submit</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- EOF -->
	<div class="wrapper">
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="min-height: 916px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Users</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">User List</li>
				</ol>
				<!-- Content Wrapper. Contains page content -->
				<!-- Main content -->
				<section class="content">

					<div class="row">

						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">Edit User</h3>
								</div>
								<!-- /.box-header -->
								<!-- form start -->
								<form role="form" method="POST"
									action="<%=request.getContextPath()%>/app/user/save">
									<div class="box-body">
										<div class="form-group">
											<label for="exampleInputEmail1">UserId</label> <input
												type="text" name="UserId" class="form-control"
												id="exampleInputEmail1" placeholder="Enter UserId"
												value="${model.userId}">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">FirstName</label> <input
												type="text" name="FirstName" class="form-control"
												id="exampleInputEmail1" placeholder="Enter FirstName"
												value="${model.firstName}">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">LastName</label> <input
												type="text" name="LastName" class="form-control"
												id="exampleInputEmail1" placeholder="Enter LastName"
												value="${model.lastName}">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Email</label> <input
												type="text" name="Email" class="form-control"
												id="exampleInputEmail1" placeholder="Enter Email"
												value="${model.email}">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Password</label> <input
												type="text" name="Password" class="form-control"
												id="exampleInputEmail1" placeholder="Enter Password"
												value="${model.password}">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Status</label> <input
												type="text" name="Status" class="form-control"
												id="exampleInputEmail1" placeholder="Enter Status"
												value="${model.status}">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Roles</label> <input
												type="text" name="Roles" class="form-control"
												id="exampleInputEmail1" placeholder="Enter Roles"
												value="${model.roles}">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Tasks</label> <input
												type="text" name="Tasks" class="form-control"
												id="exampleInputEmail1" placeholder="Enter Tasks"
												value="${model.tasks}">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<a type="submit" class="btn btn-info"
											href="<%=request.getContextPath()%>/app/user">Cancel</a>
										<button type="submit" class="btn btn-primary">Submit</button>
									</div>
								</form>
							</div>
							<!-- /.box -->

						</div>
						<!--/.col (left) -->

					</div>


				</section>
				<!-- /.content -->
			</section>
		</div>
	</div>
</body>
</html>




<html>
<jsp:include page="./../head.jsp" />
<body class="skin-blue">
	<div class="wrapper">
		<jsp:include page="./../header.jsp" />
		<jsp:include page="./../sidebar.jsp" />
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="min-height: 916px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>OrderLiness</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">OrderLines List</li>
				</ol>
				<!-- Content Wrapper. Contains page content -->
				<!-- Main content -->
				<section class="content">

					<div class="row">

						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">Edit OrderLines</h3>
								</div>
								<!-- /.box-header -->
								<!-- form start -->
								<form role="form" method="POST"
									action="<%=request.getContextPath()%>/app/orderLines/save">
									<div class="box-body">
										<div class="form-group">
											<label for="txt_orderlinesid">OrderLinesId</label> <input
												type="text" name="OrderLinesId" class="form-control"
												id="txt_orderlinesid" placeholder="Enter OrderLinesId"
												value="${d}{model.orderLinesId}">
										</div>
										<div class="form-group">
											<label for="txt_orderlinesname">OrderLinesName</label> <input
												type="text" name="OrderLinesName" class="form-control"
												id="txt_orderlinesname" placeholder="Enter OrderLinesName"
												value="${d}{model.orderLinesName}">
										</div>
										<div class="form-group">
											<label for="txt_quantity">Quantity</label> <input type="text"
												name="Quantity" class="form-control" id="txt_quantity"
												placeholder="Enter Quantity" value="${d}{model.quantity}">
										</div>
										<div class="form-group">
											<label for="txt_unitprice">UnitPrice</label> <input
												type="text" name="UnitPrice" class="form-control"
												id="txt_unitprice" placeholder="Enter UnitPrice"
												value="${d}{model.unitPrice}">
										</div>
										<div class="form-group">
											<label for="txt_discount">Discount</label> <input type="text"
												name="Discount" class="form-control" id="txt_discount"
												placeholder="Enter Discount" value="${d}{model.discount}">
										</div>
										<div class="form-group">
											<label for="txt_product">Product</label> <input type="text"
												name="Product" class="form-control" id="txt_product"
												placeholder="Enter Product" value="${d}{model.product}">
										</div>
										<div class="form-group">
											<label for="txt_order">Order</label> <input type="text"
												name="Order" class="form-control" id="txt_order"
												placeholder="Enter Order" value="${d}{model.order}">
										</div>
										<div class="form-group">
											<label for="txt_comment">Comment</label> <input type="text"
												name="Comment" class="form-control" id="txt_comment"
												placeholder="Enter Comment" value="${d}{model.comment}">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<a type="submit" class="btn btn-info"
											href="<%=request.getContextPath()%>/app/orderLines">Cancel</a>
										<button type="submit" class="btn btn-primary">Submit</button>
									</div>
								</form>
							</div>
							<!-- /.box -->

						</div>
						<!--/.col (left) -->

					</div>


				</section>
				<!-- /.content -->
			</section>
		</div>
	</div>
</body>
</html>
