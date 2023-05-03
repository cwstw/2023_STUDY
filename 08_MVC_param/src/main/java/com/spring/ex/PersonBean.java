package com.spring.ex;

public class PersonBean {
	private String id;
	private String passwd;
	private String addr;
	public PersonBean(String id, String passwd, String addr) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.addr = addr;
	}
	public PersonBean() {
		super();
		System.out.println("PersonBean()");
	}
	public String getId() {
		System.out.println("setid");
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		System.out.println("setpasswd");
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getAddr() {
		System.out.println("setaddr");
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
