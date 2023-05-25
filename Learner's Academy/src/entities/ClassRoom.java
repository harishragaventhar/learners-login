package entities;

import database.SubjectDatabase;

public class ClassRoom {
 
	private int id;
	private String name;
	private String day;
	private String time;
	private Subject subject;
	private Teacher teacher;
	private Student student;
	
	public ClassRoom() {
		
	}

	public ClassRoom(int id, String name, String day, String time, Subject subject, Teacher teacher, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.day = day;
		this.time = time;
		this.subject = subject;
		this.teacher = teacher;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject= subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", day=" + day + ", time=" + time + ", subject=" + subject
				+ ", teacher=" + teacher + ", student=" + student + "]";
	}
	
	
	
}
