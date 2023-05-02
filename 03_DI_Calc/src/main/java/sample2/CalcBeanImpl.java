package sample2;

public class CalcBeanImpl implements CalcBean{
	private int su1; //setter13
	private int su2;//constructor4
	
	public CalcBeanImpl() {
		super();
	}
	
	public CalcBeanImpl(int su2) {
		this.su2 = su2;
	}
	public CalcBeanImpl(int su1, int su2) {
		super();
		this.su1 = su1;
		this.su2 = su2;
	}
	public int getSu1() {
		return su1;
	}
	public void setSu1(int su1) {
		this.su1 = su1;
	}
	public int getSu2() {
		return su2;
	}
	public void setSu2(int su2) {
		this.su2 = su2;
	}
	
	public void calculate() {
		System.out.println("덧셈 : "+(su1+su2));
		System.out.println("뺄셈 : "+(su1-su2));
		System.out.println("곱셈 : "+(su1*su2));
		System.out.println("나눗셈 : "+(su1/su2));
		System.out.println("나머지 : "+(su1%su2));
	}
}
