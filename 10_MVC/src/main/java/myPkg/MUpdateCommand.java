package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MUpdateCommand implements MCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MovieBean mb = new MovieBean();
		mb.setNum(Integer.parseInt(request.getParameter("num")));
		mb.setName(request.getParameter("num"));
		
		
	}

}
