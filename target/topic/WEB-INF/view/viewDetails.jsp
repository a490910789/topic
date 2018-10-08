<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
</head>
<body>
	<div style="text-align: center;">
		<div style="white-space:pre">${topic.title }  ${topic.author}  <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${topic.createdate }"/> 共被浏览过${topic.clickamount }次</div>
		<div style="margin-top: 20px"></div>
		正文:${topic.content }
	</div>
	<hr>
	<div style="text-align: center;">
		<font color="red">以下是评论区域</font><br>
		<c:choose>
		<c:when test="${empty list}">
		<h2>暂无评论</h2>
   </c:when>
   <c:otherwise>
    <c:forEach var="reply" items="${list }">
   昵称:${reply.author }&emsp;时间:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${reply.createdate }"/><br>
   ${reply.content }<br>
   ===========================================================<br>
   </c:forEach>
   </c:otherwise>
   </c:choose>
	</div>
	<hr>
	<div style="position: relative;margin-left: 600px">
	<form method="post" id="fm" action="#">
	<input type="hidden" name="topicid" value="${topic.topicid }">
		<label>昵称:</label>
		<input type="text" name="author" required="required">
		<div style="margin-top: 5px"></div>
		<label>评论:</label>
		<textarea   name="content" required="required" style="width: 500px;height: 150px;vertical-align:top"></textarea><br>
		<div style="margin-top: 5px"></div> 
		<div style="white-space:pre">         <a href="javascript:void(0)"  lay-submit=""
					lay-filter="addReply">发表评论</a></div>
	</form>
	</div>
	<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
	<script type="text/javascript">
	layui.use(['form','jquery','layer'],function(){
		var form=layui.form,
		$=layui.jquery,
		layer=layui.layer;
		//监听提交
		 form.on('submit(addReply)', function(data){
			 var params=$("#fm").serialize();
				$.post("${ctx}/reply/addReply.action?"+params,function(result){
					layer.msg(result.msg);
				    setTimeout(function(){
					  window.location.href="${ctx }/topic/toViewDetails.action?topicid=${topic.topicid }"
		            },800)
			  });
		 });
	});
	</script>
</body>
</html>