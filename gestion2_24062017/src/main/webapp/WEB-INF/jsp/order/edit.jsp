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
								<li><a href="${pageContext.request.contextPath}/order">Order</a></li>
								<li class="active"><span>Create Order</span></li>
							</ol>
							<h3>Create Order</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form role="form" method="POST"
								action="${pageContext.request.contextPath}/order/createOrder"
								data-parsley-validate="">
								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">


											<div class="form-group">
												<label for="txt_ordername" class="small">Order Name</label>
												<input type="text" placeholder="Order Name"
													class="form-control" id="txt_ordername" name="OrderName"
													value="${model.orderName}">
											</div>



											<div class="form-group">
												<label for="txt_date" class="small">Date</label> <input
													type="text" placeholder="Date" class="form-control"
													id="txt_date" name="Date" value="${model.date}">
											</div>



											<div class="form-group">
												<label for="txt_amount" class="small">Amount</label> <input
													type="text" placeholder="Amount" class="form-control"
													id="txt_amount" name="Amount" value="${model.amount}">
											</div>



											<div class="form-group">
												<label for="txt_totalsettlement" class="small">Total
													Settlement(In or Out)</label> <input type="text"
													placeholder="Total Settlement(In or Out)"
													class="form-control" id="txt_totalsettlement"
													name="TotalSettlement" value="${model.totalSettlement}">
											</div>



											<div class="form-group">
												<label for="txt_balance" class="small">Balance</label> <input
													type="text" placeholder="Balance" class="form-control"
													id="txt_balance" name="Balance" value="${model.balance}">
											</div>



											<div class="form-group">
												<label for="sel_project" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="project_rel"
													id="sel_project">
													<?php
                                                        <c:forEach items="${all_project}" var="item">
<option value="${item.projectId}" ${fn:contains(order.project, item) ? 'selected' : ''} >${item.projectNameption>
</c:forEach>
                                                        ?>
												</select>
											</div>




											<div class="form-group">
												<label for="sel_tier" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="tier_rel"
													id="sel_tier">
													<?php
                                                        <c:forEach items="${all_tier}" var="item">
<option value="${item.tierId}" ${fn:contains(order.tier, item) ? 'selected' : ''} >${item.tierName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>







										</div>
									</div>
								</div>

								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group">
												<label for="txt_date" class="small">Date</label> <input
													type="text" placeholder="Date" class="form-control"
													id="txt_date" name="Date" value="${model.date}">
											</div>
											<div class="form-group">
												<label for="txt_totalsettlement" class="small">Total
													Settlement(In or Out)</label> <input type="text"
													placeholder="Total Settlement(In or Out)"
													class="form-control" id="txt_totalsettlement"
													name="TotalSettlement" value="${model.totalSettlement}">
											</div>
											<div class="form-group" id="project_dropdown_parent">
												<label for="sel_project" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="Project"
													id="project_dropdown">
													<?php
                                                        <c:forEach items="${all_project}" var="item">
<option value="${item.projectId}" ${fn:contains(order.project, item) ? 'selected' : ''} >${item.getNaturalKey()}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>




										</div>
									</div>
								</div>
								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="<?= $GLOBALS['context'] ?>/Order">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_order_btn">Submit</button>
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
				<h1>Orders</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Order List</li>
				</ol>
				<!-- Content Wrapper. Contains page content -->
				<!-- Main content -->
				<section class="content">

					<div class="row">

						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">Edit Order</h3>
								</div>
								<!-- /.box-header -->
								<!-- form start -->
								<form role="form" method="POST"
									action="<%=request.getContextPath()%>/app/order/save">
									<div class="box-body">
										<div class="form-group">
											<label for="txt_orderid">OrderId</label> <input type="text"
												name="OrderId" class="form-control" id="txt_orderid"
												placeholder="Enter OrderId" value="${d}{model.orderId}">
										</div>
										<div class="form-group">
											<label for="txt_ordername">OrderName</label> <input
												type="text" name="OrderName" class="form-control"
												id="txt_ordername" placeholder="Enter OrderName"
												value="${d}{model.orderName}">
										</div>
										<div class="form-group">
											<label for="txt_date">Date</label> <input type="text"
												name="Date" class="form-control" id="txt_date"
												placeholder="Enter Date" value="${d}{model.date}">
										</div>
										<div class="form-group">
											<label for="txt_amount">Amount</label> <input type="text"
												name="Amount" class="form-control" id="txt_amount"
												placeholder="Enter Amount" value="${d}{model.amount}">
										</div>
										<div class="form-group">
											<label for="txt_totalsettlement">TotalSettlement</label> <input
												type="text" name="TotalSettlement" class="form-control"
												id="txt_totalsettlement" placeholder="Enter TotalSettlement"
												value="${d}{model.totalSettlement}">
										</div>
										<div class="form-group">
											<label for="txt_balance">Balance</label> <input type="text"
												name="Balance" class="form-control" id="txt_balance"
												placeholder="Enter Balance" value="${d}{model.balance}">
										</div>
										<div class="form-group">
											<label for="txt_project">Project</label> <input type="text"
												name="Project" class="form-control" id="txt_project"
												placeholder="Enter Project" value="${d}{model.project}">
										</div>
										<div class="form-group">
											<label for="txt_tier">Tier</label> <input type="text"
												name="Tier" class="form-control" id="txt_tier"
												placeholder="Enter Tier" value="${d}{model.tier}">
										</div>
										<div class="form-group">
											<label for="txt_order">Order</label> <input type="text"
												name="Order" class="form-control" id="txt_order"
												placeholder="Enter Order" value="${d}{model.order}">
										</div>
										<div class="form-group">
											<label for="txt_order">Order</label> <input type="text"
												name="Order" class="form-control" id="txt_order"
												placeholder="Enter Order" value="${d}{model.order}">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<a type="submit" class="btn btn-info"
											href="<%=request.getContextPath()%>/app/order">Cancel</a>
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
