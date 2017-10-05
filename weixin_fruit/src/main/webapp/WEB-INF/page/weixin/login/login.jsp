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
            <a href="#title-link" class="">登录</a>
        </h1>
    
        <div class="am-header-right am-header-nav">
            
           <a href="index.html" class="">
                <i class="am-header-icon am-icon-home"></i>
            </a>
        </div>
  </header>

 


 
 
<div class="login">
        <form method="post" action=" ">
            <ul class="login-ul">
                <li class="login-li">
                 
                    <input name="username" placeholder="手机" class="login-input-phone" type="tel">
                    <i class="am-icon-user"></i>
                 
                </li>
                <li class="login-li">
                 
                    <input name="password" placeholder="密码" class="login-input-password" type="password">
                 	<i class="am-icon-unlock-alt"></i>
                </li>
            </ul>
        </form>
        
        
        <div class="login-btn">
        	<a href="login.html" class="am-btn am-btn-warning am-round mb20">登陆</a>
        	<a href="reg.html" class="am-btn am-btn-default am-round login-other-btn">注册</a>
        </div>
         


 </div>
   
  
  
   

 
  
   	
     


<script src="${ctx }/resources/weixin/js/jquery.min.js"></script>
<script src="${ctx }/resources/weixin/js/amazeui.min.js"></script>

</body>
</html>
