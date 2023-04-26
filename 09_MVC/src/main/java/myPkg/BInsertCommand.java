package myPkg;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BInsertCommand implements BCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookBean bb = new BookBean(0,title,author,price);
		
		BookDao bdao = BookDao.getInstance();
		
		bdao.insertBook(bb);
		
		ServletContext app = request.getServletContext();
		app.setAttribute("flag", "ture");
	}
}
