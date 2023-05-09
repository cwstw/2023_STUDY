package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dto.FDto;

public class FDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public FDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("계정 연결 실패");
			e.printStackTrace();
		}
	}
	
	private static FDao fdao;
	
	public static FDao getInstance() {
		if(fdao == null)
			fdao = new FDao();
		return fdao;
	}//getInstance

	public void insertFootball(FDto fdto) {
		String sql = "insert into football values(fb_seq.nextval,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fdto.getId());
			ps.setString(2, fdto.getPw());
			ps.setString(3, fdto.getWin());
			ps.setString(4, fdto.getRound16());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//insertFb

	public ArrayList<String> getAllFootball() {
		String sql = "select * form football";
		ArrayList<String> list = new ArrayList<String>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				FDto fdto = new FDto();
				fdto.setNum(rs.getInt("num"));
				fdto.setId(rs.getString("id"));
				fdto.setPw(rs.getString("pw"));
				fdto.setWin(rs.getString("win"));
				fdto.setRound16(rs.getString("round16"));
				
				list.add(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public FDto getFootballByNum (String num) {
		String sql = "select * from football where num=?";
		FDto fd = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				fd = new FDto();
				fd.setNum(rs.getInt("num"));
				fd.setId(rs.getString("id"));
				fd.setPw(rs.getString("pw"));
				fd.setWin(rs.getString("win"));
				fd.setRound16(rs.getString("round16"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fd;
	}//getfootballbynum

	public void updateFootball(FDto fdto) {
		String sql = "update football set id=?, pw=?, win=?, round16=? where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fdto.getId());
			ps.setString(2, fdto.getPw());
			ps.setString(3, fdto.getWin());
			ps.setString(4, fdto.getRound16());
			ps.setInt(5, fdto.getNum());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delelteFootball(String num) {
		String sql = "delete football where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
