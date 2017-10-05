<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
<link href="${ctx }/resources/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/resources/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>栏目管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 栏目管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20 text-c">
	<div class="text-c">
		<input type="text" name="" id="" placeholder="栏目名称、id" style="width:250px" class="input-text">
		<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" onclick="add_menu('录入菜单','${ctx}/menuManagerController/toAddMenu','700','500')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 录入菜单</a>
		<a href="javascript:;" onclick="onsame()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6df;</i> 同步到微信</a>
	</span> <span class="r">共有数据：<strong>54</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="40"></th>
					<th width="150">商家标识</th>
					<th width="80">微信id</th>
					<th width="80">昵称</th>
					<th width="80">备注</th>
					<th width="80">性别</th>
					<th width="80">省</th>
					<th width="80">市</th>
					<th width="80">区</th>
					<th width="80">头像</th>
					<th width="80">备注名称</th>
					<th width="80">分组id</th>
					<th width="80">创建人</th>
					<th width="80">创建日期</th>
					<th width="80">修改人名称</th>
					<th width="80">修改日期</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${data }" var="d">
					<tr class="text-c">
						<td><input type="checkbox" name="" value=""></td>
						<td></td>
						<td></td>
						<td>${d.OPENID }</td>
						<td class="text-l">${d.NICKNAME }</td>
						<td class="text-l">${d.BZNAME }</td>
						<td class="text-l">${d.SEX }</td>
						<td class="text-l">${d.PROVINCE }</td>
						<td class="text-l">${d.CITY }</td>
						<td class="text-l">${d.COUNTRY }</td>
						<td class="text-l"><img width="70" height="50" src="${d.HEADIMGURL }"/></td>
						<td class="text-l">${d.BZNAME }</td>
						<td class="text-l">${d.type }</td>
						<td class="text-l">${d.orders }</td>
						<td></td>
						<td></td>
						<td></td>
						<td class="f-14"><a title="编辑" href="javascript:;" onclick="edit_menu('菜单编辑','${ctx}/menuManagerController/toEditMenu/${d.ID }','700','480')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="delMenu(this,'${d.ID}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript" src="${ctx }/resources/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="${ctx }/resources/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="${ctx }/resources/js/H-ui.js"></script> 
<script type="text/javascript" src="${ctx }/resources/js/H-ui.admin.js"></script> 
<script type="text/javascript">
$('.table-sort').dataTable({
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,1,2,3,4,5]}// 制定列不参与排序
	]
});
function delMenu(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.get("${ctx}/menuManagerController/delMenu/"+id,function(data){
			if(data.ok) {
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			} else {
				layer.msg('删除失败!',{icon:1,time:1000});
			}
		});
	});
}
function add_menu(title,url,w,h){
	layer_show(title,url,w,h);
}
function edit_menu(title,url,w,h){
	layer_show(title,url,w,h);
}
function onsame(){
	$.get("${ctx}/weixinFansController/samefans",function(data){
		if(data.ok)
			$.Showmsg("同步成功");
		else
			$.Showmsg("同步失败");
	});
}
</script>
</body>
</html>