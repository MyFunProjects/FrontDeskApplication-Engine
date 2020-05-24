package com.frontdesk.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frontdesk.booking.model.BookingEntity;
import com.frontdesk.booking.model.BookingRequest;
import com.frontdesk.booking.model.BookingResponse;
import com.frontdesk.booking.model.DoctorEntity;
import com.frontdesk.booking.model.PatientEntity;
import com.frontdesk.booking.model.UpdateStatus;
import com.frontdesk.booking.repository.BookingRepository;
import com.frontdesk.booking.repository.DoctorRepository;
import com.frontdesk.booking.repository.PatientRepository;

@Service
public class BookingService {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	BookingRepository bookingRepository;

	public List<DoctorEntity> getAllDoctors() {
		List<DoctorEntity> theDoctorList = doctorRepository.findAll();

		if (theDoctorList.size() > 0) {
			return theDoctorList;
		} else {
			return new ArrayList<DoctorEntity>();
		}
	}

	public List<PatientEntity> getAllPatients() {
		List<PatientEntity> thePatientList = patientRepository.findAll();

		if (thePatientList.size() > 0) {
			return thePatientList;
		} else {
			return new ArrayList<PatientEntity>();
		}
	}

	public BookingResponse getBookingDetails(Long pBookinId) {
		BookingResponse aBookingResponse = null;
		Optional<BookingEntity> aNewBooking = bookingRepository.findById(pBookinId);
		if (aNewBooking.isPresent()) {
			Optional<PatientEntity> aPatient = patientRepository.findById(aNewBooking.get().getPatientID());
			Optional<DoctorEntity> aDoctor = doctorRepository.findById(aNewBooking.get().getDoctorID());
			aBookingResponse = BuildBookingResponse(aNewBooking.get(), aPatient.get(), aDoctor.get());
		}
		return aBookingResponse;
	}

	private BookingResponse BuildBookingResponse(BookingEntity pBookingEntity, PatientEntity pPatientEntity,
			DoctorEntity pDoctorEntity) {
		BookingResponse aBookingResponse = new BookingResponse();
		aBookingResponse.setBookingID(pBookingEntity.getId());
		aBookingResponse.setBookedSlot(pBookingEntity.getBookedSlot());
		aBookingResponse.setComments(pBookingEntity.getComments());
		aBookingResponse.setStatus(pBookingEntity.getStatus());
		aBookingResponse.setDoctorDetails(pDoctorEntity);
		aBookingResponse.setPatientDetails(pPatientEntity);
		return aBookingResponse;
	}

	public List<DoctorEntity> checkAvailability(String pSpecialist) {
		List<DoctorEntity> theCheckAvailability = doctorRepository.findBySpecialist(pSpecialist);
		return theCheckAvailability;
	}

	public BookingEntity createNewBooking(BookingRequest pNewBooking) {
		PatientEntity aPatient = new PatientEntity();
		BookingEntity aBooking = new BookingEntity();

		aPatient.setFirstName(pNewBooking.getPatientDetails().getFirstName());
		aPatient.setAge(pNewBooking.getPatientDetails().getAge());
		patientRepository.save(aPatient);

		aBooking.setPatientID(aPatient.getId());
		aBooking.setDoctorID(pNewBooking.getDoctorDetails().getId());
		aBooking.setBookedSlot(pNewBooking.getBookedSlot());
		aBooking.setComments(pNewBooking.getComments());
		aBooking.setStatus(pNewBooking.getStatus());
		bookingRepository.save(aBooking);
		return aBooking;
	}

	@Transactional
	public void updateNewStatus(UpdateStatus pUpdateStatus) {
		Optional<BookingEntity> aStatus = bookingRepository.findById(pUpdateStatus.getBooking_id());
		if (aStatus.isPresent()) {
			bookingRepository.setNewStatus(pUpdateStatus.getBookingStatus(), aStatus.get().getId());
		}
	}

	public void cancelBookingById(Long pBookingid) {
		Optional<BookingEntity> aBooking = bookingRepository.findById(pBookingid);
		if (aBooking.isPresent()) {
			bookingRepository.deleteById(pBookingid);
		}
	}

}
