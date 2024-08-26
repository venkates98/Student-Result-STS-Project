package com.studentsmarksheet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsmarksheet.dao.MarkDoa;
import com.studentsmarksheet.entity.MarkSheet;

@Service
public class MarkService {

	@Autowired
	MarkDoa md;

	public String setMark(MarkSheet m) {

		m.setSem1Total(m.getSem1T() + m.getSem1P());
		m.setSem2Total(m.getSem2T() + m.getSem2P());

		return md.setmark(m);
	}

	public String setAll(List<MarkSheet> m) {

		for (MarkSheet j : m) {
			j.setSem1Total(j.getSem1P() + j.getSem1T());
			j.setSem2Total(j.getSem2P() + j.getSem2T());
		}
		return md.setAll(m);

	}

	public List<MarkSheet> getAll() {

		return md.getAll();
	}

	public List<Integer> getTotal() {
		List<MarkSheet> ah = md.getAll();
		List<Integer> h = ah.stream().map(f -> f.getSem1Total() + f.getSem2Total()).collect(Collectors.toList());
		return h;
	}

	public MarkSheet getbyRolNo(int a) {
		return md.getbyRN(a);
	}

}
