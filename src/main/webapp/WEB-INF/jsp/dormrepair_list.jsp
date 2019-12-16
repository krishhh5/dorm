
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="com.dorm.entity.Repair" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
        <a href="/findDormRepair">维修信息</a>

      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/findDormRepair" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/findDormRepair" >
<%--            <input class="layui-input" placeholder="请输入宿舍编号" name="dorm_id" id="dorm_id">--%>
            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="3">
<%--            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>--%>
        </form>
    </div>
    <xblock>
        <button id="addStudnetBtn" class="layui-btn layui-btn-normal"> <i class="layui-icon">&#xe654;</i>添加 </button>
        <span class="x-right" style="line-height:40px">共有数据：${di.totalCount} 条</span>
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

                <div class="layui-form-item">
                    <label class="layui-form-label">维修人员：</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verify="required" name="repair_name"  class="layui-input" placeholder="请输入维修人员">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">报修事由：</label>
                    <div class="layui-input-block">
                        <input type="text" name="details" class="layui-input" placeholder="请输入报修事由">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">损坏时间：</label>
                    <div class="layui-input-block">
                        <input type="text" name="begin_time" class="layui-input" placeholder="请输入损坏时间">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">状态</label>
                    <div class="layui-input-block">
                        <input type="radio" name="is_repair" id="edit_repair" value="0" title="未审核" checked="">
                        <input type="radio" name="is_repair" id="edit_repair" value="1" title="通过" >
                        <input type="radio" name="is_repair" id="edit_repair" value="2" title="未通过">
                        <%--<input type="text" name="s_sex" class="layui-input" id="s_sex" placeholder="请输入性别">--%>
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
            <%--<th>--%>
                <%--<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>--%>
            <%--</th>--%>
            <th>ID</th>
            <th>宿舍编号</th>
            <th>维修人员</th>
            <th>报修事由</th>
            <th>报修时间</th>
                <th>状态</th>
            <th>完成时间</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${di.list}" var="di">
            <tr>
                <td>${di.repair_id}</td>
                <td>${di.dorm_id}</td>
                <td>${di.repair_name}</td>
                <td>${di.details}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${di.begin_time}"/></td>
               <c:if test="${di.is_repair == 0}"> <td>未审核</td></c:if>
                <c:if test="${di.is_repair == 1}"> <td>通过</td></c:if>
                <c:if test="${di.is_repair == 2}"> <td>不通过</td></c:if>
<%--                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${di.repair_time}"/></td>--%>
<%--                <c:if test="${re.is_repair == 0}"> <td>未审核</td></c:if>&ndash;%&gt;--%>
                <c:if test="${re.checked == 1}"> <td>已维修</td></c:if>
                <c:if test="${re.checked == 0}"> <td>未维修</td></c:if>
                <td>
                    <a title="编辑"  id= "updateEdit"    href="/findDormRepairById?repair_id=${di.repair_id}">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'${di.repair_id}')" href="javascript:;">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="" >
        <input type="hidden" id="totalPageCount" value="${di.pageTotalCount}"/>
        <c:import url="pageBtn.jsp">
            <c:param name="totalCount" value="${di.totalCount}"/>
            <c:param name="currentPageNo" value="${di.pageIndex}"/>
            <c:param name="totalPageCount" value="${di.pageTotalCount}"/>
        </c:import>
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
                        url: '/addDormRepair',
                        type: "post",
                        data:JSON.stringify(param),
                        contentType: "application/json; charset=utf-8",
                        success:function(){
                            layer.msg('添加成功', {icon: 1, time: 3000});
                            setTimeout(function () {window.location.href='/findDormRepair';},2000);

                        },
                        error:function(){
                            layer.msg('添加失败',{icon:0,time:3000});
                            setTimeout(function () {window.location.href='/findDormRepair';},2000);
                        }
                    });
                    // return false;
                });
            });

        });




        /*删除*/
        function member_del(obj,r_id){
            layer.confirm('确认要删除吗？',function(index){
                //发异步删除数据
                $.get("/deleteDormRepair",{"repair_id":repair_id},function (data) {
                    if(data =true){
                        layer.msg('删除成功!',{icon:1,time:2000});
                        setTimeout(function () {window.location.href='/findDormRepair';},2000);

                    }else {
                        layer.msg('删除失败!',{icon:1,time:2000});
                        setTimeout(function () {window.location.href='/findDormRepair';},2000);
                    }
                });
            });
        }


        /*批量删除*/
        function delAll (obj,s_id) {

            var data = tableCheck.getData();
            layer.confirm('确认要删除吗？'+data,function(s_id){
                //捉到所有被选中的，发异步进行删除
                layer.msg('删除成功', {icon: 1});
                $(".layui-form-checked").not('.header').parents('tr').remove();
            });
        }
    </script>


</body>


</html>

