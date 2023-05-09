package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;
import com.spring.ex.Dto.PDto;

public class PUpdateFormCommand implements PCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		String num = (String)map.get("num");
		
		PDao pdao = PDao.getInstance();
		
		PDto pd = pdao.getPersonByNum(num);
		model.addAttribute("pd",pd);
	}

}
