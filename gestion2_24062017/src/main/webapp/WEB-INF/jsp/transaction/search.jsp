<div role="navigation" id="user-left-box">
	<div class="col-xs-12 col-sm-8 col-md-9 col-lg-2"
		style="background-color: #222; height: 100%;"
		role="navigation" id="user-left-box">
		<div
			style="color: white; display: block; font-size: 14px; line-height: 14px; position: relative; transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms; margin-left: 0px; padding: 23px 0px 33px; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; quot; Source Sans Pro&amp;amp; amp; amp; amp; amp; amp; amp; quot; , sans-serif; vertical-align: middle; text-align: center; font-weight: 600;">
			<!-- react-text: 65 -->
			SÉLECTION DES FILTRES
			<!-- /react-text -->
		</div>
		<div class="profile-detail"
			style="padding: 0px; max-height: 790px; overflow-y: auto; width: 100%; overflow-x: hidden; height: 75%;">
			<form class="form-vertical"
				action="${pageContext.request.contextPath}/transaction/search"
				method="post">
				<ul class="nav nav-pills nav-stacked">
					<li class="panel-group" id="accordion">
						<ul class="panel panel-default" style="background: none;">
							<li><label class="small" for="TransactionName"
								style="color: white;">Name</label> <input id="transaction_name"
								type="text" class="form-control" placeholder="Name"
								name="transactionName" value="${search.transactionName}"
								style="background: none; color: white;" /></li>
						</ul>
					</li>
				</ul>
				<ul class="nav nav-pills nav-stacked">
					<li class="panel-group" id="accordion">
						<ul class="panel panel-default" style="background: none;">
							<li><label class="small" for="TransactionName"
								style="color: white;">Order</label> <input id="order_name"
								type="text" class="form-control" placeholder="Order"
								name="orderName" value="${search.orderName}"
								style="background: none; color: white;" /></li>
						</ul>
					</li>
				</ul>
				<ul class="nav nav-pills nav-stacked">
					<li class="panel-group" id="accordion">
						<ul class="panel panel-default" style="background: none;">
							<li><label class="small" for="TransactionName"
								style="color: white;">Currency</label> <input id="currency_name"
								type="text" class="form-control" placeholder="Currency"
								name="currencyName" value="${search.currencyName}"
								style="background: none; color: white;" /></li>
						</ul>
					</li>
				</ul>
				<div style="text-align: center; margin-top: 250px;">
					<button type="submit" class="btn btn-success" id="search_btn">Apply</button>
					<button type="submit" class="btn btn-success" id="reset_btn">Reset</button>

				</div>
			</form>
		</div>
	</div>
</div>