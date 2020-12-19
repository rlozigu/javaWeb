package sec01.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String user = "JAVAWEB";
	private static final String pwd = "javaweb";
	//PreparedStatemen 인터페이스는 Statement 인터페이스를 상속
	//컴파일된 SQL문을 전달하여 성능을 향상시킴
	//SQL문에 ?를 넣을 수 있음
	private PreparedStatement pstmt;
	private Connection con;
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			//네 가지 정보로 데이터베이스를 연결
			connDB();
			String query = "SELECT * FROM T_MEMBER";
			System.out.println("preparedStatement: "+query);
			
			//prepareStatement메서드에 SQL문을 전달해서 preparedStatment 객체 생성
			pstmt = con.prepareStatement(query);
			
			//exexuteQuery() 메서드를 호출해 미리 설정한 SQL문을 실행
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
