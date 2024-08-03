package com.tmcmum.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.tmcmum.model.Student;

public interface StudentService {
	
	Student findById(Long id);

	Student findByName(String name);

	void saveStudent(Student user);

	void updateStudent(Student user);

	void deleteStudentById(Long id);

	void deleteAllStudents();

	List<Student> findAllStudents();

	boolean isStudentExist(Student user);

	Page<Student> findPaginated(int page, int size);

	Page<Student> findPaginated(int page, int size, String searchText);
	
	Page<Student> findAllStudents(PageRequest pageRequest);
}