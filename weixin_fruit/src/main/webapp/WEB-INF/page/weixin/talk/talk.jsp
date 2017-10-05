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
		<link rel="icon" type="image/png" href="${ctx }/resources/weixin/assets/i/favicon.png">
		<link rel="stylesheet" href="${ctx }/resources/weixin/css/amazeui.min.css">
		<link rel="stylesheet" href="${ctx }/resources/weixin/css/app.css">
	</head>
	<body>
	<header data-am-widget="header" class="am-header am-header-default gy-head">
      <div class="gy-head-search">
         <a href="search.html" ><input type="text" placeholder="输入你感兴趣的关键字搜索"><i class="am-icon-search"></i></a>
      </div>
     
  </header>
   <div class="gytalktit">大家都在说</div>
   <ul class="talk-all">
   	  <li>
   	  	<div class="talk-top">
   	  		<img src="${ctx }/resources/weixin/images/sc.jpg" />
   	  		<span>南丰蜜桔</span>
   	  	</div>
   	  	<p class="talk-com"><img src="images/talk.jpg" width="25" height="26"/>赵小姐 说：</p>
   	  	<p class="talk-text">这个南丰蜜桔是我吃最好的”</p>
   	  	<p  class="talk-text">2015-09-10 11：15</p>
   	  </li>
   	  <li>
   	  	<div class="talk-top">
   	  		<img src="${ctx }/resources/weixin/images/sc.jpg" />
   	  		<span>南丰蜜桔</span>
   	  	</div>
   	  	<p class="talk-com"><img src="images/talk.jpg" width="25" height="26"/>赵小姐 说：</p>
   	  	<p class="talk-text">这个南丰蜜桔是我吃最好的”</p>
   	  	<p  class="talk-text">2015-09-10 11：15</p>
   	  </li>
   </ul>
    <div class="gytalktit">水果控有话说</div>
    <ul class="talk-list" >
    	<li>
    		<a href="${ctx}/wfruitTalkController/gocontent">
    			<img src="images/sc.jpg" class="talk-pic" />
    			<h3  class="talk-list-tit">教你怎么识别正宗南丰蜜桔</h3>
    			<p class="talk-list-text">1、看：很多假南丰蜜桔经过催红打
蜡，油光发亮。一般自然蜜然........</p>
    		</a>
    	</li>
    	<li>
    		<a href="">
    			<img src="images/sc.jpg" class="talk-pic" />
    			<h3  class="talk-list-tit">南丰蜜桔皮的神奇妙用</h3>
    			<p class="talk-list-text">桔子皮本身是个好东西，是一味中药
，民间也常用作调味品。理.........</p>
    		</a>
    	</li>
    </ul>
   
  
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
