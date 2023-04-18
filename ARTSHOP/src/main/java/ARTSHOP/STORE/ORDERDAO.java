package ARTSHOP.STORE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public int insertOrder(ORDERDTO odto, String memnum, String pronum, String propri) {
		String sql="insert into artshop_order values(artshop_ordseq.nextval,?,?,?,?,?,?)";
		int cnt=-1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memnum);
			ps.setInt(2, Integer.parseInt(pronum));
			ps.setInt(3, Integer.parseInt(propri));
			ps.setString(4, odto.getOrdask());
			ps.setString(5, odto.getOrdemail());
			ps.setString(6, odto.getOrdstat());
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}//insertOrder
	
	public ArrayList<ORDERDTO> getAllOrderByNum(int memnum){
		String sql ="select * from artshop_order where memnum=?";
		ArrayList<ORDERDTO> lists = new ArrayList<ORDERDTO>();
		
		try {
			ps =conn.prepareStatement(sql);
			ps.setInt(1, memnum);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ORDERDTO odto = new ORDERDTO();
				odto.setOrdnum(rs.getInt("ordnum"));
				odto.setMemnum(rs.getInt("memnum"));
				odto.setPronum(rs.getInt("pronum"));
				odto.setOrdpri(rs.getInt("ordpri"));
				odto.setOrdask(rs.getString("ordask"));
				odto.setOrdemail(rs.getString("ordemail"));
				odto.setOrdstat(rs.getString("ordstat"));
				
				lists.add(odto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}//getAllOrder()
	
	public int updateOrdstat(String ordnum) {
		String sql = "update artshop_order set ordstat='완료' where ordnum=?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ordnum);
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}//updateOrdstat(pronum)
	
	public int updateOrdstat2(String ordnum) {
		String sql = "update artshop_order set ordstat='전송' where ordnum=?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ordnum);
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}//updateOrdstat2(pronum)
	
	public String getOrdstatByNum(int ordnum) {
		String sql = "select ordstat from artshop_order where ordnum=?";
		String ordstat=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ordnum);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				ordstat = rs.getString("ordstat");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordstat;
	}//getOrdstatByNum(lists.get(i).getOrdnum())
	
	
}
