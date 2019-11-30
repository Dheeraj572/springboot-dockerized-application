package com.projects.springbootdockerizedapplication.service;

import java.util.List;

import com.projects.springbootdockerizedapplication.util.StudentResponse;

public interface IStudentService {

	List<StudentResponse> getStudents();
}
