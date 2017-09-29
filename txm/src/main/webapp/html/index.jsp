<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/27 0027
  Time: 上午 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>条形码生成工具</title>
    <link rel="stylesheet" type="text/css" href="css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/iconfont.min.css"/>

</head>
<script>
    function doSub() {
        var val = document.getElementById("uuid").value;
        if (val == "" || val == undefined || val == null) {
            alert('非法！请输入标识号！');
            return false;
        } else {
            return true;
        }
    }
</script>
<body>
<div class="container ui-sortable">
    <div class="panel panel-default">
        <div class="panel-header">条形码生成</div>
        <div class="panel-body">


            <form method="post" action="/generate" class="form form-horizontal responsive" onsubmit="return doSub()">
                <div class="row cl">
                    <label class="form-label col-xs-3">标识号：</label>
                    <div class="formControls col-xs-8">
                        <input type="text" class="input-text" placeholder="请输入起始标识号" name="uuid" id="uuid"
                               autocomplete="off">
                    </div>
                </div>

                <br/><br/>
                <br/><br/>
                <div class="row cl">
                    <div class="col-xs-8 col-xs-offset-3">
                        <input class="btn btn-primary size-L radius" type="submit" value="&nbsp;&nbsp;生成&nbsp;&nbsp;">
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="btn btn-primary size-L radius" type="reset" value="&nbsp;&nbsp;重置&nbsp;&nbsp;">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
