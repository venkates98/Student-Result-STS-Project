package com.result.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.result.entity.MarkSheet;
import com.result.entity.Result;
import com.result.entity.Students;
import com.result.service.ResultService;

@RestController
@RequestMapping("result")
public class ResultController {

	@Autowired
	RestTemplate rt;
	ResultService rs;

	@GetMapping(value = "/getresult")
	public List<Result> getresult() {
		return rs.getresult();
	}

	@PostMapping(value = "/setall/{a}") /// --->> Single object posted method .....!
	public String setall(@RequestBody Result result, @PathVariable int a) {

		String url1 = "http://localhost:8080/Stu/getbyrollno/";
		String url2 = "http://localhost:8081/mark/getbyRN/";

		ResponseEntity<Students> re1 = rt.exchange(url1 + a, HttpMethod.GET, null, Students.class);

		ResponseEntity<MarkSheet> re2 = rt.exchange(url2 + a, HttpMethod.GET, null, MarkSheet.class);

		Students stu = re1.getBody();
		MarkSheet mar = re2.getBody();

		result.setName(stu.getName());
		result.setRollnumer(mar.getRollnumber());

		if (stu.getAttendance() > 95) {
			result.setTotalMarks(mar.getSem1Total() + mar.getSem2Total() + 5);
		} else {
			result.setTotalMarks(mar.getSem1Total() + mar.getSem2Total());
		}
		result.setPercentage(result.getTotalMarks() / 4);
		return rs.setall(result);
	}

	@PostMapping(value = "setAllResult") // ------>>> List Of object post in single time multiple Object post Method
	public String setAllre(@RequestBody List<Result> r) {

		List<Result> lst = new ArrayList<>();

		for (Result d : r) {

			String url1 = "http://localhost:8080/Stu/getbyrollno/";
			String url2 = "http://localhost:8081/mark/getbyRN/";

			int sr1 = d.getRollnumer();

			ResponseEntity<Students> res1 = rt.exchange(url1 + sr1, HttpMethod.GET, null,
					new ParameterizedTypeReference<Students>() {
					});
			ResponseEntity<MarkSheet> res2 = rt.exchange(url2 + sr1, HttpMethod.GET, null,
					new ParameterizedTypeReference<MarkSheet>() {
					});

			Students stu = res1.getBody();
			MarkSheet mar = res2.getBody();

			d.setName(stu.getName());

			int total = mar.getSem1Total() + mar.getSem2Total();

			if (stu.getAttendance() > 90 && total < 395) {
				d.setTotalMarks(total + 5);
			} else {
				d.setTotalMarks(total);
			}

			d.setPercentage((mar.getSem1Total() + mar.getSem2Total()) / 4);

			lst.add(d);
		}

		return rs.setAllre(lst);
	}

	@GetMapping(value = "/getTop3")
	public List<Result> getTop3() {
		return rs.getTop3();
	}

	@GetMapping(value = "/getFirstMark")
	public Result getFirst() {
		return rs.getFrist();
	}

	@GetMapping(value = "/get70to100")
	public List<Result> get70t80() {
		return rs.get70to80();
	}

}