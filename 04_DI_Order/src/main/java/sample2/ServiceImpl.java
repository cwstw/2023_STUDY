package sample2;

public class ServiceImpl implements Service{
	private OrderDaoImpl odao;
	private DeliveryDaoImpl ddao;
	
	public ServiceImpl() {
		System.out.println("Service()");
	}
	
	public OrderDaoImpl getOdao() {
		return odao;
	}

	public void setOdao(OrderDaoImpl odao) {
		this.odao = odao;
	}

	public DeliveryDaoImpl getDdao() {
		return ddao;
	}

	public void setDdao(DeliveryDaoImpl ddao) {
		this.ddao = ddao;
	}

	public void order() {
		odao.insertOrder();
		ddao.insertAddress();
	}

	public void cancel() {
		odao.removeOrder();
		ddao.removeAddress();
	}
	
}
