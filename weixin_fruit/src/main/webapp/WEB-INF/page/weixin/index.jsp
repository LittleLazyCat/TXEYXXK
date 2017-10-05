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

  <link rel="icon" type="image/png" href="${ctx }/resources/weixin/assets/i/favicon.png">
  <link rel="stylesheet" href="${ctx }/resources/weixin/css/amazeui.min.css">
  <link rel="stylesheet" href="${ctx }/resources/weixin/css/app.css">

</head>
<body >

   <header data-am-widget="header" class="am-header am-header-default joan-head">
      <div class="gm-head-left">
          <a href="#left-link" class=""><i class="am-icon-map-marker"></i>南昌</a>
      </div>
      <div class="gm-head-search">
         <a href="search.html" ><input type="text" placeholder="寻找你喜欢的商品"><i class="am-icon-search"></i></a>
      </div>
 
      <div class="gm-head-right">
         <a href="${ctx }/wfruitLoginController/login" >登陆</a>  /<a href="${ctx }/wfruitRegisterController/reg" >注册</a>
      </div>
  </header>
 
  
  

 

<div data-am-widget="slider" class="am-slider am-slider-b2" data-am-slider='{"controlNav":false}'>
  <ul class="am-slides">
    <li>
      <img src="${ctx }/resources/weixin/images/ban1.png">
    </li>
    <li>
      <img src="${ctx }/resources/weixin/images/ban2.jpg">
    </li>
     
    
  </ul>
</div>

 
<div class="case-nav">
<ul>
  <li>
    <div class="am-gallery-item">
      <a href="shop.html" class="case-nav-p">
        <img src="${ctx }/resources/weixin/images/icon1.png">
        <p>全部商品</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="shop.html" class="case-nav-p">
        <img src="${ctx }/resources/weixin/images/icon2.png">
        <p>鲜果区</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="gift.html" class="case-nav-p">
        <img src="${ctx }/resources/weixin/images/icon3.png">
        <p>礼品区</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="#" class="case-nav-p">
        <img src="${ctx }/resources/weixin/images/icon4.png">
        <p>品牌故事</p>
      </a>
    </div>
  </li>
     <li>
    <div class="am-gallery-item">
      <a href="brand.html" class="case-nav-p">
        <img src="${ctx }/resources/weixin/images/icon1.png">
        <p>品质溯源</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="project.html" class="case-nav-p">
        <img src="${ctx }/resources/weixin/images/icon2.png">
        <p>企业采购</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="#" class="case-nav-p">
        <img src="${ctx }/resources/weixin/images/icon3.png">
        <p>物流售后</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="#" class="case-nav-p">
        <img src="${ctx }/resources/weixin/images/icon4.png">
        <p>免费试吃</p>
      </a>
    </div>
  </li>
   
</ul>
</div>



<div class="active-main">
	<ul>
    	<li><a href="#"><img src="${ctx }/resources/weixin/images/act1.jpg"></a></li>
    	<li><a href="#"><img src="${ctx }/resources/weixin/images/act2.jpg"></a></li>
    	<li><a href="#"><img src="${ctx }/resources/weixin/images/act3.jpg"></a></li>
    </ul>

</div>


<div class="product">
<c:forEach items="${data }" var="d">
  <ul class="am-gallery am-avg-sm-2 am-avg-md-2 am-avg-lg-4 am-gallery-default" >
  	<h2><span></span>${d.name }</h2>
  <c:forEach items="${d.goods }" var="g">
	      <li>
	        <div class="am-gallery-item">
	            <a href="${ctx }/wfruitContentController/weixinContent?id=${g.id}" class="">
	              <img  src="${ctx }/goods_img/${g.TITLE_IMG }" /> 
	                <div class="am-gallery-desc">
	                	<div class="pro-tit">
	                    	<h3>${g.title }</h3>
	                        <p>12个装</p>
	                    </div>
	                    
	                    <div class="pro-price">
	                    	￥88<del>￥108</del>
	                    </div>
	                
	                </div>
	            </a>
	        </div>
	      </li>
      </c:forEach>
  </ul>
</c:forEach>


  <ul class="am-gallery am-avg-sm-2 am-avg-md-2 am-avg-lg-4 am-gallery-default" >
  	<h2><span></span>礼盒专区</h2>
  
      <li>
        <div class="am-gallery-item">
            <a href="content.html" class="">
              <img src="${ctx }/resources/weixin/images/g1.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a href= "content.html" class="">
              <img src="${ctx }/resources/weixin/images/g1.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a href="content.html" class="">
              <img src="${ctx }/resources/weixin/images/g1.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a href= "content.html" class="">
              <img src="${ctx }/resources/weixin/images/g1.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
  </ul>
 </div>


 

 

 
  <div data-am-widget="navbar" class="am-navbar  am-navbar-default gm-foot"   id="">
      <ul class="am-navbar-nav am-cf am-avg-sm-4">
          <li >
            <a href="${ctx }/wfruitHomeController/gohome" class="curr">
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
