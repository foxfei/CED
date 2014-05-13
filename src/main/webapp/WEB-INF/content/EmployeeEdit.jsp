<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/meta.jsp"%>
<link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
<script type="text/javascript" language="JavaScript"  src="<s:url value='/js/jquery/jquery-1.3.2.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/DatePicker/DatePicker.js'/>"></script>
<title>填写雇员</title>
</head>
<body>

<s:property value="exceptionStack"/>

<br/>

	填写雇员<br/>
	
	<b><s:if test="message!=null"><s:text name="message"/></s:if></b>

	
	<s:form namespace="/" action="EmployeeUpdate" method="post">
	    <s:hidden name="item.id"/>	
		名字:<s:textfield name="item.name"></s:textfield><br/>
		年龄:<s:textfield name="item.age"></s:textfield><br/>
		OpDate:<s:textfield name="item.opDate" id="calendar_DatePicker0"></s:textfield>
		    <a href="javascript:calendar_DatePicker0.toggle(document.getElementById('calendar_DatePicker0'));"><img src="images/datepicker_icon.png" border="0"></img></a>
		
		
		
		
		
		<br/>
		备注:<s:textarea label="备注" name="item.remark"></s:textarea><br/>
		<s:submit value="保存"></s:submit>
	</s:form>
	
	   

	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	
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

--></script>
	
</body>
</html>