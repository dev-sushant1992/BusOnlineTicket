package actions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import java.sql.Date;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import models.FindBusModel;
import util.DbConnection;

public class FindBusesAction extends ActionSupport implements SessionAware {

	private String source;
	private String destination;
	private Date date;
	private int noOfSeats;
	private ArrayList<FindBusModel> foundBuses;

	private Map sessionMap;

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String execute() throws Exception {
		/*if (sessionMap.get("username") == null) {
			ServletActionContext.getResponse().sendRedirect("UserLogin.jsp");
		}*/
		Connection con = DbConnection.getConnection();
		if (con != null) 
		{
			System.out.println("***********date ="+date);
			System.out.println("***********source ="+source);
			System.out.println("***********destination ="+destination);
			System.out.println(source.substring(source.length() - 4, source.length() - 1));
			
			String query = "Select bus_id, bus_name, bus_type, departure_time, arrival_time, fare, total_seats - NVL(seatsBooked , 0) seatsAvailable"
					+ " from"
					+ " (Select bus_id, bus_name, bus_type, departure_time, arrival_time, fare, total_seats from bus"
					+ " where source = ? and destination = ?) b"
					+ " left outer join"
					+ " (Select busid, sum(noOfSeats) seatsBooked from ticket"
					+ " where dateofjourney = ?"
					+ " group by busid,dateofjourney) t"
					+ " on(bus_id = t.busid)";
			
			try (PreparedStatement ps = con.prepareStatement(query)) {
				String src,dest;
				src = source.substring(source.length() - 4, source.length() - 1);
				dest = destination.substring(destination.length() - 4, destination.length() - 1);
				ps.setString(1, src);
				ps.setString(2, dest);
				ps.setDate(3, date);

				try(ResultSet rs = ps.executeQuery())
				{
					foundBuses = new ArrayList<>();
					while(rs.next())
					{
						FindBusModel bus = new FindBusModel();
						bus.setBusId(rs.getInt(1));
						bus.setBusName(rs.getString(2));
						bus.setBusType(rs.getString(3));
						bus.setDepartureTime(rs.getString(4));
						bus.setArrivalTime(rs.getString(5));
						bus.setFare(rs.getFloat(6)* noOfSeats);
						bus.setSeatsAvailable(rs.getInt(7));
						foundBuses.add(bus);
					}
					sessionMap.put("buses", foundBuses);
					sessionMap.put("source", source);
					sessionMap.put("destination", destination);
					sessionMap.put("doj", date);
					sessionMap.put("noOfSeats", noOfSeats);
				}
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
