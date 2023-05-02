package sample2;

public class DeliveryDaoImpl implements DeliveryDao{
	public DeliveryDaoImpl() {
		System.out.println("DeliveryDaoImpl()");
	}
	public void insertAddress() {
		System.out.println("배송지정보 추가 : insertAddress()");
	}
	public void removeAddress() {
		System.out.println("배송지정보 취소 : removeAddress()");
	}
}
