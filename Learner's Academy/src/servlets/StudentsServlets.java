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

import database.StudentDatabase;
import entities.Student;

/**
 * Servlet implementation class StudentsServlets
 */
@WebServlet("/students")
public class StudentsServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentsServlets() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("students.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		System.out.println(name);
		if (name == null || name.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
			request.setAttribute("error", "Name cannot be null");
			dispatcher.forward(request, response);
			return;
		}

		StudentDatabase db = new StudentDatabase();
		Student student = new Student();
		student.setName(name);
		try {
			if (db.insertStudent(student)) {
				// take me to which page? login page
				RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
				PrintWriter out = response.getWriter();
				out.println("<p>Adding student successfully</p>");
				dispatcher.include(request, response);
			} else {
				// response.sendRedirect("register.html");
				RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
				PrintWriter out = response.getWriter();
				out.println("<p>Adding student unsuccessful</p>");
				dispatcher.include(request, response);
			}
		} catch (SQLException e) {
			// keep me on registration page
			response.sendRedirect("students.jsp");

		}
	}

}
