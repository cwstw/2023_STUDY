package myPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDao {
	Connection conn =null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	
	private static BookDao bdao;
	
	public static BookDao getInstance() {
		if(bdao == null) {
			bdao = new BookDao();
			System.out.println("按眉 积己");
		}
		return bdao;
	}//教臂沛菩畔 牢胶畔胶 积己
	
	private BookDao(){
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
			System.out.println("conn : "+conn);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//积己磊
	
	public void insertBook(BookBean bb) {
		String sql = "insert into book values(bseq.nextval,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, bb.getTitle());
			ps.setString(2, bb.getAuthor());
			ps.setInt(3, bb.getPrice());
			
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
	}//insertBook
	
	public ArrayList<BookBean> getAllBook(){
		String sql = "select * from book order by asc";
		ArrayList<BookBean> list = new ArrayList<BookBean>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BookBean bb = new BookBean();
				bb.setNo(rs.getInt("no"));
				bb.setTitle(rs.getString("title"));
				bb.setAuthor(rs.getString("author"));
				bb.setPrice(rs.getInt("price"));
				
				list.add(bb);
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
	}//finally
		return list;
	}//getallbook
	
	public void deleteBook(int no) {
		String sql = "delete from book where no=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			
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
	}//deletebook
	
	public BookBean getBookByNo(int no) {
		String sql = "select * from book where no=?";
		BookBean bb = null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				bb = new BookBean();
				bb.setNo(rs.getInt("no"));
				bb.setTitle(rs.getString("title"));
				bb.setAuthor(rs.getString("author"));
				bb.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bb;
	}//getbookbyno
	
	public void updateBook(BookBean bb) {
		String sql = "update book set title=?, author=?, price=? where no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bb.getTitle());
			ps.setString(2, bb.getAuthor());
			ps.setInt(3, bb.getPrice());
			ps.setInt(4, bb.getNo());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
	}//updatebook
	
	
	
}
