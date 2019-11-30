package com.projects.springbootdockerizedapplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
	
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStudents() {

		List<StudentResponse> studentResponseList = studentService.getStudents();

		return new ResponseEntity<>(studentResponseList, HttpStatus.OK);
	}
}
