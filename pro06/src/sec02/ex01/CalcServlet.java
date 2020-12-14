package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet{
	private static float USD_RATE = 1124.70F;
	private static float JPY_RATE = 10.113F;
	private static float CNY_RATE = 163.30F;
	private static float GBP_RATE = 1444.35F;
	private static float EUR_RATE = 1295.97F;

	
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
		PrintWriter pw = resp.getWriter();
		String command = req.getParameter("command");
		String won = req.getParameter("won");
		String operator = req.getParameter("operator");
		
		//최초 요청 시 command가 null이면 계신기 화면을, command값이 calculate면 계산 결과를 출력
		if(command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font size=10>변환 결과</font><br>");
			pw.print("<html><font size=10>" + result + "</font><br>");
			pw.print("<a href='/pro06/calc'>환율 계산기</a>");
			
			return;
		}
		
			pw.print("<html><title>환율 계산기</title>");
			pw.print("<font size=5>환율 계산기</font><br>");
			pw.print("<form name ='frmCalc' method='get' action='/pro06/calc' >");
			pw.print("원화: <input type='text' name='won' size=10>");
			pw.print("<select name='operator'>");
			pw.print("<option value ='dollar'>달러</option>");
			pw.print("<option value ='en'>엔</option>");
			pw.print("<option value ='wian'>위안</option>");
			pw.print("<option value ='pound'>파운드</option>");
			pw.print("<option value ='euro'>유로</option>");
			pw.print("</select>");
			//hidden 태그를 이용해 계산기에서 서블릿으로 수행할 요청 전달
			pw.print("<input type='hidden' name='command' value = 'calculate'>");
			pw.println("<input type='submit' value='변환'>");
			pw.println("</form>");
			pw.println("</html>");
			pw.close();
	}
	
	private static String calculate(float won, String operator) {
		String result = null;
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won / USD_RATE);
		} else if(operator.equals("en")) {
			result = String.format("%.6f", won / JPY_RATE);
		} else if(operator.equals("wian")) {
			result = String.format("%.6f", won / CNY_RATE);
		} else if(operator.equals("pound")) {
			result = String.format("%.6f", won / GBP_RATE);
		} else if(operator.equals("euro")) {
			result = String.format("%.6f", won / EUR_RATE);
		}
		
		return result;
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

}
