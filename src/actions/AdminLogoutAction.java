package actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLogoutAction extends ActionSupport implements SessionAware{

	Map sessionMap ;
	@Override
	public void setSession(Map arg0) {
		sessionMap = arg0;
	}
	
	@Override
	public String execute() throws Exception {
		if(sessionMap.get("adminname") != null)
			sessionMap.remove("adminname");
		return SUCCESS;
	}

}
