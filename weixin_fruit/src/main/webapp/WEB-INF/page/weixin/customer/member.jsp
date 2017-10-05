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

	<body>
		<div class="user-head">
			<div class="user-head-con">
				<a href="">
					<div class="user-head-img">
						<img src="${ctx }/resources/weixin/images/default.png">
						<i class="am-icon-chevron-right"></i>
						<div class="user-dengji"><img src="${ctx }/resources/weixin/images/v0.png" /></div>
					</div>

				</a>

			</div>
			<div class="user-contact">183****1020</div>
			<ul class="user-list">
				<li>
					<a href="">
						<p>积分</p><em>0</em></a>
				</li>
				<li>
					<a href="">
						<p>余额</p><em>￥0.00</em></a>
				</li>
				<li>
					<a href="">
						<p>优惠劵</p><em>0</em></a>
				</li>
			</ul>
		</div>
		<div class="user-quick">
			<ul>
				<li>
					<div class="am-gallery-item">
						<a href="myorder.html" class="user-quick-p">
							<img src="${ctx }/resources/weixin/images/u-icon1.png">
							<p>我的订单</p>
						</a>
					</div>
				</li>
				<li>
					<div class="am-gallery-item">
						<a href="" class="user-quick-p">
							<img src="${ctx }/resources/weixin/images/u-icon2.png">
							<p>待评价</p>
						</a>
					</div>
				</li>
				<li>
					<div class="am-gallery-item">
						<a href="memberlevel.html" class="user-quick-p">
							<img src="${ctx }/resources/weixin/images/u-icon3.png">
							<p>会员等级</p>
						</a>
					</div>
				</li>

				<li>
					<div class="am-gallery-item">
						<a href="mygift.html" class="user-quick-p">
							<img src="${ctx }/resources/weixin/images/u-icon4.png">
							<p>我的赠品</p>
						</a>
					</div>
				</li>

				<li>

					<div class="am-gallery-item">
						<a href="" class="user-quick-p">
							<img src="${ctx }/resources/weixin/images/u-icon5.png">
							<p>我的特权</p>
						</a>
					</div>
				</li>
				<li>
					<div class="am-gallery-item">
						<a href="myeat.html" class="user-quick-p">
							<img src="${ctx }/resources/weixin/images/u-icon6.png">
							<p>我的试吃</p>
						</a>
					</div>
				</li>
			</ul>
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
            <a href="${ctx }/wfruitCustomerController/gocustomer" class="curr">
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