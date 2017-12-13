package struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class lanjieqi extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invoc) throws Exception {
		demoAction da = (demoAction) invoc.getAction();
		if("rkdj".equals(da.getName())){
			System.out.println(" 1");
			invoc.invoke();
		}
		if("kclb".equals(da.getName())){
			System.out.println(" 2");
			invoc.invoke();
		}
		
		return null;
	}

}
