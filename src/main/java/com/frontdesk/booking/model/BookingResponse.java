package com.frontdesk.booking.model;

public class BookingResponse {

	public long bookingID;
	public DoctorEntity doctorDetails;
	public PatientEntity patientDetails;
	public String bookedSlot;
	public String comments;
	public String status;

	public long getBookingID() {
		return bookingID;
	}

	public void setBookingID(long pBookingID) {
		this.bookingID = pBookingID;
	}

	public DoctorEntity getDoctorDetails() {
		return doctorDetails;
	}

	public void setDoctorDetails(DoctorEntity pDoctorDetails) {
		this.doctorDetails = pDoctorDetails;
	}

	public PatientEntity getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(PatientEntity pPatientDetails) {
		this.patientDetails = pPatientDetails;
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
		return "BookingResponse [bookingID=" + bookingID + ", doctorDetails=" + doctorDetails + ", patientDetails="
				+ patientDetails + ", bookedSlot=" + bookedSlot + ", comments=" + comments + ", status=" + status + "]";
	}
}
