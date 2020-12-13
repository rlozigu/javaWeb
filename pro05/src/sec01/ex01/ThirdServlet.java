package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션을 이용한 서블릿 매핑
@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	//서블릿 클래스 직렬화를 위해 이클립스에서 자동으로 지정한 상수.
	//사용하지 않으면 삭제해도됨.(나는 주석)
	//private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("ThirdServlet init 메서드 호출");
	}

	public void destroy() {
		System.out.println("ThirdServlet destroy 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ThirdServlet doGet 메서드 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ThirdServlet doPost 메서드 호출");
	}

}
