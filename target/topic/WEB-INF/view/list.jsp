<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ctx}/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx}/resources/css/public.css" media="all" />
<meta charset="UTF-8">
<title>贴吧首页</title>
</head>
<body>
<%-- <a href="javascript:void(0)"  lay-submit=""
					lay-filter="toAddTopic">我要发帖</a>
	<table border="1" style="text-align: center;">
			<thead>
			  <tr>
				<td>标题</td>
				<td>发帖人</td>
				<td>发帖时间</td>
				<td>浏览量</td>
			  </tr>
			</thead>
			<tbody>
				<c:forEach var="topic" items="${list }">
				<tr>
					<td><a href="${ctx }/topic/toViewDetails.action?topicid=${topic.topicid }">${topic.title }</a></td>
					<td>${topic.author }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${topic.createdate }"/></td>
					<td>${topic.clickamount }</td>
				</tr>
			</c:forEach>
			</tbody>
	</table> --%>
	<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
	<table id="topicList" lay-filter="topicList" ></table>
	<script type="text/html" id="tableToolBar">
       <a class="layui-btn" lay-event="add">我要发帖</a>
</script>
	<script type="text/javascript">
	var  tableIns;
	layui.use(['form','jquery','layer','table'],function(){
		var $=layui.jquery,
		form=layui.form,
		table=layui.table;
		layer=layui.layer;
		tableIns = table.render({
		        elem: '#topicList',
		        url : '${ctx}/topic/loadAllTopic.action',
		        cellMinWidth : 95,
		        toolbar: "#tableToolBar",
		        height : "full-180",
		        limit : 10,
		        limits : [10,15,20,25],
		        defaultToolbar: [''],
		        id : "topicListTable",
		        cols : [[
		            {field: 'title', title: ' 标题',align:"center"},
		            {field: 'author', title: '发帖人',  align:'center'},
		            {field: 'createdate', title: '发帖时间', align:'center'},
		            {field: 'clickamount', title: '浏览量',  align:'center'},
		        ]]
		    });
		//监听行单击事件
		table.on('row(topicList)', function(obj){
		  var topicid=obj.data.topicid;
		  window.location.href="${ctx }/topic/toViewDetails.action?topicid="+topicid;
		});
		
		  //监听表格按钮
	    table.on('toolbar(topicList)',function(obj){
	     	switch (obj.event) {
	 		case "add":
	 			toAddTopic();
	 			break;
	 		}
	    });
		function toAddTopic(){
			layer.open({
				title:'发表帖子',  
				type:2,
				content:'${ctx}/topic/toAddTopic.action',
				area:['1000px','600px'],
				maxmin:true,
				success : function(layero, index){
	                var body = layui.layer.getChildFrame('body', index);
	                setTimeout(function(){
	                    layui.layer.tips('点击此处返回帖吧首页', '.layui-layer-setwin .layui-layer-close', {
	                        tips: 3
	                    });
	                },500)
	             }
		     });
		 }
	});
	</script>
</body>
</html>