<%@ page language="java" pageEncoding="UTF-8" %> <%@ include file="../includes/inc_taglib.jsp" %> <!DOCTYPE html> <html lang="en"> <%@ include file="../includes/inc_head.jsp" %> <body style="margin-top:60px"> <%@ include file="../includes/inc_navbar.jsp" %> <div class="container-fluid"> <div class="row"> <%@ include file="../includes/inc_slidebar.jsp" %> <div class="col-md-10"> <%@ include file="../includes/inc_page_path.jsp" %> <%@ include file="../includes/inc_alert.jsp" %> <div class="well">
    <form role="form" action="${ctxPath}/${domainAndAction.domain}/${domainAndAction.action}" method="POST"><input type="hidden" id="id" name="id" value="${m.id}">

        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="username" value="${m.username}">
        </div>

        <div class="form-group">
            <label for="password">密码</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="password" value="${m.password}">
        </div>


        <div class="form-group">
            <label for="email">邮箱</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="email" value="${m.email}">
        </div>

        <div class="form-group">
            <label for="age">年龄</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="age" value="${m.age}">
        </div>

        <div class="form-group">
            <label for="money">金额</label>
            <input type="text" class="form-control" id="money" name="money" placeholder="money" value="${m.money}">
        </div>

        <button type="submit" class="btn btn-primary">提交</button>
        <a href="${ctxPath}/${domainAndAction.domain}/list" class="btn btn-default">列表</a>
    </form>
</div> </div> </div> </div> <%@ include file="../includes/inc_footer.jsp" %> <%@ include file="../includes/inc_js.jsp" %> </body> </html>
