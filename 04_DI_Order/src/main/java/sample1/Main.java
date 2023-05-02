package sample1;

public class Main {

	public static void main(String[] args) {
		Service ser = new Service();
		OrderDao odao = new OrderDao();
		DeliveryDao ddao = new DeliveryDao();
		
		ser.setOdao(odao);
		ser.setDdao(ddao);
		ser.cancel();
	}

}
