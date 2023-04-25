package svy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SurveyDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id="jspid";
	String pw ="jsppw";
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	SurveyDao(){
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("계정 로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("계정 로드 실패");
			e.printStackTrace();
		}
	}//생성자
	
	public void insertSurvey(SurveyBean sb) {
		String sql = "insert into survey values(sseq.nextval,?,?,?,?,?,?,?)";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getCompany());
			ps.setString(3, sb.getEmail());
			ps.setString(4, sb.getSatisfaction());
			ps.setString(5, sb.getPart());
			ps.setString(6, sb.getHowto());
			ps.setInt(7, sb.getAgree());
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("성공 : "+cnt);
	}//insertSurvey
	
	public ArrayList<SurveyBean> getAllSurvey(){
		String sql = "select * from survey order by asc";
		ArrayList<SurveyBean> list = new ArrayList<SurveyBean>();
		try {
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				SurveyBean sb = new SurveyBean();
				
				sb.setNo(rs.getInt("no"));
				sb.setName(rs.getString("name"));
				sb.setCompany(rs.getString("company"));
				sb.setEmail(rs.getString("email"));
				sb.setSatisfaction(rs.getString("satisfaction"));
				sb.setPart(rs.getString("part"));
				sb.setHowto(rs.getString("howto"));
				sb.setAgree(rs.getInt("agree"));
				
				list.add(sb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}//getAllSurvey
}
