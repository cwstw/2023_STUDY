package sample1;

public class OrderDao {
	public OrderDao(){
		System.out.println("OrderDao()");
	}
	public void insertOrder() {
		System.out.println("주문정보 추가 : insertOrder()");
	}
	public void removeOrder() {
		System.out.println("주문정보 취소 : removeOrder()");
	}
}
