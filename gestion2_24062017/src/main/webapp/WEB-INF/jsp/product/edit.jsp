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
							<form role="form" method="POST"
								action="${pageContext.request.contextPath}/product/createProduct"
								data-parsley-validate="">
								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">


											<div class="form-group">
												<label for="txt_productname" class="small">Product
													Name</label> <input type="text" placeholder="Product Name"
													class="form-control" id="txt_productname"
													name="ProductName" value="${model.productName}">
											</div>



											<div class="form-group">
												<label for="sel_family" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="family_rel"
													id="sel_family">
													<?php
                                                        <c:forEach items="${all_family}" var="item">
<option value="${item.familyId}" ${fn:contains(product.family, item) ? 'selected' : ''} >${item.familyName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>




											<div class="form-group">
												<label for="txt_unitprice" class="small">Unit Price</label>
												<input type="text" placeholder="Unit Price"
													class="form-control" id="txt_unitprice" name="UnitPrice"
													value="${model.unitPrice}">
											</div>



											<div class="form-group">
												<label for="txt_tva1" class="small">Tva1</label> <input
													type="text" placeholder="Tva1" class="form-control"
													id="txt_tva1" name="Tva1" value="${model.tva1}">
											</div>



											<div class="form-group">
												<label for="txt_tva2" class="small">Tva2</label> <input
													type="text" placeholder="Tva2" class="form-control"
													id="txt_tva2" name="Tva2" value="${model.tva2}">
											</div>




										</div>
									</div>
								</div>

								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group" id="family_dropdown_parent">
												<label for="sel_family" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="Family"
													id="family_dropdown">
													<?php
                                                        <c:forEach items="${all_family}" var="item">
<option value="${item.familyId}" ${fn:contains(product.family, item) ? 'selected' : ''} >${item.familyName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>

											<div class="form-group">
												<label for="txt_tva1" class="small">Tva1</label> <input
													type="text" placeholder="Tva1" class="form-control"
													id="txt_tva1" name="Tva1" value="${model.tva1}">
											</div>

										</div>
									</div>
								</div>
								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="<?= $GLOBALS['context'] ?>/Product">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_product_btn">Submit</button>
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
				<h1>Products</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Product List</li>
				</ol>
				<!-- Content Wrapper. Contains page content -->
				<!-- Main content -->
				<section class="content">

					<div class="row">

						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">Edit Product</h3>
								</div>
								<!-- /.box-header -->
								<!-- form start -->
								<form role="form" method="POST"
									action="<%=request.getContextPath()%>/app/product/save">
									<div class="box-body">
										<div class="form-group">
											<label for="txt_productid">ProductId</label> <input
												type="text" name="ProductId" class="form-control"
												id="txt_productid" placeholder="Enter ProductId"
												value="${d}{model.productId}">
										</div>
										<div class="form-group">
											<label for="txt_productname">ProductName</label> <input
												type="text" name="ProductName" class="form-control"
												id="txt_productname" placeholder="Enter ProductName"
												value="${d}{model.productName}">
										</div>
										<div class="form-group">
											<label for="txt_family">Family</label> <input type="text"
												name="Family" class="form-control" id="txt_family"
												placeholder="Enter Family" value="${d}{model.family}">
										</div>
										<div class="form-group">
											<label for="txt_unitprice">UnitPrice</label> <input
												type="text" name="UnitPrice" class="form-control"
												id="txt_unitprice" placeholder="Enter UnitPrice"
												value="${d}{model.unitPrice}">
										</div>
										<div class="form-group">
											<label for="txt_tva1">Tva1</label> <input type="text"
												name="Tva1" class="form-control" id="txt_tva1"
												placeholder="Enter Tva1" value="${d}{model.tva1}">
										</div>
										<div class="form-group">
											<label for="txt_tva2">Tva2</label> <input type="text"
												name="Tva2" class="form-control" id="txt_tva2"
												placeholder="Enter Tva2" value="${d}{model.tva2}">
										</div>
										<div class="form-group">
											<label for="txt_product">Product</label> <input type="text"
												name="Product" class="form-control" id="txt_product"
												placeholder="Enter Product" value="${d}{model.product}">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<a type="submit" class="btn btn-info"
											href="<%=request.getContextPath()%>/app/product">Cancel</a>
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
