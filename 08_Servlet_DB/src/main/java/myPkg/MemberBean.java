package myPkg;

public class MemberBean {
	private int no;
	private String name;
	private String password;
	
	
	public MemberBean() {
		super();
	}
	public MemberBean(int no, String name, String password) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
