package actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserLogoutAction extends ActionSupport implements SessionAware
{
	Map sessionMap;
	@Override
	public String execute() throws Exception {
		if(sessionMap.get("username") != null)
			sessionMap.remove("username");
		return SUCCESS;
	}
	@Override
	public void setSession(Map arg0) {
		sessionMap = arg0;
		
	}
}
