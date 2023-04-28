package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BReplyFormCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String ref = request.getParameter("ref");
		String re_step = request.getParameter("re_step");
		String re_level = request.getParameter("re_level");
		String pageNum = request.getParameter("pageNum");
		
		System.out.println(ref+", "+re_step+", "+re_level);
		
	}

}
