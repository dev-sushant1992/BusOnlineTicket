<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book a bus</title>
</head>
<body>
	<body>
		<table width="80%" align="center" border = "1">
			<tr id="header">
				<td>
					<s:include value="header.jsp"/>
				</td>
			</tr>
			
			<tr id="content">
				<td>
					<s:form action="getBusListAction" >
						<s:select list="source" name="source" label="Source"/>
						<s:select list="destination" name="destination" label="Destination"></s:select>
						<s:head/>
						<s:datetimepicker label="Date of Journey" name="date"></s:datetimepicker>
						<s:textfield name="noOfSeats" label="No of Seats"/>
						
						<s:submit value="Find buses"/>
					</s:form>
				</td>
			</tr>
			<tr id="footer">
				
			</tr>
		</table>
		
	</body>
</body>
</html>