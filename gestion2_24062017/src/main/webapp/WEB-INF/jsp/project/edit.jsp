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
								<li><a href="${pageContext.request.contextPath}/project">Project</a></li>
								<li class="active"><span>Create Project</span></li>
							</ol>
							<h3>Create Project</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form role="form" method="POST"
								action="${pageContext.request.contextPath}/project/createProject"
								data-parsley-validate="">
								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">


											<div class="form-group">
												<label for="txt_projectname" class="small">Project
													Name</label> <input type="text" placeholder="Project Name"
													class="form-control" id="txt_projectname"
													name="ProjectName" value="${model.projectName}">
											</div>



											<div class="form-group">
												<label for="sel_region" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="region_rel"
													id="sel_region">
													<?php
                                                        <c:forEach items="${all_region}" var="item">
<option value="${item.regionId}" ${fn:contains(project.region, item) ? 'selected' : ''} >${item.regionName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>




											<div class="form-group">
												<label for="sel_projecttype" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="projectType_rel"
													id="sel_projectType">
													<?php
                                                        <c:forEach items="${all_projectType}" var="item">
<option value="${item.projectTypeId}" ${fn:contains(project.projectType, item) ? 'selected' : ''} >${item.projectTypeName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>




											<div class="form-group">
												<label for="sel_status" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="projectStatus_rel"
													id="sel_projectStatus">
													<?php
                                                        <c:forEach items="${all_projectStatus}" var="item">
<option value="${item.projectStatusId}" ${fn:contains(project.status, item) ? 'selected' : ''} >${item.projectStatusName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>




											<div class="form-group">
												<label for="txt_startdate" class="small">Start Date</label>
												<input type="text" placeholder="Start Date"
													class="form-control" id="txt_startdate" name="StartDate"
													value="${model.startDate}">
											</div>



											<div class="form-group">
												<label for="txt_enddate" class="small">End Date</label> <input
													type="text" placeholder="End Date" class="form-control"
													id="txt_enddate" name="EndDate" value="${model.endDate}">
											</div>



											<div class="form-group">
												<label for="txt_cost" class="small">Cost</label> <input
													type="text" placeholder="Cost" class="form-control"
													id="txt_cost" name="Cost" value="${model.cost}">
											</div>



											<div class="form-group">
												<label for="txt_sale" class="small">Sale</label> <input
													type="text" placeholder="Sale" class="form-control"
													id="txt_sale" name="Sale" value="${model.sale}">
											</div>



											<div class="form-group">
												<label for="txt_resttopay" class="small">Rest To Pay</label>
												<input type="text" placeholder="Rest To Pay"
													class="form-control" id="txt_resttopay" name="RestToPay"
													value="${model.restToPay}">
											</div>



											<div class="form-group">
												<label for="txt_margin" class="small">Margin</label> <input
													type="text" placeholder="Margin" class="form-control"
													id="txt_margin" name="Margin" value="${model.margin}">
											</div>




										</div>
									</div>
								</div>

								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group" id="region_dropdown_parent">
												<label for="sel_region" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="Region"
													id="region_dropdown">
													<?php
                                                        <c:forEach items="${all_region}" var="item">
<option value="${item.regionId}" ${fn:contains(project.region, item) ? 'selected' : ''} >${item.regionName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>


											<div class="form-group" id="status_dropdown_parent">
												<label for="sel_status" class="small">${prop.getRelationship().getOwningEntity().getName()}</label>
												<select class="form-control custom" name="Status"
													id="status_dropdown">
													<?php
                                                        <c:forEach items="${all_status}" var="item">
<option value="${item.projectStatusId}" ${fn:contains(project.status, item) ? 'selected' : ''} >${item.projectStatusName}</option>
</c:forEach>
                                                        ?>
												</select>
											</div>

											<div class="form-group">
												<label for="txt_enddate" class="small">End Date</label> <input
													type="text" placeholder="End Date" class="form-control"
													id="txt_enddate" name="EndDate" value="${model.endDate}">
											</div>
											<div class="form-group">
												<label for="txt_sale" class="small">Sale</label> <input
													type="text" placeholder="Sale" class="form-control"
													id="txt_sale" name="Sale" value="${model.sale}">
											</div>
											<div class="form-group">
												<label for="txt_margin" class="small">Margin</label> <input
													type="text" placeholder="Margin" class="form-control"
													id="txt_margin" name="Margin" value="${model.margin}">
											</div>

										</div>
									</div>
								</div>
								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="<?= $GLOBALS['context'] ?>/Project">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_project_btn">Submit</button>
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
				<h1>Projects</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Project List</li>
				</ol>
				<!-- Content Wrapper. Contains page content -->
				<!-- Main content -->
				<section class="content">

					<div class="row">

						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">Edit Project</h3>
								</div>
								<!-- /.box-header -->
								<!-- form start -->
								<form role="form" method="POST"
									action="<%=request.getContextPath()%>/app/project/save">
									<div class="box-body">
										<div class="form-group">
											<label for="txt_projectid">ProjectId</label> <input
												type="text" name="ProjectId" class="form-control"
												id="txt_projectid" placeholder="Enter ProjectId"
												value="${d}{model.projectId}">
										</div>
										<div class="form-group">
											<label for="txt_projectname">ProjectName</label> <input
												type="text" name="ProjectName" class="form-control"
												id="txt_projectname" placeholder="Enter ProjectName"
												value="${d}{model.projectName}">
										</div>
										<div class="form-group">
											<label for="txt_region">Region</label> <input type="text"
												name="Region" class="form-control" id="txt_region"
												placeholder="Enter Region" value="${d}{model.region}">
										</div>
										<div class="form-group">
											<label for="txt_projecttype">ProjectType</label> <input
												type="text" name="ProjectType" class="form-control"
												id="txt_projecttype" placeholder="Enter ProjectType"
												value="${d}{model.projectType}">
										</div>
										<div class="form-group">
											<label for="txt_status">Status</label> <input type="text"
												name="Status" class="form-control" id="txt_status"
												placeholder="Enter Status" value="${d}{model.status}">
										</div>
										<div class="form-group">
											<label for="txt_startdate">StartDate</label> <input
												type="text" name="StartDate" class="form-control"
												id="txt_startdate" placeholder="Enter StartDate"
												value="${d}{model.startDate}">
										</div>
										<div class="form-group">
											<label for="txt_enddate">EndDate</label> <input type="text"
												name="EndDate" class="form-control" id="txt_enddate"
												placeholder="Enter EndDate" value="${d}{model.endDate}">
										</div>
										<div class="form-group">
											<label for="txt_cost">Cost</label> <input type="text"
												name="Cost" class="form-control" id="txt_cost"
												placeholder="Enter Cost" value="${d}{model.cost}">
										</div>
										<div class="form-group">
											<label for="txt_sale">Sale</label> <input type="text"
												name="Sale" class="form-control" id="txt_sale"
												placeholder="Enter Sale" value="${d}{model.sale}">
										</div>
										<div class="form-group">
											<label for="txt_resttopay">RestToPay</label> <input
												type="text" name="RestToPay" class="form-control"
												id="txt_resttopay" placeholder="Enter RestToPay"
												value="${d}{model.restToPay}">
										</div>
										<div class="form-group">
											<label for="txt_margin">Margin</label> <input type="text"
												name="Margin" class="form-control" id="txt_margin"
												placeholder="Enter Margin" value="${d}{model.margin}">
										</div>
										<div class="form-group">
											<label for="txt_project">Project</label> <input type="text"
												name="Project" class="form-control" id="txt_project"
												placeholder="Enter Project" value="${d}{model.project}">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<a type="submit" class="btn btn-info"
											href="<%=request.getContextPath()%>/app/project">Cancel</a>
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
