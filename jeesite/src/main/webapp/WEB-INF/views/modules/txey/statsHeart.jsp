<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>收费统计</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function autoRowSpan(tb,row,col){
	        var lastValue="",value="",pos=1;  
	        for(var i=row;i<tb.rows.length;i++){
	            value = tb.rows[i].cells[col].innerText;  
	            if(lastValue == value){
	                tb.rows[i].deleteCell(col); 
	                tb.rows[i-pos].cells[col].rowSpan = tb.rows[i-pos].cells[col].rowSpan+1;
	                pos++;
	            }else{
	                lastValue = value;
	                pos=1;
	            }
	        }
	    }
		$(document).ready(function(){
			autoRowSpan(contentTable,0,0);
	        $("td,th").css({"text-align":"center","vertical-align":"middle"});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/txey/stats/heart">收费统计</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="heart" action="${ctx}/txey/stats/heart" method="post" class="breadcrumb form-search">
		<div>
			<label>开始日期：</label><input id="beginDate" name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
				value="${paramMap.beginDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			<label>结束日期：</label><input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
				value="${paramMap.endDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>&nbsp;&nbsp;
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
		</div>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>收费日期</th><th>费用名称</th><th>单价</th><th>数量</th><th>合计金额</th></tr></thead>
		<tbody>
		<c:forEach items="${list}" var="stats">
			<tr>
				<td>${stats.sfrq}</td>
				<td>${stats.fymc}</td>
				<td>${stats.yldj}</td>
				<td>${stats.ylsl}</td>
				<td>${stats.hjje}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>