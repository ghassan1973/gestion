<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<jsp:include page="./../head.jsp" />
<body class="skin-blue">
  <div id="admin-panel">
    <jsp:include page="./../header.jsp" />
    <div class="container-fluid">
      <div class="row row-offcanvas row-offcanvas-left">
        <jsp:include page="./../sidebar.jsp" />
		<jsp:include page="search.jsp" />

        <!-- Content-->
        <div class="col-xs-12 col-sm-8 col-md-9 col-lg-10">
          <div class="row">
						<div class="col-lg-12 header-bar">
							<ol class="breadcrumb">
								<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
								<li class="active"><span>Project</span></li>
							</ol>
						</div>
					</div>
    <div class="main-box">
   
						
      <div class="table-responsive">
        <table id="mytable" class="table table-striped table-hover table-row checkboxNew">
                                <thead>
                                    <tr>
									
                                        <th>#</th>
										<th class="small">In/Out</th>
										<th class="small">Project Name</th>
										<th class="small">Credit</th>
										<th class="small">Debt</th>
										<th class="small">Balance</th>
                                        <th>&nbsp;</th>
                                        <th>&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${page.content}" varStatus="loop">
                                 <tr class=" repeated">
                                  <td>${loop.index + 1}.</td>
                                            <td>
                                            ${item.inOut}
                                            </td>
											<td>
                                            ${item.projectName}
                                            </td>
											<td>
                                            ${item.credit}
                                            </td>
											<td>
                                            ${item.debt}
                                            </td>
											<td>
                                            ${item.balance}
                                            </td>
											
                                            <td>
                                            </td>
                                 </tr>
                  </c:forEach>
                                </tbody>
      </table>
      </div>
      <!-- Pagination toolbar -->
            <div class="clearfix">
              <div class="pull-left">
                <span>Showing page ${page.number + 1} of
                  ${page.totalPages}</span>
              </div>
              <ul class="pagination pull-right">
                <c:if test="${page.isFirstPage()}">
                  <li class="disabled"><a href="#" class="prev"><i
                      class="fa fa-chevron-left"></i>&nbsp;</a></li>
                </c:if>
                <c:if test="${not page.isFirstPage()}">
                  <li><a href="#" class="prev"><i
                      class="fa fa-chevron-left"></i>&nbsp;</a></li>
                </c:if>

                <c:forEach begin="1" end="${page.totalPages}" var="i">
                  <li><a
                    href="${pageContext.request.contextPath}/reportprojectinout?page=${i}">
                      ${i} </a></li>
                </c:forEach>
                <c:if test="${page.isLastPage()}">
                  <li class="disabled"><a href="#" class="next"><i
                      class="fa fa-chevron-right"></i>&nbsp;</a></li>
                </c:if>
                <c:if test="${not page.isLastPage()}">
                  <li><a href="#" class="next"><i
                      class="fa fa-chevron-right"></i>&nbsp;</a></li>
                </c:if>
              </ul>
            </div>
    </div>
</div>

</div>
</div>

</div>

<jsp:include page="./../include_js.jsp" />

</body>

</html>
