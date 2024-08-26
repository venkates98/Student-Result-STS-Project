package com.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.customexception.AgeInvalidException;
import com.students.entity.Students;
import com.students.service.StuService;

@RestController
@RequestMapping("Stu")
public class StuController {
	@Autowired
	StuService ss;

	@PostMapping(value = "/setStu")
	public String setStu(@RequestBody Students s) throws AgeInvalidException {
		return ss.setStu(s);
	}

	@PostMapping(value = "/setAllStu")
	public String setAllStu(@RequestBody List<Students> s) throws AgeInvalidException {
		return ss.setAllStu(s);
	}

	@GetMapping(value = "/getAll")
	public List<Students> getAll() {
		return ss.getAll();
	}
	@GetMapping(value ="/getbyrollno/{r}")
	public Students getByRN(@PathVariable int r ) {
		return ss.getByRN(r);
	}
	
	

}
