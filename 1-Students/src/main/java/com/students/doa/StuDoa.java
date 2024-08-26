package com.students.doa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.students.entity.Students;
import com.students.repository.StuRepository;

@Repository
public class StuDoa {

	@Autowired
	StuRepository sd;

	public String setStu(Students s) {
		sd.save(s);
		return "Saved";
	}

	public String setAllStu(List<Students> s) {
		sd.saveAll(s);
		return "All file Saved ";
	}

	public List<Students> getAll() {

		return sd.findAll();
	}

	public Students getByRN(int r) {
		
		return sd.getByRN(r);
	}

}
