package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.MDao;

public class MDeleteMultiCommand implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		String[] numArr = request.getParameterValues("rowCheck");
		for(int i = 0;i<numArr.length;i++) {
			System.out.println((numArr[i]+" "));
		}//for
		System.out.println();
		MDao mdao = MDao.getInstance();
		mdao.deleteMultiByNum(numArr);
	}

	
}
