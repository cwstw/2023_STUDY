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

import com.oreilly.servlet.MultipartRequest;

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
				
				lists.add(pdto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lists;
	}//getAllProduct
	
	public ArrayList<PRODUCTDTO> getProductByNick(String memnick){
		String sql2 = "select * from artshop_product where prowri=?";
		ArrayList<PRODUCTDTO> lists = new ArrayList<PRODUCTDTO>();
		
		try {
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
				
				lists.add(pdto);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}//getProductById
	
	public String getNicknameById(String smemid){
		String sql = "select memnick from artshop_member where memid=?";
		String memnick = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, smemid);
			rs = ps.executeQuery();
			if(rs.next()) {
				memnick = rs.getString("memnick");
			}//if
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memnick;
	}//getProductById
	
	public int insertProduct(PRODUCTDTO pdto) {
		String sql = "insert into artshop_product values(artshop_proseq.nextval, ?, ?, ?, ?, ?)";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pdto.getProsub());
			ps.setString(2, pdto.getProwri());
			ps.setString(3, pdto.getProcat());
			ps.setString(4, pdto.getProcon());
			ps.setInt(5, pdto.getPropri());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}//insertProduct
}
