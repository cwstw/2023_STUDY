package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {//��ǰ����, ������ �� ��������
	//orderLists�� �����ϴ� map ��ü
	private Map<Integer, Integer> orderLists = null;
	
	public MyCartList() {
		orderLists = new HashMap<Integer, Integer>();
		
	}

	public void addOrder(int num, int orderqty) {
		//��ٱ��Ͽ� �߰�
		orderLists.put(num,orderqty);
	}
	
	public Map<Integer,Integer> getAllOrderLists(){
		return orderLists;
	}
}
