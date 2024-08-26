package com.result.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.result.entity.Result;
import com.result.repository.ResultRepository;

@Repository
public class ResultDao {

	@Autowired
	ResultRepository rr;

	public String set(Result a) {
		rr.save(a);
		return "Saved";
	}

	public String setAll(Result result) {
		rr.save(result);
		return "---> Saved All <---";
	}

	public List<Result> getall() {

		return rr.findAll();
	}

	public List<Result> getTop3() {

		return rr.getTop3();
	}

	public Result getFrist() {
		return rr.getFrist();
	}

	public List<Result> get70to80() {

		return rr.get70to80();
	}

	public String setAllRe(List<Result> lst) {
		rr.saveAll(lst);
		return "----->> Saved List of data's <<------";
	}

}
