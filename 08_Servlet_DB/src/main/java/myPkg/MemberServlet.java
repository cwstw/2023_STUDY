package myPkg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("*.mb")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage =null;
		
		System.out.println("method : "+request.getMethod());
		
		MemberDao mdao = new MemberDao();
		if(command.equals("/insert.mb")) {
			System.out.println("insert ����");
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			MemberBean mb = new MemberBean(0,name,password);
			
			mdao.insertData(mb);
			viewPage = "Ex01_MemberTo.jsp";
			
		}else if(command.equals("/delete.mb")) {
			System.out.println("delete ����");
			int no = Integer.parseInt(request.getParameter("no"));
			
//			ArrayList<MemberBean> mlist = mdao.getAllMember();
//			request.setAttribute("mlist", mlist);//�Ӽ����� �־ ��������
			
			mdao.deleteMember(no);
			
			viewPage="/list.mb";
			
		}else if(command.equals("/update.mb")) {
			System.out.println("update ����");
			
			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			MemberBean mb = new MemberBean(no,name,password);
			
			mdao.updateMember(mb); 
			
			viewPage="/list.mb";
			
		}else if(command.equals("/updateForm.mb")) {
			System.out.println("updateForm ����");
			
			int no = Integer.parseInt(request.getParameter("no"));
			
//			ArrayList<MemberBean> mlist = mdao.getAllMember();
//			request.setAttribute("mlist", mlist);//�Ӽ����� �־ ��������
			
			MemberBean mb = mdao.getOneMember(no);
			request.setAttribute("mb", mb);
			viewPage="Ex01_memberUpdateForm.jsp";
			
		}else if(command.equals("/list.mb")) {
			System.out.println("list ����");
			
			ArrayList<MemberBean> mlist = mdao.getAllMember();
			
			request.setAttribute("mlist", mlist);//�Ӽ����� �־ ��������
			
			viewPage="Ex01_memberList.jsp";
			
		}else {

			
		}//if
		
		RequestDispatcher rs = request.getRequestDispatcher(viewPage);
		rs.forward(request, response);
		
	}//doprocess
}