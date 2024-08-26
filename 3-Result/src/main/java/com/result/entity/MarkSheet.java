package com.result.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mark_sheet")
public class MarkSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int rollnumber;
	private int sem1T;
	private int sem1P;
	private int sem2T;
	private int sem2P;
	private int sem1Total;
	private int sem2Total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}

	public int getSem1T() {
		return sem1T;
	}

	public void setSem1T(int sem1t) {
		sem1T = sem1t;
	}

	public int getSem1P() {
		return sem1P;
	}

	public void setSem1P(int sem1p) {
		sem1P = sem1p;
	}

	public int getSem2T() {
		return sem2T;
	}

	public void setSem2T(int sem2t) {
		sem2T = sem2t;
	}

	public int getSem2P() {
		return sem2P;
	}

	public void setSem2P(int sem2p) {
		sem2P = sem2p;
	}

	public int getSem1Total() {
		return sem1Total;
	}

	public void setSem1Total(int sem1Total) {
		this.sem1Total = sem1Total;
	}

	public int getSem2Total() {
		return sem2Total;
	}

	public void setSem2Total(int sem2Total) {
		this.sem2Total = sem2Total;
	}

}
