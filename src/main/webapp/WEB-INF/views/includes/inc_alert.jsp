<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<c:if test="${!empty actionFlag}">
    <div class="alert alert-info" role="alert">${actionFlag?"操作成功":"操作失败"}</div>
</c:if>