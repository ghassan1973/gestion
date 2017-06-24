<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <li><a href="${pageContext.request.contextPath}/permission">Permission</a></li>
                <li class="active"><span>Permission List</span></li>
              </ol>
              <h3>Permission List</h3>
            </div>
          </div>
    <div class="main-box">
      <form class="form-horizontal" action="${pageContext.request.contextPath}/permission/search" method="post">
                            <div class="form-group">
                                <div class="clearfix">
                                <div class="col-lg-3 padding-b-15">
                                <label class="small" for="PermissionName">Permission Name</label>
                                <input id="permission_name" type="text" class="form-control" placeholder="Permission Name" name="permissionName"
                                       value="${search.permissionName}" />
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <button type="submit" class="btn btn-success" id="search_btn">Seach</button>
                                <a href="${pageContext.request.contextPath}/permission/create" class="btn btn-info pull-right">Create Permission</a>
                            </div>
                            </div>
                        </form>
      <div class="table-responsive">
        <table id="mytable" class="table table-striped table-hover table-row checkboxNew">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                                                                                                                                                                                                                                                                    <th class="small">PermissionName</th>
                                                                                                                         <th>&nbsp;</th>
                                        <th>&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${page.content}" varStatus="loop">
                                 <tr class=" repeated">
                                  <td>${loop.index + 1}.</td>
                                                                                                                                <td>
                                            ${item.permissionName}
                                            </td>   
                                                                                                                                <td>
                                                                                    <p data-placement="top" data-toggle="tooltip" title="Edit"><a
                                                class="btn btn-success btn-xs edit_permission_link" href="${pageContext.request.contextPath}/permission/${item.permissionId}/edit"><span
                                                    class="glyphicon glyphicon-pencil"></span>&nbsp;</a></p>
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
                    href="${pageContext.request.contextPath}/permission?page=${i}">
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
