package myPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	MemberDao(){
		try {
			Class.forName(driver);
			System.out.println("driver 성공");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("login 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("driver 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("login 실패");
			e.printStackTrace();
		}
	}//MemberDao생성자
	
	public void insertData(MemberBean mb) {
		String sql = "insert into member values(mseq.nextval,?,?)";
		int cnt = -1;
		try {
			ps =conn.prepareStatement(sql);
			ps.setString(1, mb.getName());
			ps.setString(2, mb.getPassword());
			
			cnt = ps.executeUpdate();
			System.out.println("성공 : "+cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
	}//insertData
	public ArrayList<MemberBean> getAllMember(){
		String sql = "select * from member";
		ArrayList<MemberBean> mlist = new ArrayList<MemberBean>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberBean mb = new MemberBean();
				mb.setNo(rs.getInt("no"));
				mb.setName(rs.getString("name"));
				mb.setPassword(rs.getString("password"));
				
				mlist.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
					conn.close();
			}
			if(rs!=null) {
				rs.close();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		
		return mlist;
	}//getallmember
	
	public void deleteMember(int no) {
		String sql = "delete member where no=?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			
			cnt = ps.executeUpdate();
			System.out.println("성공 : "+cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
					conn.close();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
	}//deletemember
}
