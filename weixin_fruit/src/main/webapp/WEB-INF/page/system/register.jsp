<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<%@ include file="/WEB-INF/page/base/css.jsp"%>
<link href="${ctx }/resources/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/resources/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/resources/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/resources/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>注册账号</title>
</head>
<body>
<div class="loginWraper">
<div class="pd-20" style="margin-top: 175px;">
	<form action="" enctype="multipart/form-data" method="post" class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-5">注册邮箱：</label>
			<div class="formControls col-3">
				<input type="text" class="input-text" value="" placeholder="" id="" name="sequence">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-5">注册密码：</label>
			<div class="formControls col-3">
				<input type="text" class="input-text" value="" placeholder="" id="" name="sequence">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-5">确认密码：</label>
			<div class="formControls col-3">
				<input type="text" class="input-text" value="" placeholder="" id="" name="standard">
			</div>
		</div>
		<div class="row cl">
			<div class="col-18 col-offset-6">
				<input name="" type="submit" class="btn btn-success radius size-LL" value="&nbsp;注&nbsp;册&nbsp;">
			</div>
		</div>
	</form>
</div>
</div>
<script type="text/javascript" src="${ctx }/resources/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/jquery.form.js"></script> 
<script type="text/javascript" src="${ctx }/resources/js/H-ui.js"></script> 
<script type="text/javascript" src="${ctx }/resources/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="${ctx }/resources/lib/ueditor/1.4.3/ueditor.all.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
$(function(){
	
	$("#form-article-add").Validform({
		tiptype:2,
		ajaxPost:true,
		beforeSubmit:function(curform){
			curform.ajaxSubmit({
				type : "post",
				url : "${ctx }/weixinShopGoodsController/addGoods",
				success:function(data) {
					if(data.ok) {
						setTimeout(function(){
							$.Hidemsg(); //公用方法关闭信息提示框;显示方法是$.Showmsg("message goes here.");
							parent.location.reload(); 
				        	layer_close();
						},1000);
					}else {
						$.Showmsg(data.msg);
					}
				}
			});
			return false;
		}

	});
	
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
});

</script>
</body>
</html>