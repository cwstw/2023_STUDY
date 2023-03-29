package my.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;
 
public class ProductDAO {
	private static ProductDAO pdao;
	private Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static ProductDAO getInstance() {
		if(pdao == null) {
			pdao = new ProductDAO();
		}
		return pdao;
	}
	private ProductDAO(){
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//생성자
	
	public int insertProduct(MultipartRequest mr) {
		
		int cnt = -1;
		String sql = "insert into product values(catprod.nextval,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mr.getParameter("pname"));
			
			String p_fk = mr.getParameter("getPcategory_fk");
			p_fk += mr.getParameter("pcode");//연결
			
			ps.setString(2, p_fk);
			
			ps.setString(3, mr.getParameter("getPcompany"));
			ps.setString(4, mr.getFilesystemName("getPimage"));//파일 시스템 네임
			ps.setInt(5, Integer.parseInt(mr.getParameter("getPqty")));
			ps.setInt(6, Integer.parseInt(mr.getParameter("getPrice")));
			ps.setString(7, mr.getParameter("getPspec"));
			ps.setString(8, mr.getParameter("getPcontents"));
			ps.setInt(9, Integer.parseInt(mr.getParameter("getPoint")));
			
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String today = sdf.format(d);
			
			ps.setString(10, today);

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
	}//insertproduct
	
	public ArrayList<ProductBean> getAllProduct() {
		ArrayList<ProductBean> lists = new ArrayList<ProductBean>();
		String sql = "select * from product order by pnum";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductBean pb = new ProductBean();
				
				pb.setPnum(rs.getInt("pnum"));
				pb.setPname(rs.getString("pname"));
				pb.setPcategory_fk(rs.getString("pcategory_fk"));
				pb.setPcompany(rs.getString("pcompany"));
				pb.setPimage(rs.getString("pimage"));
				pb.setPqty(rs.getInt("pqty"));
				pb.setPrice(rs.getInt("price"));
				pb.setPspec(rs.getString("pspec"));
				pb.setPcontents(rs.getString("pcontents"));
				pb.setPoint(rs.getInt("point"));
				pb.setPinputdate(rs.getString("pinputdate"));
				
				lists.add(pb);
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
	}//getAllProduct
	
	public ProductBean getProductByPnum(String pnum){
		ProductBean pb = new ProductBean();
		
		String sql = "select * from product where pnum="+pnum;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				pb.setPnum(rs.getInt("pnum"));
				pb.setPname(rs.getString("pname"));
				pb.setPcategory_fk(rs.getString("pcategory_fk"));
				pb.setPcompany(rs.getString("pcompany"));
				pb.setPimage(rs.getString("pimage"));
				pb.setPqty(rs.getInt("pqty"));
				pb.setPrice(rs.getInt("price"));
				pb.setPspec(rs.getString("pspec"));
				pb.setPcontents(rs.getString("pcontents"));
				pb.setPoint(rs.getInt("point"));
				pb.setPinputdate(rs.getString("pinputdate"));
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
				e.printStackTrace();
			}
		}				
		return pb;
	}//getProductByPnum
	
	public int deleteProduct(String pnum) {
		int cnt=-1;
		String sql ="delete from product where pnum=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, pnum);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		return cnt;
	}//deleteProduct
}
