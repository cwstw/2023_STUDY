package ARTSHOP.MEMBER;

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
	
	public MEMBERDTO findPw(MEMBERDTO mdto) {
		String sql = "select * from artshop_member where memid=? and memname=? and memrrn1=? and memrrn2=?";
		
		MEMBERDTO member=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getMemid());
			ps.setString(2, mdto.getMemname());
			ps.setString(3, mdto.getMemrrn1());
			ps.setString(4, mdto.getMemrrn2());
			
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
	}//findpw
	
	public MEMBERDTO getMemberDto(ResultSet rs2) throws SQLException {
		MEMBERDTO member = new MEMBERDTO();
		member.setMemnum(rs.getInt("memnum"));
		member.setMemid(rs.getString("memid"));
		member.setMempw(rs.getString("mempw"));
		member.setMemname(rs.getString("memname"));
		member.setMemnick(rs.getString("memnick"));
		member.setMemrrn1(rs.getString("memrrn1"));
		member.setMemrrn2(rs.getString("memrrn2"));
		member.setMemkind(rs.getString("memkind"));
		member.setMempic(rs.getString("mempic"));
		member.setMempr(rs.getString("mempr"));
		
		return member;
	}//getMemberDto
	
	public boolean searchId(String userid) {
		String sql = "select * from artshop_member where memid=?";
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}//searchId
	
	public int insertMember(MultipartRequest mr) {
		String sql = "insert into artshop_member values(artshop_memseq.nextval,?,?,?,?,?,?,?,?,?)";
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mr.getParameter("memid"));
			ps.setString(2, mr.getParameter("mempw"));
			ps.setString(3, mr.getParameter("memname"));
			ps.setString(4, mr.getParameter("memnick"));
			ps.setString(5, mr.getParameter("memrrn1"));
			ps.setString(6, mr.getParameter("memrrn2"));
			ps.setString(7, mr.getParameter("memkind"));
			ps.setString(8, mr.getFilesystemName("mempic"));
			ps.setString(9, mr.getParameter("mempr"));
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}//insertMember
	
	public MEMBERDTO getMemberInfo(String id, String password) {
		String sql = "select * from artshop_member where memid=? and mempw=?";
		MEMBERDTO member = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member = getMemberDto(rs);
			}//if
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}//getMemberInfo
	
	public ArrayList<MEMBERDTO> getAllMember() {
		ArrayList<MEMBERDTO> lists = new ArrayList<MEMBERDTO>();
		String sql = "select * from artshop_member order by memnum";
		
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MEMBERDTO member = new MEMBERDTO();
				member.setMemnum(rs.getInt("memnum"));
				member.setMemid(rs.getString("memid"));
				member.setMempw(rs.getString("mempw"));
				member.setMemname(rs.getString("memname"));
				member.setMemnick(rs.getString("memnick"));
				member.setMemrrn1(rs.getString("memrrn1"));
				member.setMemrrn2(rs.getString("memrrn2"));
				member.setMemkind(rs.getString("memkind"));
				member.setMempic(rs.getString("mempic"));
				member.setMempr(rs.getString("mempr"));
				
				lists.add(member);
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
	}//getAllMember
	
	public int updateMember(MultipartRequest mr, String memnum) {
		String sql = "update artshop_member set memid=?, mempw=?, memname=?, memnick=?, memrrn1=?, memrrn2=?, memkind=?, mempic=?, mempr=? where memnum=?";
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mr.getParameter("memid"));
			ps.setString(2, mr.getParameter("mempw"));
			ps.setString(3, mr.getParameter("memname"));
			ps.setString(4, mr.getParameter("memnick"));
			ps.setString(5, mr.getParameter("memrrn1"));
			ps.setString(6, mr.getParameter("memrrn2"));
			ps.setString(7, mr.getParameter("memkind"));
			ps.setString(8, mr.getFilesystemName("mempic"));
			ps.setString(9, mr.getParameter("mempr"));
			ps.setString(10, memnum);
			
			cnt = ps.executeUpdate();
			System.out.println("cnt : "+cnt);
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
	}//updateMember
	
	public MEMBERDTO getMemberByMemnum(String memnum) {
		String sql = "select * from artshop_member where memnum=?";
		MEMBERDTO member=null;
		
		try {
			ps =conn.prepareStatement(sql);
			ps.setString(1, memnum);
			
			rs= ps.executeQuery();
			if(rs.next()) {
				member = mdao.getMemberDto(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return member;
	}//getmemberbymemnum
	
	public int deleteMember(String memnum) {
		String sql = "delete artshop_member where memnum=?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, memnum);
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}//deleteMember
	
	public String getNumById(String smemid) {
		String sql = "select memnum from artshop_member where memid=?";
		String memnum=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, smemid);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				memnum = rs.getString("memnum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memnum;
	}//getNumByID(smemid)
	
	public String getNickById(String smemid) {
		String sql = "select memnick from artshop_member where memid=?";
		String memnick=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, smemid);
			
			rs =ps.executeQuery();
			if(rs.next()) {
				memnick = rs.getString("memnick");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memnick;
	}//getNickById(smemid)
}
