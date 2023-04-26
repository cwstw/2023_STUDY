package myPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static MovieDao mdao;
	
	public static MovieDao getInstance() {
		if(mdao == null) {
			mdao = new MovieDao();
		}
		return mdao;
	}
	// MovieDao.getInstance()
	
	private MovieDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"jspid","jsppw");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로드실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("계정로드실패");
			e.printStackTrace();
		}
	}//MovieDao


	public ArrayList<MovieBean> getAllMovie(){
		ArrayList <MovieBean> lists= new ArrayList<MovieBean>();


		String sql = "select * from movie order by num";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieBean mb = new MovieBean();

				mb.setNum(rs.getInt("num"));
				mb.setId(rs.getString("id"));
				mb.setName(rs.getString("name"));
				mb.setAge(rs.getInt("age"));
				mb.setGenre(rs.getString("genre"));
				mb.setTime(rs.getString("time"));
				mb.setPartner(rs.getInt("partner"));
				mb.setMemo(rs.getString("memo"));

				lists.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
//				if(conn!=null)
//					conn.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}//getAllMovie

	public boolean searchId(String userid) {
		boolean flag = false;
		String sql = "select * from movie where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);

			rs = ps.executeQuery();

			if(rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(conn!=null)
//					conn.close();
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}//


	public int insertMovie(MovieBean mb) {
		int cnt = -1;
		String sql = "insert into movie values(mv_seq.nextval,?,?,?,?,?,?,?)";
		try {
			//3. SQL 遺꾩꽍
			ps= conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getName());
			ps.setInt(3, mb.getAge());
			ps.setString(4, mb.getGenre());
			ps.setString(5, mb.getTime());
			ps.setInt(6, mb.getPartner());
			ps.setString(7, mb.getMemo());

			//4. SQL �떎�뻾
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//				if(conn != null)
//					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}//insertMovie

	public MovieBean getMovieByNo(String num) {
		String sql = "select * from movie where num=?";
		MovieBean mb = new MovieBean();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();

			if(rs.next()) {
				mb.setNum(rs.getInt("num"));
				mb.setId(rs.getString("id"));
				mb.setName(rs.getString("name"));
				mb.setAge(rs.getInt("age"));
				mb.setGenre(rs.getString("genre"));
				mb.setTime(rs.getString("time"));
				mb.setPartner(rs.getInt("partner"));
				mb.setMemo(rs.getString("memo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(conn!=null)
//					conn.close();
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mb;
	}//getMovieByNo

	public int updateMovie(MovieBean mb) {
		int cnt=-1;
		String sql="update movie set id=?,name=?,age=?,genre=?,time=?,partner=?,memo=? where num=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getName());
			ps.setInt(3, mb.getAge());
			ps.setString(4, mb.getGenre());
			ps.setString(5, mb.getTime());
			ps.setInt(6, mb.getPartner());
			ps.setString(7, mb.getMemo());
			ps.setInt(8, mb.getNum());

			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//				if(conn!=null) {
//					conn.close();
//				}
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}//updateMovie
	
	public int deleteMovie(String num){
		int cnt = -1;
		String sql = "delete from movie where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			
			cnt = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps != null) {
					ps.close();
				}
//				if (conn != null) {
//					conn.close();
//				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return cnt;
		
	}//deleteMovie
	
	public int  deleteCheckData(String[] num) {

		int cnt = -1;
		String sql = "delete from movie where num=?";

		try {	
			for(int i=0; i<num.length-1; i++) {
				sql += " or num = ?";
			}
			ps= conn.prepareStatement(sql);
			for(int i=0; i<num.length; i++) {
				ps.setString(i+1, num[i]);
			}
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//				if (conn != null) {
//					conn.close();
//				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
}




