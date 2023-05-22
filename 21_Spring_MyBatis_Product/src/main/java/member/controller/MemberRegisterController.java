package member.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberRegisterController {

	private final String command ="regisertForm.mb";
	private final String getPage ="memberRegisterForm";
	private final String gotoPage ="memberList";
	
	MemberDao mdao;
	
	//�α��������� ��û
	@RequestMapping(command)
	public String doAction() {
		return getPage;
	}
	
	//ȸ������ ������ ��û
	@RequestMapping("regiser.mb")
	public String doAction(
			@ModelAttribute("mb") @Valid MemberBean mb,
			BindingResult result
			) {
		
		if(result.hasErrors()) {
			return getPage;
			
		} else {
			int cnt = mdao.insertMember(mb);
			if(cnt > -1) {
				return gotoPage;
				
			} else {
				return getPage;
			}
		}
	}
	
}
