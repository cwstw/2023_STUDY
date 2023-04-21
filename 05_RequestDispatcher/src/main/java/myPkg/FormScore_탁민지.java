package myPkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormScore
 */
@WebServlet("/score")
public class FormScore_Å¹¹ÎÁö extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormScore_Å¹¹ÎÁö() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));
		String[] hobby = request.getParameterValues("hobby");
		int c = Integer.parseInt(request.getParameter("c"));
		int java = Integer.parseInt(request.getParameter("java"));
		int jsp = Integer.parseInt(request.getParameter("jsp"));
		
		request.setAttribute("aid", id);
		request.setAttribute("apasswd", passwd);
		request.setAttribute("aname", name);
		request.setAttribute("ayear", year);
		request.setAttribute("amonth", month);
		request.setAttribute("aday", day);
		request.setAttribute("ahobby", hobby);
		request.setAttribute("ac", c);
		request.setAttribute("ajava", java);
		request.setAttribute("ajsp", jsp);
		
		RequestDispatcher rd = request.getRequestDispatcher("result_Å¹¹ÎÁö.jsp");
		rd.forward(request, response);
	}

}
