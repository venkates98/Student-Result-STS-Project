package com.result.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.result.dao.ResultDao;
import com.result.entity.Result;

@Service
public class ResultService {

	@Autowired
	ResultDao rd;

	public String set(Result a) {

		return rd.set(a);
	}

	public String setall(Result result) {

		return rd.setAll(result);
	}

	public List<Result> getresult() {

		return rd.getall();
	}

	public List<Result> getTop3() {
		return rd.getTop3();
	}

	public Result getFrist() {
 		return rd.getFrist();
	}

	public List<Result> get70to80() {

		return rd.get70to80();
	}

	public String setAllre(List<Result> lst) {

		return rd.setAllRe(lst);
	}

}
