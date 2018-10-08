<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贴吧首页</title>
</head>
<body>
	<a href="javascript:void(0)" onclick="toAddTopic()">我要发帖</a>
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
					<td>${topic.createdate }</td>
					<td>${topic.clickamount }</td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
	<script type="text/javascript">
	function toAddTopic(){
		
	}
	</script>
</body>
</html>