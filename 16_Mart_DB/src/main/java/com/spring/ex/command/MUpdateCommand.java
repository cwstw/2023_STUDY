package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.MDao;
import com.spring.ex.dto.MDto;

public class MUpdateCommand implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		MDto mdto = (MDto)map.get("mDto");
		
		String agree="";
		if(mdto.getAgree()==null) {
			agree="동의안함";
		}else {
			agree="동의함";
		}
		mdto.setAgree(agree);
		
		MDao mdao = MDao.getInstance();
		mdao.updateForm(mdto);
	}

}
