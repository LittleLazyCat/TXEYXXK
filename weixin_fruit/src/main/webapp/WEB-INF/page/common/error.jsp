<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0" />
<title>不要给我搞事情</title>
<style type="text/css">
<!--
/*error_404*/
*{ margin:0; padding:0;}
.error_404{ width:100%; }
.error_404 img{width:100%;margin:0;padding:0;border:none;position:relative;}
.return_home{width:100%; height:100%;background-size:contain;position:absolute;top:0;left:0;}
.return_home a{display:block;width:100%;height:100%;}

/*error_404 end*/
-->
</style>
</head>
<body>
<div class="error_404">
	<img src="${ctx }/resources/images/error_404.jpg"/>
	<div class="return_home"><a href="${url }"><!--返回首页--></a></div>
</div>
    
</body>
</html>