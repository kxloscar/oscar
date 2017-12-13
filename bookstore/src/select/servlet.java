package select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bookstoreDao.bookDAOIpml;
import bookstoreDao.bookModel;


@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors = new ArrayList<>();
		//1、获取请求参数
		String strtitle = request.getParameter("title");
		String strwriter = request.getParameter("writer");
		String strdiscount = request.getParameter("discount");
		String strprice=request.getParameter("price");
		String stramount=request.getParameter("amount");
		String strsynosis=request.getParameter("synopsis");
		String[] strtype=request.getParameterValues("type");
		String type = "";
		//2、数据类型转换
		double discount=0;
		double price=0;
		int amount=0;
		if(strtitle == null || strtitle.trim().length() == 0) {
			errors.add("请输入书名");
		}
		if(strwriter == null || strwriter.trim().length() == 0) {
			errors.add("请输入作者");
		}	
		if(strdiscount == null || strdiscount.trim().length() == 0) {
			errors.add("请选择折扣");
		}else{
			 discount=Double.parseDouble(strdiscount);
		}
		if(strprice == null || strprice.trim().length() == 0) {
			errors.add("请输入价格");
		}else{
			 price=Double.parseDouble(strprice);
		}
		if(stramount == null || stramount.trim().length() == 0) {
			errors.add("请输入数量");
		}else{
			amount=Integer.parseInt(stramount);
		}
		if(strsynosis == null || strsynosis.trim().length() == 0) {
			errors.add("请输入简介");
		}
		if(strtype == null || strtype.length == 0) {
			errors.add("请选择类型");
		}else{
			for(int i=0;i<strtype.length;i++){
				type+=strtype[i];
			}
		}
		//如果校验成功
		if(errors.isEmpty()) {
			//4、执行业务逻辑
			bookDAOIpml bookService = new bookDAOIpml();
			bookModel book = null;
			try {
				book = new bookModel(strtitle, strwriter, discount, price, amount, strsynosis,type);
				
				bookService.addbook(book);
			} catch (Exception e) {
				errors.add("添加联赛失败");
				request.setAttribute("errors", errors);
				RequestDispatcher dispatcher = request.getRequestDispatcher("err.jsp");
				dispatcher.forward(request, response);
			}
			//将league对象存储到request作用域
			request.setAttribute("book", book);
			
			//5、根据以上结果调用下一个视图
			RequestDispatcher dispatcher = request.getRequestDispatcher("cg.jsp");
			dispatcher.forward(request, response);
		}
		//如果失败
		else {
			//将errors存储到request作用域
			request.setAttribute("errors", errors);
			//5、根据以上结果调用下一个视图
			RequestDispatcher dispatcher = request.getRequestDispatcher("err.jsp");
			dispatcher.forward(request, response);
		}
	}

}
