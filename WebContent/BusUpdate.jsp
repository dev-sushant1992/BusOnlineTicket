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
<h2 align ="center"> Update Bus Details Form </h2>
<br> <br>
<s:form action="updateBusAction" >


<s:textfield name="busName" label="Bus Name"/>
<s:select name="busType" label="Bus Type" list="{'','AC','NON-AC','Sleeper','Semi Sleeper'}"/>

 
<s:textfield name="departureTime" label="Departure Time"/>
<s:textfield name="arrivalTime" label="Arrival Time"/>

<s:textfield label="Total Seats" name="totalSeats"/>
<s:textfield label="Fare" name="fare"/>
<s:textfield label="Source" name="source"/>
<s:textfield label="Destination" name="destination"/>

<s:hidden name="busid" value="%{#request.busid}"/>

<s:submit value="Confirm Bus Update"/>
</s:form>
<br/>
<a href="AdminPanel.jsp">Go back to Admin Panel</a>
</body>
</html>