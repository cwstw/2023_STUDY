package album.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumListController {

	@RequestMapping("/list.ab")
	public String doAction() {
		return "albumList"; //WEB-INF/album/albumList.jsp
	}
	
}
