<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>国贸城</title>
		<meta name="description" content="">
		<meta name="keywords" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="icon" type="image/png" href="${ctx }/resources/weixin/assets/i/favicon.png">
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
  	<a href="" class="">水果控有话说</a>
  </h1>
</header>
  
    <div class="talk-list" style="padding-top: 1rem;">
    		<a href="">
    			<img src="images/sc.jpg" class="talk-pic" />
    			<h3  class="talk-list-tit">教你怎么识别正宗南丰蜜桔</h3>
    			<p class="talk-list-text">发布时间：2015-9-29</p>
    		</a>
    </div>
    <div class="talk-list-con">
    	<p>1、看：很多假南丰蜜桔经过催红打蜡，油光发亮。一
般自然生长的南丰蜜桔表皮自然，很少有油光发亮。而
且桔子表皮多少会有自然生长产生的少数疤点。</p>
<p>2、闻：拿一个桔子用手轻轻一挤，放在鼻子下闻一闻
，假的南丰蜜桔有刺鼻的气味；南丰蜜桔（南丰贡桔)
近闻有桔香却不刺鼻。</p>
<p>3、吃：皮薄、脉不粘瓣、汁多少渣、味甜而不酸，酸
甜适口，而且有股桔香味，这是南丰蜜桔特有的，少
核。（正宗蜜桔10只有3--5只有核）。</p>
<p>4、烧：南丰蜜桔桔皮挤压后喷出的雾状气体遇火即燃。</p>
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
            <a href="${ctx }/wfruitTalkController/gotalk" class="curr">
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
