package com.projects.springbootdockerizedapplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projects.springbootdockerizedapplication.service.IStudentService;
import com.projects.springbootdockerizedapplication.util.StudentResponse;

@RestController
@RequestMapping(value="students")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@GetMapping
	public ResponseEntity<?> getStudents() {
		
		LOGGER.info("Retrieving student details ----");
		
		List<StudentResponse> studentResponseList  = studentService.getStudents();

		LOGGER.info("Retrieved student details ----");
		
		return new ResponseEntity<>(studentResponseList, HttpStatus.OK);
	}
	
}
