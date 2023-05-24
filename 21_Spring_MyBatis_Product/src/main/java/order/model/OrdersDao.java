package order.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myOrder")
public class OrdersDao {
	private String namespace="order.model.Order";
	
	@Autowired
	SqlSessionTemplate sst;

	public int insertOrder(String mid) {
		int cnt = sst.insert(namespace+".InsertOrders",mid);
		return cnt;
	}

	public int getMaxOid() {
		int oid = sst.selectOne(namespace+".GetMaxOid");
		return oid;
	}
	
	
	
}
