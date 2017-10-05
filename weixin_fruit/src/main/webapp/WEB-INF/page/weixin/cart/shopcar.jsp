<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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
	</head>
	<body style="background: #fff;">
<header data-am-widget="header" class="am-header am-header-default joan-head2 ">
			<div class="am-header-left am-header-nav">
				<a href="javascript:history.back()" class="">
					<i class="am-icon-chevron-left"></i>
				</a>
			</div>
			<h1 class="am-header-title">
  	            <a href="" class="">购物车</a>
            </h1>
            <div class="am-header-right am-header-nav">
       <a href="" class="">
            <i class="am-header-icon am-icon-del"></i>
        </a>
    </div>
</header>

<div class="shopcartit">已购商品</div>
<div class="c-comment-list" style="border: 0;">
			<div class="o-con2" >
            	<div class="o-con-img"><img src="${ctx }/resources/weixin/images/sc.jpg"/></div>
                <div class="o-con-txt2">
                	<p>南丰蜜桔 南丰贡桔</p>
                	<p style="color: #afafaf;">12个装</p>
                	 <div class="con">
	                    <div class="price">￥<span>88</span></div>
	                    <div class="p-pur">
                           <a class="decrease">-</a>
                           <em class="sy_num">0</em>
                           <a class="increase">+</a>   
                        </div>
	                 </div>
                </div>
            </div>
            <div class="o-con2" >
            	<div class="o-con-img"><img src="${ctx }/resources/weixin/images/sc.jpg"/></div>
                <div class="o-con-txt2">
                	<p>南丰蜜桔 南丰贡桔</p>
                	<p style="color: #afafaf;">12个装</p>
                	 <div class="con">
	                    <div class="price">￥<span>88</span></div>
	                    <div class="p-pur">
                           <a class="decrease">-</a>
                           <em class="sy_num">0</em>
                           <a class="increase">+</a>   
                        </div>
	                 </div>
                </div>
            </div>
            <div class="o-con2" >
            	<div class="o-con-img"><img src="${ctx }/resources/weixin/images/sc.jpg"/></div>
                <div class="o-con-txt2">
                	<p>南丰蜜桔 南丰贡桔</p>
                	<p style="color: #afafaf;">12个装</p>
                	 <div class="con">
	                    <div class="price">￥<span>88</span></div>
	                    <div class="p-pur">
                           <a class="decrease">-</a>
                           <em class="sy_num">0</em>
                           <a class="increase">+</a>   
                        </div>
	                 </div>
                </div>
            </div>
            <div class="o-con2" >
            	<div class="o-con-img"><img src="images/sc.jpg"/></div>
                <div class="o-con-txt2">
                	<p>南丰蜜桔 南丰贡桔</p>
                	<p style="color: #afafaf;">12个装</p>
                	 <div class="con">
	                    <div class="price">￥<span>88</span></div>
	                    <div class="p-pur">
                           <a class="decrease">-</a>
                           <em class="sy_num">0</em>
                           <a class="increase">+</a>   
                        </div>
	                 </div>
                </div>
            </div>
            
</div>
<div class="shaopprice">
	<em>￥ <span>264</span></em>
	<a href="${ctx }/wfruitOrderController/weixinOrder">立即结算</a>
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
            <a href="${ctx }/wfruitShopController/goshop" class="">
                <span class="am-icon-th-large"></span>
                <span class="am-navbar-label">商品</span>
            </a>
          </li>
          <li>
            <a href="${ctx }/wfruitShopCartController/gocart" class="curr">
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
	</body>
</html>
