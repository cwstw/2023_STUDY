package myPkg;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BListCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BookDao bdao = BookDao.getInstance();
		
		ArrayList<BookBean> list = bdao.getAllBook();
		
		request.setAttribute("list", list);
		
	}

}
