<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose your bus</title>
<link rel="stylesheet" href="header.css" type="text/css" />
<script type="text/javascript">
	function setHiddenField() {
		
	}
</script>
</head>
<body>
	<table width="80%" align="center" cellspacing="0">
		<tr>
			<td><s:include value="header.jsp" /></td>
		</tr>

		<tr>
			<td align="center">
				<table style="text-align: center;" cellspacing="0" width="100%">
					<tr style="background-color: #3e6fde">
						<td><s:property value="#session.source" /> - <s:property
								value="#session.destination" /><br /> <s:property
								value="#session.doj" /></td>
					</tr>
					<s:iterator value="#session.buses" id="b">
						<tr>
							<td>
								<table width="100%" align="center" >
									<tr>
										<td width="33%"><s:property value="busName" /></td>
										<td width="33%"><s:property value="departureTime" /> - <s:property
												value="arrivalTime" /></td>
										<td width="33%">
											<s:form action="confirmTicketAction" >
													<s:hidden name="selectedId" value = "%{busId}"/>
													<s:submit align="center" value="BOOK"></s:submit>
											</s:form>
										</td>
									</tr>
									<tr>
										<td><s:property value="busType" /></td>
										<td></td>
										<td><font style="color: red;">Seats Available : <s:property value="seatsAvailable" /></font></td>
									</tr>
								</table>
							</td>
						</tr>
					</s:iterator>
					<tr>
						<td></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>