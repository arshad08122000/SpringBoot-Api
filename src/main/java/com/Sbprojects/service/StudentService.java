package com.Sbprojects.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sbprojects.entity.Student;
import com.Sbprojects.repository.StudentRepository;

@Service
public class StudentService implements IStudentService{

	@Autowired
	private StudentRepository studrepo;
	
	@Override
	public Student Create(Student student) 
	{
		return studrepo.save(student);
	}

	@Override
	public List<Student> getall() {
		// TODO Auto-generated method stub
		return studrepo.findAll();
	}

	@Override
	public Student updatestudent(long id, Student student) {
		student.setId(id);
		return studrepo.save(student);
	}

	@Override
	public String deleteStudent(long id) {
		Optional<Student> stud=studrepo.findById(id);
		if(stud.get()==null)
		{
			return "Student not found";
		}
		studrepo.delete(stud.get());
		return "Student Deleted Sucessfully";
	}

	@Override
	public Student getstudent(long id) {
		Optional<Student> stud=studrepo.findById(id);
		return stud.get();
	}
	
	
}
