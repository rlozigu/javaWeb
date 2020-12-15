package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		String address = req.getParameter("user_address");
		
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pw);
		
		String data = "<html>";
		data += "<body>";
		data += "아이디 : " + id;
		data += "<br>";
		data += "비밀번호 : " + pw;
		data += "<br>";
		data += "주소 : " + address;
		data += "</body>";
		data += "</html>";
		out.print(data);
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

}
