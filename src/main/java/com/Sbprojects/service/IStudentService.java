package com.Sbprojects.service;

import java.util.List;
import java.util.Optional;

import com.Sbprojects.entity.Student;

public interface IStudentService {
	public Student Create(Student student);
	public List<Student> getall();	
	public Student updatestudent(long id,Student student);
	public String deleteStudent(long id);
	public Student getstudent(long id);
}
