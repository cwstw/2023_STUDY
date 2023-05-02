package com.spring.ex;

public class StudentImpl implements Student{

	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	
	public StudentImpl() {
		super();
	}

	public StudentImpl(String name, int age, int gradeNum, int classNum) {
		super();
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}

	@Override
	public void getStudentInfo() {
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("학년 : "+gradeNum);
		System.out.println("반 : "+classNum);
	}

}
