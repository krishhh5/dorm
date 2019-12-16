
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
    <form class="layui-form"  id="f_auto" action="/updateRepair" method="post" >
        <input type="hidden" value="${sessionScope.e.repair_id}" name="repair_id" id="repair_id"/>

        <div class="layui-form-item">
            <label class="layui-form-label">维修人员：</label>
            <div class="layui-input-block">
                <input type="text" name="repair_name" class="layui-input" placeholder="请输入损坏时间(yyyy-MM-dd HH:mm:ss)">
            </div>
        </div>



        <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
<%--            <input type="radio" name="is_repair" id="edit_repair" value="0" title="未审核" checked="">--%>
            <input type="radio" name="checked" id="edit_repair" value="1" title="已维修">
            <input type="radio" name="checked" id="edit_repair" value="0" title="未维修">
            <%--<input type="text" name="s_sex" class="layui-input" id="s_sex" placeholder="请输入性别">--%>
        </div>
</div>


<%--        <input type="hidden" value="${sessionScope.e.repair_time}" name="repair_time" id="repair_time"/>--%>

<%--        <input type="hidden" value="${sessionScope.d.repair_time}" name="repair_time" id="repair_time"/>--%>

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

