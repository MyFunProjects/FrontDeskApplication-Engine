package com.frontdesk.booking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frontdesk.booking.controller.BookingController;
import com.frontdesk.booking.model.BookingEntity;
import com.frontdesk.booking.model.BookingRequest;
import com.frontdesk.booking.model.BookingResponse;
import com.frontdesk.booking.model.DoctorEntity;
import com.frontdesk.booking.model.PatientEntity;
import com.frontdesk.booking.repository.BookingRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
@AutoConfigureMockMvc
public class BookingServiceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	BookingService bookingService;

	@MockBean
	BookingRepository boookingRepository;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getAllDoctorsTest() throws Exception {
		List<DoctorEntity> theDoctorList = new ArrayList<DoctorEntity>();
		DoctorEntity aDoctor = new DoctorEntity(1L, "Kamal", "Dentist", "B");
		DoctorEntity aDoctor1 = new DoctorEntity(2L, "Rajini", "Neurologist", "C");
		theDoctorList.add(aDoctor);
		theDoctorList.add(aDoctor1);
		when(bookingService.getAllDoctors()).thenReturn(theDoctorList);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/frontdesk/doctors")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		assertTrue(!content.isEmpty());
	}

	@Test
	public void getAllPatientsTest() throws Exception {
		List<PatientEntity> thePatientList = new ArrayList<PatientEntity>();
		PatientEntity aPatient = new PatientEntity(1L, "Vikram", 27);
		PatientEntity aPatient1 = new PatientEntity(2L, "Aadhi", 48);
		thePatientList.add(aPatient);
		thePatientList.add(aPatient1);
		when(bookingService.getAllPatients()).thenReturn(thePatientList);
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/frontdesk/doctors")
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
		assertEquals(2, thePatientList.size());
	}

	@Test
	public void getBookingDetailsTest() throws Exception {
		DoctorEntity aDoctor = new DoctorEntity(1L, "Ramu", "Gynacologist", "A");
		PatientEntity aPatient = new PatientEntity(1L, "Raju", 35);
		BookingResponse aBookingResponse = new BookingResponse(1L, aDoctor, aPatient, "A", "Chest pain", "Pending");
		when(bookingService.getBookingDetails(any(Long.class))).thenReturn(aBookingResponse);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("http://localhost:8080/frontdesk/booking/{booking_id}", 1).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		assertTrue(!content.isEmpty());
	}

	@Test
	public void createNewBookingTest() throws Exception {
		DoctorEntity aDoctor = new DoctorEntity(1L, "Ramu", "Gynacologist", "A");
		PatientEntity aPatient = new PatientEntity(1L, "Raju", 35);
		BookingRequest aBookingRequest = new BookingRequest(aPatient, aDoctor, "A", "NormalCheck", "Completed");
		BookingEntity aBooking = new BookingEntity(1L, 1L, 1L, "A", "NormalCheck", "Completed");
		when(bookingService.createNewBooking(any(BookingRequest.class))).thenReturn(aBooking);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/frontdesk/newbooking")
				.content(jsonRequestString(aBookingRequest)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		assertTrue(!content.isEmpty());
	}

	@Test
	public void checkAvailabilityTest() throws Exception {
		List<DoctorEntity> theDoctorList = new ArrayList<>();
		DoctorEntity aDocotor = new DoctorEntity(1L, "Vijay", "Cardiologist", "C");
		DoctorEntity aDocotor1 = new DoctorEntity(2L, "Sujay", "Cardiologist", "D");
		theDoctorList.add(aDocotor);
		theDoctorList.add(aDocotor1);
		when(bookingService.checkAvailability(any(String.class))).thenReturn(theDoctorList);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("http://localhost:8080/frontdesk/checkavailability/{specialist}", "Cardiologist")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		assertTrue(!content.isEmpty());
	}

	@Test
	public void deleteBookingTest() throws Exception {
		bookingService.cancelBookingById(any(Long.class));
		mockMvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/frontdesk//cancelbooking/{booking_id}", 1)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		verify(bookingService, times(2)).cancelBookingById(any(Long.class));
	}

	public static String jsonRequestString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			System.out.println(jsonContent);
			return jsonContent;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
