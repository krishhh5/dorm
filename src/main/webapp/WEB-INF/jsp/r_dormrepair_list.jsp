
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="com.dorm.entity.Repair" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>后台登录</title>
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
        <a href="/applyrepair">维修申请</a>

      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/applyrepair" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/findRepair" >
            <input class="layui-input" placeholder="请输入宿舍编号查询申请单" name="dorm_id" id="dorm_id">
            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="3">
            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button id="addStudnetBtn" class="layui-btn layui-btn-normal"> <i class="layui-icon">&#xe654;</i>填写申请单</button>
<%--        <span class="x-right" style="line-height:40px">共有数据：${di.totalCount} 条</span>--%>
    </xblock>

    <%--添加模态框--%>
    <div class="layui-row" id="test" style="display: none;">
        <div class="layui-col-md10">
            <form class="layui-form" id="addEmployeeForm">
                <div class="layui-form-item">
                    <label class="layui-form-label">宿舍编号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="dorm_id" class="layui-input" placeholder="请输入宿舍编号">
                    </div>
                </div>

<%--                <div class="layui-form-item">--%>
<%--                    <label class="layui-form-label">维修人员：</label>--%>
<%--                    <div class="layui-input-block">--%>
<%--                        <input type="text" lay-verify="required" name="repair_name"  class="layui-input" placeholder="请输入维修人员">--%>
<%--                    </div>--%>
<%--                </div>--%>

                <div class="layui-form-item">
                    <label class="layui-form-label">报修事由：</label>
                    <div class="layui-input-block">
                        <input type="text" name="details" class="layui-input" placeholder="请输入报修事由">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">损坏时间：</label>
                    <div class="layui-input-block">
                        <input type="text" name="begin_time" class="layui-input" placeholder="请输入损坏时间(yyyy-MM-dd HH:mm:ss)">
                    </div>
                </div>


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
    <table class="layui-table">
        <thead>
        <tr>
<%--            <th>ID</th>--%>
            <th>宿舍编号</th>
            <th>维修人员</th>
            <th>报修事由</th>
            <th>报修时间</th>
            <th>更新时间</th>
<%--            <th>操作</th>--%>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="r">
            <tr>
<%--                <td>${r.repair_id}</td>--%>
                <td>${r.dorm_id}</td>
                <td>${r.repair_name}</td>
                <td>${r.details}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${r.begin_time}"/></td>
                <c:if test="${re.checked == 1}"> <td>已维修</td></c:if>
                <c:if test="${re.checked == 0}"> <td>未维修</td></c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>

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
                    title:"添加班级",
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
                        url: '/applyRepair',
                        type: "post",
                        data:JSON.stringify(param),
                        contentType: "application/json; charset=utf-8",
                        success:function(){
                            layer.msg('添加成功', {icon: 1, time: 3000});
                            setTimeout(function () {window.location.href='/applyrepair';},2000);

                        },
                        error:function(){
                            layer.msg('添加失败',{icon:0,time:3000});
                            setTimeout(function () {window.location.href='/applyrepair';},2000);
                        }
                    });
                    // return false;
                });
            });

        });

    </script>


</body>


</html>

