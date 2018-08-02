package content;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//获得多个表单的值
		String[] values = request.getParameterValues("hobby");
		for (String str : values) {
			out.write(str+"<br>");
		}
		
		//获得所有请求参数的名称
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			out.write(names.nextElement()+"<br>");
		}
		
		//将所有的参数封装到一个Map<String, String[]>
		Map<String, String[]> parameterMap = request.getParameterMap();
		for(Map.Entry<String, String[]> entry:parameterMap.entrySet()){
			System.out.println(entry.getKey());
			for(String str:entry.getValue()){
				System.out.println(str);
			}
			System.out.println("---------------------------");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
