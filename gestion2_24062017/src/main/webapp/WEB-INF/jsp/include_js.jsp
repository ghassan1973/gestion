<script
	src="${pageContext.request.contextPath}/static/js/jquery-2.2.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/parsley.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/moment.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/sidebar.js"></script>

<script>
    $(document).ready(function () {
        $('.nav-item.active').removeClass('active');
        $('.nav-item a').each(function (elem) {
            if(window.location.href.indexOf($(this).attr('href')) != -1){
                $(this).closest('.nav-item').addClass('active');
            }
        });
    });
</script>