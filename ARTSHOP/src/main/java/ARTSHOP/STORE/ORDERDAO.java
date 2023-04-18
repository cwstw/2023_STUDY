package ARTSHOP.STORE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ORDERDAO {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	private static ORDERDAO odao;
	
	public ORDERDAO() {
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
	
	public static ORDERDAO getInstance() {
		if(odao==null) {
			odao = new ORDERDAO();
		}
		return odao;
	}//getInstance
	
	
}
