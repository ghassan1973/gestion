<%@ page contentType="text/html; charset=UTF-8" %>
<div role="navigation" id="user-left-box">
	<div class="col-xs-12 col-sm-8 col-md-9 col-lg-2"
		style="background-color: #222; height: 100%;" role="navigation"
		id="user-left-box">
		<div
			style="color: white; display: block; font-size: 14px; line-height: 14px; position: relative; transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms; margin-left: 0px; padding: 23px 0px 33px; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; Source Sans Pro&amp;amp; amp; amp; amp; amp; amp; amp; amp; quot; , sans-serif; vertical-align: middle; text-align: left; font-weight: 600;">
			<!-- react-text: 65 -->
			Advanced search - Customer's payments
			<!-- /react-text -->
		</div>
		<div class="profile-detail"
			style="padding: 0px; max-height: 790px; overflow-y: auto; width: 100%; overflow-x: hidden; height: 75%;">
			<form class="form-vertical"
				action="${pageContext.request.contextPath}/reportcustomerin/search"
				method="post">
				<ul class="nav nav-pills nav-stacked">
					<li class="panel-group" id="accordion">
						<ul class="panel panel-default" style="background: none;">
							<li><label class="small" for="ProjectName"
								style="color: white;">Name</label> <input id="project_name"
								type="text" class="form-control" placeholder="Project name"
								name="projectName" value="${search.projectName}"
								style="background: none; color: white;" autofocus/></li>
						</ul>
					</li>
											<!-- remplir combo avec projet ne marche pas!! -->
											<!--
											<div class="form-group" id="project_dropdown_parent">
													<label for="sel_project" class="small">Project</label> <select
														class="form-control custom" name="project_rel"
														id="project_dropdown">
														<c:forEach items="${all_project}" var="item">
															<option value="${item.projectId}"
																>${item.projectName}</option>
														</c:forEach>
													</select>
												</div>
												-->
					
					<!-- ul class="nav nav-pills nav-stacked">
					<li class="panel-group" id="accordion">
						<ul class="panel panel-default" style="background: none;">
							<li><label class="small" for="InOut"
								style="color: white;">In/Out</label> <input id="in_out"
								type="text" class="form-control" placeholder="In / Out"
								name="inOut" value="${search.inOut}"
								style="background: none; color: white;" autofocus/></li>
						</ul>
					</li>
					</ul -->
					<ul class="nav nav-pills nav-stacked">
					<li class="panel-group" id="accordion">
						<ul class="panel panel-default" style="background: none;">
							<li><label class="small" for="TierName"
								style="color: white;">In / Out</label>
								
													 <select name="inout_sel" class="form-control custom"
														placeholder="Enter InOut" id="inout_dropdown">
														<option value="vide"></option>
														<option value="Out (Payment)">Out(Payment)</option>
														<option value="In (Take)">In(Take)</option>
													</select>
													</li>
													</ul>
					</li>
					</ul>
					
					<ul class="nav nav-pills nav-stacked">
					<li class="panel-group" id="accordion">
						<ul class="panel panel-default" style="background: none;">
							<li><label class="small" for="TierName"
								style="color: white;">Tier name</label> <input id="tier_name"
								type="text" class="form-control" placeholder="Tier name"
								name="tierName" value="${search.tierName}"
								style="background: none; color: white;" autofocus/></li>
						</ul>
					</li>
					</ul>
					<ul class="nav nav-pills nav-stacked">
					<li class="panel-group" id="accordion">
						<ul class="panel panel-default" style="background: none;">
							<li><label class="small" for="OrderName"
								style="color: white;">Order name</label> <input id="order_name"
								type="text" class="form-control" placeholder="Order name"
								name="orderName" value="${search.orderName}"
								style="background: none; color: white;" autofocus/></li>
						</ul>
					</li>
					</ul>
					
					
												
					
				</ul>
				<div style="text-align: center; margin-top: 250px;">
					<button type="submit" class="btn btn-success" id="search_btn">Apply</button>
					<button type="submit" class="btn btn-success" id="reset_btn">Reset</button>

				</div>
			</form>
		</div>
	</div>
</div>