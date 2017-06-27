<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<jsp:include page="./../head.jsp" />
<body class="skin-blue">
	<div id="admin-panel">
		<jsp:include page="./../header.jsp" />
		<div class="container-fluid">
			<div class="row row-offcanvas row-offcanvas-left">
				<jsp:include page="./../sidebar.jsp" />

				<!-- Content-->
				<div class="">
					<div class="row"
						style="padding-bottom: 15px; border-bottom: 1px solid #ccc;">
						<div class="col-lg-12 header-bar">
							<ol class="breadcrumb">
								<li><a href="#">Home</a></li>
								<li class="active"><span>Dashboard</span></li>
							</ol>
							<h3>Dashboard</h3>
						</div>
					</div>

					<div class="row" style="margin-top: 24px;">
						<div class="col-lg-3 col-sm-6">
							<!-- START widget-->
							<div class="panel widget bg-primary"
								data-href="${pageContext.request.contextPath}/transaction">
								<div class="clearfix">
									<div class="col-xs-3 text-center bg-primary-dark pv-lg">
										<em class="fa fa-th-large fa-3x"></em>
									</div>
									<div class="col-xs-8 pv-lg">
										<div class="h2 mt0">${count_transaction}</div>
										<div class="text-uppercase">Transactions</div>
									</div>
								</div>
							</div>
						</div>



						<div class="col-lg-3 col-sm-6">
							<!-- START widget-->
							<div class="panel widget bg-purple"
								data-href="${pageContext.request.contextPath}/project">
								<div class="clearfix">
									<div class="col-xs-4 text-center bg-purple-dark pv-lg">
										<em class="fa fa-th-large fa-3x"></em>
									</div>
									<div class="col-xs-8 pv-lg">
										<div class="h2 mt0">${count_project}</div>
										<div class="text-uppercase">Projects</div>
									</div>
								</div>
							</div>
						</div>


						<div class="col-lg-3 col-sm-6">
							<!-- START widget-->
							<div class="panel widget bg-green"
								data-href="${pageContext.request.contextPath}/order">
								<div class="clearfix">
									<div class="col-xs-4 text-center bg-green-dark pv-lg">
										<em class="fa fa-th-large fa-3x"></em>
									</div>
									<div class="col-xs-8 pv-lg">
										<div class="h2 mt0">${count_order}</div>
										<div class="text-uppercase">Orders</div>
									</div>
								</div>
							</div>
						</div>


						<div class="col-lg-3 col-sm-6">
							<!-- START widget-->
							<div class="panel widget bg-red"
								data-href="${pageContext.request.contextPath}/Tier">
								<div class="clearfix">
									<div class="col-xs-4 text-center bg-red-dark pv-lg">
										<em class="fa fa-th-large fa-3x"></em>
									</div>
									<div class="col-xs-8 pv-lg">
										<div class="h2 mt0">${count_tier}</div>
										<div class="text-uppercase">Tiers</div>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>

		</div>
	</div>
	<jsp:include page="./../include_js.jsp" />


	<script type="text/javascript">
    $('.widget').click(function () {
        window.location.href = $(this).attr('data-href');
    })
</script>
</body>
</html>
