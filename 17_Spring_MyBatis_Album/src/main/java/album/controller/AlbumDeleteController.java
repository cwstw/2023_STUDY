package album.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumDao;

@Controller
public class AlbumDeleteController {

	private final String command = "delete.ab";
	private final String getPage = "redirect:/list.ab";
	
	@Autowired
	AlbumDao adao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam("num") int num) {
		//String num = request.getParameter("num");
		System.out.println("num : "+num);
		
		//parseInt 안 쓰고 위 매개변수 자료형만 바꾸어주면 된다.
		adao.deleteAlbum(num);
		
		return getPage;
	}
}
