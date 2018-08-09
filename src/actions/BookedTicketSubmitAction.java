package actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BookedTicketSubmitAction extends ActionSupport implements SessionAware{
	
	Map sessionMap;
	private String btnPressed;
	public int selectedId;
	
	public int getSelectedId() {
		return selectedId;
	}
	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}

	public String getBtnPressed() {
		return btnPressed;
	}
	public void setBtnPressed(String btnPressed) {
		this.btnPressed = btnPressed;
	}
	@Override
	public String execute() throws Exception {
		sessionMap.put("pnr", selectedId);
		if(btnPressed.equals("cancel"))
		{
			return "cancel";
		}
		return "details";
	}

	@Override
	public void setSession(Map arg0) {
		sessionMap = arg0;
	}

}
