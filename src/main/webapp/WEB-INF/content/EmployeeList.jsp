<!--
@author liang.wang@footmarktech.com
@version 1.1.0
@date 2009/08/18
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/common/meta.jsp"%>
<link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
<link href="<s:url value='/js/prompt/skin/dmm-green/ymPrompt.css'/>" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<s:url value='/js/jquery/jquery-1.3.2.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/prompt/ymPrompt.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/prompt/jquery_ymPrompt.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/DatePicker/DatePicker.js'/>"></script>
<title>查询雇员</title>
</head>
<body>

<s:url var="url" action="EmployeeEdit"/>
<a href="javascript:void(0)" href1="<s:property value='url'/>" class="ymPrompt" title="新增雇员">新增雇员</a>


<!-- 查询条件~begin -->



<s:form  namespace="/" action="EmployeeList" method="POST" id="queryForm">
<table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#E2E2E2">
<tr class="tr1">
<td colspan="10">雇员查询</td>
</tr>
  <tr class="tab">
    <td class="td1">名字：</td><td><s:textfield  name="queryBean.name"></s:textfield></td>
    <td class="td1">年龄：</td><td><s:textfield  name="queryBean.age"></s:textfield></td>
    <td class="td1">日期：</td><td><s:textfield  name="queryBean.beginOpDate" id="calendar_DatePicker0"></s:textfield>
    <a href="javascript:calendar_DatePicker0.toggle(document.getElementById('calendar_DatePicker0'));"><img src="images/datepicker_icon.png" border="0"></img></a>
    </td>
 </tr>
  <tr class="tab">
    <td colspan="10">
    <s:submit cssClass="button" value="查询" method="doQuery" 			id="doQuery"></s:submit>
    <div style="display:none">
    <s:submit cssClass="button" value="刪除" method="doDelete" 			id="doDelete"></s:submit>
    <s:submit cssClass="button" value="分页" method="doPage" 			id="doPage"></s:submit>
    <s:submit cssClass="button" value="排序" method="doSortColumn" 		id="doSortColumn"></s:submit>
    </div>
    </td>
  </tr>
</table>

<div style="display:none">
<br/>initialPageNo:<s:textfield  name="queryParam.pageBean.initialPageNo" id="initialPageNo"></s:textfield>
<br/>initialPageSize:<s:textfield  name="queryParam.pageBean.initialPageSize" id="initialPageSize"></s:textfield>
<br/>initialSortColumn:<s:textfield  name="queryParam.pageBean.initialSortColumn" id="initialSortColumn"></s:textfield>
<br/>initialSortOrder:<s:textfield  name="queryParam.pageBean.initialSortOrder" id="initialSortOrder"></s:textfield>
<br/>pageNo:<s:textfield  name="queryParam.pageBean.pageNo" id="pageNo"></s:textfield>
<br/>pageSize:<s:textfield  name="queryParam.pageBean.pageSize" id="pageSize"></s:textfield>
<br/>sortColumn:<s:textfield  name="queryParam.pageBean.sortColumn" id="sortColumn"></s:textfield>
<br/>sortOrder:<s:textfield  name="queryParam.pageBean.sortOrder" id="sortOrder"></s:textfield>	
<br/>pagesDisplayed:<s:textfield  name="queryParam.pageBean.pagesDisplayed" id="pagesDisplayed"></s:textfield>
<br/>deleteIds:<s:textfield  name="queryParam.deleteIds" id="deleteIds"></s:textfield>
<br/>queryBeanJson:<s:textfield  name="queryParam.queryBeanJson" id="queryBeanJson"></s:textfield>
</div>

</s:form>
<!-- 查询条件~~end -->



<br/>

<s:if test="message!=null"><div class="message"><s:text name="message"/></div></s:if>

<br/>


