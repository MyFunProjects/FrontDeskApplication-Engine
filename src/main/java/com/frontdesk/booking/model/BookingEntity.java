package com.frontdesk.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_BOOKING")

public class BookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "patient_id")
	private long patientID;

	@Column(name = "doctor_id")
	private long doctorID;

	@Column(name = "booked_slot")
	private String bookedSlot;

	@Column(name = "comments")
	private String comments;

	@Column(name = "status")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long pBookingID) {
		this.id = pBookingID;
	}

	public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public long getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(long pDoctorID) {
		this.doctorID = pDoctorID;
	}

	public String getBookedSlot() {
		return bookedSlot;
	}

	public void setBookedSlot(String pBookedSlot) {
		this.bookedSlot = pBookedSlot;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String pComments) {
		this.comments = pComments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String pStatus) {
		this.status = pStatus;
	}

	@Override
	public String toString() {
		return "BookingEntity [id=" + id + ", patientID=" + patientID + ", doctorID=" + doctorID + ", bookedSlot="
				+ bookedSlot + ", comments=" + comments + ", status=" + status + "]";
	}
}
