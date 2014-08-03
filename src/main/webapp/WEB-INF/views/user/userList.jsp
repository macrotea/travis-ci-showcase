<%@ page language="java" pageEncoding="UTF-8" %> <%@ include file="../includes/inc_taglib.jsp" %> <!DOCTYPE html> <html lang="en"> <%@ include file="../includes/inc_head.jsp" %> <body style="margin-top:60px"> <%@ include file="../includes/inc_navbar.jsp" %> <div class="container-fluid"> <div class="row"> <%@ include file="../includes/inc_slidebar.jsp" %> <div class="col-md-10"> <%@ include file="../includes/inc_page_path.jsp" %> <%@ include file="../includes/inc_alert.jsp" %> <div class="well">
<table class="table table-hover">
    <thead>
        <tr>
            <th>#</th>
            <th>用户名</th>
            <th>邮箱</th>
            <th>年龄</th>
            <th>金额</th>
            <th>添加时间</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="m" items="${dataList}" varStatus="status">
        <tr>
            <td>${m.id}</td>
            <td>${m.username}</td>
            <td>${m.email}</td>
            <td>${m.age}</td>
            <td>${m.money}</td>
            <td><fmt:formatDate value="${m.addTime}" type="date"/></td>
            <td><a href="${ctxPath}/user/edit?id=${m.id}" title="编辑"><span class="glyphicon glyphicon-pencil"></span></a>
                &nbsp;&nbsp;&nbsp;
                <a href="${ctxPath}/user/delete/${m.id}" title="删除"><span class="glyphicon glyphicon-remove"></span></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div> </div> </div> </div> <%@ include file="../includes/inc_footer.jsp" %> <%@ include file="../includes/inc_js.jsp" %> </body> </html>
