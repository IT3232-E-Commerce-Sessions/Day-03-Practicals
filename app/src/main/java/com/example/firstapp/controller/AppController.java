package com.example.firstapp.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstapp.model.Student;


@RestController
@RequestMapping("/app")
public class AppController {
	Student s1= new Student("2020ICT07", "Udara", 24, "ICT", 3.9);
	Student s2= new Student("2020ICT06", "Jello", 27, "ICT", 3.2);
	Student s3= new Student("2020ICT91", "Dilmy", 32, "ICT", 2.9);
	
	List<Student> students= new ArrayList<Student>();
	
	public AppController() {
		students.add(s1);
		students.add(s2);
		students.add(s3);
	}
	
	
	@GetMapping("/msg")
	public String myMessage() {
		return "Hello Springboot";
	}
	
	@GetMapping("/name")
	public String myName() {
		return "My Name is  Springboot";
	}
	
	@GetMapping("/age/{ag}")
	public String MyAge(@PathVariable("ag") int age) {
		return "My Age is " +age;
	}
	
	//A method to return a student
	@GetMapping("/student")
	public Student getStudent() {
		return s1;
	}
	
	
	@GetMapping("students")
	public List<Student> getStudents(){
		return students;
	}
	
	@GetMapping("/students/{reg}")
	public Student GetStudentbyRegNo(@PathVariable("reg") String regNo) {
		for(Student student:students) {
			if(student.getRegNo().equals(regNo)) {
				return student;
			}
		}
		return null;
		
	}
	
	

	@GetMapping("/students/age-between")
	public List<Student> getStudentsByAgeRang(){
		return students.stream()
				.filter(student -> student.getAge() >= 20 && student.getAge()<=23)
				.collect(Collectors.toList());
	}
	

	
	//Create - Add a new student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		students.add(student);
		return student;
	}
	
	//Update
	
	 @PutMapping("/students/{id}")
	    public Student updateStudent(@PathVariable("id") String regno, @RequestBody Student updatedStudent) {
	        for (int i = 0; i < students.size(); i++) {
	            Student student = students.get(i);
	            if (student.getRegNo().equals(regno)) {
	 
	                student.setName(updatedStudent.getName());
	                student.setAge(updatedStudent.getAge());
	                student.setCourse(updatedStudent.getCourse());
	                student.setGpa(updatedStudent.getGpa());
	                return student;
	            }
	        }
	        return null; 
	    }
	
	//Delete
	 
	 @DeleteMapping("/students/{id}")
	    public boolean deleteStudent(@PathVariable("id") String regno) {
	        return students.removeIf(student -> student.getRegNo().equals(regno));
	    }
}
