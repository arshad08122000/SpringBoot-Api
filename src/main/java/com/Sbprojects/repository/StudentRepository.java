package com.Sbprojects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sbprojects.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

	
}
