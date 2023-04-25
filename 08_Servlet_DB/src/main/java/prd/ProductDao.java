package prd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import myPkg.MemberBean;

public class ProductDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id="jspid";
	String pw="jsppw";
	
	Connection conn = null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	ProductDao(){
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("계정 로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("계정 로드 실패");
			e.printStackTrace();
		}
	}//ProductDao생성자
	
	public void insertProduct(ProductBean pb) {
		String sql = "insert into product values(pseq.nextval,?,?)";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getPrice());
			cnt=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
					conn.close();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		System.out.println("성공 : "+cnt);
	}//insertProduct
	
	public ArrayList<ProductBean> getAllProduct(){
		String sql = "select * from product";
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setNum(rs.getInt("num"));
				pb.setName(rs.getString("name"));
				pb.setPrice(rs.getInt("price"));
				
				list.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
					conn.close();
			}
			if(rs!=null) {
				rs.close();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		return list;
	}//getallproduct
	
	public void deleteProduct(int num) {
		String sql = "delete product where num=?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			cnt = ps.executeUpdate();
			System.out.println("성공 : "+cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
					conn.close();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
	}//deletemember
	
	public ProductBean getOneProduct(int num) {
		String sql = "select * from product where no=?";
		ProductBean pb = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				pb = new ProductBean();
				pb.setNum(num);
				pb.setName(rs.getString("name"));
				pb.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pb;
	}//getOneMember
	
	public void updateProduct(ProductBean pb) {
		String sql ="update product set name=?, password=? where num=?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getPrice());
			ps.setInt(3, pb.getNum());
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("성공 : "+cnt);
	}//updateMember
}
