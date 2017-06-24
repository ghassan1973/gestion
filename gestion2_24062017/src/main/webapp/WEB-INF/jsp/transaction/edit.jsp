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
								<li><a
									href="${pageContext.request.contextPath}/transaction">Transaction</a></li>
								<li class="active"><span>Create Transaction</span></li>
							</ol>
							<h3>Create Transaction</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form role="form" method="POST"
								action="${pageContext.request.contextPath}/transaction/createTransaction"
								data-parsley-validate="">
								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">


											<div class="form-group">
												<label for="txt_transactionname" class="small">Transaction
													Name</label> <input type="text" placeholder="Transaction Name"
													class="form-control" id="txt_transactionname"
													name="TransactionName" value="${model.transactionName}">
											</div>



											<div class="form-group">
												<label for="sel_order" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="order_rel"
													id="sel_order">
													<?php
                                                        <c:forEach items="${all_order}" var="item">
<option value="${item.orderId}" ${fn:contains(transaction.order, item) ? 'selected' : ''} >${item.getNaturalKey()}</option>
</c:forEach>
                                                        ?>
												</select>
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
												<label for="txt_piecenum" class="small">Piece Number</label>
												<input type="text" placeholder="Piece Number"
													class="form-control" id="txt_piecenum" name="PieceNum"
													value="${model.pieceNum}">
											</div>



											<div class="form-group">
												<label for="sel_currency" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="currency_rel"
													id="sel_currency">
													<?php
                                                        <c:forEach items="${all_currency}" var="item">
<option value="${item.currencyId}" ${fn:contains(transaction.currency, item) ? 'selected' : ''} >${item.currencyName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>




											<div class="form-group">
												<label for="sel_mode" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="modePayment_rel"
													id="sel_modePayment">
													<?php
                                                        <c:forEach items="${all_mode}" var="item">
<option value="${item.modePaymentId}" ${fn:contains(transaction.mode, item) ? 'selected' : ''} >${item.modePaymentName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>




											<div class="form-group">
												<label for="txt_comment" class="small">Comment</label> <input
													type="text" placeholder="Comment" class="form-control"
													id="txt_comment" name="Comment" value="${model.comment}">
											</div>



											<div class="form-group">
												<label for="txt_inout" class="small">In(Take) /
													Out(Payment)</label> <input type="text"
													placeholder="In(Take) / Out(Payment)" class="form-control"
													id="txt_inout" name="InOut" value="${model.inOut}">
											</div>


										</div>
									</div>
								</div>

								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group" id="order_dropdown_parent">
												<label for="sel_order" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="Order"
													id="order_dropdown">
													<?php
                                                        <c:forEach items="${all_order}" var="item">
<option value="${item.orderId}" ${fn:contains(transaction.order, item) ? 'selected' : ''} >${item.getNaturalKey()}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>

											<div class="form-group">
												<label for="txt_amount" class="small">Amount</label> <input
													type="text" placeholder="Amount" class="form-control"
													id="txt_amount" name="Amount" value="${model.amount}">
											</div>
											<div class="form-group" id="currency_dropdown_parent">
												<label for="sel_currency" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="Currency"
													id="currency_dropdown">
													<?php
                                                        <c:forEach items="${all_currency}" var="item">
<option value="${item.currencyId}" ${fn:contains(transaction.currency, item) ? 'selected' : ''} >${item.currencyName}</option>
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
								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="<?= $GLOBALS['context'] ?>/Transaction">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_transaction_btn">Submit</button>
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
				<h1>Transactions</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Transaction List</li>
				</ol>
				<!-- Content Wrapper. Contains page content -->
				<!-- Main content -->
				<section class="content">

					<div class="row">

						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">Edit Transaction</h3>
								</div>
								<!-- /.box-header -->
								<!-- form start -->
								<form role="form" method="POST"
									action="<%=request.getContextPath()%>/app/transaction/save">
									<div class="box-body">
										<div class="form-group">
											<label for="txt_transactionid">TransactionId</label> <input
												type="text" name="TransactionId" class="form-control"
												id="txt_transactionid" placeholder="Enter TransactionId"
												value="${d}{model.transactionId}">
										</div>
										<div class="form-group">
											<label for="txt_transactionname">TransactionName</label> <input
												type="text" name="TransactionName" class="form-control"
												id="txt_transactionname" placeholder="Enter TransactionName"
												value="${d}{model.transactionName}">
										</div>
										<div class="form-group">
											<label for="txt_order">Order</label> <input type="text"
												name="Order" class="form-control" id="txt_order"
												placeholder="Enter Order" value="${d}{model.order}">
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
											<label for="txt_piecenum">PieceNum</label> <input type="text"
												name="PieceNum" class="form-control" id="txt_piecenum"
												placeholder="Enter PieceNum" value="${d}{model.pieceNum}">
										</div>
										<div class="form-group">
											<label for="txt_currency">Currency</label> <input type="text"
												name="Currency" class="form-control" id="txt_currency"
												placeholder="Enter Currency" value="${d}{model.currency}">
										</div>
										<div class="form-group">
											<label for="txt_mode">Mode</label> <input type="text"
												name="Mode" class="form-control" id="txt_mode"
												placeholder="Enter Mode" value="${d}{model.mode}">
										</div>
										<div class="form-group">
											<label for="txt_comment">Comment</label> <input type="text"
												name="Comment" class="form-control" id="txt_comment"
												placeholder="Enter Comment" value="${d}{model.comment}">
										</div>
										<div class="form-group">
											<label for="txt_inout">InOut</label> <input type="text"
												name="InOut" class="form-control" id="txt_inout"
												placeholder="Enter InOut" value="${d}{model.inOut}">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<a type="submit" class="btn btn-info"
											href="<%=request.getContextPath()%>/app/transaction">Cancel</a>
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
