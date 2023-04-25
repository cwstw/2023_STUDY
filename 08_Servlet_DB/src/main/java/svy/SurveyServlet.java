package svy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyServlet
 */
@WebServlet("*.sv")
public class SurveyServlet extends HttpServlet {
	ServletContext sc;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		sc = config.getServletContext();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy");
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		// TODO Auto-generated method stub
		//doGet(request, response);
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage=null;
		SurveyDao sdao = new SurveyDao();
		
		if(command.equals("/insert.sv")) {
			String flag = (String)sc.getAttribute("flag");
			if(flag==false) {
			String name = request.getParameter("name");
			String company = request.getParameter("company");
			String email = request.getParameter("email");
			String satisfaction = request.getParameter("satisfaction");
			String[] partArr = request.getParameterValues("part");
			String part="";
			if(partArr ==null) {
				part="선택한 관심 분야가 없습니다.";
			}else {
				for(int i=0;i<partArr.length;i++) {
					part +=partArr[i];
					if(i !=partArr.length-1) {
						part += ",";
					}
				}
			}
			String howto = request.getParameter("howto");
			int agree=0;
			if(request.getParameter("agree")!=null) {
				agree = Integer.parseInt(request.getParameter("agree"));
			}else {
				
			}
			
			SurveyBean sb = new SurveyBean(0,name,company,email,satisfaction,part,howto,agree);
			
			sdao.insertSurvey(sb);
			sc.setAttribute("flag", "true");
			}
			viewPage="/list.sv";
			
		}else if(command.equals("/list.sv")) {
			ArrayList<SurveyBean> list = sdao.getAllSurvey();
			
			request.setAttribute("list", list);
			
			viewPage = "Ex03_surveyResult.jsp";
		}else if(command.equals("/delete.sv")) {
		}else if(command.equals("/updateForm.sv")) {
		}else if(command.equals("/update.sv")) {
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}//doprocess

}
