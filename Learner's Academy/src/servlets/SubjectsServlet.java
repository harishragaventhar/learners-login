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

import database.SubjectDatabase;
import entities.Subject;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/subjects")
public class SubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("subjects.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		if(name == null || name.isEmpty())
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("subjects.jsp");
			request.setAttribute("error", "Name cannot be null");
			dispatcher.forward(request, response);
			return;
		}
				
		SubjectDatabase db = new SubjectDatabase();
		Subject subject = new Subject();
		subject.setName(name);
		try {
			if(db.insertSubject(subject))
			{
				// take me to which page? login page
				RequestDispatcher dispatcher = request.getRequestDispatcher("subjects.jsp");
				PrintWriter out = response.getWriter();
				out.println("<p>Adding subject successfully</p>");
				dispatcher.include(request, response);
			}
			else {
				//response.sendRedirect("register.html");
				RequestDispatcher dispatcher = request.getRequestDispatcher("subjects.jsp");
				PrintWriter out = response.getWriter();
				out.println("<p>Adding subject unsuccessful</p>");
				dispatcher.include(request, response);
			}
		} catch (SQLException e) {
			// keep me on registration page
			response.sendRedirect("subjects.jsp");
			
		}
	}

}