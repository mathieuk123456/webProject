package com.webproject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webproject.entity.Student;
import com.webproject.service.DaoService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private DaoService<Student> daoService;
	
	@Autowired
	private Student student;

	@RequestMapping("studentHandler")
	public String formulaire(Model model) {
		System.out.println("student : " + this.student);

		model.addAttribute("student", this.student);
		
		for( Student s : this.daoService.getAll())
			System.out.println("studentList : " + s);
		model.addAttribute("studentList", this.daoService.getAll());
		return "studentHandler";
	}

	@RequestMapping("studentCreation")
	public String creation(
			@ModelAttribute("student") Student student, 
			Model model ) {
		this.daoService.persist(student);
		model.addAttribute("returnCode", "Student added");
		return "redirect:/student/studentHandler";
	}
	
	@RequestMapping("studentDeletion")
	public String deletion(
			@ModelAttribute("student") Student student, 
			@RequestParam("identifier") int id, 
			Model model) {
		this.daoService.delete( new Student( id ) );
		model.addAttribute("returnCode", "Student deleted");
		return "redirect:/student/studentHandler";
	}
	
	@RequestMapping("studentEdit")
	public String edit(
			@ModelAttribute("student") Student student, 
			@RequestParam("edit") String edit, 
			Model model) {
		System.out.println("edit : " + edit.equals("delete"));
		System.out.println(student);
		if(edit.equals("delete"))
			this.daoService.delete( student );
		if(edit.equals("edit"))
			this.student = student;
		
		model.addAttribute("returnCode", "Student deleted");
		return "redirect:/student/studentHandler";
	}
}
