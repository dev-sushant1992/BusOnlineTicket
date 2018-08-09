<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="80%" align="center">
		<tr id="header">
			<td>
				<s:include value="header.jsp"/>
			</td>
		</tr>
		
		<tr id="content">
			<td>
				<h2 align ="center">Sign Up Page </h2>
				<br/> <br/>
				<s:form action="userRegisterAction">
					<s:textfield name="firstName" label="First name:"/>
					<s:textfield name="lastName" label="Last name:"/>
					<s:textfield name="username" label="User name:"/>
					<s:password name="password" label="Enter password"/>
					<s:password name="confirmPassword" label="Re-Enter password"/>
					<s:textfield name="age" label="Age:"/>
					<s:radio name="gender" label="Gender" list="{'Male' , 'Female'}"/>
					<s:textfield name="mobileNo" label="Mobile No"/>
					<s:textfield name="emailId" label="E-mail Id:" />
					<s:textarea name="address" label = "Address"/>
					<s:submit value="Sign Up"/>
				</s:form>
			</td>
		</tr>
		<tr id="footer">
			
		</tr>
	</table>
</body>
</html>