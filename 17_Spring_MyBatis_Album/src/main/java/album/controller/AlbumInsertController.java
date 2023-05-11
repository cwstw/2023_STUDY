package album.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlbumInsertController {

	private final String command="insert.ab";
	private String getPage="alubumInsertForm";
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String insert() {
		
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public String insert(Model model) {
		
		return getPage;
	}
	
}
