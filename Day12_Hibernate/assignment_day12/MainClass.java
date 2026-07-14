package com.coforge.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Course;
import com.coforge.model.Student;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//each transaction needs one session
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//insert
		/*Student student = new Student(101, "Neha");
		Course course = new Course(1, "SQL");
		
		student.getCourses().add(course);*/
		/* insert and get
		// Students
		Student s1 = session.get(Student.class, 101);
		Student s2 = new Student(102, "Harshika");
		Student s3 = new Student(103, "Satvika");
		Student s4 = new Student(104, "Sakshi");
		Student s5 = new Student(105, "Aradhaya");

		// Courses
		Course c1 = session.get(Course.class,1);
		Course c2 = new Course(2, "Hibernate");
		Course c3 = new Course(3, "Java");

		s1.getCourses().add(c2);

		s2.getCourses().add(c2);
		s2.getCourses().add(c3);

		s3.getCourses().add(course);
		s3.getCourses().add(c3);

		s4.getCourses().add(c2);

		s5.getCourses().add(course);
		s5.getCourses().add(c2);
		s5.getCourses().add(c3);

		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		*/
		/*
		//update
		Student s5 = new Student(105, "Aardhaya");
//		Student s5 = session.get(Student.class, 105);
//		s5.setStudent_name("Aardhaya");
//		session.update(s5);
		session.update(s5);
		*/
		
		/* if we don't use cascadeType.ALL then we have to do it in below way
		 Student s5 = session.get(Student.class, 105);
		s5.getCourses().clear();
		session.delete(s5);
		 */
		//delete
		Student s5 = session.get(Student.class, 105);
		session.delete(s5);
		transaction.commit();
		session.close();
		factory.close();
		
		System.out.println("Student Object Saved");
	}

}
