<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>个人信息</title>


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Hotel Info Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>


    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" media="all">
    <link href="<%=request.getContextPath()%>/css/font-awesome.css" rel="stylesheet">


    <link href="//fonts.googleapis.com/css?family=Play:400,700&amp;subset=cyrillic,cyrillic-ext,greek,latin-ext"
          rel="stylesheet">


<body>

<div class="agileheader">
    <h1>用户信息修改</h1>
</div>


<div class="main-w3l">

    <div class="banner-right-agile">
        <div class="banner-text">
            <h3>个人信息</h3>
            <form action="updateEmp.html" method="post">
                <h3>编号：<label name="ygbh" property="ygbh">${ygbh}</label></h3>
                <h3>姓名：<label id="ygxm" name="ygxm" property="ygxm">${ygxm}</label></h3>
                <h3>科室：<label id="ksmc" name="ksmc" property="ksmc">${ksmc}</label></h3>


                <input type="text" placeholder="手机长号" name="sjch" property="sjch" value="${sjch}"/>


                <input type="text" placeholder="虚拟网" name="xnw" property="xnw" value="${xnw}"/>


                <input type="hidden" name="ygbh" property="ygbh" value="${ygbh}"/>

                <input type="submit" value="确认提交">
            </form>
        </div>
    </div>
    <div class="clear"></div>
</div>


<div class="footer-w3l">
    <p>&copy; 2017 User Info Form. All rights reserved | Design by Alex Jones</p>
</div>


</body>
</html>