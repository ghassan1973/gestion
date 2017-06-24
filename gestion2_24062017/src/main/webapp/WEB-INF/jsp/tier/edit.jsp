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
								<li><a href="${pageContext.request.contextPath}/tier">Tier</a></li>
								<li class="active"><span>Create Tier</span></li>
							</ol>
							<h3>Create Tier</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form role="form" method="POST"
								action="${pageContext.request.contextPath}/tier/createTier"
								data-parsley-validate="">
								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">


											<div class="form-group">
												<label for="txt_tiername" class="small">Tier Name</label> <input
													type="text" placeholder="Tier Name" class="form-control"
													id="txt_tiername" name="TierName" value="${model.tierName}">
											</div>



											<div class="form-group">
												<label for="sel_type" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="familyTier_rel"
													id="sel_familyTier">
													<?php
                                                        <c:forEach items="${all_familyTier}" var="item">
<option value="${item.familyTierId}" ${fn:contains(tier.familyTier, item) ? 'selected' : ''} >${item.familyTierName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>




											<div class="form-group">
												<label for="txt_address1" class="small">Address_1</label> <input
													type="text" placeholder="Address_1" class="form-control"
													id="txt_address1" name="Address1" value="${model.address1}">
											</div>



											<div class="form-group">
												<label for="txt_address2" class="small">Address_2</label> <input
													type="text" placeholder="Address_2" class="form-control"
													id="txt_address2" name="Address2" value="${model.address2}">
											</div>



											<div class="form-group">
												<label for="txt_mobile" class="small">Mobile</label> <input
													type="text" placeholder="Mobile" class="form-control"
													id="txt_mobile" name="Mobile" value="${model.mobile}">
											</div>



											<div class="form-group">
												<label for="txt_phone" class="small">Phone</label> <input
													type="text" placeholder="Phone" class="form-control"
													id="txt_phone" name="Phone" value="${model.phone}">
											</div>



											<div class="form-group">
												<label for="txt_email" class="small">Email</label> <input
													type="text" placeholder="Email" class="form-control"
													id="txt_email" name="Email" value="${model.email}">
											</div>




										</div>
									</div>
								</div>

								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group" id="type_dropdown_parent">
												<label for="sel_type" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="Type"
													id="type_dropdown">
													<?php
                                                        <c:forEach items="${all_type}" var="item">
<option value="${item.familyTierId}" ${fn:contains(tier.type, item) ? 'selected' : ''} >${item.familyTierName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>

											<div class="form-group">
												<label for="txt_address2" class="small">Address_2</label> <input
													type="text" placeholder="Address_2" class="form-control"
													id="txt_address2" name="Address2" value="${model.address2}">
											</div>
											<div class="form-group">
												<label for="txt_phone" class="small">Phone</label> <input
													type="text" placeholder="Phone" class="form-control"
													id="txt_phone" name="Phone" value="${model.phone}">
											</div>

										</div>
									</div>
								</div>
								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="<?= $GLOBALS['context'] ?>/Tier">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_tier_btn">Submit</button>
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
				<h1>Tiers</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Tier List</li>
				</ol>
				<!-- Content Wrapper. Contains page content -->
				<!-- Main content -->
				<section class="content">

					<div class="row">

						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">Edit Tier</h3>
								</div>
								<!-- /.box-header -->
								<!-- form start -->
								<form role="form" method="POST"
									action="<%=request.getContextPath()%>/app/tier/save">
									<div class="box-body">
										<div class="form-group">
											<label for="txt_tierid">TierId</label> <input type="text"
												name="TierId" class="form-control" id="txt_tierid"
												placeholder="Enter TierId" value="${d}{model.tierId}">
										</div>
										<div class="form-group">
											<label for="txt_tiername">TierName</label> <input type="text"
												name="TierName" class="form-control" id="txt_tiername"
												placeholder="Enter TierName" value="${d}{model.tierName}">
										</div>
										<div class="form-group">
											<label for="txt_type">Type</label> <input type="text"
												name="Type" class="form-control" id="txt_type"
												placeholder="Enter Type" value="${d}{model.type}">
										</div>
										<div class="form-group">
											<label for="txt_address1">Address1</label> <input type="text"
												name="Address1" class="form-control" id="txt_address1"
												placeholder="Enter Address1" value="${d}{model.address1}">
										</div>
										<div class="form-group">
											<label for="txt_address2">Address2</label> <input type="text"
												name="Address2" class="form-control" id="txt_address2"
												placeholder="Enter Address2" value="${d}{model.address2}">
										</div>
										<div class="form-group">
											<label for="txt_mobile">Mobile</label> <input type="text"
												name="Mobile" class="form-control" id="txt_mobile"
												placeholder="Enter Mobile" value="${d}{model.mobile}">
										</div>
										<div class="form-group">
											<label for="txt_phone">Phone</label> <input type="text"
												name="Phone" class="form-control" id="txt_phone"
												placeholder="Enter Phone" value="${d}{model.phone}">
										</div>
										<div class="form-group">
											<label for="txt_email">Email</label> <input type="text"
												name="Email" class="form-control" id="txt_email"
												placeholder="Enter Email" value="${d}{model.email}">
										</div>
										<div class="form-group">
											<label for="txt_tier">Tier</label> <input type="text"
												name="Tier" class="form-control" id="txt_tier"
												placeholder="Enter Tier" value="${d}{model.tier}">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<a type="submit" class="btn btn-info"
											href="<%=request.getContextPath()%>/app/tier">Cancel</a>
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
