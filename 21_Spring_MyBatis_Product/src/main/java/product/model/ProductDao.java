package product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class ProductDao {

	private String namespace = "product.model.Product";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int getTotalCount(Map<String, String> map) {
		int cnt = 0;

		cnt = sqlSessionTemplate.selectOne(namespace+".CountProducts",map);

		return cnt;
	}

	public List<ProductBean> getProductList(Paging pageInfo, Map<String, String> map) {
		List<ProductBean> lists = new ArrayList<ProductBean>();

		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetProductList",map,rowBounds);
		return lists;
	}

	public int insertProduct(ProductBean productBean) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertProduct", productBean);
		return cnt;
	}

	public ProductBean getOneProduct(int num) {
		ProductBean product = null;
		product = sqlSessionTemplate.selectOne(namespace+".GetOneProduct",num);
		return product;
	}

	public int deleteProduct(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateProduct(ProductBean pb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateProduct",pb);
		return cnt;
	}

}