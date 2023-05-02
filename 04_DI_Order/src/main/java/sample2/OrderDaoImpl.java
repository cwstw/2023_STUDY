package sample2;

public class OrderDaoImpl implements OrderDao{
	public OrderDaoImpl(){
		System.out.println("OrderDaoImpl()");
	}
	public void insertOrder() {
		System.out.println("주문정보 추가 : insertOrder()");
	}
	public void removeOrder() {
		System.out.println("주문정보 취소 : removeOrder()");
	}
}
