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
									href="${pageContext.request.contextPath}/modePayment">ModePayment</a></li>
								<li class="active"><span>Create ModePayment</span></li>
							</ol>
							<h3>Create ModePayment</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form role="form" method="POST"
								action="${pageContext.request.contextPath}/modePayment/createModePayment"
								data-parsley-validate="">
								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">


											<div class="form-group">
												<label for="txt_modepaymentname" class="small">Mode
													Name</label> <input type="text" placeholder="Mode Name"
													class="form-control" id="txt_modepaymentname"
													name="ModePaymentName" value="${model.modePaymentName}">
											</div>




										</div>
									</div>
								</div>

								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12"></div>
									</div>
								</div>
								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="<?= $GLOBALS['context'] ?>/modePayment">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_modePayment_btn">Submit</button>
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
				<h1>ModePayments</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">ModePayment List</li>
				</ol>
				<!-- Content Wrapper. Contains page content -->
				<!-- Main content -->
				<section class="content">

					<div class="row">

						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">Edit ModePayment</h3>
								</div>
								<!-- /.box-header -->
								<!-- form start -->
								<form role="form" method="POST"
									action="<%=request.getContextPath()%>/app/modePayment/save">
									<div class="box-body">
										<div class="form-group">
											<label for="txt_modepaymentid">ModePaymentId</label> <input
												type="text" name="ModePaymentId" class="form-control"
												id="txt_modepaymentid" placeholder="Enter ModePaymentId"
												value="${d}{model.modePaymentId}">
										</div>
										<div class="form-group">
											<label for="txt_modepaymentname">ModePaymentName</label> <input
												type="text" name="ModePaymentName" class="form-control"
												id="txt_modepaymentname" placeholder="Enter ModePaymentName"
												value="${d}{model.modePaymentName}">
										</div>
										<div class="form-group">
											<label for="txt_mode">Mode</label> <input type="text"
												name="Mode" class="form-control" id="txt_mode"
												placeholder="Enter Mode" value="${d}{model.mode}">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<a type="submit" class="btn btn-info"
											href="<%=request.getContextPath()%>/app/modePayment">Cancel</a>
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
