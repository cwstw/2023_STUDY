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
 * Servlet implementation class Book
 */
@WebServlet("*.bk")
public class BookServlet extends HttpServlet {
	ServletContext sc;
	BCommand bcommand;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		System.out.println("command : "+command);
		
		String viewPage =null;
		
		if(command.equals("/insert.bk")) {
			if(sc.getAttribute("flag").equals("false")) {
				bcommand = new BInsertCommand();
				bcommand.execute(request, response);
				
				viewPage="list.bk";
			} else {
				viewPage="list.bk";
			}
		}else if(command.equals("/list.bk")) {
			
			bcommand = new BListCommand();
			bcommand.execute(request, response);
			viewPage="bookList.jsp";
			
		}else if(command.equals("/updateForm.bk")) {
			bcommand = new BUpdateFormCommand();
			bcommand.execute(request, response);
			
			viewPage="updateForm.jsp";
		}else if(command.equals("/update.bk")) {
			bcommand = new BUpdateCommand();
			bcommand.execute(request, response);
			
			
		}else if(command.equals("/delete.bk")) {
			bcommand = new BDeleteCommand();
			bcommand.execute(request, response);
			
			viewPage="list.bk";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);

	}
}