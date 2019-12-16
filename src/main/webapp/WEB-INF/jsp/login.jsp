
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <link rel="stylesheet" href="/css/usersLogin.css">
    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <script src="/js/jquery-1.3.2.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <script src="js/login.js"></script>

    <title>首页</title>
</head>
<body>

<div class="header">

</div>

<div class="body">
    <div class="panel">
        <div class="top">
            <p>账户登陆</p>
        </div>

        <div class="middle">
            <form action="/login" method="post">

                <span class="erro">${msg}</span>
                <span class="s1"></span>
                <span class="s2"></span>
                <input type="text" name="user_name" value=""  class="iputs"/>
                <input type="password" name="user_pass" value="" class="iputs"/>
                <label>
                <input type="radio" checked="checked" name="identype" value="student">学生</label>
                <label>
                <input type="radio"  name="identype" value="admin">宿管</label>
                <label>
                <input type="radio"  name="identype" value="repair">维修人员</label>
<%--                <label>--%>
<%--                <input type="radio"  name="identype" value="visitor">访客</label>--%>
                <input type="submit" value="登陆"/>
            </form>
            <a href="/homepage">访客模式</a>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <span>@Copyright © 2019-2020 版权所有 </span>
</div>
</body>
</html>
