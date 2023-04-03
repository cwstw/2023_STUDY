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
		int pnum_new = Integer.parseInt(pnum);
		int oqty_new = Integer.parseInt(oqty);
		//이미 장바구니에 있으면
		for(int i=0;i<clist.size();i++) {
			if(clist.get(i).getPnum() == pnum_new) {
				int cpqty = clist.get(i).getPqty();
						clist.get(i).setPqty(cpqty+oqty_new);
						return;
			};
		}
		//장바구니에 없으면
		ProductDAO pdao = ProductDAO.getInstance();
		ProductBean pb = pdao.getProductByPnum(pnum);
		pb.setPqty(Integer.parseInt(oqty));
		clist.add(pb);
		System.out.println("장바구니 상품갯수 : "+clist.size());
		for(int i=0;i<clist.size();i++) {
			System.out.println(clist.get(i).getPnum()+"/"+clist.get(i).getPqty());
		}
	}//addProduct
	
	public Vector<ProductBean> getAllProducts() {
		return clist;
	}//getallproducts
	
	//장바구니 수량 바꾸는 메서드
	public void setEdit(String pnum, String oqty) {
		for(ProductBean pb : clist) {
			if(pb.getPnum() == Integer.parseInt(pnum)) {
				if(Integer.parseInt(oqty)==0) {//수량이 0이면
					clist.removeElement(pb);
					break;
				}else {
				pb.setPqty(Integer.parseInt(oqty));
				break;
				}//else
			}//if
		}//for
	}//setedit
	
	public void removeProduct(String pnum) {
		for(ProductBean pb : clist) {
			if(pb.getPnum() == Integer.parseInt(pnum)) {
				clist.removeElement(pnum);
				break;
			}//if
		}//for
	}//cartDel
	
	public void removeAllProduct() {
		clist.removeAllElements();
	}//removeallproduct
}
