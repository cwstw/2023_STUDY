package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.dao.MDao;
import com.spring.ex.dto.MDto;

public class MListCommand implements MCommand{

	@Override
	public void execute(Model model) {
		MDao mdao = MDao.getInstance();
		ArrayList<MDto> lists = mdao.getAllMart(); 
		
		model.addAttribute("lists",lists);
	}

}
