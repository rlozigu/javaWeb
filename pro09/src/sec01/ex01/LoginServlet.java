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
		System.out.println("init �޼��� ȣ��");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "�ȳ��ϼ���!<br> �α����ϼ̽��ϴ�.<br><br>";
		data += "<html><body>";
		data += "���̵�: " + request.getParameter("user_id");
		data += "<br>";
		data += "�н�����: " + request.getParameter("user_pw");
		data += "<br>";
		data += "�ּ�: " + request.getParameter("user_address");
		data += "<br>";
		data += "email: " + request.getParameter("user_email");
		data += "<br>";
		data += "�޴���ȭ: " + request.getParameter("user_hp");
		data += "</body></html>";
		
		out.print(data);
	}
	
	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}
}
