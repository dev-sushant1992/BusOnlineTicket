<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="header.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<table width="80%" align="center" border="1">
		<tr id="header">
			<td><s:include value="header.jsp" /></td>
		</tr>

		<tr id="content" height="800px">
			<td valign="top">
				<div>
					<h2 align="center">Admin Login Page</h2>
					<br />
					<br />
					<div align="center">
						<s:form action="adminLoginAction" method="post">
							<s:actionerror />
							<s:textfield name="username" label="Enter user name" />
							<s:password name="password" label="Enter password" />
							<s:submit value="Log in" />
						</s:form>
					</div>
				</div>
			</td>
		</tr>
	</table>
	<table align="center" style="position:fixed; width:100%;height:60px; background-color: #feb300;bottom: 0">
		<tr>
			<td width="100%">
			<img src="mail.png" align="right" height="50px" width="50px">
			</td>
			<td>
			<font>seedproject@gmail.com</font>
			</td>
		</tr>
	</table>


</body>
</html>