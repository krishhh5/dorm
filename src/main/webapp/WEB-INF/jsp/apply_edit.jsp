
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改信息</title>
    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <link rel="stylesheet" href="/css/pg_btn.css">
    <script type="text/javascript" src="./js/jquery-1.3.2.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>

<body>

<div class="x-body">
    <form class="layui-form"  id="f_auto" action="/update" method="post" >
        <input type="hidden" value="${sessionScope.a.apply_id}" name="apply_id" id="apply_id"/>

        <div class="layui-form-item">
        <label class="layui-form-label">是否通过</label>
        <div class="layui-input-block">
<%--            <input type="radio" name="is_repair" id="edit_repair" value="0" title="未审核" checked="">--%>
            <input type="radio" name="is_pass" id="is_pass" value="1" title="已通过">
            <input type="radio" name="is_pass" id="is_pass" value="0" checked="checked" title="未通过">
        </div>
</div>

        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn" id="btn_on"  lay-submit="" lay-filter="updateEdit">
                修改
            </button>
        </div>
    </form>
</div>

<script>
</script>
</body>
</html>

