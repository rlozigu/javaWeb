package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	public void init() {
		System.out.println("init 메서드 호출");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "안녕하세요!<br> 로그인하셨습니다.<br><br>";
		data += "<html><body>";
		data += "아이디: " + request.getParameter("user_id");
		data += "<br>";
		data += "패스워드: " + request.getParameter("user_pw");
		data += "<br>";
		data += "주소: " + request.getParameter("user_address");
		data += "<br>";
		data += "email: " + request.getParameter("user_email");
		data += "<br>";
		data += "휴대전화: " + request.getParameter("user_hp");
		data += "</body></html>";
		
		out.print(data);
	}
	
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
