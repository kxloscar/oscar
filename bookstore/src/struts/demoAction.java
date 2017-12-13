package struts;

import javax.servlet.http.HttpServlet;

import com.opensymphony.xwork2.ActionContext;

public class demoAction {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute() {
		if("rkdj".equals(name)){
			System.out.println(" 3");
			return "rkdj";
		}
		if("kclb".equals(name)){
			System.out.println(" 4");
			return "kclb";
		}
		return name;
	}
}
