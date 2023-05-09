package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;

public class PWriteCommand implements PCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //모델을 맵처럼 사용
		
		//req에 담은 값 가져오기 (다운캐스팅)
		HttpServletRequest request = (HttpServletRequest)map.get("req"); 
		System.out.println("PWriteCommand");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(id+","+name+","+age);
		
		PDao pdao = PDao.getInstance();
		
		pdao.write(id, name, age);
	}

}
