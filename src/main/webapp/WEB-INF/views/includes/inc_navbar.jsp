<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${ctxPath}">演示程序</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${ctxPath}">首页</a></li>
                <li><a href="#">设置</a></li>
                <li><a href="http://www.macrotea.com" target="_blank">联系我</a></li>
                <li><a href="http://www.macrotea.com" target="_blank">帮助</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="搜索...">
            </form>
        </div>
    </div>
</div>
