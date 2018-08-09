package actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import models.Bus;
import util.DbConnection;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BusAddAction extends ActionSupport implements ModelDriven<Bus>, SessionAware {

	private Bus bus;
	private Connection con;
	Map sessionMap;

	@Override
	public Bus getModel() {
		bus = new Bus();
		return bus;
	}
	
	public String execute() {
		System.out.println("AddBus Entered.");
		if(sessionMap.get("adminname") == null)
		{
			System.out.println("AddBusAction : 1");
			return LOGIN;
		}		
		
		try {
			con = DbConnection.getConnection();
			System.out.println(bus.getDepartureTime());
			System.out.println(bus.getArrivalTime());

			if (con != null) {
				System.out.println("Entered 2.");
				String query = "Insert into bus (bus_id, bus_name, bus_type, departure_time, arrival_time, total_seats, fare, source, destination)"
						+ "values(?,?,?,?,?,?,?,?,?)";
				try (PreparedStatement ps = con.prepareStatement(query)) 
				{
					ps.setInt(1, bus.getBusId());
					ps.setString(2, bus.getBusName());
					ps.setString(3, bus.getBusType());
					ps.setString(4, bus.getDepartureTime());
					ps.setString(5, bus.getArrivalTime());
					ps.setInt(6, bus.getNoOfSeats());
					ps.setFloat(7, bus.getFare());
					ps.setString(8, bus.getSource());
					ps.setString(9, bus.getDestination());
					ps.executeUpdate();
					return SUCCESS;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	@Override
	public void setSession(Map map) {
		sessionMap = map;
	}

}
