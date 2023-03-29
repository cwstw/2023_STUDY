package my.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CategoryDAO {
	//CategryDAO 객체 싱글톤 패턴으로 생성
	// 생성자에서 DBCP 기술 접속

	private static CategoryDAO cdao;
	private Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static CategoryDAO getInstance() {
		if(cdao == null) {
			cdao = new CategoryDAO();
		}
		return cdao;
	}
	private CategoryDAO(){
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//

	public int insertCategory(CategoryBean cb) {
		int cnt = -1;
		String sql = "insert into category values(catseq.nextval,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cb.getCode());
			ps.setString(2, cb.getCname());

			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}//insertCategory

	public ArrayList<CategoryBean> getAllCategory() {
		ArrayList<CategoryBean> lists = new ArrayList<CategoryBean>();
		String sql = "select * from category order by cnum";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int cnum = rs.getInt("cnum");
				String code = rs.getString("code");
				String cname = rs.getString("cname");

				CategoryBean cb = new CategoryBean(cnum,code,cname);
				//				cb.setCnum(cnum);
				//				cb.setCode(code);
				//				cb.setCname(cname);
				lists.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("lists.size() : "+lists.size());
		return lists;

	}//getAllCategory

	public int deleteCategory(String cnum) {
		int cnt=-1;
		String sql = "delete from category where cnum=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, cnum);
			cnt=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}//deleteCategory
}
