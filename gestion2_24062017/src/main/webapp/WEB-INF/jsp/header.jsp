<%@ page contentType="text/html; charset=UTF-8" %>
<header>
	<div role="navigation" class="container-fluid navbar-inverse">
		<a class="navbar-brand" id="logo" href="index.jsp"><i class="fa fa-bar-chart fa-2x" aria-hidden="true"></i>HOLDINCO GROUP - REAL ESTATE</a>
		<div class="clearfix">
			<button type="button" class="navbar-toggle" data-toggle="offcanvas"
				data-target=".sidebar-nav">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<div id="header-nav" class="nav-no-collapse pull-right">
				<ul class="nav navbar-nav pull-right" style="margin: 0;">


					<li class="dropdown profile-dropdown pull-left"><a
						data-toggle="dropdown" class="dropdown-toggle" href="#"> <img
							alt=""
							src="${pageContext.request.contextPath}/static/img/images.jpg">
							<span class="hidden-xs"> ${me.firstName} ${me.lastName} </span> <b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="${pageContext.request.contextPath}/myProfile"><i
									class="fa fa-user"></i>Profile</a></li>
							<li><a href="${pageContext.request.contextPath}/logout"><i
									class="fa fa-power-off"></i>Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
</header>
