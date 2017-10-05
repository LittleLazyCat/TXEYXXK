<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>水果预定</title>
    <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />

  <link rel="icon" type="image/png" href="${ctx }/resources/weixin/assets/i/favicon.png">
  <link rel="stylesheet" href="${ctx }/resources/weixin/css/amazeui.min.css">
  <link rel="stylesheet" href="${ctx }/resources/weixin/css/app.css">
  
  	
 <style> .am-direction-nav{ display: none;}</style>
	</head>
	<body style=" background: #fff;">
<div class="am-slider am-slider-default" data-am-flexslider id="demo-slider-0" style="border-bottom: 1px solid #b6b6b6;">
  <ul class="am-slides">
    <li><img src="${ctx }/goods_img/${goods.titleImg }"/></li>
    <li><img src="${ctx }/category_img/${category.imgurl }" /></li>
  </ul>
  <div class="am-header-left am-header-nav return">

		<a href="javascript:history.back()" class="return-fir">
			<i class="am-icon-chevron-left"></i>
		</a>
		<a href="javascript:;" class="share"></a>
		<a href="" class="xin"></a>
  </div>
  <div class="share-con">
  	<a href="" class="friend"></a>
  	<a href="" class="zone"></a>
  	<a href="" class="weixin"></a>
  	<a href="" class="qq"></a>
  	<a href="" class="sina"></a>
  </div>
 
</div>

<div class="content">
	<div class="title">南丰贡桔</div>
	<div class="con">
	  <div class="price">￥<span>88</span></div>
	  <div class="p-pur">
        <a class="decrease">-</a>
        <em class="sy_num">0</em>
        <a class="increase">+</a>   
      </div>
	</div>
</div>
<div class="con-num">
	<span class="con-num-l">规格</span>
	<span class="con-num-r">12个装</span>
</div>
<a class="con-num" href="procomment.html">
	<span class="con-num-l">商品评价</span>
	<i class="am-icon-angle-right" style=" float:right; color: #b4b4b4;"></i>
	<span class="con-num-m">
		<p style="color: #b4b4b4;">97%的果友给了</p>
		<p style=" margin-top: 1px;">
			<img src="${ctx }/resources/weixin/images/start.png"/>
			<img src="${ctx }/resources/weixin/images/start.png"/>
			<img src="${ctx }/resources/weixin/images/start.png"/>
			<img src="${ctx }/resources/weixin/images/start.png"/>
			<img src="${ctx }/resources/weixin/images/start.png"/>
		</p>
	</span>
</a>
<div class="con-relative">
	<div class="title">购买该产品的果友也买了</div>
	<ul class="am-gallery am-avg-sm-3 am-avg-md-3 am-avg-lg-3 am-gallery-default ">
		<li>
			<a href="">
				<img src="${ctx }/resources/weixin/images/p1.jpg">
				<div class="am-gallery-desc">
                	<p class="tit">南丰贡桔<span>12个装</span></p>
                	<p class="yanse">￥<span>88</span></p>
                </div>
			</a>
		</li>
		<li>
			<a href="">
				<img src="${ctx }/resources/weixin/images/p1.jpg">
				<div class="am-gallery-desc">
                	<p class="tit">南丰贡桔<span>12个装</span></p>
                	<p class="yanse">￥<span>88</span></p>
                </div>
			</a>
		</li>
		<li>
			<a href="">
				<img src="${ctx }/resources/weixin/images/p1.jpg">
				<div class="am-gallery-desc">
                	<p class="tit">南丰贡桔<span>12个装</span></p>
                	<p class="yanse">￥<span>88</span></p>
                </div>
			</a>
		</li>

	</ul>
</div>

<div class="con-moretit"><img src="${ctx }/resources/weixin/images/tit.png"></div>
<div class="con-pic"><img src="${ctx }/resources/weixin/images/test.jpg"></div>
<div class="con-pic"><img src="${ctx }/resources/weixin/images/test2.jpg"></div>

<div class="shop-cart">
  <span><i class="am-icon-shopping-cart am-icon-sm"></i><p class="nums">1</p></span> 
 <a href="${ctx }/wfruitShopCartController/gocart">加入购物车</a>        
 </div>




  <div data-am-widget="navbar" class="am-navbar  am-navbar-default gm-foot"   id="">
      <ul class="am-navbar-nav am-cf am-avg-sm-4">
          <li >
            <a href="index.html" class="curr">
                <span class="am-icon-home"></span>
                <span class="am-navbar-label">首页</span>
            </a>
          </li>
          <li>
            <a href="shop.html" class="">
                <span class="am-icon-th-large"></span>
                <span class="am-navbar-label">商品</span>
            </a>
          </li>
          <li >
            <a href="member.html" class="">
                <span class="am-icon-user"></span>
                <span class="am-navbar-label">个人中心</span>
            </a>
          </li>
          <li>
            <a href="shopcar.html" class="">
                <span class="am-icon-shopping-cart"></span>
                <span class="am-navbar-label">购物车</span>
            </a>
          </li>
          <li >
            <a href="talk.html" class="">
                <span class="am-icon-file-text-o"></span>
                <span class="am-navbar-label">果友说</span>
            </a>
          </li>
      </ul>
  </div>

<script src="${ctx }/resources/weixin/js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="${ctx }/resources/weixin/js/jquery.min.js"></script>
<script src="${ctx }/resources/weixin/js/amazeui.min.js"></script>
		<script>
			$(function(){
        		$(".share").click(function(){
        			$(".share-con").fadeToggle()
        		})
        	})

		</script>

	</body>
</html>
