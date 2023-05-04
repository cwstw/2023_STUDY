package example3;

public class Main {

	public static void main(String[] args) {
		//@~ x
		Consumer cs = new Consumer();
		cs.setName("웬디");
		cs.setAge(30);
		//cs.setCar(); 자식이 갖고 있지만 호출 불가능, 부모에 붙여넣기
		
		Car car = new Morning();
		//car.drive();
		cs.setCar(car);
		
		System.out.println(cs.getName()+", "+cs.getAge()+", "+cs.personDrive());
		System.out.println("============================");
		
		Car car2 = new Morning();
		//정국,40,Sonata-drive
		
		cs.setName("정국");
		cs.setAge(40);
		
		car2 = new Sonata();
		cs.setCar(car2);

		System.out.println(cs.getName()+", "+cs.getAge()+", "+cs.personDrive());
		System.out.println("============================");
		
		
	}

}
