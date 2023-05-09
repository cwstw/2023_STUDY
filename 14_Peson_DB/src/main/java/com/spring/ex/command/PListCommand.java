package com.spring.ex.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;
import com.spring.ex.Dto.PDto;

public class PListCommand implements PCommand{

	@Override
	public void execute(Model model) {
		//select ~ model 속성 설정, list 출력
		PDao pdao = PDao.getInstance();
		ArrayList<PDto> list = pdao.getAllPerson();
		
		model.addAttribute(list);
	}

}
