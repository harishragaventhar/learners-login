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

import database.TeacherDatabase;
import entities.Teacher;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/teachers")
public class TeachersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("teachers.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.println(name);
		System.out.println(email);
		
		if(name == null || name.isEmpty())
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("teachers.jsp");
			request.setAttribute("error", "Name cannot be null");
			dispatcher.forward(request, response);
			return;
		}
		
		if(email == null || email.isEmpty())
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("teachers.jsp");
			request.setAttribute("error", "Email cannot be null");
			dispatcher.forward(request, response);
			return;
		}
				
		TeacherDatabase db = new TeacherDatabase();
		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setEmail(email);
		
		try {
			
			if(db.insertTeacher(teacher))
			{
				// take me to which page? login page
				RequestDispatcher dispatcher = request.getRequestDispatcher("teachers.jsp");
				PrintWriter out = response.getWriter();
				out.println("<p>Adding teacher successfully</p>");
				dispatcher.include(request, response);
			}
			else {
				//response.sendRedirect("register.html");
				RequestDispatcher dispatcher = request.getRequestDispatcher("teachers.jsp");
				PrintWriter out = response.getWriter();
				out.println("<p>Adding teacher unsuccessful</p>");
				dispatcher.include(request, response);
			}
		} catch (SQLException e) {
			// keep me on registration page
			response.sendRedirect("teachers.jsp");
			
		}
	}

}