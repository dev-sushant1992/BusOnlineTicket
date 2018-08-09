package actions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import models.TicketHistoryModel;
import util.DbConnection;

public class TicketHistoryAction extends ActionSupport implements SessionAware{
	
	Map sessionMap;
	ArrayList<TicketHistoryModel> thm;
	
	@Override
	public String execute() throws Exception {
		
		if (sessionMap.get("username") == null) {
			return LOGIN;
		}
		Connection con = DbConnection.getConnection();
		
		if(con != null)
		{
			String query = "Select pnr,source,destination,dateofjourney,status from ticket t join bus b on(t.busid = b.bus_id) where username = ?";
			try(PreparedStatement ps = con.prepareStatement(query))
			{
				ps.setString(1, (String)sessionMap.get("username"));
				try(ResultSet rs = ps.executeQuery())
				{
					thm = new ArrayList<>();
					while(rs.next())
					{
						TicketHistoryModel th = new TicketHistoryModel();
						th.setPnr(rs.getInt(1));
						th.setSource(rs.getString(2));
						th.setDestination(rs.getString(3));
						th.setDoj(rs.getDate(4));
						thm.add(th);
					}
					sessionMap.put("thm", thm);
					return SUCCESS;
				}
			}
		}
		
		
		return ERROR;
	}

	@Override
	public void setSession(Map arg0) {
		sessionMap = arg0;
		
	}

}
