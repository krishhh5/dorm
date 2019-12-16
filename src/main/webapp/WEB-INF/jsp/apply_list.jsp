
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="com.dorm.entity.Dorm" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <%--<meta http-equiv="Cache-Control" content="no-siteapp" />--%>

    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="./js/jquery-1.3.2.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <script src="/layui_exts/excel.js"></script>
    <style type="text/css">
        .layui-table{
                text-align: center;
            }
        .layui-table th{
            text-align: center;
        }
    </style>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="/apply">宿舍信息</a>

      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/apply" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
    </div>
    <%--表格数据--%>
    <table class="layui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>名字</th>
            <th>学号</th>
            <th>性别</th>
            <th>地址</th>
            <th>年龄</th>
            <th>班级</th>
            <th>宿舍编号</th>
            <th>是否通过</th>
            <th>操作</th>
        </thead>
        <tbody>
<c:forEach items="${list}" var="list">
        <tr>
            <%--<td>--%>
                <%--<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>--%>
            <%--</td>--%>
            <td>${list.apply_id}</td>
                <td>${list.s_name}</td>
                <td>${list.s_num}</td>
                <td>${list.s_sex}</td>
                <td>${list.s_address}</td>
                <td>${list.s_age}</td>
                <td>${list.s_class}</td>
                <td>${list.dorm_num}</td>
                <c:if test="${list.is_pass == 1}"> <td>已通过</td></c:if>
                <c:if test="${list.is_pass == 0}"> <td>未通过</td></c:if>
<%--                <td>${list.is_pass}</td>--%>
            <td>
                <a title="编辑" id= "updateEdit"  href="/findApply?apply_id=${list.apply_id}">
                    <i class="layui-icon">&#xe642;</i>
                </a>
<%--                <a title="删除" onclick="member_del(this,'${list.dorm_id}')" href="javascript:;">--%>
<%--                    <i class="layui-icon">&#xe640;</i>--%>
<%--                </a>--%>
            </td>
        </tr>
</c:forEach>
        </tbody>
    </table>

<%--<div class="" >--%>
<%--    <input type="hidden" id="totalPageCount" value="${di.pageTotalCount}"/>--%>
<%--    <c:import url="pageBtn.jsp">--%>
<%--        <c:param name="totalCount" value="${di.totalCount}"/>--%>
<%--        <c:param name="currentPageNo" value="${di.pageIndex}"/>--%>
<%--        <c:param name="totalPageCount" value="${di.pageTotalCount}"/>--%>
<%--    </c:import>--%>
<%--</div>--%>
<script>

    layui.config({
        base: 'layui_exts/',
    }).extend({
        excel: 'excel',
    });

    layui.use(['jquery', 'excel','form','layer','laydate'], function(){
        var form = layui.form,
            $ = layui.jquery,
            laydate = layui.laydate;
        var excel = parent.layui.excel;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });


        /*添加弹出框*/
        $("#addStudnetBtn").click(function () {
            layer.open({
                type:1,
                title:"添加宿舍",
                skin:"myclass",
                area:["50%"],
                anim:2,
                content:$("#test").html()
            });
            $("#addEmployeeForm")[0].reset();
            form.on('submit(formDemo)', function(data) {
                // layer.msg('aaa',{icon:1,time:3000});
                var param=data.field;
                // console.log(JSON.stringify(param));
                $.ajax({
                    url: '/addDormitory',
                    type: "post",
                    data:JSON.stringify(param),
                    contentType: "application/json",
                    success:function(){
                            layer.msg('添加成功', {icon: 1, time: 3000});
                            setTimeout(function () {window.location.href='/findDormitory';},2000);

                    },
                    error:function(){
                        layer.msg('添加失败',{icon:0,time:3000});
                        setTimeout(function () {window.location.href='/findDormitory';},2000);
                    }
                });
                // return false;
            });
        });

    });


    /*删除*/
    // function member_del(obj,dorm_id){
    //     layer.confirm('确认要删除吗？',function(index){
    //         //发异步删除数据
    //         $.get("/deleteDormitory",{"dorm_id":dorm_id},function (data) {
    //             if(data =true){
    //                 layer.msg('删除成功!',{icon:1,time:2000});
    //                 setTimeout(function () {window.location.href='/findDormitory';},2000);
    //
    //             }else {
    //                 layer.msg('删除失败!',{icon:1,time:2000});
    //                 setTimeout(function () {window.location.href='/findDormitory';},2000);
    //             }
    //         });
    //     });
    // }

</script>


</body>


</html>
