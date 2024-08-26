package com.studentsmarksheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentsmarksheet.entity.MarkSheet;
import com.studentsmarksheet.service.MarkService;



@RestController
@RequestMapping("mark")
public class MarkController {

	@Autowired
	MarkService ms;

	@PostMapping(value = "/setmark")
	public String setMark(@RequestBody MarkSheet m) {
		return ms.setMark(m);
	}

	@PostMapping(value = "/setAll")
	public String setAll(@RequestBody List<MarkSheet> m) {
		return ms.setAll(m);
	}

	@GetMapping(value = "/getAllMark")
	public List<MarkSheet> getAll() {
		return ms.getAll();

	}

	@GetMapping(value ="/getTotal")
	public  List<Integer> getTotal() {
		return ms.getTotal();
	}
	@GetMapping(value ="/getbyRN/{a}")
	public MarkSheet getbyRN(@PathVariable int a) {
		return ms.getbyRolNo(a);
	}
}
