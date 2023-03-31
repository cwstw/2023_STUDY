package my.shop.mall;

import java.util.Vector;

import my.shop.ProductBean;
import my.shop.ProductDAO;

public class CartBean {
	private Vector<ProductBean> clist;
	
	public CartBean() {
		clist = new Vector<ProductBean>();
	}//생성자
	
	public void addProduct(String pnum, String oqty) {
		ProductDAO pdao = ProductDAO.getInstance();
		ProductBean pb = pdao.getProductByPnum(pnum);
		pb.setPqty(Integer.parseInt(oqty));
		clist.add(pb);
		System.out.println("장바구니 상품갯수 : "+clist.size());
	}//addProduct
	
	public Vector<ProductBean> getAllProducts() {
		return clist;
	}
}
