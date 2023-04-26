package svy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SurveyDao {
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public SurveyDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertSurvey(SurveyBean sb) {
		String sql="insert into Survey values(sseq.nextval,?,?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getCompany());
			ps.setString(3, sb.getEmail());
			ps.setString(4, sb.getSatisfaction());
			ps.setString(5, sb.getPart());
			ps.setString(6, sb.getHowto());
			ps.setInt(7, sb.getAgree());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<SurveyBean> getAllSurvey() {
		ArrayList<SurveyBean> list = new ArrayList<SurveyBean>();
		String sql = "select * from survey order by no";
		try {
			ps = conn.prepareStatement(sql);
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
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(list.size());
		return list;
	}

	public void deleteSurvey(String no) {
		String sql = "delete from survey where no=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, no);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public SurveyBean getOneSurvey(String no) {
		SurveyBean sb = new SurveyBean();
		String sql="select * from survey where no=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, no);
			rs=ps.executeQuery();
			if(rs.next()) {
				sb.setNo(rs.getInt("no"));
				sb.setName(rs.getString("name"));
				sb.setCompany(rs.getString("company"));
				sb.setEmail(rs.getString("email"));
				sb.setSatisfaction(rs.getString("satisfaction"));
				sb.setPart(rs.getString("part"));
				sb.setHowto(rs.getString("howto"));
				sb.setAgree(rs.getInt("agree"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(rs!=null) {
					rs.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sb;
	}
}






