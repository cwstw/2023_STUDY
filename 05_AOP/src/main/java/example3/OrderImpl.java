package example3;

public class OrderImpl implements Order{

	@Override
	public void order() {
		String msg="상품 주문";
		System.out.println(msg+"하기");
	}

}
