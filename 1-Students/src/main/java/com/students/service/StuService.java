package com.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.customexception.AgeInvalidException;
import com.students.doa.StuDoa;
import com.students.entity.Students;

@Service
public class StuService {

	@Autowired
	StuDoa sd;

	public String setStu(Students s) throws AgeInvalidException {
		if(s.getAge()<18) {
			throw new AgeInvalidException("NOT ALLOWED");
		}

		return sd.setStu(s);
	}

	public String setAllStu(List<Students> s) throws AgeInvalidException {

		List<Students> list=s.stream().filter(d->d.getAge()<18).toList();
		if(list.isEmpty()) {
			return sd.setAllStu(s);	 
		}
		
		else {
			throw new AgeInvalidException("NOT ALLOWED") ;
	
		}
	}

	public List<Students> getAll() {
		
		return sd.getAll();
	}

	public Students getByRN(int r) {
		
		return sd.getByRN(r);
	}

}
