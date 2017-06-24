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
								<li><a href="${pageContext.request.contextPath}/tier">Tier</a></li>
								<li class="active"><span>Create Tier</span></li>
							</ol>
							<h3>Create Tier</h3>
						</div>
					</div>
					<div class="main-box">
						<div class="row">
							<form:form role="form" method="POST" modelAttribute="tier"
								action="${pageContext.request.contextPath}/tier/save"
								data-parsley-validate="">
								<input type="hidden" name="id" value="${tier.tierId}" />
								<div class="col-md-12">
									<div class="row">
										<div class="col-lg-12">

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_tiername" class="small">Tier Name</label> <input
														type="text" name="TierName" class="form-control"
														id="tier_name_input" placeholder="Enter TierName"
														value="${tier.tierName}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group" id="type_dropdown_parent">
													<label for="sel_type" class="small">FamilyTier</label> <select
														class="form-control custom" name="familyTier_rel"
														id="type_dropdown">
														<c:forEach items="${all_familyTier}" var="item">
															<option value="${item.familyTierId}"
																${fn:contains(tier.familyTier, item) ? 'selected' : ''}>${item.familyTierName}</option>
														</c:forEach>
													</select>
												</div>
											</div>


											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_address1" class="small">Address_1</label> <input
														type="text" name="Address1" class="form-control"
														id="address1_input" placeholder="Enter Address1"
														value="${tier.address1}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_address2" class="small">Address_2</label> <input
														type="text" name="Address2" class="form-control"
														id="address2_input" placeholder="Enter Address2"
														value="${tier.address2}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_mobile" class="small">Mobile</label> <input
														type="text" name="Mobile" class="form-control"
														id="mobile_input" placeholder="Enter Mobile"
														value="${tier.mobile}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_phone" class="small">Phone</label> <input
														type="text" name="Phone" class="form-control"
														id="phone_input" placeholder="Enter Phone"
														value="${tier.phone}" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="txt_email" class="small">Email</label> <input
														type="text" name="Email" class="form-control"
														id="email_input" placeholder="Enter Email"
														value="${tier.email}" />
												</div>
											</div>



										</div>
									</div>
								</div>


								<div class="box-footer col-md-12 pull-right">
									<a type="submit" class="btn btn-info"
										href="${pageContext.request.contextPath}/tier">Cancel</a>
									<button type="submit" class="btn btn-primary"
										id="save_tier_btn">Submit</button>
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
