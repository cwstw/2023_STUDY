package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.MDto;

public class MDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:@localhost:1521:orcl";
	String jspid = "jspid";
	String jsppw = "jsppw";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public MDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,jspid,jsppw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//try
	}//생성자
	
	private static MDao mdao;
	
	public static MDao getInstance() {
		if(mdao==null)
			mdao = new MDao();
		return mdao;
	}//getInstance

	public void insertForm(MDto mdto) {
		String sql = "insert into mart values(e_seq.nextval,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getId());
			ps.setString(2, mdto.getPw());
			ps.setString(3, mdto.getProduct());
			ps.setString(4, mdto.getTime());
			ps.setString(5, mdto.getApprove());
			ps.setString(6, mdto.getAgree());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
	}//insertform
	
	public ArrayList<MDto> getAllMart(){
		String sql = "select * from mart";
		ArrayList<MDto> lists =  new ArrayList<MDto>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MDto mdto = new MDto();
				mdto.setNum(rs.getInt("num"));
				mdto.setId(rs.getString("id"));
				mdto.setPw(rs.getString("pw"));
				mdto.setProduct(rs.getString("product"));
				mdto.setTime(rs.getString("time"));
				mdto.setApprove(rs.getString("approve"));
				mdto.setAgree(rs.getString("agree"));
				
				lists.add(mdto);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		return lists;
	}//getallmart

	public MDto getMartByNum(String num) {
		String sql = "select * form mart where num=?";
		MDto mdto = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				mdto.setNum(rs.getInt("num"));
				mdto.setId(rs.getString("id"));
				mdto.setPw(rs.getString("pw"));
				mdto.setProduct(rs.getString("product"));
				mdto.setTime(rs.getString("time"));
				mdto.setApprove(rs.getString("approve"));
				mdto.setAgree(rs.getString("agree"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		return mdto;
	}//getMartByNum

	public void updateForm(MDto mdto) {
		String sql = "update mart set id=?, pw=?, product=?, time=?, approve=?, agree=? where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getId());
			ps.setString(2, mdto.getPw());
			ps.setString(3, mdto.getProduct());
			ps.setString(4, mdto.getTime());
			ps.setString(5, mdto.getApprove());
			ps.setString(6, mdto.getAgree());
			ps.setInt(7, mdto.getNum());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		
	}

	public void deleteMart(String num) {
		String sql = "delete mart where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
	}
	
	
	
	
}
