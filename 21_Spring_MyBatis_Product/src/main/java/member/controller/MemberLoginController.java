package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberLoginController {
	
	private final String command = "/loginForm.mb";
	private final String getPage = "memberLoginForm";
	
	@RequestMapping(command)
	public String doAction() {
		return getPage;
	}
	
}
