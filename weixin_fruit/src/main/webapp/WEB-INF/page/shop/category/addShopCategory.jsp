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
<link href="${ctx }/resources/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/resources/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/resources/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/resources/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>新增图片</title>
</head>
<body>
<div class="pd-20">
	<form action="" enctype="multipart/form-data" method="post" class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>分类名称：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="" id="" datatype="*" nullmsg="分类名称不能为空" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-3">录入顺序：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="" id="" name="sequence">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>图片上传：</label>
			<div class="formControls col-30"> 
				<img width="300" id="fileImg1" height="150" src="${d.imgurl }"/>
				<span class="btn-upload">
				  <a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont"></i> 浏览文件</a>
				  <input type="file" id="file1" name="file" datatype="*" nullmsg="分类名称不能为空" class="input-file">
				</span>
			</div>
		</div>
		<div class="row cl">
			<div class="col-10 col-offset-3">
				<button  class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="${ctx }/resources/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/jquery.form.js"></script> 
<script type="text/javascript" src="${ctx }/resources/js/H-ui.js"></script> 
<script type="text/javascript" src="${ctx }/resources/js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$("#file1").change(function () {
		 var fileImg = $("#fileImg1");
		 var imgSrc = $(this)[0].value;
		   if(!/\.(jpg|jpeg|png|JPG|PNG|JPEG)$/.test(imgSrc)) {
	            imgSrc = "";
				alert("格式不正确，请选择正确格式");
	            fileImg.attr("src", "/images/noPic.jpg");
				$('#file1').val("");
	            return false;
			}else {
	            var file = $(this)[0].files[0];
	            var url = URL.createObjectURL(file);
	            fileImg.attr("src", url);
			}
	});
	
	$("#form-article-add").Validform({
		tiptype:2,
		ajaxPost:true,
		beforeSubmit:function(curform){
			curform.ajaxSubmit({
				type : "post",
				url : "${ctx }/weixinShopCategoryController/addCategory",
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