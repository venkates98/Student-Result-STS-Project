package com.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.students.entity.Students;

public interface StuRepository extends JpaRepository<Students, Integer> {

	@Query(value = "select * from stu_details where rollnumber= ?", nativeQuery = true)
	Students getByRN(int r);

}
