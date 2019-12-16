
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
    <form class="layui-form" action="/updateStudent" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.s.user_id}" name="user_id" id="user_id"/>
        <div class="layui-form-item">
            <label for="user_name" class="layui-form-label">
                <span class="f_sp">学号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="user_name" name="user_name"
                       autocomplete="off" value="${sessionScope.s.user_name}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="name" class="layui-form-label">
                <span class="f_sp">姓名</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="name" name="name"
                       autocomplete="off" value="${sessionScope.s.name}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="student_sex" class="layui-form-label">
                <span class="f_sp">性别</span>
            </label>
            <div class="layui-input-inline" id="student_sex">
                <input type="radio" name="student_sex" id="s_male" value="男" title="男" checked="">
                <input type="radio" name="student_sex" id="s_female" value="女" title="女">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="student_age" class="layui-form-label">
                <span class="f_sp">年龄</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="student_age" name="student_age"
                       autocomplete="off" value="${sessionScope.s.student_age}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="student_class" class="layui-form-label">
                <span class="">*</span>班级编号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="student_class" name="student_class"
                       autocomplete="off" value="${sessionScope.s.student_class}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="student_address" class="layui-form-label">
                <span class="">*</span>地址
            </label>
            <div class="layui-input-inline">
                <input type="text" id="student_address" name="student_address"
                       autocomplete="off" value="${sessionScope.s.student_address}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="dorm_id" class="layui-form-label">
                <span class="">*</span>寝室编号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="dorm_id" name="dorm_id"
                       autocomplete="off" value="${sessionScope.s.dorm_id}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn"  id="btn_on" lay-filter="updateForm" lay-submit="">
                修改
            </button>
        </div>
    </form>
</div>

</body>
</html>
