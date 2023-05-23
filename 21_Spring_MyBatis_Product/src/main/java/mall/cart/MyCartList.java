package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {//상품숫자, 수량을 한 묶음으로
	//orderLists로 관리하는 map 객체
	private Map<Integer, Integer> orderLists = null;
	
	public MyCartList() {
		orderLists = new HashMap<Integer, Integer>();
		
	}

	public void addOrder(int num, int orderqty) {
		//장바구니에 추가
		orderLists.put(num,orderqty);
	}
	
	public Map<Integer,Integer> getAllOrderLists(){
		return orderLists;
	}
}
