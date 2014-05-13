<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>异常信息页面</title>
<script type="text/javascript" src="<s:url value='/js/jquery/jquery-1.3.2.min.js'/>"></script>
</head>
<body>	
	<s:property value="exceptionStack"/>	
</body>
</html>