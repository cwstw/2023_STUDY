package ARTSHOP.MEMBER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MEMBERDAO {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	private static MEMBERDAO mdao;
	
	public MEMBERDAO() {
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
	
	public static MEMBERDAO getInstance() {
		if(mdao==null) {
			mdao = new MEMBERDAO();
		}
		return mdao;
	}//getInstance
	
	public MEMBERDTO findId(MEMBERDTO mdto) {
		String sql = "select * from artshop_member where memname=? and memrrn1=? and memrrn2=?";
		
		MEMBERDTO member=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getMemname());
			ps.setString(2, mdto.getMemrrn1());
			ps.setString(3, mdto.getMemrrn2());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member = getMemberDto(rs);
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
		}//finally
		
		return member;
	}//findid
	
	public MEMBERDTO getMemberDto(ResultSet rs2) throws SQLException {
		MEMBERDTO member = new MEMBERDTO();
		member.setMemnum(rs.getInt("memnum"));
		member.setMemid(rs.getString("memid"));
		member.setMempw(rs.getString("mempw"));
		member.setMemname(rs.getString("memname"));
		member.setMemrrn1(rs.getString("memrrn1"));
		member.setMemrrn2(rs.getString("memrrn2"));
		member.setMemkind(rs.getString("memkind"));
		member.setMempic(rs.getString("mempic"));
		member.setMempr(rs.getString("mempr"));
		
		return member;
	}//getMemberDto
}
