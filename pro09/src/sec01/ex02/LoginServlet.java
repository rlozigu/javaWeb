package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

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
		
		out.println(data);
		
		String user_address = request.getParameter("user_address");
		user_address = URLEncoder.encode(user_address, "utf-8");
		out.print("<a href ='/pro09/second?user_id=" + request.getParameter("user_id") + "&user_pw="+ request.getParameter("user_pw") + "&user_address=" + user_address +"'>�� ��° �������� ������</a>");
		data = "</body></html>";
		out.print(data);
	}
	
	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}
}
