package myPkg;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MIdCheckCommand implements MCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		MovieDao mdao = MovieDao.getInstance();
		
		boolean isCheck = mdao.searchId(id);
		
			try {
				if(isCheck) {
				response.getWriter().append("NO");
				}else {
					response.getWriter().append("YES");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
