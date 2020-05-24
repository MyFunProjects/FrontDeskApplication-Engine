package com.frontdesk.booking.model;

public class UpdateStatus {
	public Long booking_id;
	public String bookingStatus;
	public Long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public String toString() {
		return "UpdateStatus [booking_id=" + booking_id + ", bookingStatus=" + bookingStatus + "]";
	}	
}
