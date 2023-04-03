package my.shop.mall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import my.shop.ProductBean;
import my.shop.ProductDAO;

public class OrdersDAO {
	private static OrdersDAO odao;
	private Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static OrdersDAO getInstance() {
		if(odao == null) {
			odao = new OrdersDAO();
		}
		return odao;
	}
	private OrdersDAO(){
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
	
	public int insertOrder(int sno, Vector<ProductBean> clist) throws SQLException {
		int cnt = -1;
			for(int i=0;i<clist.size();i++) {
				String sql="insert into orders values(orderseq.nextval,?,?,?,?)";
				ps =conn.prepareStatement(sql);
				ps.setInt(1, sno);
				ps.setInt(2, clist.get(i).getPnum());
				ps.setInt(3, clist.get(i).getPqty());
				ps.setInt(4, clist.get(i).getPnum()*clist.get(i).getPqty());
				cnt += ps.executeUpdate();
			}
		return cnt;
	}//insertOrder
	
	public Vector<OrdersBean> getOrderList(String memid) {
		String sql = "select m.name as mname, m.id mid, p.pname, o.qty, o.amount "
				+ "from (members m inner join orders o on m.no = o.memno) "
				+ "inner join product p on o.pnum = p.pnum where id=?";
		Vector<OrdersBean> olist = new Vector<OrdersBean>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String mname = rs.getString("mname");
				String mid = rs.getString("mid");
				String pname = rs.getString("pname");
				String qty = rs.getString("qty");
				String amount = rs.getString("amount");
			
				OrdersBean ob = new OrdersBean();
				ob.setMname(mname);
				ob.setMid(mid);
				ob.setPname(pname);
				ob.setQty(Integer.parseInt(qty));
				ob.setAmount(Integer.parseInt(amount));
				
				olist.add(ob);
			}//while
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return olist;
	}//getorderlist
}
