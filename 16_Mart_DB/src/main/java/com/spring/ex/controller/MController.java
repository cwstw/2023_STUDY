package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.command.MCommand;
import com.spring.ex.command.MDeleteCommand;
import com.spring.ex.command.MDeleteMultiCommand;
import com.spring.ex.command.MInsertFormCommand;
import com.spring.ex.command.MListCommand;
import com.spring.ex.command.MUpdateCommand;
import com.spring.ex.command.MUpdateFormCommand;
import com.spring.ex.dto.MDto;

@Controller
public class MController {
	MCommand cm = null;
	@RequestMapping(value="form",method=RequestMethod.GET)
	public String form() {
		return "insertform";
	}

	@RequestMapping(value="form",method=RequestMethod.POST)
	public String form(Model model, @Valid MDto md,BindingResult result) {
		String page=null;
		model.addAttribute("mDto",md);
		if(result.hasErrors()) {
			page="insertform";
		} else {
			model.addAttribute("mDto",md);
			cm = new MInsertFormCommand();
			cm.execute(model);
			page="redirect:/list";
		}
		return page;
	}

	@RequestMapping("list")
	public String list(Model model) {
		cm = new MListCommand();
		cm.execute(model);
		return "list";
	}

	@RequestMapping("updateForm")
	public String updateForm(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		
		model.addAttribute("num",num);
		cm = new MUpdateFormCommand();
		cm.execute(model);
		
		return "updateForm";
	}

	@RequestMapping("update")
	public String update(Model model, MDto mdto) {
		cm = new MUpdateCommand();
		cm.execute(model);
		return "redirect:/list";
	}

	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		String num = request.getParameter("num");
		
		model.addAttribute("num",num);
		cm = new MDeleteCommand();
		cm.execute(model);
		return "redirect:/list";
	}

	@RequestMapping("deleteMulti")
	public String deleteMulti(Model model, HttpServletRequest request) {
		model.addAttribute("req",request);
		
		cm = new MDeleteMultiCommand();
		cm.execute(model);
		return "redirect:/list";
	}
	
}
