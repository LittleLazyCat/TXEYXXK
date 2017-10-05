<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>国贸城</title>
    <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />

  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="stylesheet" href="${ctx }/resources/weixin/css/amazeui.min.css">
  <link rel="stylesheet" href="${ctx }/resources/weixin/css/app.css">

</head>
<body >

   <header data-am-widget="header" class="am-header am-header-default joan-head2 ">
       <div class="am-header-left am-header-nav">
        <a href="javascript:history.back()" class="">
            <i class="am-icon-chevron-left"></i>
        </a>
        </div>
    
        <h1 class="am-header-title">
            <a href="#title-link" class="">注册</a>
        </h1>
    
        <div class="am-header-right am-header-nav">
            
           <a href="index.html" class="">
                <i class="am-header-icon am-icon-home"></i>
            </a>
        </div>
  </header>

 


 
 
<div class="login">
        <form method="post" action=" ">
            <ul class="login-ul reg-ul">
                <li class="login-li">
                 	<span>手机号码</span>
                    <input name="username" placeholder="手机" class=" " type="tel">
                    <i class="am-icon-mobile"></i>
                 
                </li>
                <li class="login-li">
                 	<span>登录密码</span>
                    <input name="password" placeholder="密码" class=" " type="password">
                 	<i class="am-icon-unlock-alt"></i>
                </li>
                <li class="login-li">
                 	<span>再次输入密码</span>
                    <input name="password" placeholder="密码" class=" " type="password">
                 	<i class="am-icon-unlock-alt"></i>
                </li>
                
                <li class="login-li">
                 	<span>手机验证码</span>
                    <input name="yzm" placeholder="验证码" class="yzm-input" type="text">
                 	 <button class="am-btn am-btn-warning">获取验证码</button>
                </li>
            </ul>
        </form>
        
        
        <div class="login-btn">
        	<a href="reg.html" class="am-btn am-btn-warning am-round mt20">注册</a> 
        </div>
         


 </div>
   
  
  
   

 
  
   	
     


<script src="${ctx }/resources/weixin/js/jquery.min.js"></script>
<script src="${ctx }/resources/weixin/js/amazeui.min.js"></script>

</body>
</html>
