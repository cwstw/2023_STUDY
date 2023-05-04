package example3;

public class Consumer implements Person{
	
	private String name; //웬디
	private int age;//30
	
	private Car car;//모닝
	
	public Consumer() {
		System.out.println("Consumer()");
	}

	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String personDrive() {
		return car.drive();
	}

}
