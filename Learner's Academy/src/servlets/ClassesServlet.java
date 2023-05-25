package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ClassDatabase;
import database.StudentDatabase;
import database.SubjectDatabase;
import database.TeacherDatabase;
import entities.ClassRoom;
import entities.Student;
import entities.Subject;
import entities.Teacher;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/classes")
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassesServlet() {
		super();
		System.out.println("Classes Servlet");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SubjectDatabase sDB = new SubjectDatabase();
		TeacherDatabase tDB = new TeacherDatabase();
		StudentDatabase studDB = new StudentDatabase();
		try {
			List<Subject> subjects = sDB.getAllSubjects();
			List<Teacher> teachers = tDB.getAllTeachers();
			List<Student> students = studDB.getAllStudents();
			RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
			request.setAttribute("subjects", subjects);
			request.setAttribute("teachers", teachers);
			request.setAttribute("students", students);
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		String subjectName = request.getParameter("subject");
		String teacherName = request.getParameter("teacher");
		String studentName = request.getParameter("student");
		
		SubjectDatabase sdb = new SubjectDatabase();
		TeacherDatabase tdb = new TeacherDatabase();
		StudentDatabase studdb = new StudentDatabase();
		
		System.out.println(name);
		System.out.println(day);
		System.out.println(time);
		System.out.println(subjectName);
		System.out.println(teacherName);
		System.out.println(studentName);
		try {
			System.out.println(sdb.getSubjectIdByName(subjectName));
			System.out.println(tdb.getTeacherIdByName(teacherName));
			System.out.println(studdb.getStudentIdByName(studentName));
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (name == null || name.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
			request.setAttribute("error", "Name cannot be null");
			dispatcher.forward(request, response);
			return;
		}

		if (day == null || day.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
			request.setAttribute("error", "Day cannot be null");
			dispatcher.forward(request, response);
			return;
		}

		if (time == null || time.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
			request.setAttribute("error", "Time cannot be null");
			dispatcher.forward(request, response);
			return;
		}

		ClassDatabase db = new ClassDatabase();
		ClassRoom classRoom = new ClassRoom();
		classRoom.setName(name);
		classRoom.setDay(day);
		classRoom.setTime(time);
		
		String nameToInsert = name;
		String dayToInsert = day;
		String timeToInsert = time;
		int subjectIdToInsert = 0;
		int teacherIdToInsert = 0;
		int studentToInsert = 0;
		try {
			subjectIdToInsert = sdb.getSubjectIdByName(subjectName);
			teacherIdToInsert = tdb.getTeacherIdByName(teacherName);
			studentToInsert = studdb.getStudentIdByName(studentName);
			System.out.println(subjectIdToInsert);
			System.out.println(teacherIdToInsert);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {

			if (db.insertClass(nameToInsert, dayToInsert, timeToInsert, subjectIdToInsert, teacherIdToInsert, studentToInsert)) {
				// take me to which page? login page
				RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
				PrintWriter out = response.getWriter();
				out.println("<p>Adding class successfully</p>");
				dispatcher.include(request, response);
			} else {
				// response.sendRedirect("register.html");
				RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
				PrintWriter out = response.getWriter();
				out.println("<p>Adding class unsuccessful</p>");
				dispatcher.include(request, response);
			}
		} catch (SQLException e) {
			// keep me on registration page
			response.sendRedirect("classes.jsp");

		}
	}
}
