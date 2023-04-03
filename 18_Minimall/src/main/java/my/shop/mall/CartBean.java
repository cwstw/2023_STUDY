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
		/* pnum : 14, oqty:2
		 clist
		 0 : 11상품정보
		 1 : 14상품정보
		 이미 장바구니에 있으면/ 없으면
		 */
		for(int i=0;i<clist.size();i++) {
			clist.get(i).getPnum() == pnum;
			clist.get(i).getPqty() += oqty;
		}
		ProductDAO pdao = ProductDAO.getInstance();
		ProductBean pb = pdao.getProductByPnum(pnum);
		pb.setPqty(Integer.parseInt(oqty));
		clist.add(pb);
		System.out.println("장바구니 상품갯수 : "+clist.size());
		for(int i=0;i<clist.size();i++) {
			System.out.println("clist : "+clist);
		}
	}//addProduct
	
	public Vector<ProductBean> getAllProducts() {
		return clist;
	}
}
