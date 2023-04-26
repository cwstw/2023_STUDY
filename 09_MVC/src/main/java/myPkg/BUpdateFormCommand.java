package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BUpdateFormCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		BookDao bdao = BookDao.getInstance();
		BookBean bb = bdao.getBookByNo(no);
		request.setAttribute("bb", bb);
	}

}
