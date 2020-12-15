package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	

	@Override
	//Post 방식으로 전송된 데이터 처리
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//브라우저에서 전성된 데이터의 인코딩 설정
		req.setCharacterEncoding("utf-8");
		//응답할 데이터 종류가 HTML임을 설정
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pw);
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

}
