

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontServlet
 */
//@WebServlet({"/insert.do","/upadate.do","/delete.do","select.do"})
@WebServlet("*.do")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		System.out.println("doGet");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//doGet(request, response);
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		String conPath = request.getContextPath();
		int len = conPath.length();
		String command = uri.substring(len);
		
		System.out.println("uri : "+uri);
		System.out.println("url : "+url);
		System.out.println("conPath : "+conPath);
		System.out.println("len : "+len);
		System.out.println("command : "+command);
		System.out.println("======================");
		if(command.equals("/insert.do")) {
			System.out.println("insert夸没");
		}else if(command.equals("/update.do")) {
			System.out.println("update夸没");
		}else if(command.equals("/delete.do")) {
			System.out.println("delete夸没");
		}else {
			System.out.println("select夸没");
		}
	}//doprocess
}
