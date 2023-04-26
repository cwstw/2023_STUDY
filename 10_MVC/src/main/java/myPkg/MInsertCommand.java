package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MInsertCommand implements MCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String genre = request.getParameter("genre");
		String time = request.getParameter("time");
		int partner = Integer.parseInt(request.getParameter("parter"));
		String memo = request.getParameter("memo");
		
		MovieBean mb = new MovieBean(0, id, name, age, genre, time, partner, memo);

		MovieDao mdao = MovieDao.getInstance();
		
		mdao.insertMovie(mb);
	}

}
