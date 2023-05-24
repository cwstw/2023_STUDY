package product.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompositeDao {
	private final String namespace="product.model.Composite";

	@Autowired
	SqlSessionTemplate sst;

	public List<ProductBean> getOrderDetailByOid(int oid) {
		List<ProductBean> lists = sst.selectList(namespace+".GetOrderDetailByOid",oid);
		return lists;
	}
}
