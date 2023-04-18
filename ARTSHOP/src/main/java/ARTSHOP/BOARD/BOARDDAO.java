package ARTSHOP.BOARD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BOARDDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "jspid";
	String dbpw = "jsppw";
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	private static BOARDDAO bdao;
	
	public static BOARDDAO getInstance() {
		if(bdao == null) {
			bdao = new BOARDDAO();
			System.out.println("객체 생성");
		}
		return bdao;
	}//getInstance
	
	private BOARDDAO() {
		//System.out.println("BoardDao 객체 생성");
		try {
			Class.forName(driver);
			System.out.println("driver load success");
			conn = DriverManager.getConnection(url,dbid,dbpw);
			System.out.println("db load success");
		} catch (ClassNotFoundException e) {
			System.out.println("driver load failed");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("db load failed");
			e.printStackTrace();
		}
	}//BoardDao 생성자
	
	public ArrayList<BOARDDTO> getArticles(int start, int end){
		//1페이지 : 1,5
		//2페이지 : 6,10
		ArrayList<BOARDDTO> lists = new ArrayList<BOARDDTO>();

		//3.sql문 작성, 분석
		String sql = "select num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level, content, ip " ;		        
		sql += "from (select rownum as rank, num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level, content, ip ";
		sql += "from (select num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level, content, ip ";
		sql += "from board  ";
		sql += "order by ref desc, re_step asc )) ";
		sql += "where rank between ? and ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,start);
			ps.setInt(2,end);
			
			if (ps != null)
				System.out.println("SQL문 분석 성공");
			else
				System.out.println("SQL문 분석 실패");

			//4.sql문 실행
			rs = ps.executeQuery();
			if (rs != null)
				System.out.println("select 실행 성공");
			else
				System.out.println("select 실행 실패");

			while(rs.next()){
				BOARDDTO bb = new BOARDDTO();

				bb.setNum(rs.getInt("num"));
				bb.setWriter(rs.getString("writer"));
				bb.setEmail(rs.getString("email"));
				bb.setSubject(rs.getString("subject"));
				bb.setPasswd(rs.getString("passwd"));
				bb.setReg_date(rs.getTimestamp("reg_date"));
				bb.setReadcount(rs.getInt("ref"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setRe_step(rs.getInt("re_step"));
				bb.setRe_level(rs.getInt("re_level"));
				bb.setContent(rs.getString("content"));
				bb.setIp(rs.getString("ip"));

				lists.add(bb);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//5.자원 반납
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally

		return lists;
	}//getArticles

	public int getArticleCount() {
		String sql = "select count(*) as cnt from board";
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("레코드 갯수 : "+count);
		return count;
	}//getarticlecount
	
	//원글쓰기
	public int insertArticle(BOARDDTO bb) { // 5+2
		int cnt = -1;
		String sql = "insert into board(num,writer,subject,email,content,passwd,reg_date,ref,re_step,re_level,ip) "
				+ "values(board_seq.nextval,?,?,?,?,?,?,board_seq.currval,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bb.getWriter());
			ps.setString(2, bb.getSubject());
			ps.setString(3, bb.getEmail());
			ps.setString(4, bb.getContent());
			ps.setString(5, bb.getPasswd());
			ps.setTimestamp(6, bb.getReg_date());
			ps.setInt(7, 0); // re_step
			ps.setInt(8, 0); // re_level
			ps.setString(9, bb.getIp());

			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;

	}//insertArticle
	
	public BOARDDTO getArticleByNum(String num) {
		BOARDDTO bb = new BOARDDTO();
		//조회수 먼저 증가
		String sql2 = "update board set readcount = readcount+1 where num="+num;
		String sql="select * from board where num="+num;
		
		try {
			ps = conn.prepareStatement(sql2);
			ps.executeUpdate();
			
			ps = conn.prepareStatement(sql);			
			rs = ps.executeQuery();
			
			if(rs.next()){
				bb.setNum(rs.getInt("num"));
				bb.setWriter(rs.getString("writer"));
				bb.setEmail(rs.getString("email"));
				bb.setSubject(rs.getString("subject"));
				bb.setPasswd(rs.getString("passwd"));
				bb.setReg_date(rs.getTimestamp("reg_date"));
				bb.setReadcount(rs.getInt("ref"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setRe_step(rs.getInt("re_step"));
				bb.setRe_level(rs.getInt("re_level"));
				bb.setContent(rs.getString("content"));
				bb.setIp(rs.getString("ip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bb;
	}//getArticleByNum
	
	public BOARDDTO getContentByNum(String num) {
		BOARDDTO bb = new BOARDDTO();
		//조회수 먼저 증가
		String sql="select * from board where num="+num;
		
		try {
			ps = conn.prepareStatement(sql);			
			rs = ps.executeQuery();
			
			if(rs.next()){
				bb.setNum(rs.getInt("num"));
				bb.setWriter(rs.getString("writer"));
				bb.setEmail(rs.getString("email"));
				bb.setSubject(rs.getString("subject"));
				bb.setPasswd(rs.getString("passwd"));
				bb.setReg_date(rs.getTimestamp("reg_date"));
				bb.setReadcount(rs.getInt("ref"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setRe_step(rs.getInt("re_step"));
				bb.setRe_level(rs.getInt("re_level"));
				bb.setContent(rs.getString("content"));
				bb.setIp(rs.getString("ip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bb;
	}//getcontentbynum
	
	public int updateArticle(BOARDDTO bb) {
		System.out.println("입력한 비밀번호 : "+bb.getPasswd());
		String sql = "select passwd from board where num=?";
		String sql2 = "update board set writer=?, subject=?, email=?, content=? where num=?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bb.getNum());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String pw = rs.getString("passwd");
				if(pw.equals(bb.getPasswd())) {//입력비번==수정비번
					ps = conn.prepareStatement(sql2);
					
					ps.setString(1, bb.getWriter());
					ps.setString(2, bb.getSubject());
					ps.setString(3, bb.getEmail());
					ps.setString(4, bb.getContent());
					ps.setInt(5, bb.getNum());
					
					cnt = ps.executeUpdate();
				}//if
			}//if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(ps != null) {
						ps.close();
					}
					if(rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}//finally
		return cnt;
	}//updateArticle
	
	public int deleteArticle(String num, String passwd) {
		String sql = "select passwd from board where num="+num;
		String sql2 = "delete from board where num="+num;
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String pw = rs.getString("passwd");
				if(pw.equals(passwd)) {//입력비번==수정비번
					ps = conn.prepareStatement(sql2);
					cnt = ps.executeUpdate();
				}//if
			}//if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(ps != null) {
						ps.close();
					}
					if(rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}//finally
		return cnt;
	}//deleteArticle
	
	public int replyArticle(BOARDDTO bb) {
		//10가지 정보 (7가지 : 답글/3가지 : 부모정보)
		//update 후에 insert
		int re_step,re_level;
		String sql = "update board set re_step=re_step+1 where ref=? and re_step>?";
		String sql2 = "insert into board(num,writer,subject,email,content,passwd,reg_date,ref,re_step,re_level,ip) "
				+ "values(board_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bb.getRef());
			ps.setInt(2, bb.getRe_step());
			ps.executeUpdate();
			
			re_step = bb.getRe_step()+1;
			re_level = bb.getRe_level()+1;
			
			ps = conn.prepareStatement(sql2);
			
			ps.setString(1, bb.getWriter());
			ps.setString(2, bb.getSubject());
			ps.setString(3, bb.getEmail());
			ps.setString(4, bb.getContent());
			ps.setString(5, bb.getPasswd());
			ps.setTimestamp(6, bb.getReg_date());
			ps.setInt(7, bb.getRef()); //ref
			ps.setInt(8, re_step); // re_step
			ps.setInt(9, re_level); // re_level
			ps.setString(10, bb.getIp());
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}//finally
		
		return cnt;
	}//replyArticle
}


