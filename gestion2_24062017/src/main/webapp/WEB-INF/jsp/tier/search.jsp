<%@ page contentType="text/html; charset=UTF-8"%>
<div role="navigation" id="user-left-box">
	<div class="col-xs-12 col-sm-8 col-md-9 col-lg-2"
		style="background-color: #222; height: 100%;" role="navigation"
		id="user-left-box">
		<div
			style="color: white; display: block; font-size: 14px; line-height: 14px; position: relative; transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms; margin-left: 0px; padding: 23px 0px 33px; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; Source Sans Pro&amp;amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; , sans-serif; vertical-align: middle; text-align: left; font-weight: 600;">
			Filter...
		</div>
		<div class="profile-detail"
			style="padding: 0px; max-height: 790px; overflow-y: auto; width: 100%; overflow-x: hidden; height: 75%;">
			<form class="form-vertical"
				action="${pageContext.request.contextPath}/tier/search"
				method="post">
				<ul class="nav nav-pills nav-stacked">
					<li class="panel-group" id="accordion">
						<ul class="panel panel-default" style="background: none;">
							<li><label class="small" for="TierName"
								style="color: white;">Name</label> <input id="tier_name"
								type="text" class="form-control" placeholder="Name"
								name="tierName" value="${search.tierName}"
								style="background: none; color: white;" autofocus /></li>
						</ul>
					</li>
					<li class="panel-group" id="accordion">
						<ul class="panel panel-default" style="background: none;">
							<li><label class="small" for="Type" style="color: white;">Type</label> <input
								id="type" type="text" class="form-control" placeholder="Type"
								name="type" value="${search.type}" style="background: none; color: white;" /></li>
						</ul>
					</li>
				</ul>
				<div style="text-align: center; margin-top: 250px;">
					<button type="submit" class="btn btn-success" id="search_btn">
						Apply</button>
					<button type="button" class="btn btn-success" id="reset_btn">
						Reset</button>
				</div>
			</form>
		</div>
	</div>
</div>