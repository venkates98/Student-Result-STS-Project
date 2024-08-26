package com.result.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.result.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {

	@Query(value = "select * from results order by total_marks desc limit 3", nativeQuery = true)
	List<Result> getTop3();

	@Query(value = "select * from results order by total_marks desc limit 1", nativeQuery = true)
	Result getFrist();

	@Query(value = "select * from results where percentage>85 and percentage< 100",nativeQuery = true)
	List<Result> get70to80();

}
