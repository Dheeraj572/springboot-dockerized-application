package com.projects.springbootdockerizedapplication.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.springbootdockerizedapplication.entity.Student;
import com.projects.springbootdockerizedapplication.util.StudentResponse;

@Service
public class StudentService implements IStudentService{

	private ObjectMapper objectMapper = new ObjectMapper();
	
	List<Student> studentList = Arrays.asList(new Student(1L, "Student1", "Java"),new Student(2L, "Student2", "C"),new Student(3L, "Student3", "Python"));
	public List<StudentResponse> getStudents(){
		
		List<StudentResponse> studentResponseList = studentList.stream()
				.map(mapper -> objectMapper.convertValue(mapper, StudentResponse.class)).collect(Collectors.toList());
		
		return studentResponseList;
	}
}
