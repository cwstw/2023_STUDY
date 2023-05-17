package movie.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import movie.model.MovieDao;

@Controller
public class MovieCheckController {

	private final String command = "/title_check_proc.mv";

	@Autowired
	MovieDao movieDao;

	@RequestMapping(command)
	@ResponseBody
	public String doAction(@RequestParam("inputtitle") String inputtitle, 
			HttpServletResponse response) {

		System.out.println("title_check_proc.mv");
		boolean result = movieDao.searchTitle(inputtitle);  

		if(result)  // 참 : 제목이미있음, 사용못함
			//response.getWriter().append("N");
			return "NO"; // web-inf\movie\NO.jsp X
		else
			//response.getWriter().append("Y");
			return "YES"; // web-inf\movie\YES.jsp X

	}
}







