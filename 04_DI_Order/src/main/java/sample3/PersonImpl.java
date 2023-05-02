package sample3;

public class PersonImpl implements Person{

	private String name;
	private int age;
	private double height;

	public PersonImpl() {

	}
	public PersonImpl(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public void print() {
		System.out.println("name : "+name);
		System.out.println("age : "+age);
		System.out.println("height : "+height);
	}

	public String toString() {
		return "이름 : " + name + "\n나이 : " + age + "\n키 : " + height;
	}

}