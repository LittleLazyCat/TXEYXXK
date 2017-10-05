<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="${ctx }/resources/lib/Hui-iconfont/1.0.6/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>菜单编辑</title>
</head>
<body>
<div class="pd-20">
  <form action="${ctx }/menuManagerController/editMenu" method="post" class="form form-horizontal" id="form-member-add">
   <input type="hidden" value="${obj.ID }" name="id">
   <div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>菜单名称：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text"  value="${obj.name }" placeholder="" id="" datatype="*" nullmsg="菜单名称不能为空" name="name">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>上级菜单：</label>
			<div class="formControls col-5"> <span class="select-box">
				<select name="fatherId" id="fatherID" class="select" value="${obj.id }">
					<option value="0">一级菜单</option>
					<c:forEach items="${ data }" var="d" >
						<option value="${d.ID }">${d.name }</option>
						<c:forEach items="${d.selectSonMenuByAccountId }" var="son">
							<option value="${son.ID }">&nbsp;&nbsp;├ ${son.name }</option>
						</c:forEach>
					</c:forEach>
					</select>
				</span>
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>动作设置：</label>
			<div class="formControls col-5"> <span class="select-box">
				<select name="type" class="select">
						<option value="view">网页链接类</option>
					</select>
				</span>
			</div>
			<div class="col-4"> </div>
		</div>
		 <div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>URL：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="${obj.url }" placeholder="" id="" datatype="*" nullmsg="URL不能为空" name="url">
			</div>
			<div class="col-4"> </div>
		</div>
		 <div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>菜单标识：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text"  value="${obj.menukey }" placeholder="" id="" datatype="*" nullmsg="标识不能为空" name="menuKey">
			</div>
			<div class="col-4"> </div>
		</div>
		 <div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>顺序：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="${obj.orders }" placeholder="" id="" datatype="*" nullmsg="顺序不能为空" name="orders">
			</div>
			<div class="col-4"> </div>
		</div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit"  value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
<script type="text/javascript" src="${ctx }/resources/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="${ctx }/resources/js/H-ui.js"></script> 
<script type="text/javascript" src="${ctx }/resources/js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").Validform({
		tiptype:2,
		postonce:true,
		ajaxPost:true,
		callback:function(data){
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
	
});
</script>
</body>
</html>