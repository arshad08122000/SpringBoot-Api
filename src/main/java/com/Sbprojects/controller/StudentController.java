package com.Sbprojects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sbprojects.entity.Student;
import com.Sbprojects.repository.StudentRepository;
import com.Sbprojects.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studser;
	
	@PostMapping(value="/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student stu)
	{
		if((stu.getName() ==null) || (stu.getEmail() ==null) || (stu.getAddress() == null))
		{
			return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Student>(studser.Create(stu),HttpStatus.CREATED);	
	}
	
	@RequestMapping(value="/getall")
	public ResponseEntity<List<Student>> getallStudent()
	{
		return new ResponseEntity<List<Student>>(studser.getall(),HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<Student> upstudent(@PathVariable(value="id") long id,@RequestBody Student stu)
	{
		return new ResponseEntity<Student>(studser.updatestudent(id,stu),HttpStatus.OK);
	}
	
	@RequestMapping(value="/get/{id}")
	public ResponseEntity<Student> getstud(@PathVariable(value="id") long id)
	{
		return new ResponseEntity<Student>(studser.getstudent(id),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deletestud(@PathVariable(value="id") long id)
	{
		return new ResponseEntity<String>(studser.deleteStudent(id),HttpStatus.OK);
	}
}
