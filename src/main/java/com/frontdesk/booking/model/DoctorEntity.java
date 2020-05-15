package com.frontdesk.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_DOCTORS")

public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "specialist")
	private String specialist;

	@Column(name = "avail_time")
	private String availableTime;

	public Long getId() {
		return id;
	}

	public void setId(Long pDoctorID) {
		this.id = pDoctorID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String pFirstName) {
		this.firstName = pFirstName;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String pSpecialist) {
		this.specialist = pSpecialist;
	}

	public String getAvail_time() {
		return availableTime;
	}

	public void setAvail_time(String pAvailableTime) {
		this.availableTime = pAvailableTime;
	}

	@Override
	public String toString() {
		return "DoctorEntity [id=" + id + ", firstName=" + firstName + ", specialist=" + specialist + ", availableTime="
				+ availableTime + "]";
	}
}
