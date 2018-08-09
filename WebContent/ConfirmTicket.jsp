<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="80%" align="center" border="1">
		<tr id="header">
			<td><s:include value="header.jsp" /></td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
					<td colspan="2" align="center">Ticket Details</td>
					</tr>
					<tr>
					<td>PNR :</td>
					<td><s:property value="#session.tdm.pnr"/></td>
					</tr>
					<tr>
					<td>Bus Name :</td>
					<td><s:property value="#session.tdm.bus_name"/></td>
					</tr>
					<tr>
					<td>Date Of Journey :</td>
					<td><s:property value="#session.tdm.doj"/></td>
					</tr>
					<tr>
					<td>Departure time :</td>
					<td><s:property value="#session.tdm.departure_time"/></td>
					</tr>
					<tr>
					<td>Arrival time :</td>
					<td><s:property value="#session.tdm.arrival_time"/></td>
					</tr>
					<tr>
					<td>Seats :</td>
					<td><s:property value="#session.tdm.noOfSeats"/></td>
					</tr>
					<tr>
					<td>Total Fare</td>
					<td><s:property value="#session.tdm.totalFare"/></td>
					</tr>
				</table>
			</td>
		</tr>
		
	</table>
</body>
</html>