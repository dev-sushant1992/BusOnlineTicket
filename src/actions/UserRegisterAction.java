package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import models.User;
import util.DbConnection;

public class UserRegisterAction extends ActionSupport implements ModelDriven<User>{

	private User user;	

	@Override
	public User getModel() 
	{
		user = new User();
		return user;
	}
	
	public String execute() 
	{
		Connection con = DbConnection.getConnection();
		try 
		{
			Statement stmt = con.createStatement();

			
			try (ResultSet rs = stmt.executeQuery("Select username,mobileno,emailid from userregistration")) 
			{
				
				String uname,mob,email;
				while (rs.next()) 
				{
					
					uname = rs.getString(1);
					mob = rs.getString(2);
					email = rs.getString(3);
					
					if (uname.equals(user.getUsername()))
					{
						
						addFieldError("username", "Username already exists.");
						return "error";
					}
					if (mob.equals(user.getMobileNo()))
					{
						
						addFieldError("mobileNo", "Mobile number is already registered with us.");
						return "error";
					}
					if (email.equals(user.getEmailId()))
					{
						
						addFieldError("emailId", "Email already exists.");
						return "error";
					}
				}
			}
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		String query = "Insert into userregistration(firstname, lastname,username,password,"
				+ "age,gender,mobileno,emailid,address) "
				+ "values (?,?,?,?,?,?,?,?,?)";
				/*+ user.getFirstName() + "','" + user.getLastName() + "','" + user.getUsername() + "','" + user.getPassword() + "'," + user.getAge() + ",'" +
				user.getGender() + "','" + user.getMobileNo() + "','" + user.getEmailId() + "','" + user.getAddress() + "'";*/
		try (PreparedStatement ps = con.prepareStatement(query)) 
		{
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getAge());
			ps.setString(6, user.getGender());
			ps.setString(7, user.getMobileNo());
			ps.setString(8, user.getEmailId());
			ps.setString(9, user.getAddress());
			ps.executeUpdate();
			return SUCCESS;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ERROR;
	}	
}
