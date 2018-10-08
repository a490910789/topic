<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ctx}/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx}/resources/css/public.css" media="all" />
</head>
<body>
  <form class="layui-form" id="fm" style="text-align: center;margin: 10px 20px">
     	<div class="layui-form-item">
		 <label class="layui-form-label">发帖人</label>
		 <div class="layui-input-block">
			<input type="text" name="author" id="author" lay-verify="title"
				autocomplete="off" placeholder="请输入发帖人" class="layui-input">
		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">帖子标题</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="title" lay-verify="title"
					autocomplete="off" placeholder="请输入标题" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">帖子内容</label>
			<div class="layui-input-block">
		<textarea class="layui-textarea" id="LAY_content" name="content"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
				<div class="layui-input-block" style="text-align: center;">
					<a href="javascript:void(0)"  class="layui-btn"  lay-submit="" lay-filter="formSubmit">提交</a>
					<button type="reset" class="layui-btn layui-btn-warm reset">重置</button>
				</div>
		 </div>
	</form>
	<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
	<script type="text/javascript"> 
		layui.use(['layedit','form'], function() {
			var layedit = layui.layedit, 
			$ = layui.jquery,
			form=layui.form;
			//构建一个默认的编辑器
			var num = layedit.build('LAY_content');
		    
			//清空内容
			$('.reset').on('click', function() {
				$('#LAY_layedit_1').contents().find('body').html('');
			});
			//提交
			 form.on("submit(formSubmit)",function(data){
				 var title=$('#title').val();
				 var author=$('#author').val();
				 var content=layedit.getContent(num);
				 var id=$('#id').val();
			       $.post("${ctx}/topic/addTopic.action?title="+title+"&content="+content+"&id="+id+"&author="+author,function(result){
					//关闭窗口
				   layer.msg(result.msg);
				   var index=parent.layer.getFrameIndex(window.name);
				   parent.layer.close(index);
				   parent.window.location.href="${ctx }/topic/toTopicList.action";
				   });
			   });
		  });
	</script>
</body>
</html>