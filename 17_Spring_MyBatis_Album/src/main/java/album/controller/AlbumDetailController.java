package album.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumDetailController {
	
	private final String command = "detail.ab";
	private final String getPage = "albumDetailView";
	
	@Autowired
	AlbumDao adao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam("num") int num, Model model) {
		System.out.println("num : "+num);
		AlbumBean ab = adao.getAlbumByNum(num);
		
		model.addAttribute("ab",ab);
		return getPage;
	}
}
