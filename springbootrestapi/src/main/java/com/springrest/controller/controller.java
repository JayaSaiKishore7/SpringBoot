package com.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entity.Student;
import com.springrest.repository.StudentRepository;

@RestController
public class controller {
	@Autowired
	StudentRepository repo;
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		
		List<Student> students = repo.findAll();
		System.out.println(students);
		return students;
		
	
	}
	
	@GetMapping("/students{id}")
	public Student getStudent(@PathVariable int id) {
	 Student s = repo.findById(id).get();
		return s;
		
	}
	
	@PostMapping("/students/add")
	@ResponseStatus(code=HttpStatus.CREATED)
		public String postStudent(@RequestBody Student student) {
			repo.save(student);
			return null;
		}
	
	@PutMapping("/students/update{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setStudentName("roja");
		student.setPercentage(111);
		student.setBranch("mech");
		return repo.save(student);
		
	}
	@DeleteMapping("/students/delete{id}")
	public void deleteStudent(@PathVariable int id) {
		Student s = repo.findById(id).get();
		repo.delete(s);
		
	}
	

}
