package com.spring.ex.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.Dto.PDto;

public class PDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url ="jdbc:oracle:thin:@localhost:1521:orcl";
	String id="jspid";
	String pw="jsppw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public PDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("계정 연결 실패");
			e.printStackTrace();
		}
	}//생성자
	
	private static PDao pdao;
	
	public static PDao getInstance() {
		if(pdao==null) 
			pdao = new PDao();
		return pdao;
	}//getInstance

	public void write(String id2, String name, String age) {
		String sql = "insert into person values(pseq.nextval,?,?,?)";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id2);
			ps.setString(2, name);
			ps.setString(3, age);
			
			cnt = ps.executeUpdate();
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
		if(cnt!=0)
			System.out.println("insert 성공");
	}//write

	public ArrayList<PDto> getAllPerson() {
		String sql = "select * from person";
		ArrayList<PDto> list = new ArrayList<PDto>();
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				PDto pd = new PDto();
				pd.setNum(rs.getInt("num"));
				pd.setId(rs.getString("id"));
				pd.setName(rs.getString("name"));
				pd.setAge(rs.getInt("age"));
				
				list.add(pd);
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
		return list;
	}//getAllPerson


	public PDto getPersonByNum(String num) {
		String sql = "select * from person where num=?";
		PDto pd=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				pd = new PDto();
				pd.setId(rs.getString("id"));
				pd.setName(rs.getString("name"));
				pd.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return pd;
	}

	public void updatePerson(HttpServletRequest request) {
		String sql = "update person set id=?, name=?, age=? where num=?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, request.getParameter("id"));
			ps.setString(2, request.getParameter("name"));
			ps.setString(3, request.getParameter("age"));
			ps.setString(4, request.getParameter("num"));
			
			cnt = ps.executeUpdate();
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
		if(cnt>0)
			System.out.println("update 성공");
	}

	public void deletePerson(HttpServletRequest request) {
		String sql = "delete person where num=?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
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
	
}
