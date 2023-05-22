package member.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	@NotBlank(message = "���̵�� �ʼ��Դϴ�.")
	private String id;
	
	@NotBlank(message = "�̸��� �ʼ��Դϴ�.")
	private String name;
	
	@NotBlank(message = "����� �ʼ��Դϴ�")
	private String password;
	
	private String salary;
	
	private String hiredate;
	
	@NotEmpty(message = "������ ������ �ּ���.")
	private String gender;
	
	@NotEmpty(message = "��̴� 1�� �̻� �����ؾ� �մϴ�.")
	private String hobby;
	private String job;
	private String zipcode;
	
	@NotEmpty(message = "�ּ�1�� �ʼ��Դϴ�.")
	private String address1;
	
	private String address2;
	private String mpoint;
	
	
	public MemberBean() {
		super();
	}
	
	public MemberBean(String id, String name, String password, String salary, String hiredate, String gender,
			String hobby, String job, String zipcode, String address1, String address2, String mpoint) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.salary = salary;
		this.hiredate = hiredate;
		this.gender = gender;
		this.hobby = hobby;
		this.job = job;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
		this.mpoint = mpoint;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getMpoint() {
		return mpoint;
	}
	public void setMpoint(String mpoint) {
		this.mpoint = mpoint;
	}
	
}