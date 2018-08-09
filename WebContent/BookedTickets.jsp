<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booked Tickets</title>
</head>
<body>
	<table width="80%" align="center" border = "1">
			<tr id="header">
				<td>
					<s:include value="header.jsp"/>
				</td>
			</tr>
			
			<tr id="content">
				<td>
					<p align="center">Booked Tickets</p>
					<table>
					<s:iterator value="#session.thm">
						<tr>
							<td>
								<table width="100%" align="center">
									<tr>										
										<td><s:property value="pnr"/></td>
										<td><s:property value="doj"/></td>
										<td><s:property value="source"/></td>
										<td><s:property value="destination"/></td>
										<td>
											<s:form action = "BookedTicketSubmitAction">
												<s:hidden name="selectedId" value="%{pnr}"/>
												<s:submit name="btnPressed" value="cancel"/>
												<s:submit name="btnPressed" value= "details"/>
											</s:form>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</s:iterator>
					</table>
				</td>
			</tr>
			<tr id="footer">
				
			</tr>
		</table>
</body>
</html>