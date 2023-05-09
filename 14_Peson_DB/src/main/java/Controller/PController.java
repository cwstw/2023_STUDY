package Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.command.PCommand;
import com.spring.ex.command.PDeleteCommand;
import com.spring.ex.command.PListCommand;
import com.spring.ex.command.PUpdateCommand;
import com.spring.ex.command.PUpdateFormCommand;
import com.spring.ex.command.PWriteCommand;

@Controller
public class PController {
	PCommand command;
	@RequestMapping("writeform")
	public String form() {
		return "write_form";
	}

	@RequestMapping("write")
	public String write(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(id+","+name+","+age);
		
		model.addAttribute("req", request); //입력한 값이 담겨있는 ㄴ리퀘스트 객체 자체를 보냄
		command = new PWriteCommand(); //부모로 자식 객체 관리
		command.execute(model); //커맨드는 모델을 매개변수로 받기 때문에 해당 객체 생성해줌
		//return "list"; jsp 요청
		return "redirect:/list"; //다시 컨트롤러 요청
	}

	@RequestMapping("list")
	public String list(Model model) {
		command = new PListCommand();
		command.execute(model);
		return "list";
	}

	@RequestMapping("updateForm")
	public String updateForm(Model model,HttpServletRequest request) {
		String num = request.getParameter("num");
		model.addAttribute("num",num);
		
		command = new PUpdateFormCommand();
		command.execute(model);
		return "updateForm";
	}

	@RequestMapping("update")
	public String update(Model model,HttpServletRequest request) {
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(id+","+name+","+age+","+num);
		
		model.addAttribute("req", request); //입력한 값이 담겨있는 ㄴ리퀘스트 객체 자체를 보냄
		command = new PUpdateCommand(); //부모로 자식 객체 관리
		command.execute(model);
		return "updateForm";
	}

	@RequestMapping("delete")
	public String delete(Model model,HttpServletRequest request) {
		String num = request.getParameter("num");
		
		model.addAttribute("req", request); //입력한 값이 담겨있는 ㄴ리퀘스트 객체 자체를 보냄
		command = new PDeleteCommand(); //부모로 자식 객체 관리 
		command.execute(model);
		return "list";
	}
	
	
	
	
}
