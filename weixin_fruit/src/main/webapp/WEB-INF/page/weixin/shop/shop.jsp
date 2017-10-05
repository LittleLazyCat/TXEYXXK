<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>水果预定</title>
		<meta name="description" content="">
		<meta name="keywords" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="icon" type="image/png" href="assets/i/favicon.png">
		<link rel="stylesheet" href="${ctx }/resources/weixin/css/amazeui.min.css">
		<link rel="stylesheet" href="${ctx }/resources/weixin/css/app.css">
		<style> 
		.list-curr{ background: #fff; display: block; border-right: 0;}
		.gm-head-right{ color: #2b2a2a;}
		.gm-head-right a{ color: #2b2a2a;}
		.joan-head{ background: #fff;}
		.gm-head-search input{ border: 1px solid #599a3c;}
		.gm-head-left a, .gm-head-right a{ color: #599a3c;}
		</style>

	</head>
	<body class="gudin am-with-fixed-navbar" >
		<header data-am-widget="header" class="am-header am-header-default joan-head" style="z-index:999;position: fixed; top: 0; left: 0;border: 1px solid #ddd;">
			<div class="gm-head-left">
				<a href="#left-link" class=""><i class="am-icon-map-marker"></i>南昌</a>
			</div>
			<div class="gm-head-search">
				<a href="search.html">
					<input type="text" placeholder="寻找你喜欢的商品"><i class="am-icon-search"></i></a>
			</div>

			<div class="gm-head-right">
				<a href="login.html">登陆</a> /<a href="reg.html">注册</a>
			</div>
		</header>
		<div class="list-content">
			 <div class="list-left">
			 	 <li class="list-curr"><a href="" >全部商品</a></li>
			 	 <li><a href="">鲜果区</a></li>
			 	 <li><a href="">礼盒专区</a></li>
			 </div>
			 <div class="list-right">
			 	<ul class="list-menu">
			 		<li><a href="">默认排序 </a></li>
			 		<li><a href="">口碑值</a><i class="list-menu-arrow"></i></li>
			 		<li><a href="">价格</a><i class="list-menu-arrow"></i></li>
			 		<li><a href="">新品</a><i class="list-menu-arrow"></i></li>
			 		<li><a href="">收藏</a><i class="list-menu-arrow"></i></li>
			 	</ul>
			 	<ul><!--ul-->
			 		<li class="zm">
			 			<div class="zm-l">
			 				<div class="pro-img" ><img src="${ctx }/resources/weixin/images/p2.jpg"/></div>
			 				<div class="pro-con">
			 					<h2 class="pro-deta" data-id="{$val.id}">南丰蜜桔 </h2>
			 					<p class="pro-num" data-id="{$val.id}"> 12个装</p>
			 					<p><span>￥88</span><del>￥108</del></p>
			 				</div>
			 				
			 			</div>
			 			<div class="zm-r">
			 				<a class="zm-r-j">-</a>
			 				<a class="zm-r-num">0</a>
			 				<a class="zm-r-j">+</a>
			 			</div>
			 		</li>
			 		<li class="zm">
			 			<div class="zm-l">
			 				<div class="pro-img" ><img src="${ctx }/resources/weixin/images/p2.jpg"/></div>
			 				<div class="pro-con">
			 					<h2 class="pro-deta" >南丰蜜桔 </h2>
			 					<p class="pro-num"> 12个装</p>
			 					<p><span>￥88</span><del>￥108</del></p>
			 				</div>
			 				
			 			</div>
			 			<div class="zm-r">
			 				<a class="zm-r-j">-</a>
			 				<a class="zm-r-num">0</a>
			 				<a class="zm-r-j">+</a>
			 			</div>
			 		</li>
			 		<li class="zm">
			 			<div class="zm-l">
			 				<div class="pro-img" ><img src="${ctx }/resources/weixin/images/p2.jpg"/></div>
			 				<div class="pro-con">
			 					<h2 class="pro-deta" >南丰蜜桔 </h2>
			 					<p class="pro-num"> 12个装</p>
			 					<p><span>￥88</span><del>￥108</del></p>
			 				</div>
			 				
			 			</div>
			 			<div class="zm-r">
			 				<a class="zm-r-j">-</a>
			 				<a class="zm-r-num">0</a>
			 				<a class="zm-r-j">+</a>
			 			</div>
			 		</li>
			 		<li class="zm">
			 			<div class="zm-l">
			 				<div class="pro-img" ><img src="${ctx }/resources/weixin/images/p2.jpg"/></div>
			 				<div class="pro-con">
			 					<h2 class="pro-deta" >南丰蜜桔 </h2>
			 					<p class="pro-num"> 12个装</p>
			 					<p><span>￥88</span><del>￥108</del></p>
			 				</div>
			 				
			 			</div>
			 			<div class="zm-r">
			 				<a class="zm-r-j">-</a>
			 				<a class="zm-r-num">0</a>
			 				<a class="zm-r-j">+</a>
			 			</div>
			 		</li>
			 		<li class="zm">
			 			<div class="zm-l">
			 				<div class="pro-img" ><img src="${ctx }/resources/weixin/images/p2.jpg"/></div>
			 				<div class="pro-con">
			 					<h2 class="pro-deta" >南丰蜜桔 </h2>
			 					<p class="pro-num"> 12个装</p>
			 					<p><span>￥88</span><del>￥108</del></p>
			 				</div>
			 				
			 			</div>
			 			<div class="zm-r">
			 				<a class="zm-r-j">-</a>
			 				<a class="zm-r-num">0</a>
			 				<a class="zm-r-j">+</a>
			 			</div>
			 		</li>
			 		<li class="zm">
			 			<div class="zm-l">
			 				<div class="pro-img" ><img src="${ctx }/resources/weixin/images/p2.jpg"/></div>
			 				<div class="pro-con">
			 					<h2 class="pro-deta" >南丰蜜桔 </h2>
			 					<p class="pro-num"> 12个装</p>
			 					<p><span>￥88</span><del>￥108</del></p>
			 				</div>
			 				
			 			</div>
			 			<div class="zm-r">
			 				<a class="zm-r-j">-</a>
			 				<a class="zm-r-num">0</a>
			 				<a class="zm-r-j">+</a>
			 			</div>
			 		</li>
			 		<li style="height: 20px;"></li>
			 	</ul><!--ul-->
			 </div>
		</div>
		
  <div data-am-widget="navbar" class="am-navbar  am-navbar-default gm-foot"   id="">
      <ul class="am-navbar-nav am-cf am-avg-sm-4">
          <li >
            <a href="${ctx }/wfruitHomeController/gohome" class="">
                <span class="am-icon-home"></span>
                <span class="am-navbar-label">首页</span>
            </a>
          </li>
          <li>
            <a href="${ctx }/wfruitShopController/goshop" class="curr">
                <span class="am-icon-th-large"></span>
                <span class="am-navbar-label">商品</span>
            </a>
          </li>
          <li>
            <a href="${ctx }/wfruitShopCartController/gocart" class="">
                <span class="am-icon-shopping-cart"></span>
                <span class="am-navbar-label">购物车</span>
            </a>
          </li>
           <li >
            <a href="${ctx }/wfruitCustomerController/gocustomer" class="">
                <span class="am-icon-user"></span>
                <span class="am-navbar-label">个人中心</span>
            </a>
          </li>
          <li >
            <a href="${ctx }/wfruitTalkController/gotalk" class="">
                <span class="am-icon-file-text-o"></span>
                <span class="am-navbar-label">果友说</span>
            </a>
          </li>
      </ul>
  </div>

		<script src="${ctx }/resources/weixin/js/jquery.min.js"></script>
		<script src="${ctx }/resources/weixin/js/amazeui.min.js"></script>
<script type="text/javascript">
			$(function(){				
				$('.pro-deta').click(function(){
					 var id = $(this).data('id');
					 var $modal = $('.st-pop-'+id);
					 var pop_height = $('.st-slider-box-'+id).height();
//		 			 console.log(pop_height);
					 $('.st-pop-'+id+' .am-modal-bd').html($('.slide-'+id).html());
					 $modal.modal();					 
					 $('.st-slider-'+id).flexslider();
				})
				
				$('.pro-img').click(function(){
					 var id = $(this).data('id');
					 var $modal = $('.st-pop-'+id);
					 var pop_height = $('.st-slider-box-'+id).height();
//		 			 console.log(pop_height);
					 $('.st-pop-'+id+' .am-modal-bd').html($('.slide-'+id).html());
					 $modal.modal();					 
					 $('.st-slider-'+id).flexslider();
				})
</script>
	</body>

</html>