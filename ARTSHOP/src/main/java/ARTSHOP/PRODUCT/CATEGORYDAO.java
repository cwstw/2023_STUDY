package ARTSHOP.PRODUCT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CATEGORYDAO {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	private static CATEGORYDAO cdao;
	
	public CATEGORYDAO() {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
			System.out.println("conn:" + conn);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//생성자
	
	public static CATEGORYDAO getInstance() {
		if(cdao==null) {
			cdao = new CATEGORYDAO();
		}
		return cdao;
	}//getInstance
	
	public ArrayList<CATEGORYDTO> getAllCategory(){
		String sql = "select * from artshop_category";
		ArrayList<CATEGORYDTO> lists = new ArrayList<CATEGORYDTO>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CATEGORYDTO cat = new CATEGORYDTO();
				cat.setCatnum(rs.getInt("catnum"));
				cat.setCatname(rs.getString("catname"));
				
				lists.add(cat);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}//getAllCategory
}
