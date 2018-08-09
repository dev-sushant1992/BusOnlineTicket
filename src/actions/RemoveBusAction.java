package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import util.DbConnection;

public class RemoveBusAction extends ActionSupport implements SessionAware {
	int busid;
	Map sessionMap;
	private Connection con;

	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}

	
	
	@Override
	public String execute() 
	{	
		if(sessionMap.get("adminname") == null)
			return LOGIN;
		try {
			con = DbConnection.getConnection();
			con.setAutoCommit(false);
			if (con != null)
			{
				String query = " select count(Bus_id) from Bus where Bus_id=?";
				try (PreparedStatement ps = con.prepareStatement(query))
				{
					ps.setInt(1, busid);
					try (ResultSet rs = ps.executeQuery()) 
					{
						while (rs.next())
						{
							int count = rs.getInt(1);
							if (count == 1)
							{
								query = "Delete from Bus where Bus_id = ? ";
								try (PreparedStatement ps2 = con.prepareStatement(query)) 
								{
									ps2.setInt(1, busid);
									int rowsDeleted = ps2.executeUpdate();
									con.commit();
									return SUCCESS;
								}
							}
							addFieldError("busid", "BusId doesnt exist");
						}
					}
				}		
			}
		} catch (SQLException e) {
			DbConnection.closeConnection();
			e.printStackTrace();
		}
		return INPUT;
	}
	@Override
	public void setSession(Map arg0) {
		sessionMap = arg0;
	}	
}
