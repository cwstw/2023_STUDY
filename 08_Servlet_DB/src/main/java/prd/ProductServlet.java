package prd;

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

import myPkg.MemberBean;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("*.prd")
public class ProductServlet extends HttpServlet {
	String flag;
	ServletContext sc;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//doGet(request, response);
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length()); 
		String viewPage=null;
		ProductDao pdao = new ProductDao();
		
		if(command.equals("/insert.prd")) {
			request.setCharacterEncoding("UTF-8");

			flag = (String)sc.getAttribute("flag");
			System.out.println(flag);
			
			if(flag.equals("false")) {
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			ProductBean pb = new ProductBean(0, name, price);
			
			pdao.insertProduct(pb);
			sc.setAttribute("flag", "true");
			}
			viewPage="/list.prd";
			
		} else if(command.equals("/list.prd")) {
			
			ArrayList<ProductBean> list = pdao.getAllProduct(); 
			
			request.setAttribute("list", list);//속성으로 넣어서 가져가기
			
			viewPage = "Ex02_productList.jsp";
			
		} else if(command.equals("/delete.prd")) {
			
			int num = Integer.parseInt(request.getParameter("num"));
			
			pdao.deleteProduct(num);
			
			viewPage="/list.prd";
		} else if(command.equals("/updateForm.prd")) {
			int num = Integer.parseInt(request.getParameter("num"));
	
			ProductBean pb = pdao.getOneProduct(num);
			request.setAttribute("pb", pb);
			viewPage="Ex02_productUpdateForm.jsp";
		} else if(command.equals("/update.prd")) {
			
			ArrayList<ProductBean> list = pdao.getAllProduct();
			
			request.setAttribute("list", list);//속성으로 넣어서 가져가기
			
			viewPage="Ex02_productList.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
