package actions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import models.FindBusModel;
import util.DbConnection;
import util.PNRGenerator;

public class TicketAddAction extends ActionSupport implements SessionAware {

	int selectedId;
	int PNR;
	int noOfSeats;
	private Date doj;
	float totalFare;
	int busId;
	String busName;
	String busType;
	String status;
	String username;
	
	private Map sessionMap;
	
	public int getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}

	@Override
	public String execute() throws Exception {
		if (sessionMap.get("username") == null) {
			return LOGIN;
		}
		username = (String)sessionMap.get("username");
		System.out.println(username);
		PNR = PNRGenerator.generateUniquePNR();
		noOfSeats = (int)sessionMap.get("noOfSeats");
		doj = (Date)sessionMap.get("doj");
		status = "CNF";
		ArrayList<FindBusModel> buses = (ArrayList<FindBusModel>)sessionMap.get("buses");

		for (FindBusModel fbm : buses) 
		{
			if(fbm.getBusId() == selectedId)
			{
				totalFare = fbm.getFare();
				break;
			}
		}
		System.out.println(username);
		
		Connection con = DbConnection.getConnection();
		if(con != null)
		{
			String query = "Insert into ticket values(?,?,?,?,?,?,?)";
			try(PreparedStatement ps = con.prepareStatement(query))
			{
				ps.setInt(1,PNR);
				ps.setInt(2,noOfSeats);
				ps.setDate(3, doj);
				ps.setFloat(4, totalFare);
				ps.setString(5, username);
				ps.setString(6, status);
				ps.setInt(7, selectedId);
				
				ps.executeUpdate();
				System.out.println(PNR + " " + noOfSeats + " " + doj + " " + totalFare + " " + username + " " + status + " " +selectedId);
				sessionMap.clear();
				sessionMap.put("pnr", PNR);
				sessionMap.put("username", username);
				return SUCCESS;
			}
		}
		return ERROR;
	}

	public void setSession(Map arg0) {

		sessionMap = arg0;
	}

}
