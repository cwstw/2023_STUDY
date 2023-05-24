package order.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailsDao {
	private String namespace="orderdetail.model.OrderDetail";
	
	@Autowired
	SqlSessionTemplate sst;

	public int insertOrderDetails(OrderDetailsBean odb) {
		int cnt = sst.insert(namespace+".InsertOrderDetails",odb);
		return cnt;
	}
	
}
