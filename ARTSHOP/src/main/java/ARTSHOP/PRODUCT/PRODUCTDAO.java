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

public class PRODUCTDAO {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	private static PRODUCTDAO pdao;
	
	public PRODUCTDAO() {
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
	
	public static PRODUCTDAO getInstance() {
		if(pdao==null) {
			pdao = new PRODUCTDAO();
		}
		return pdao;
	}//getInstance
	
	public ArrayList<PRODUCTDTO> getAllProduct() {
		String sql = "select * from artshop_product";
		ArrayList<PRODUCTDTO> lists = new ArrayList<PRODUCTDTO>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				PRODUCTDTO pdto = new PRODUCTDTO();
				pdto.setPronum(rs.getInt("pronum"));
				pdto.setProsub(rs.getString("prosub"));
				pdto.setProwri(rs.getString("prowri"));
				pdto.setProcat(rs.getString("procat"));
				pdto.setProcon(rs.getString("procon"));
				pdto.setPropri(rs.getInt("propri"));
				pdto.setProingslot(rs.getInt("proingslot"));
				pdto.setProallslot(rs.getInt("proallslot"));
				
				lists.add(pdto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lists;
	}//getAllProduct
	
	public ArrayList<PRODUCTDTO> getProductById(String smemid){
		String sql1 = "select memnick from artshop_member where memid=?";
		String sql2 = "select * from artshop_product where prowri=?";
		String memnick = null;
		ArrayList<PRODUCTDTO> lists = new ArrayList<PRODUCTDTO>();
		
		try {
			ps = conn.prepareStatement(sql1);
			ps.setString(1, smemid);
			rs = ps.executeQuery();
			if(rs.next()) {
				memnick = rs.getString("memnick");
			}//if
			ps = conn.prepareStatement(sql2);
			ps.setString(1, memnick);
			rs = ps.executeQuery();
			while(rs.next()) {
				PRODUCTDTO pdto = new PRODUCTDTO();
				pdto.setPronum(rs.getInt("pronum"));
				pdto.setProsub(rs.getString("prosub"));
				pdto.setProwri(rs.getString("prowri"));
				pdto.setProcat(rs.getString("procat"));
				pdto.setProcon(rs.getString("procon"));
				pdto.setPropri(rs.getInt("propri"));
				pdto.setProingslot(rs.getInt("proingslot"));
				pdto.setProallslot(rs.getInt("proallslot"));
				
				lists.add(pdto);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}//getProductById
}
