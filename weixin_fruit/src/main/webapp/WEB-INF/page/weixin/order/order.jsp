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
  	<link rel="stylesheet" href="${ctx }/resources/weixin/css/check.css" />
	</head>
	<body>
		<header data-am-widget="header" class="am-header am-header-default joan-head2 ">
	<div class="am-header-left am-header-nav">
		<a href="javascript:history.back()" class="">
			<i class="am-icon-chevron-left"></i>
		</a>
	</div>
	<h1 class="am-header-title">
  	<a href="" class="">订单信息</a>
  </h1>
</header>
    <div class="order-infor">收货人信息 </div>
    <div class="order-infor">
    	<div class="order-infpr-left">
    	<span>李女士  &nbsp;&nbsp; 18307032222</span>
    	<p>江西省南昌南昌 南昌南昌南昌 </p>
    	<p></p>
    	<a href="">增加新地址</a>
    	</div>
    	<i class="am-icon-angle-right" style=" float:right; color: #b4b4b4; margin-top: 20px;"></i>
    </div>
    <div class="order-pay">
    	<li>
    		<span class="pay-sty">支付方式<i>*</i></span>
    		<i class="am-icon-angle-right" style=" float:right; color: #333; "></i>
    		<span class="weixinpay"><img src="${ctx }/resources/weixin/images/weixinpay.png" width="28" height="24"/>微信支付</span>
    	</li>
    	<li>
    		<span class="pay-sty">优惠劵</span>
    		<i class="am-icon-angle-right" style=" float:right; color: #333; "></i>
    		<span class="weixinpay">请选择优惠劵 </span>
    	</li>
    	<li style="border: 0;">
    		<span class="pay-sty">积分抵扣（最多0元）</span>
    		<span class="weixinpay">
    		 <section class="model-10">
			  <div class="checkbox">
			    <input type="checkbox"/>
			    <label></label>
			  </div>
    		 </section>
    		</span>
    	</li>
    </div>
    
    <div class="c-comment-list" style="margin: 1rem 0; border-top: 1px solid #ddd;">
			<a class="o-con" href="">
            	<div class="o-con-img"><img src="${ctx }/resources/weixin/images/sc.jpg"/></div>
                <div class="o-con-txt" style="padding-top: 0;"><p>南丰蜜桔 南丰贡桔</p><p style="color: #afafaf;">12个装</p></div>
            	<div class="o-con-much"> <h4>x2</h4></div>
            	<div class="agoprice" style="margin-left: 2%;">￥<span>88</span></div>
            </a>
	</div>
    
     <div class="order-pay">
    	<li>
    		<span class="pay-sty" >商品总价</span>
    		<span class="weixinpay" style="color: #ff992e;">￥40.00</span>
    	</li>
    	<li>
    		<span class="pay-sty">运费</span>
    		<span class="weixinpay"  style="color: #ff992e;">￥10.00 </span>
    	</li>
    	<li>
    		<span class="pay-sty">积分抵扣</span>
    		<span class="weixinpay">￥0.00</span>
    	</li>
    	<li style="border: 0;">
    		<span class="pay-sty">优惠劵抵扣</span>
    		<span class="weixinpay">￥0.00</span>
    	</li>
    </div>
    
    <div class="order-pay">
    	<li style="border: 0;">
    		<span class="pay-sty">发票</span>
    		<span class="weixinpay">
    		 <section class="model-10">
			  <div class="checkbox">
			    <input type="checkbox"/>
			    <label></label>
			  </div>
    		 </section>
    		</span>
    	</li>
    </div>
    <div class="order-message">订单留言</div>
   <div class="shaopprice">
	<em>￥ <span>264</span></em>
	<a href="">提交订单</a>
</div>
	</body>
</html>
