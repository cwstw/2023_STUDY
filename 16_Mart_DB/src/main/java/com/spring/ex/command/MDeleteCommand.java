package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.MDao;
import com.spring.ex.dto.MDto;

public class MDeleteCommand implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		String num = (String)map.get("num");
		
		MDao mdao = MDao.getInstance();
		
		mdao.deleteMart(num);
	}

}
