package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//这条语句要放在getWriter()之前
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
				
		out.write("<style type=text/css>");
		out.write("body {");
		out.write("font-family:等线;");
		out.write("}");
		out.write("</style>");
		
		//获得请求方式
		String method = request.getMethod();
		//获得请求行中资源名称部分
		String uri = request.getRequestURI();
		//获得请求的URL
		String url = new String(request.getRequestURL());
		//获得请求行中的参数部分
		String queryString = request.getQueryString();
		//获得URL中WEB应用的路径
		String path = request.getContextPath();
		//获得Servlet的名称或其映射路径
		String servletPath = request.getServletPath();
		//获得http请求中的主机名
		String serverName = request.getServerName();
		//获得客户端的IP
		String addr = request.getRemoteAddr();
		//获得服务器的IP地址
		String localAddr = request.getLocalAddr();
		
		out.write(method); 		out.write("<br>");
		out.write(uri); 		out.write("<br>");
		out.write(url); 		out.write("<br>");
		out.write(queryString); out.write("<br>");
		out.write(path); 		out.write("<br>");
		out.write(servletPath); out.write("<br>");
		out.write(serverName); 	out.write("<br>");
		out.write(addr); 		out.write("<br>");
		out.write(localAddr); 	out.write("<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
