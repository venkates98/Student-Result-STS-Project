package com.studentsmarksheet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentsmarksheet.entity.MarkSheet;
import com.studentsmarksheet.repository.MarkRepository;

@Repository
public class MarkDoa {

	@Autowired
	MarkRepository mr;

	public String setmark(MarkSheet m) {
		mr.save(m);
		return "->Saved<- ";
	}

	public String setAll(List<MarkSheet> m) {
		mr.saveAll(m);
		return "->-> Saved <-<-";
	}

	public List<MarkSheet> getAll() {
		
		return mr.findAll();
	}

	public MarkSheet getbyRN(int a) {
		
		return mr.getbyRN(a);
	}

}
