package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;

public class FListCommand implements FCommand{

	@Override
	public void execute(Model model) {
		FDao fdao = FDao.getInstance();
		ArrayList<String> list = fdao.getAllFootball();
		
		model.addAttribute(list);
	}

}
