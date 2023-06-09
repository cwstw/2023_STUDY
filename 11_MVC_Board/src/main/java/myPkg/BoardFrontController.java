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
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.bd")
public class BoardFrontController extends HttpServlet {
	BCommand bc = null;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BoardFrontController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

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
		String viewPage="";
		
		if(command.equals("/write.bd")) {
			bc = new BWriteCommand();
			bc.execute(request, response);
			
			viewPage="/list.bd";
		} else if(command.equals("/list.bd")) {
			bc = new BListCommand();
			bc.execute(request, response);
			
			viewPage="/select.jsp";
		} else if(command.equals("/content.bd")) {//목록보기에서 제목 클릭
			bc = new BContentCommand();
			bc.execute(request, response);
			
			viewPage="/content.jsp";
		} else if(command.equals("/deleteForm.bd")) { //content에서 호출
			bc = new BDeleteFormCommand(); 
			bc.execute(request, response);
			
			viewPage="/delete.bd";
		} else if(command.equals("/delete.bd")) {
			bc = new BDeleteCommand();
			bc.execute(request, response);
			
			if(request.getAttribute("match").equals("flase")) {
				return; //비밀번호 틀림
			}else {
				viewPage="/list.bd?pageNum="+request.getParameter("pageNum");//일치 시 이동
			}
		} else if(command.equals("/updateForm.bd")) {//content에서
			bc = new BUpdateFormCommand();
			bc.execute(request, response);
			
			viewPage="/updateFrom.jsp";
		} else if(command.equals("/update.bd")) {
			bc = new BUpdateCommand();
			bc.execute(request, response);
			
			if(request.getAttribute("match").equals("flase")) {
				return; //비밀번호 틀림
			}else {
				viewPage="/select.jsp";//일치 시 이동
			}
		} else if(command.equals("/replyForm.bd")) {
			bc = new BReplyFormCommand();
			bc.execute(request, response);
			
			viewPage="/reply.bd";
		} else if(command.equals("/reply.bd")) {
			bc = new BReplyCommand();
			bc.execute(request, response);
			
			viewPage="/list.bd";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	}//doprocess

}
