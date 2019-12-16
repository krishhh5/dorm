
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.dorm.entity.Visitor" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>后台</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />

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
        <a href="/applyVisit">访客信息</a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/applyVisit" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
<%--        <form class="layui-form layui-col-md12 x-so" action="/findVisitor" >--%>
<%--            <input class="layui-input" placeholder="请输入姓名" name="visitor_name" id="visitor_name">--%>


<%--            <input class="layui-input" type="hidden" name="pageIndex" value="1">--%>
<%--            <input class="layui-input" type="hidden" name="pageSize" value="3">--%>
<%--            <button class="layui-btn"  lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i></button>--%>
<%--        </form>--%>
    </div>
    <xblock>
        <button id="addStudentBtn" class="layui-btn layui-btn-normal"> <i class="layui-icon">&#xe654;</i>填写申请表 </button>
<%--        <span class="x-right" style="line-height:40px">共有数据：${pi.totalCount} 条</span>--%>
    </xblock>

    <%--添加模态框--%>
    <div class="layui-row" id="test" style="display: none;">
        <div class="layui-col-md10">
            <form class="layui-form" id="addEmployeeForm">

                <div class="layui-form-item">
                    <label class="layui-form-label">姓名：</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verify="required" name="visitor_name"  class="layui-input" placeholder="请输入姓名">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">电话：</label>
                    <div class="layui-input-block">
                        <input type="text"  name="phone"  class="layui-input" placeholder="请输入电话">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">备注：</label>
                    <div class="layui-input-block">
                        <input type="text"  name="remark"  class="layui-input" placeholder="请输入备注">
                    </div>
                </div>

<%--                <div class="layui-form-item">--%>
<%--                    <label class="layui-form-label">访问时间：</label>--%>
<%--                    <div class="layui-input-block">--%>
<%--                        <input type="text"  name="beginTime"  class="layui-input" placeholder="请输入访问时间">--%>
<%--                    </div>--%>
<%--                </div>--%>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <%--表格数据--%>
<%--    <table class="layui-table">--%>
<%--        <thead>--%>
<%--        <tr>--%>

<%--            <th>ID</th>--%>
<%--            <th>访客姓名</th>--%>
<%--            <th>访客电话</th>--%>
<%--            <th>访问时间</th>--%>
<%--            <th>备注</th>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach items="${pi.list}" var="visitor">--%>
<%--            <tr>--%>
<%--                <td>${visitor.visitor_id}</td>--%>
<%--                <td>${visitor.visitor_name}</td>--%>
<%--                <td>${visitor.phone}</td>--%>
<%--                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${visitor.beginTime}"/></td>--%>
<%--                <td>${visitor.remark}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>

<%--    <div class="" >--%>
<%--        <input type="hidden" id="totalPageCount" value="${pi.pageTotalCount}"/>--%>
<%--        <c:import url="pageBtn.jsp">--%>
<%--            <c:param name="totalCount" value="${pi.totalCount}"/>--%>
<%--            <c:param name="currentPageNo" value="${pi.pageIndex}"/>--%>
<%--            <c:param name="totalPageCount" value="${pi.pageTotalCount}"/>--%>
<%--        </c:import>--%>
<%--    </div>--%>
</div>
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
        $("#addStudentBtn").click(function () {
            layer.open({
                type:1,
                title:"添加访客",
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
                    url: '/addVisit',
                    type: "post",
                    data:JSON.stringify(param),
                    contentType: "application/json",
                    success:function(){
                        layer.msg('添加成功', {icon: 1, time: 3000});
                        setTimeout(function () {window.location.href='/applyVisit';},2000);

                    },
                    error:function(){
                        layer.msg('添加失败',{icon:0,time:3000});
                        setTimeout(function () {window.location.href='/applyVisit';},2000);
                    }
                });
            });
        });


    });
</script>

</body>

</html>
