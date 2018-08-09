package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import util.DbConnection;

public class AdminLoginAction extends ActionSupport implements SessionAware{
	
	Map sessionMap;
	String username;
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String execute() throws Exception {
		Connection con = DbConnection.getConnection();
		if(con !=null)
		{
			String query="Select username, password from adminregistration where username= ? and password = ?";
			try(PreparedStatement ps = con.prepareStatement(query))
			{
				ps.setString(1, username);
				ps.setString(2, password);
				try(ResultSet rs = ps.executeQuery())
				{
					while(rs.next())
					{
						String uname,password;
						uname = rs.getString(1);
						password = rs.getString(2);
						sessionMap.put("adminname", uname);
						return SUCCESS;
					}
				}
			}
		}
		addActionError("Username or password doesnt match.");
		return ERROR;
	}
	@Override
	public void setSession(Map arg0) {
		sessionMap = arg0;
		
	}
}
