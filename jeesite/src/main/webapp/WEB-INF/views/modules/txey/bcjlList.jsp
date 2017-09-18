<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>病程记录</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {

        });

        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/oa/oaNotify/${oaNotify.self?'self':''}">病程记录</a></li>
</ul>
<form:form id="searchForm" modelAttribute="Bcjl" action="${ctx}/txey/stats/bcjl" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>病案号：</label>
            <input id="bah" name="bah" type="text" maxlength="20" class="input-medium"
                   value="${paramMap.bah}"/>
        </li>

        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>

    </ul>
</form:form>

<table id="contentTable" class="table table-striped table-bordered table-condensed">

    <c:forEach items="${list}" var="bcjl">
    <tr>

    </tr>
        <tr>
            <td>${bcjl.jlsj}

            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <c:choose>
                    <c:when test="${bcjl.typeid ='0'}">
                        <label>首次病程记录</label>
                    </c:when>
                    <c:when test="${bcjl.typeid = '2'}">
                        <label>日常病程记录</label>
                    </c:when>
                    <c:when test="${bcjl.typeid = '24'}">
                        <label>副主任医师代主治医师查房记录</label>
                    </c:when>
                    <c:otherwise>
                        <label>日常病程记录</label>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td>
                    ${bcjl.jlnr}
            </td>
        </tr>
        <tr>
            <td align="right">
                <label>记录医生：    </label>   <label>${bcjl.dname}</label>
            </td>
        </tr>

    </tr>

        </c:forEach>
</table>
<div class="pagination">${page}</div>
</body>
</html>