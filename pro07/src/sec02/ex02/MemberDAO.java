package sec02.ex02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			//JNDI에 접근하기 위해 기본 경로를 지정
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			//톰캣 context.xml에서 설정한 name값을 이용해 톰캣이 미리 연결한 DataSource를 받아온다.
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			//DataSource를 이용해 데이터 베이스와 연결
			con = dataFactory.getConnection();
			String query = "SELECT * FROM T_MEMBER";
			System.out.println("preparedStatement:" +query);
			pstmt = con.prepareStatement(query);
			//executeQuery() = 수행결과로 ResultSet객체의 값을 반환.
			//select 구문을 수행할 때 사용되는 함수
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
	
	public void addMember(MemberVO vo) {
		try {
			//DataSource를 이용해 DB와 연결
			con = dataFactory.getConnection();
			
			String query = "INSERT INTO T_MEMBER("
					+ "ID, PWD, NAME, EMAIL"
					+ ")VALUES(?,?,?,?)";
			
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			//?에 대응하는 값을 지정
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			
			//수행결과로 int 타입 값을 반환
			//select구문을 제외한 다른 구문을 수행할 때 사용되는 함수
			//insert/delete/update 관련 구문에서는 반영된 레코드의 건수를 반환
			//creat/drop구문에서는 -1을 반환
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {
		try {
			//DataSource를 이용해 DB와 연결
			con = dataFactory.getConnection();
			
			String query = "DELETE FROM T_MEMBER"
					+ " WHERE ID = ?";
			
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
