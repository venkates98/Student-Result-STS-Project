package com.studentsmarksheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentsmarksheet.entity.MarkSheet;

public interface MarkRepository extends JpaRepository<MarkSheet, Integer> {

	@Query(value = "select * from mark_sheet where rollnumber= ?", nativeQuery = true)
	MarkSheet getbyRN(int a);

}
