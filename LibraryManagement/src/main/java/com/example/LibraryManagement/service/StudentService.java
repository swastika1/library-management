package com.example.LibraryManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryManagement.model.Student;
import com.example.LibraryManagement.repository.StudentRepository;
import com.example.LibraryManagement.request.StudentCreation;
import com.example.LibraryManagement.request.StudentEdit;
import com.example.LibraryManagement.response.StudentResponse;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public void createStudent(StudentCreation studentCreation) {
		Student stud = studentRepository.findByStudentname(studentCreation.getStudentname());
		if (stud == null) {
			Student student = new Student();
			student.setStudentname(studentCreation.getStudentname());
			student.setAddress(studentCreation.getAddress());
			student.setSemester(studentCreation.getSemester());
			student.setBorrowDate(studentCreation.getBorrowdate());
			student.setExpiryDate(studentCreation.getExpirydate());
			student.setMemberType(studentCreation.getMemberType());

			studentRepository.save(student);
		} else {
			throw new ServiceException("ALREADY EXIST");
		}

	}

	@Transactional
	public StudentResponse getStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent()) {
			throw new ServiceException("ID " + id + " NOT FOUND");
		}
		StudentResponse sr = new StudentResponse();
		sr.setId(student.get().getId());
		sr.setStudentname(student.get().getStudentname());
		sr.setAddress(student.get().getAddress());
		sr.setSemester(student.get().getSemester());
		sr.setBorrowdate(student.get().getBorrowDate());
		sr.setExpirydate(student.get().getExpiryDate());
		sr.setMemberType(student.get().getMemberType());

		return sr;

	}

	@Transactional
	public void editStudent(StudentEdit studentEdit) {
		Optional<Student> student = studentRepository.findById(studentEdit.getId());
		if (!student.isPresent()) {
			throw new ServiceException("ID " + studentEdit.getId() + " NOT FOUND");

		}
		student.get().setStudentname(studentEdit.getStudentname());
		student.get().setAddress(studentEdit.getAddress());
		student.get().setSemester(studentEdit.getSemester());
		student.get().setBorrowDate(studentEdit.getBorrowdate());
		student.get().setExpiryDate(studentEdit.getExpirydate());
		student.get().setMemberType(studentEdit.getMemberType());
		studentRepository.save(student.get());

	}

	@Transactional
	public void deleteStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent()) {
			throw new ServiceException("ID " + id + " NOT FOUND");

		}
		studentRepository.delete(student.get());

	}

	@Transactional
	public List<StudentResponse> getallStudent() {
		List<Student> student = studentRepository.findAll();
		if (!student.isEmpty()) {
			throw new ServiceException("NO STUDENT");
		}
		List<StudentResponse> srList = new ArrayList<>();

		student.stream().forEach(u -> {
			StudentResponse sr = new StudentResponse();
			sr.setId(u.getId());
			sr.setStudentname(u.getStudentname());
			sr.setAddress(u.getAddress());
			sr.setSemester(u.getSemester());
			sr.setBorrowdate(u.getBorrowDate());
			sr.setExpirydate(u.getExpiryDate());
			srList.add(sr);
		});
		return srList;
	}

}
