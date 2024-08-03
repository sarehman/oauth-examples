package com.tmcmum.repository;

import com.tmcmum.model.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findByName(String name);

	@Query("SELECT s FROM Student s WHERE LOWER(s.name) like LOWER(CONCAT('%', :searchText, '%'))" +
		" OR LOWER(s.grNo) like LOWER(CONCAT('%', :searchText, '%')) " +
		" OR LOWER(s.uid) like LOWER(CONCAT('%', :searchText, '%')) " +
		" OR LOWER(s.dob) like LOWER(CONCAT('%', :searchText, '%')) " +
		" OR LOWER(DATE_FORMAT(s.dateAdmission, '%Y-%m-%d')) like LOWER(CONCAT('%', :searchText, '%')) ")
	Page<Student> find(@Param("searchText") String searchTerm, 
	Pageable pageRequest);
}
 