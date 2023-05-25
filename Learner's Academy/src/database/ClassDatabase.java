package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.ClassRoom;
import entities.Student;
import entities.Subject;
import entities.Teacher;

public class ClassDatabase {
	
	public boolean insertClass(String name, String day, String time, int subjectId, int teacherId, int studentId) throws SQLException
	{	
		String sql = " insert into class (name, day, time, subject_id, teacher_id, student_id)" + " values(?,?,?,?,?,?)";
		System.out.println(sql);
		// 1. DB connection 
		Connection conn = DBConnection.dbConn();
		//2. create the statememt
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, name);
		stat.setString(2, day);
		stat.setString(3, time);
		stat.setInt(4, subjectId);
		stat.setInt(5, teacherId);
		stat.setInt(6, studentId);
		try {
			stat.execute();
		}catch(Exception e)
		{
			System.out.println("error "+e.getMessage());
			return false;
		}
		return true;
	}
	
	public List<ClassRoom> getAllClasses() throws SQLException {
		List<ClassRoom> classes = new ArrayList<ClassRoom>();
		String sql = "select * from class";

		// 1. DB connection
		Connection conn = DBConnection.dbConn();
		// 2. create the statememt
		Statement stat = conn.createStatement();
		// 3. execute the query
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			
			ClassRoom classRoom = new ClassRoom();
			Subject subject = new Subject();
			SubjectDatabase sDb = new SubjectDatabase();
			Teacher teacher = new Teacher();
			TeacherDatabase tDb = new TeacherDatabase();
			Student student = new Student();
			StudentDatabase studDb = new StudentDatabase();
			
			classRoom.setId(rs.getInt(1));
			classRoom.setName(rs.getString(2));
			classRoom.setDay(rs.getString(3));
			classRoom.setTime(rs.getString(4));
			subject = sDb.getSubjectById(rs.getInt(5));
			classRoom.setSubject(subject);
			student = studDb.getStudentById(rs.getInt(6));
			classRoom.setStudent(student);
			teacher = tDb.getTeacherById(rs.getInt(7));
			classRoom.setTeacher(teacher);

			classes.add(classRoom);
		}
		return classes;
	}
}
