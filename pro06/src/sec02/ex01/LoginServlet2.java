package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//브라우저에서 전성된 데이터의 인코딩 설정
		req.setCharacterEncoding("utf-8");
		//응답할 데이터 종류가 HTML임을 설정
		resp.setContentType("text/html;charset=utf-8");
		//출력 스트림 PrintWriter 객체를 받아온다.
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		String data = "<html>";
			data += "<body>";
			data += "아이디 : " + id;
			data += "<br>";
			data += "패스워드 : " + pw;
			data += "</body>";
			data += "</html>";
			out.print(data);
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

}
