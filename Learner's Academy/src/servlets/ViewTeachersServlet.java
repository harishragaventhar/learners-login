package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.SubjectDatabase;
import database.TeacherDatabase;
import entities.Subject;
import entities.Teacher;

/**
 * Servlet implementation class ViewTeachersServlet
 */
@WebServlet("/viewTeachers")
public class ViewTeachersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTeachersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDatabase tDB = new TeacherDatabase();
		try {
			List<Teacher> teachers = tDB.getAllTeachers();
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewTeachers.jsp");
			request.setAttribute("teachers", teachers);
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
