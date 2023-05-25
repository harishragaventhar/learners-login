package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Subject;
import entities.Teacher;

public class TeacherDatabase {

	public boolean insertTeacher(Teacher teacher) throws SQLException {
		String sql = " insert into teacher (name, email)" + " values(?,?)";
		System.out.println(sql);
		// 1. DB connection
		Connection conn = DBConnection.dbConn();
		// 2. create the statememt
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, teacher.getName());
		stat.setString(2, teacher.getEmail());
		try {
			stat.execute();
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
			return false;
		}
		return true;
	}

	public List<Teacher> getAllTeachers() throws SQLException {
		List<Teacher> teachers = new ArrayList<Teacher>();
		String sql = "select * from teacher";

		// 1. DB connection
		Connection conn = DBConnection.dbConn();
		// 2. create the statememt
		Statement stat = conn.createStatement();
		// 3. execute the query
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			Teacher teacher = new Teacher();
			teacher.setId(rs.getInt(1));
			teacher.setName(rs.getString(2));
			teacher.setEmail(rs.getString(3));

			teachers.add(teacher);
		}
		return teachers;
	}

	public int getTeacherIdByName(String name) throws SQLException {
		String sql = "select * from teacher where name=?";

		// 1. DB connection
		Connection conn = DBConnection.dbConn();
		// 2. create the statememt
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, name);
		// 3. execute the query
		ResultSet rs = stat.executeQuery();
		Teacher teacher = new Teacher();
//		int teacherId = 0;
//		if (rs.next()) {
//			teacherId = rs.getInt(rs.getInt(2));
//		}
		while (rs.next()) {
			teacher.setId(rs.getInt(1));
			teacher.setName(rs.getString(2));
			teacher.setEmail(rs.getString(3));
		}


		return teacher.getId();
	}
	
	public Teacher getTeacherById(int id) throws SQLException {
		String sql = "select * from teacher where id=?";

		// 1. DB connection 
		Connection conn = DBConnection.dbConn();
		//2. create the statememt
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setInt(1, id);
		// 3. execute the query
		Teacher t = null;
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			t= new Teacher();
			t.setId(rs.getInt(1));
			t.setName(rs.getString(2));
			t.setEmail(rs.getString(3));
		}
		return t;
	}
}
