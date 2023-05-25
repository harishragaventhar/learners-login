package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.UserDatabase;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	System.out.println("Login Servlet");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
//		try {
//			if(email!=null && email.equals("admin") 
//					&& password!=null && password.equals("admin")) {
//				request.setAttribute("email", email);
//				// url rewriting
//				HttpSession session = request.getSession();
//				session.setAttribute("id", email);
//				response.sendRedirect("dashboard.jsp");
//			}
//			else {
//				response.sendRedirect("login.jsp?error=Invalid Credentials");				
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			response.sendRedirect("login.jsp?error=something went wrong");
//		}
		
		if(email!=null && email.equals("admin") 
				&& password!=null && password.equals("admin") )
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", email);
			response.sendRedirect("classes");
			return;
		}
		UserDatabase db = new UserDatabase();
		try {
			if(db.validateUser(email, password)) {
				request.setAttribute("email", email);
				// url rewriting
				HttpSession session = request.getSession();
				session.setAttribute("id", email);
				response.sendRedirect("dashboard.jsp");
			}
			else {
				response.sendRedirect("login.jsp?error=Invalid Credentials");				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("login.jsp?error=something went wrong");
		}
	}
}