<s:if test="queryParam.query">
	<s:if test="!queryResult.empty">
	<!-- 分页导航~begin -->
	<div class="pageContent">
		<s:set name="rowCount" value="queryResult.rowCount"/>
		<s:set name="pageCount" value="queryResult.pageCount"/>
		<s:set name="fwdPage" value="queryResult.fwdPage"/>
		<s:set name="backPage" value="queryResult.backPage"/>
		<s:set name="currentPage" value="queryResult.currentPage"/>
		
		
		
		<a href="javascript:toPage('queryForm','pageNo',1)">第一页</a>
		<a href="javascript:toPage('queryForm','pageNo',<s:property value="#backPage"/>)">上一页</a>
		<s:iterator value="queryResult.pagesDisplayed" var="p">
			<s:if test="%{#currentPage==#p}"><b><s:property value="#p"/></b></s:if>
			<s:else><a href="javascript:toPage('queryForm','pageNo',<s:property value='p'/>)"><s:property value="p"/></a></s:else>
		</s:iterator>
		<a href="javascript:toPage('queryForm','pageNo',<s:property value="#fwdPage"/>)">下一页</a>
		<a href="javascript:toPage('queryForm','pageNo',<s:property value="#pageCount"/>)">最后页</a>
		
		
		
		
		&nbsp;&nbsp;
		<span><s:property value="#currentPage"/>/<s:property value="#pageCount"/>页[<s:property value="#rowCount"/>记录]</span>
		&nbsp;&nbsp;
		<span>设置每页显示记录数:</span>
			<s:set name="changePages" value="{'20','50','100',200}"/>
			<s:iterator value="changePages" var="changePage">
				<s:if test="#changePage==queryParam.pageBean.pageSize"><b><s:property value="#changePage"/></b></s:if>
				<s:else><a href="javascript:changePageSize('queryForm','pageSize','<s:property value='#changePage'/>')"><s:property value='#changePage'/></a></s:else>
			</s:iterator>
	</div>
	
	

	<!-- 分页导航~end -->
	
	
	<!-- 查询结果~begin -->
	<table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#E2E2E2">
   	<tr class="tr1">
        <th>
        <s:set name="_sortColumn" value="'a.Name'"/>
        <a href="javascript:sortColumn('queryForm','sortColumn','<s:property value='#_sortColumn'/>','sortOrder')">姓名</a>
        <s:if test="queryParam.pageBean.sortColumn==#_sortColumn"><s:if test="queryParam.pageBean.sortOrder"><img src="images/arrow-down.gif"/></s:if><s:else><img src="images/arrow-up.gif"/></s:else></s:if>
        </th>
        <th>
        <s:set name="_sortColumn" value="'a.Age'"/>
        <a href="javascript:sortColumn('queryForm','sortColumn','<s:property value='#_sortColumn'/>','sortOrder')">年龄</a>
        <s:if test="queryParam.pageBean.sortColumn==#_sortColumn"><s:if test="queryParam.pageBean.sortOrder"><img src="images/arrow-down.gif"/></s:if><s:else><img src="images/arrow-up.gif"/></s:else></s:if>
        </th>
        
        <th>
        <s:set name="_sortColumn" value="'a.OpDate'"/>
        <a href="javascript:sortColumn('queryForm','sortColumn','<s:property value='#_sortColumn'/>','sortOrder')">OpDate</a>
        <s:if test="queryParam.pageBean.sortColumn==#_sortColumn"><s:if test="queryParam.pageBean.sortOrder"><img src="images/arrow-down.gif"/></s:if><s:else><img src="images/arrow-up.gif"/></s:else></s:if>
        </th>
        <th>备注</th>
        <th>&nbsp;</th>
    </tr>
    <s:iterator value="queryResult.currentPageList" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap"><s:property value="name"/></td>
            <td class="nowrap"><s:property value="age"/></td>
            <td class="nowrap"><s:property value="opDate"/></td>
            <td class="nowrap"><s:property value="remark"/></td>
            <td class="nowrap">
                <s:url action="EmployeeEdit" id="url"><s:param name="branch.id" value="id"/></s:url>
                <a href="javascript:void(0)" href1="<s:property value="#url"/>" class="ymPrompt" title="编辑雇员">编辑</a>
                <a href="javascript:dropObj('queryForm','deleteIds','<s:property value='id'/>')">删除</a>
            </td>
        </tr>
    </s:iterator>
    </table>	<!-- 查询结果~end -->

    
    </s:if><s:else><div class="message">根据输入查询条件查询无结果!</div></s:else>
</s:if>
    
    













<script type="text/javascript"><!--

var calendar_DatePicker0 = new Calendar();
calendar_DatePicker0.create();
calendar_DatePicker0.onchange = function() {
  var field = document.getElementById("calendar_DatePicker0");
  var value = this.formatDate();
  if (field.value != value) {
    field.value = value;
    if (field.onchange) {
      field.onchange();
    }
  }
}

		
		function dropObj(v1,v2,v3){
			var pass =  confirm('确定要删除该记录吗？');
			if(pass){
				document.getElementById(v2).value = v3;
				$("#doDelete").click();
				
			}
		}
		function toPage(v1,v2,v3){
			document.getElementById(v2).value = v3;
			$("#doPage").click();
		}
		
		function changePageSize(v1,v2,v3){
			document.getElementById(v2).value = v3;
			$("#doPage").click();
		}
		
		function sortColumn(v1,v2,v3,v4){
			var sortColumn = document.getElementById(v2).value;
			var sortOrder = document.getElementById(v4).value;
			if(sortColumn!=null || sortColumn!=""){
				if(sortColumn!=v3){
					document.getElementById(v2).value = v3;
					document.getElementById(v4).value="";
				}else{
					if(sortOrder!="true" ){
						document.getElementById(v4).value="true";
					}else if(sortOrder=="true"){
						document.getElementById(v4).value="false";
					}
				}
			}
			$("#doSortColumn").click();
		}

-->		
</script>
	
</body>
</html>