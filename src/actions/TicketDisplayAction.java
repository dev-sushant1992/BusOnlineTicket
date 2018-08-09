package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import models.TicketDisplayModel;
import util.DbConnection;

public class TicketDisplayAction extends ActionSupport implements SessionAware
{
	Map sessionMap;
	private int pnr;
	TicketDisplayModel tdm;
	
	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	@Override
	public void setSession(Map arg0) {
		sessionMap = arg0;
	}
	
	@Override
	public String execute() throws Exception {
		Connection con = DbConnection.getConnection();
		pnr = (int)sessionMap.get("pnr");
		if(con != null)
		{
			String query = "Select pnr,dateofjourney,bus_name, departure_time, arrival_time,noOfSeats,totalFare from bus join ticket on (bus_id = busid) where pnr = ?";
			try(PreparedStatement ps = con.prepareStatement(query))
			{
				ps.setInt(1, pnr);
				try(ResultSet rs = ps.executeQuery())
				{
					while(rs.next())
					{
						tdm = new TicketDisplayModel();
						tdm.setPnr(rs.getInt(1));
						tdm.setDoj(rs.getDate(2));
						tdm.setBus_name(rs.getString(3));
						tdm.setDeparture_time(rs.getString(4));
						tdm.setArrival_time(rs.getString(5));
						tdm.setNoOfSeats(rs.getInt(6));
						tdm.setTotalFare(rs.getFloat(7));
					}					
					sessionMap.put("tdm", tdm);
					return SUCCESS;
				}
			}
		}
		return ERROR;
	}

}
