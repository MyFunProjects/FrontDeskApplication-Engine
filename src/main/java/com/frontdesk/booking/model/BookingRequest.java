package com.frontdesk.booking.model;

public class BookingRequest {

	public PatientEntity patientDetails;
	public DoctorEntity doctorDetails;
	public String bookedSlot;
	public String comments;
	public String status;

	public DoctorEntity getDoctorDetails() {
		return doctorDetails;
	}

	public PatientEntity getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(PatientEntity patientDetails) {
		this.patientDetails = patientDetails;
	}

	public void setDoctorDetails(DoctorEntity pDoctorDetails) {
		this.doctorDetails = pDoctorDetails;
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
		return "BookingRequest [patientDetails=" + patientDetails + ", doctorDetails=" + doctorDetails + ", bookedSlot="
				+ bookedSlot + ", comments=" + comments + ", status=" + status + "]";
	}
}
