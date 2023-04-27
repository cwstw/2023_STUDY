package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MDeleteAllCommand implements MCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String[] rowchk = request.getParameterValues("rowchk");
		MovieDao mdao = MovieDao.getInstance();
		
		mdao.deleteCheckData(rowchk);
		
	}

}
