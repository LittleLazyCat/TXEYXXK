<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/27 0027
  Time: 上午 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>条形码</title>
    <link rel="stylesheet" type="text/css" href="css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/iconfont.min.css"/>
    <style>
        body {
            text-align: center
        }
    </style>
    <style>
        table {
            border-collapse: collapse;
        }

        table, td, th {
            border: 1px solid black;
        }
    </style>

</head>
<body>
<div class="panel panel-default mt-20" style="margin: 0 auto; width: 1000px;height: auto;">
    <div class="panel-header">条形码</div>
    <div class="panel-body" id="printArea">
        <table>
            <thead>
            </thead>
            <tbody>
            <tr>
                <c:forEach items="${code1}" var="li" varStatus="status">
                    <td>
                        <div style="margin-top: 20px;">
                            <div style="margin-left: 20px;"><img style="vertical-align:middle;"
                                                                 src="txmimages/${li.imageName}"/></div>
                            <div style="margin-left: 40px;margin-bottom: 20px; "><label>${li.codeNumber}</label></div>
                        </div>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <c:forEach items="${code2}" var="li" varStatus="status">
                    <td>
                        <div style="margin-top: 20px;">
                            <div style="margin-left: 20px;"><img style="vertical-align:middle;"
                                                                 src="txmimages/${li.imageName}"/></div>
                            <div style="margin-left: 40px; margin-bottom: 20px;"><label>${li.codeNumber}</label></div>
                        </div>
                    </td>
                </c:forEach>

            </tr>
            <tr>

                <c:forEach items="${code3}" var="li" varStatus="status">
                    <td>
                        <div style="margin-top: 20px;">
                            <div style="margin-left: 20px;"><img style="vertical-align:middle;"
                                                                 src="txmimages/${li.imageName}"/></div>
                            <div style="margin-left: 40px; margin-bottom: 20px;"><label>${li.codeNumber}</label></div>
                        </div>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <c:forEach items="${code4}" var="li" varStatus="status">
                    <td>
                        <div style="margin-top: 20px;">
                            <div style="margin-left: 20px;"><img style="vertical-align:middle;"
                                                                 src="txmimages/${li.imageName}"/></div>
                            <div style="margin-left: 40px; margin-bottom: 20px;"><label>${li.codeNumber}</label></div>
                        </div>
                    </td>
                </c:forEach>

            </tr>
            <tr>
                <c:forEach items="${code5}" var="li" varStatus="status">
                    <td>
                        <div style="margin-top: 20px;">
                            <div style="margin-left: 20px;"><img style="vertical-align:middle;"
                                                                 src="txmimages/${li.imageName}"/></div>
                            <div style="margin-left: 40px; margin-bottom: 20px;"><label>${li.codeNumber}</label></div>
                        </div>
                    </td>
                </c:forEach>
            </tr>

            </tbody>
        </table>

    </div>
</div>
<div id="toolbar"><input id="butn" type="button" class="btn btn-primary size-L radius" value="打印"
                         onclick="javascript:printit('printArea');"/></div>
</body>
<script language="javascript">
    //提示窗口
    function printit(MyDiv) {
        if (confirm('确定打印吗？')) {
            //var newstr = document.all.item(myDiv).innerHTML;
            var newstr = document.getElementById(MyDiv).innerHTML;
            //alert(newstr);
            var oldstr = document.body.innerHTML;
            document.body.innerHTML = newstr;
            window.print();
            document.body.innerHTML = oldstr;
            return false;
        }
    }
</script>
</html>
