package myPkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("*.mv")
public class MovieServlet extends HttpServlet {
	MCommand mc=null;
	ServletContext sc;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MovieServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		sc = config.getServletContext();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage="";
		
		if(command.equals("/insert.mv")) {
			mc = new MInsertCommand();
			mc.execute(request, response);
			
			viewPage="list.mv";
		}else if(command.equals("/list.mv")) {
			if(sc.getAttribute("flag").equals("false")) {
			mc = new MListCommand();
			mc.execute(request, response);
			
			sc.setAttribute("flag", "true");
			}
			viewPage="movieList.jsp";
		}else if(command.equals("/id_check.mv")) {
			mc = new MIdCheckCommand();
			mc.execute(request, response);
			
			return;
		}else if(command.equals("/delete.mv")) {
			mc = new MDeleteCommand(); 
			mc.execute(request, response);
			
			viewPage="/list.mv";
		}else if(command.equals("/deleteAll.mv")) {
			mc = new MDeleteAllCommand();
			mc.execute(request, response);
			
			viewPage="/list.mv";
		}else if(command.equals("/updateForm.mv")) {
			mc = new MUpdateFormCommand();
			mc.execute(request, response);
			
			viewPage="updateMovie.jsp";
		}else if(command.equals("/update.mv")) {
			mc = new MUpdateCommand();
			mc.execute(request, response);
			
			viewPage="/list.mv";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}//doProcess

}
