package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import util.DbConnection;

public class UpdateBusGetIdAction extends ActionSupport implements SessionAware {
	Map sessionMap;
	int busid;
	private Connection con;

	public int getBusid() {
		return busid;
	}

	public void setBusid(int busid) {
		this.busid = busid;
	}

	@Override
	public String execute() {
		if(sessionMap.get("adminname") == null)
			return LOGIN;
		try {
			con = DbConnection.getConnection();
			con.setAutoCommit(false);
			if (con != null) {
				String query = " select Bus_id from Bus where Bus_id=?";
				try (PreparedStatement ps = con.prepareStatement(query)) {
					ps.setInt(1, busid);
					System.out.println(busid);
					try (ResultSet rs = ps.executeQuery()) {
						while (rs.next()) {
							int id = rs.getInt(1);
							System.out.println(id);
							if (id == busid) {
								System.out.println("entered");
								return SUCCESS;
							}
							addFieldError("busid", "BusId doesnt exist");
						}
					}
				}
			}
		} catch (

		SQLException e) {
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
