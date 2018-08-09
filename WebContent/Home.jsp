<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home</title>
	<s:head/>
	<link rel="stylesheet" href="main.css" type="text/css"/>
</head>
	<body>
	<s:include value="headerHome.jsp"/>
	<table width="80%" align="center" cellspacing="0" cellpadding="0">		
		<tr>
			<td align="center" width="100%">
				Welcome <s:property value="#session.username"/>
			</td>
			<td align="right">
				<a href="UserLogoutAction">Logout</a>
			</td>
		</tr>
	</table>
	</body>
</html>