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
	<h2 align ="center"> Add Bus Details Form </h2>
	<br/> <br/>
	<s:form action="addBusAction">
		<s:actionerror/>
		<s:textfield name="busId" label="Bus Id"/>
		<s:textfield name="busName" label="Bus Name"/>

		<s:select name="busType" label="Bus Type" list="{'AC','NON-AC','Sleeper','Semi Sleeper'}"/>
		<s:textfield name="departureTime" label="Departure Time"/>
		<s:textfield name="arrivalTime" label="Arrival Time"/>

		<s:textfield label="Total Seats" name="noOfSeats"/>
		<s:textfield label="Fare" name="fare"/>
		<s:textfield label="Source" name="source"/>
		<s:textfield label="Destination" name="destination"/>
		<s:submit value="Add Bus"/>
	</s:form>
	<br/>
	<a href="AdminPanel.jsp">Go back to Admin Panel</a>
</body>
</html>