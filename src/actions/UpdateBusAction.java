package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import models.Bus;
import util.DbConnection;

public class UpdateBusAction extends ActionSupport implements ModelDriven<Bus>,SessionAware{
	
	private Map sessionMap;
	private int busid;
	public int getBusid() {
		return busid;
	}

	public void setBusid(int busid) {
		this.busid = busid;
	}

	private Bus bus;
	Connection con;
	
	@Override
	public String execute() throws Exception {
		if(sessionMap.get("adminname") == null)
			return LOGIN;
		con = DbConnection.getConnection();
		System.out.println("YYYYYY");
		System.out.println(busid);
		if(con != null)
		{
			String query = "Update bus set bus_name = ?, bus_type = ? , departure_time = ?," +
					"arrival_time = ?, total_seats = ?, fare = ?, source = ?, destination = ?" +
					"where bus_Id= ?";
			try(PreparedStatement ps = con.prepareStatement(query))
			{
				ps.setString(1, bus.getBusName());
				ps.setString(2, bus.getBusType());
				ps.setString(3, bus.getDepartureTime());
				ps.setString(4, bus.getArrivalTime());
				ps.setInt(5, bus.getNoOfSeats());
				ps.setFloat(6, bus.getFare());
				ps.setString(7, bus.getSource());
				ps.setString(8, bus.getDestination());
				ps.setInt(9, busid);
				
				int rowsUpdated = ps.executeUpdate();
				return SUCCESS;
			}
		}
		
		return INPUT;
	}

	@Override
	public Bus getModel() {
		bus = new Bus();
		return bus;
	}

	@Override
	public void setSession(Map arg0) {
		sessionMap = arg0;
		
	}

}
