package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.command.FCommand;
import com.spring.ex.command.FDeleteCommand;
import com.spring.ex.command.FInsertCommand;
import com.spring.ex.command.FListCommand;
import com.spring.ex.command.FUpdateCommand;
import com.spring.ex.command.FUpdateFormCommand;
import com.spring.ex.dto.FDto;

@Controller
public class FController {
	FCommand command;
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insertForm() {
		return "insertForm";
	}

	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insult(Model model,HttpServletRequest request, @Valid FDto fdto, BindingResult result) {
		String page=null;
		model.addAttribute("fdto",fdto);
		//자바로 넘어갈 때는 한번 더 설정 해주어야 함
		//혹은 매개변수 앞의 @ModelAttribute("fdto")로 설정
		if(result.hasErrors()) {
			
			System.out.println("참 :"+result.hasErrors());
			page="insertfrom";
		}else {
			System.out.println("거짓 :"+result.hasErrors());
			model.addAttribute("fdto",fdto);
			command = new FInsertCommand();
			command.execute(model);
			page="redirect:/list";
		}//else
		return page;
	}

	@RequestMapping("list")
	public String list(Model model) {
		command = new FListCommand();
		command.execute(model);
		return "list";
	}

	@RequestMapping("updateForm")
	public String updateForm(Model model,HttpServletRequest request) {
		String num = request.getParameter("num");
		
		model.addAttribute("num",num);
		command = new FUpdateFormCommand();
		command.execute(model);
		return "updateForm";
	}

	@RequestMapping("update")
	public String update(Model model, FDto fdto) {
		model.addAttribute("fdto",fdto);
		command = new FUpdateCommand();
		command.execute(model);
		return "list";
	}

	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		
		model.addAttribute("num",num);
		command = new FDeleteCommand();
		command.execute(model);
		return "list";
	}

	
	
}
