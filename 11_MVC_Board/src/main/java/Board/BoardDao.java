package Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url ="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid="jspid";
	String dbpw="jsppw";
	Connection conn = null ;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static BoardDao bdao;

	public static BoardDao getInstance() {
		if(bdao==null) {
			bdao = new BoardDao();
			System.out.println("��ü ����");
		}
		return bdao;
	}

	private BoardDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,dbid,dbpw);
			System.out.println(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//

	public int getArticleCount(){

		int count = 0;
		String sql = "select count(*) as cnt from board";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} try {
			if(ps != null)
				ps.close();
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("��ü ���ڵ� ����:" + count);
		return count;
	}//getArticleCount


	public ArrayList<BoardBean> getArticles(int start, int end){
		//		1������ : 1,5
		//		2������ : 6,10

		ArrayList<BoardBean> lists = new ArrayList<BoardBean>();

		//3.sql�� �ۼ�, �м�
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
				System.out.println("SQL�� �м� ����");
			else
				System.out.println("SQL�� �м� ����");

			//4.sql�� ����
			rs = ps.executeQuery();
			if (rs != null)
				System.out.println("select ���� ����");
			else
				System.out.println("select ���� ����");

			while(rs.next()){
				BoardBean bb = new BoardBean();

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
			//5.�ڿ� �ݳ�
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
	}//getArticles

	//���۾���
	public int insertArticle(BoardBean bb) { // 5+2
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

	public BoardBean getArticleByNum(String num) {

		String sql2 = "update board set readcount = readcount+1 where num=?";


		BoardBean bb = new BoardBean();
		String sql = "select * from board where num=?";
		try {

			ps = conn.prepareStatement(sql2);
			ps.setString(1, num);
			ps.executeUpdate();

			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				bb.setNum(rs.getInt("num"));
				bb.setWriter(rs.getString("writer"));
				bb.setEmail(rs.getString("email"));
				bb.setSubject(rs.getString("subject"));
				bb.setPasswd(rs.getString("passwd"));
				bb.setReg_date(rs.getTimestamp("reg_date"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setRef(rs.getInt("ref"));
				bb.setRe_step(rs.getInt("re_step"));
				bb.setRe_level(rs.getInt("re_level"));
				bb.setContent(rs.getString("content"));
				bb.setIp(rs.getString("ip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bb;
	}//getArticleByNum

	public BoardBean getContentByNum(String num){

		BoardBean bb = new BoardBean();
		String sql = "select * from board where num=?";
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				bb.setNum(rs.getInt("num"));
				bb.setWriter(rs.getString("writer"));
				bb.setEmail(rs.getString("email"));
				bb.setSubject(rs.getString("subject"));
				bb.setPasswd(rs.getString("passwd"));
				bb.setReg_date(rs.getTimestamp("reg_date"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setRef(rs.getInt("ref"));
				bb.setRe_step(rs.getInt("re_step"));
				bb.setRe_level(rs.getInt("re_level"));
				bb.setContent(rs.getString("content"));
				bb.setIp(rs.getString("ip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bb;
	}

	public int updateArticle(BoardBean bb){ // 5+1
		System.out.println(bb.getPasswd()); // ����form���� �Է��� ���

		int cnt = -1;

		String sql = "select passwd from board where num=?";
		String sql2 = "update board set writer=?, email=?, "
				+ "subject=?,content=? where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bb.getNum());
			rs = ps.executeQuery();
			if(rs.next()) {
				String dbpw = rs.getString("passwd");
				if(dbpw.equals(bb.getPasswd())) { // �Է��Ѻ�� == db���

					ps = conn.prepareStatement(sql2);
					ps.setString(1, bb.getWriter());
					ps.setString(2, bb.getEmail());
					ps.setString(3, bb.getSubject());
					ps.setString(4, bb.getContent());
					ps.setInt(5, bb.getNum());
					cnt = ps.executeUpdate();

				}else {

				}
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
				e.printStackTrace();
			}
		}

		return cnt;
	}//updateArticle

	public int deleteArticle(String num, String passwd) {
		String sql = "select passwd from board where num=?";
		String sql2 = "delete board where num=?";
		int cnt = -1;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				dbpw = rs.getString("passwd"); 
				if(dbpw.equals(passwd)) { // �Է��Ѻ�� == db���
					ps = conn.prepareStatement(sql2);
					ps.setString(1, num);
					cnt = ps.executeUpdate();
				}
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
				e.printStackTrace();
			}
		}
		return cnt;
	}//deleteArticle
	
	public int replyArticle(BoardBean bb){
		//10���� ������ �Ѿ��
//		7���� : ���
//		3���� : �θ�����(ref,re_step,re_level)
//		
//		update~
//		insert 
		int re_step,re_level,cnt = -1;
		
		String sql = "update board set re_step=re_step+1 where ref=? and re_step>?";
		String sql2 = "insert into board(num,writer,subject,email,content,passwd,reg_date,ref,re_step,re_level,ip) "
				+ "values(board_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bb.getRef());
			ps.setInt(2, bb.getRe_step());
			ps.executeUpdate();
			
			re_step = bb.getRe_step() + 1;
			re_level = bb.getRe_level() + 1;

			ps = conn.prepareStatement(sql2);
			ps.setString(1, bb.getWriter());
			ps.setString(2, bb.getSubject());
			ps.setString(3, bb.getEmail());
			ps.setString(4, bb.getContent());
			ps.setString(5, bb.getPasswd());
			ps.setTimestamp(6, bb.getReg_date());
			ps.setInt(7, bb.getRef()); // ref
			ps.setInt(8, re_step); // re_step
			ps.setInt(9, re_level); // re_level
			ps.setString(10, bb.getIp());
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
		
	}
}

