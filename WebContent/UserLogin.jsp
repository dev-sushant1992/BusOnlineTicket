<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login User</title>
</head>
<body>
	<table width="80%" align="center" border="2">
		<tr id="header">
			<td>
				<s:include value="header.jsp"/>
			</td>
		</tr>
		
		<tr id="content">
			<td>
				<div>
					<h2 align ="center">Login Page </h2>
					<br/><br/>
					<div align="center">
						<s:form action="userLoginAction" method="post">
							<s:textfield name="username" label="Enter user name"/>
							<s:password name="password" label="Enter password"/>
							<s:submit value="Log in"/>
						</s:form>
					</div>
				</div>
			</td>
		</tr>
		<tr id="footer">
			
		</tr>
	</table>
</body>
</html>