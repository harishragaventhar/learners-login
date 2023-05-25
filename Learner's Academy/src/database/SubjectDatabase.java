package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Subject;

public class SubjectDatabase {

	public boolean insertSubject(Subject subject) throws SQLException {
		// String sql = "insert into customer values('" + customer.getEmail()+
		// "','"+ customer.getPhone()+ "','"+customer.getPassword() +
		// "','"+customer.getCity()+"',"+customer.isIsmember()+")";
		String sql = " insert into subject (name)" + " values(?)";
		System.out.println(sql);
		// 1. DB connection
		Connection conn = DBConnection.dbConn();
		// 2. create the statememt
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, subject.getName());
		try {
			stat.execute();
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
			return false;
		}
		return true;
	}

	public List<Subject> getAllSubjects() throws SQLException {
		List<Subject> subjects = new ArrayList<Subject>();
		String sql = "select * from subject";

		// 1. DB connection
		Connection conn = DBConnection.dbConn();
		// 2. create the statememt
		Statement stat = conn.createStatement();
		// 3. execute the query
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			Subject subject = new Subject();
			subject.setId(rs.getInt(1));
			subject.setName(rs.getString(2));
			subjects.add(subject);
		}
		return subjects;
	}

	public int getSubjectIdByName(String name) throws SQLException {
		String sql = "select * from subject where name=?";

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
		Subject subject = new Subject();
		while (rs.next()) {
			subject.setId(rs.getInt(1));
			subject.setName(rs.getString(2));
		}

		return subject.getId();
	}
	
	public Subject getSubjectById(int id) throws SQLException {
		String sql = "select * from subject where id=?";

		// 1. DB connection 
		Connection conn = DBConnection.dbConn();
		//2. create the statememt
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setInt(1, id);
		// 3. execute the query
		Subject s = null;
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			s= new Subject();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
		}
		return s;
	}
}
