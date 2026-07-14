package com.coforge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_student")
public class Student {

	@Id //primary key
	@Column(name = "student_id", length =5)
	private int student_id;
	
	@Column(name = "student_name", length =30)
	private String student_name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable (
			name="student_course",
	        joinColumns=@JoinColumn(name="student_id"),
	        inverseJoinColumns=@JoinColumn(name="course_id")
			)
	
	private Set<Course> courses = new HashSet<Course>(); 
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Student(int student_id, String student_name) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
}
