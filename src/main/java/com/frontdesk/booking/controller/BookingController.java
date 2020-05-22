package com.frontdesk.booking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frontdesk.booking.model.BookingEntity;
import com.frontdesk.booking.model.BookingRequest;
import com.frontdesk.booking.model.BookingResponse;
import com.frontdesk.booking.model.DoctorEntity;
import com.frontdesk.booking.model.PatientEntity;
import com.frontdesk.booking.service.BookingService;

@RestController
@RequestMapping("/frontdesk")
@CrossOrigin(origins= "*",allowedHeaders="*")

public class BookingController {

	@Autowired
	BookingService bookingService;

	@GetMapping("/doctors")
	public ResponseEntity<List<DoctorEntity>> getdoctorDetails() {
		List<DoctorEntity> theDoctorList = bookingService.getAllDoctors();

		return new ResponseEntity<List<DoctorEntity>>(theDoctorList, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/patients")
	public ResponseEntity<List<PatientEntity>> getpatientDetails() {
		List<PatientEntity> thePatientList = bookingService.getAllPatients();

		return new ResponseEntity<List<PatientEntity>>(thePatientList, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/booking/{booking_id}")
	public ResponseEntity<List<BookingResponse>> getEmployeeById(@PathVariable("booking_id") Long pBookingid) {
		BookingResponse aBookingResponse = bookingService.getBookingDetails(pBookingid);
		List<BookingResponse> theBookingResponseList =new ArrayList<BookingResponse>();
		if (aBookingResponse != null) {
			theBookingResponseList.add(aBookingResponse);
			return new ResponseEntity<List<BookingResponse>>(theBookingResponseList, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<BookingResponse>>(theBookingResponseList, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/checkavailability/{specialist}")
	public ResponseEntity<List<DoctorEntity>> checkAvailabityList(@PathVariable("specialist") String pSpecialist) {
		List<DoctorEntity> theEntity = bookingService.checkAvailability(pSpecialist);
		if (theEntity != null && !theEntity.isEmpty()) {
			return new ResponseEntity<List<DoctorEntity>>(theEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<DoctorEntity>>(theEntity, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/newbooking")
	public ResponseEntity<List<String>> createNewBooking(@RequestBody BookingRequest pNewBooking) {		
		BookingEntity newBooking = bookingService.createNewBooking(pNewBooking);	
		List<String> response = new ArrayList<String>();
		response.add(String.valueOf(newBooking.getId()));
		return new ResponseEntity<List<String>>(response, HttpStatus.OK);
	}
}
