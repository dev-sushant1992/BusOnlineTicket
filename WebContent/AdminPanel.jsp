<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Welcome <s:property value="username"/>
</h1>
<ol>
<li>
<s:a href="BusAdd.jsp">Add Page</s:a>
</li>
<li>
<s:a href="BusUpdateGetId.jsp">Update Page</s:a>
</li>
<li>
<s:a href="BusRemove.jsp">Delete Page</s:a>
</li>
</ol>
<s:form action ="adminLogoutAction">
	<s:submit value="LogOut"></s:submit>
</s:form>
<a href="Home.jsp">Go to Home</a>
</body>
</html>