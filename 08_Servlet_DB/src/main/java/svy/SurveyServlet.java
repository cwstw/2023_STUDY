package svy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
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
	private static final long serialVersionUID = 1L;
	ServletContext sc;
	SurveyDao sdao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SurveyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String id = config.getInitParameter("id");
		String pw = config.getInitParameter("pw");
		System.out.println(driver);
		sc = config.getServletContext(); 
		
		sdao = new SurveyDao(driver,url,id,pw);
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
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//SurveyDao sdao = new SurveyDao();
		String viewPage = null;

		String uri = request.getRequestURI();
		String command = uri.substring(request.getContextPath().length());
		System.out.println("command:" + command);

		if(command.equals("/insert.sv")) {
			String flag = (String)sc.getAttribute("flag");
			System.out.println("flag:" + flag);
			if(flag.equals("false")) {

				String name = request.getParameter("name");
				String company = request.getParameter("company");
				String email = request.getParameter("email");
				String satisfaction = request.getParameter("satisfaction");
				String[] partArr = request.getParameterValues("part");
				String howto = request.getParameter("howto");
				//int agree = Integer.parseInt(request.getParameter("agree"));

				String agreeStr = request.getParameter("agree"); // "1"
				int agree;
				if(agreeStr == null) { // 체크 안함(0)
					agree = 0;
				}else { // 체크 함(1)
					agree = 1;
				}

				String part="";
				if(partArr == null) {
					part = "선택한 관심 분야가 없습니다.";
				}else {
					for(int i=0;i<partArr.length;i++) {
						part += partArr[i];
						if(i != partArr.length - 1) {
							part += ",";
						}
					}
				}
				//part = 서블릿,스프링,UML

				SurveyBean sb = new SurveyBean(0,name,company,email,satisfaction,part,howto,agree);
				sdao.insertSurvey(sb);
				sc.setAttribute("flag", "true");
				//viewPage = "/list.sv";
				
			}else {
				//viewPage = "/list.sv";
			}
			viewPage = "/list.sv";
			
		}else if(command.equals("/delete.sv")) {
			String no = request.getParameter("no");
			sdao.deleteSurvey(no);
			viewPage = "list.sv";
			
		}else if(command.equals("/updateForm.sv")) {
			String no = request.getParameter("no");
			SurveyBean sb = sdao.getOneSurvey(no);
			System.out.println(sb.getName());

			request.setAttribute("sb", sb);
			viewPage = "Ex03_surveyUpdateForm.jsp";
			
		}else if(command.equals("/update.sv")) {
				String name = request.getParameter("name");
				String company = request.getParameter("company");
				String email = request.getParameter("email");
				String satisfaction = request.getParameter("satisfaction");
				String[] partArr = request.getParameterValues("part");
				String howto = request.getParameter("howto");
				//int agree = Integer.parseInt(request.getParameter("agree"));

				String agreeStr = request.getParameter("agree"); // "1"
				int agree;
				if(agreeStr == null) { // 체크 안함(0)
					agree = 0;
				}else { // 체크 함(1)
					agree = 1;
				}

				String part="";
				if(partArr == null) {
					part = "선택한 관심 분야가 없습니다.";
				}else {
					for(int i=0;i<partArr.length;i++) {
						part += partArr[i];
						if(i != partArr.length - 1) {
							part += ",";
						}
					}
				}
				//part = 서블릿,스프링,UML

				SurveyBean sb = new SurveyBean(0,name,company,email,satisfaction,part,howto,agree);
				sdao.updateSurvey(sb);
				
				viewPage = "/list.sv";
		}else if(command.equals("/list.sv")) {
			ArrayList<SurveyBean> lists = sdao.getAllSurvey();
			request.setAttribute("slists", lists);
			viewPage = "Ex03_surveyList.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}





