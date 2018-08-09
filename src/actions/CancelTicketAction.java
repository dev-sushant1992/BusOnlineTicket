package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import util.DbConnection;

public class CancelTicketAction extends ActionSupport implements SessionAware
{
	Map sessionMap;
	private int selectedId;

	@Override
	public String execute() throws Exception {
		
		System.out.println("Reached Here.");
		if (sessionMap.get("username") == null) {
			return LOGIN;
		}
		Connection con = DbConnection.getConnection();
		con.setAutoCommit(false);
		selectedId = (int) sessionMap.get("pnr");
		if(con != null)
		{
			String query = "Update ticket set noOfSeats = 0, status='CAN' where pnr= ?";
			try(PreparedStatement ps = con.prepareStatement(query))
			{
				ps.setInt(1, selectedId);
				ps.executeUpdate();
				con.commit();
				return SUCCESS;
			}
					
		}
		return ERROR;
	}

	@Override
	public void setSession(Map arg0) {
		sessionMap = arg0;
		
	}
}
