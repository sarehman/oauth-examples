package com.tmcmum.service;

import java.util.List;

import com.tmcmum.model.Student;
import com.tmcmum.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student findById(Long id) {
		return studentRepository.getOne(id);
	}

	@Override
	public Student findByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void updateStudent(Student student){
		saveStudent(student);
	}

	@Override
	public void deleteStudentById(Long id){
		studentRepository.deleteById(id);
	}

	@Override
	public void deleteAllStudents(){
		studentRepository.deleteAll();
	}

	@Override
	public List<Student> findAllStudents(){
		return studentRepository.findAll();
	}
	
	@Override
	public Page<Student> findAllStudents(PageRequest pageRequest){
		return studentRepository.findAll(pageRequest);
	}

	@Override
	public boolean isStudentExist(Student student) {
		return findByName(student.getName()) != null;
	}

	@Override
    public Page<Student> findPaginated(int page, int size) {
        return studentRepository.findAll(PageRequest.of(page, size));
    }
	
	@Override
    public Page<Student> findPaginated(int page, int size, String searchText) {
        return studentRepository.find(searchText, PageRequest.of(page, size));
    }

}
