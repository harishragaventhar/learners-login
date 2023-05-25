package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Student;
import entities.Subject;

public class StudentDatabase {
	
	public boolean insertStudent(Student student) throws SQLException {

		String sql = " insert into student (name)" + " values(?)";
		System.out.println(sql);
		// 1. DB connection
		Connection conn = DBConnection.dbConn();
		// 2. create the statememt
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, student.getName());
		try {
			stat.execute();
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
			return false;
		}
		return true;
	}

	public List<Student> getAllStudents() throws SQLException {
		List<Student> students = new ArrayList<Student>();
		String sql = "select * from student";

		// 1. DB connection
		Connection conn = DBConnection.dbConn();
		// 2. create the statememt
		Statement stat = conn.createStatement();
		// 3. execute the query
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			Student student = new Student();
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			students.add(student);
		}
		return students;
	}

	public int getStudentIdByName(String name) throws SQLException {
		String sql = "select * from student where name=?";

		// 1. DB connection
		Connection conn = DBConnection.dbConn();
		// 2. create the statememt
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, name);
		// 3. execute the query
		ResultSet rs = stat.executeQuery();
//		int subjectId = 0;
//		if (rs.next()) {
//			subjectId = rs.getInt(rs.getInt(1));
//		}
		Student student = new Student();
		while (rs.next()) {
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
		}

		return student.getId();
	}
	
	public Student getStudentById(int id) throws SQLException {
		String sql = "select * from student where id=?";

		// 1. DB connection 
		Connection conn = DBConnection.dbConn();
		//2. create the statememt
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setInt(1, id);
		// 3. execute the query
		Student s = null;
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			s= new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
		}
		return s;
	}
}
