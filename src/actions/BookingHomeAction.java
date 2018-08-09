package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import util.DbConnection;

public class BookingHomeAction extends ActionSupport implements SessionAware{

	ArrayList<String> source,destination;
	
	
	public ArrayList<String> getSource() {
		return source;
	}
	public void setSource(ArrayList<String> source) {
		this.source = source;
	}
	public ArrayList<String> getDestination() {
		return destination;
	}
	public void setDestination(ArrayList<String> destination) {
		this.destination = destination;
	}

	
	@Override
	public void setSession(Map arg0) {
		
	}
	@Override
	public String execute() throws Exception {
		source = new ArrayList<>();
		destination = new ArrayList<>();
		Connection con = DbConnection.getConnection();
		System.out.println("Entered");
		try {
			if(con != null)
			{
				String query = "Select Cityname||'('||citycode||')' from city";
				try(PreparedStatement ps = con.prepareStatement(query))
				{
					try(ResultSet rs = ps.executeQuery())
					{
						while(rs.next())
						{
							String s = rs.getString(1);
							source.add(s);
							destination.add(s);
							
						}
						System.out.println("source="+source);
						System.out.println("destination="+destination);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
