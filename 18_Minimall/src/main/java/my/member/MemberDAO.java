package my.member;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static MemberDAO mdao;

	public static MemberDAO getInstance() {
		if(mdao==null)
			mdao = new MemberDAO();
		return mdao;
	}
	
	private MemberDAO() {
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
	}


	public boolean searchId(String userid) {
		boolean result = false;
		String sql = "select * from members where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
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
		return result;
	}//

	public int insertMember(MemberDTO mdto) {
		int cnt = -1;
		String sql = "insert into members values(memseq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getName());
			ps.setString(2, mdto.getId());
			ps.setString(3, mdto.getPassword());
			ps.setString(4, mdto.getRrn1());
			ps.setString(5, mdto.getRrn2());
			ps.setString(6, mdto.getEmail());
			ps.setString(7, mdto.getHp1());
			ps.setString(8, mdto.getHp2());
			ps.setString(9, mdto.getHp3());
			ps.setString(10, mdto.getJoindate());

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
	}//insertMember

	public MemberDTO getIdbyRrn(MemberDTO dto){ // 3ê°€ì§€

		String sql = "select * from members where name=? and rrn1=? and rrn2=?";
		MemberDTO member = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getRrn1());
			ps.setString(3, dto.getRrn2());
			rs = ps.executeQuery();

			if(rs.next()) {
				member = getMemberDTO(rs);
			}
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
	}//getIdbyRrn

	private MemberDTO getMemberDTO(ResultSet rs2) throws SQLException {

		MemberDTO member = new MemberDTO();
		member.setNo(rs2.getInt("no"));
		member.setId(rs2.getString("id"));
		member.setPassword(rs2.getString("password"));
		member.setEmail(rs2.getString("email"));
		member.setHp1(rs2.getString("hp1"));
		member.setHp2(rs2.getString("hp2"));
		member.setHp3(rs2.getString("hp3"));
		member.setJoindate(rs2.getString("joindate"));
		member.setName(rs2.getString("name"));
		member.setRrn1(rs2.getString("rrn1"));
		member.setRrn2(rs2.getString("rrn2"));

		return member;
	}//getMemberDTO

	public MemberDTO getPwbyRrnAndName(MemberDTO dto){ // 4ê°€ì§€

		String sql = "select * from members where name=? and rrn1=? and rrn2=? and id=?";
		MemberDTO member = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getRrn1());
			ps.setString(3, dto.getRrn2());
			ps.setString(4, dto.getId());
			rs = ps.executeQuery();

			if(rs.next()) {
				member = getMemberDTO(rs);
			}
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
	}//

	public MemberDTO getMemberInfo(String id, String password) {

		String sql = "select * from members where id=? and password=?";

		MemberDTO member = null;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if(rs.next()) {
				member = getMemberDTO(rs);
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

		return member;
	}//getMemberInfo
}






