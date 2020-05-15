package com.frontdesk.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PATIENTS")

public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "age")
	private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long pPatientID) {
		this.id = pPatientID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String pFirstName) {
		this.firstName = pFirstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int pAge) {
		this.age = pAge;
	}

	@Override
	public String toString() {
		return "PatientEntity [id=" + id + ", firstName=" + firstName + ", age=" + age + "]";
	}

}
