package com.spring.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AOPMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new GenericXmlApplicationContext("AOPContext.xml");
	Student mystudent = (Student)context.getBean("mystudent");
	Worker myworker = (Worker)context.getBean("myworker");
	
	mystudent.getStudentInfo();
	myworker.getWorkerInfo();
	
	
	}
}

/*
Hello
출근합니다.
안녕하세요
이름 : 조정석
나이 : 10
학년 : 3
반 : 5
퇴근합니다.
=================
출근합니다.
이름 : 윤아
나이 : 35
직업 : 개발자
안녕히 계세요
퇴근합니다.
*/