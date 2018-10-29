package com.example.LibraryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.request.StudentCreation;
import com.example.LibraryManagement.request.StudentEdit;
import com.example.LibraryManagement.response.StudentResponse;
import com.example.LibraryManagement.service.StudentService;

@RestController
@RequestMapping("rest/students")
class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody StudentCreation studentCreation) {
		studentService.createStudent(studentCreation);
		return new ResponseEntity<>("DONE", HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getStudent(@RequestHeader Long id) {
		StudentResponse sr = studentService.getStudent(id);
		return new ResponseEntity<>(sr, HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Object> editStudent(@RequestBody StudentEdit studentEdit) {
		studentService.editStudent(studentEdit);
		return new ResponseEntity<>("EDITED", HttpStatus.ACCEPTED);

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@RequestHeader Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<>("DONE", HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "getall", method = RequestMethod.GET)
	public ResponseEntity<Object> getallStudent() {
		List<StudentResponse> sr = studentService.getallStudent();
		return new ResponseEntity<>(sr, HttpStatus.ACCEPTED);
	}

}
