package com.tmcmum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tmcmum.exception.StudentNotFoundException;
import com.tmcmum.mapper.Cloner;
import com.tmcmum.model.Student;
import com.tmcmum.service.StudentService;
import com.tmcmum.util.CustomErrorType;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class StudentController {

	public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     dateFormat.setLenient(false);
     webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
     }

	@Autowired
	StudentService studentService; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All
	// Students---------------------------------------------

	@RequestMapping(value = "/student/", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listAllStudents() {
		List<Student> students = studentService.findAllStudents();
		if (students.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<Page<Student>> getAllStudents(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Page<Student> students = studentService.findAllStudents(PageRequest.of(page, size));

		if (students.getSize() == 0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Page<Student>>(students, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Student------------------------------------------

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getStudent(@PathVariable("id") long id) {
		logger.info("Fetching Student with id {}", id);
		Student student = studentService.findById(id);
		if (student == null) {
			logger.error("Student with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Student with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	// -------------------Create a
	// Student-------------------------------------------

	@RequestMapping(value = "/students/", method = RequestMethod.POST)
	public ResponseEntity<?> createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Student : {}", student);

		if (studentService.isStudentExist(student)) {
			logger.error("Unable to create. A Student with name {} already exist", student.getName());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A Student with name " + student.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		studentService.saveStudent(student);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/students/{id}").buildAndExpand(student.getId()).toUri());
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	// ------------------- Update a Student
	// ------------------------------------------------

	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
		logger.info("Updating Student with id {}", id);

		Student currentStudent = studentService.findById(id);

		if (currentStudent == null) {
			logger.error("Unable to update. Student with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Student with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentStudent = Cloner.MAPPER.clone(student);

		studentService.updateStudent(currentStudent);
		return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
	}

	// ------------------- Delete a Student-----------------------------------------

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStudent(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Student with id {}", id);

		Student student = studentService.findById(id);
		if (student == null) {
			logger.error("Unable to delete. Student with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Student with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		studentService.deleteStudentById(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Students-----------------------------

	@RequestMapping(value = "/students/", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteAllStudents() {
		logger.info("Deleting All Students");

		studentService.deleteAllStudents();
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

	// --------------------search Student

	@RequestMapping(value = "/students/get", params = { "page", "size", "searchText" }, method = RequestMethod.GET, produces = "application/json")
	public Page<Student> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size,
		@RequestParam("searchText") String searchText ) throws StudentNotFoundException {
		page = Math.max(page-1, 0);
		Page<Student> resultPage = null;
		if (StringUtils.isBlank(searchText)) {
			resultPage = studentService.findPaginated(page, size);
		} else {
			resultPage = studentService.findPaginated(page, size, searchText);
		}
		if (page > resultPage.getTotalPages()) {
			throw new StudentNotFoundException();
		}
		return resultPage;
	}

}