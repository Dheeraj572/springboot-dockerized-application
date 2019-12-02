package com.projects.springbootdockerizedapplication.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.springbootdockerizedapplication.entity.Student;
import com.projects.springbootdockerizedapplication.util.StudentResponse;

@Service
public class StudentService implements IStudentService{

	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	
	List<Student> studentList = Arrays.asList(new Student(1L, "Student1", "Java"),new Student(2L, "Student2", "C"),new Student(3L, "Student3", "Python"));
	
	public List<StudentResponse> getStudents(){
		
		LOGGER.info("Mapping Student list to StudentResponse List --------");
		
		List<StudentResponse> studentResponseList = studentList.stream()
				.map(mapper -> objectMapper.convertValue(mapper, StudentResponse.class)).collect(Collectors.toList());
		
		LOGGER.info("Mapped Student list to StudentResponse List --------");
		
		return studentResponseList;
	}
}
