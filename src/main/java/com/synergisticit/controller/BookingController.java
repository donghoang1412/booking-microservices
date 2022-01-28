package com.synergisticit.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.synergisticit.domain.Booking;
import com.synergisticit.domain.Guest;
import com.synergisticit.service.BookingService;
import com.synergisticit.service.GuestService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	GuestService guestService;
	
	@PostMapping(value="/saveBooking")
	public ResponseEntity<?> saveBooking(@RequestBody String body) {		
		System.out.println("body: " + body);
		Gson gson = new Gson();
		Booking booking__ = gson.fromJson(body, Booking.class);
		System.out.println("booking__" + booking__);
		
		String mobile = booking__.getCustomerMobile();
		int hotelRoomId = booking__.getHotelRoomId();
		Booking bookingDB = bookingService.getBookingByCustomerMobileAndHotelRoomId(mobile, hotelRoomId);
		
		if(bookingDB == null) {
			bookingDB = booking__;
		}
		else {
			Set<Guest> existenceGuest = bookingDB.getGuests();
			for(Guest guest : booking__.getGuests()) {
				for(Guest existedGuest : existenceGuest) {
					if(guest.getAge() == existedGuest.getAge() && guest.getFirstName().equals(existedGuest.getFirstName()) && 
							guest.getLastName().equals(existedGuest.getLastName()) && guest.getGender().equals(existedGuest.getGender())) {
						guest.setGuestId(existedGuest.getGuestId());
					}
				}
			}
			booking__.setGuests(booking__.getGuests());
			booking__.setBookingId(bookingDB.getBookingId());
			bookingDB = booking__;
		}
		
		Booking persistBooking = bookingService.saveBooking(bookingDB);	
		return ResponseEntity.ok(persistBooking);
//	
	}
	
	@PostMapping(value="/getBookings")
	public List<Booking> getBooking (@RequestBody String body) {
		Gson gson = new Gson();
		Booking booking__ = gson.fromJson(body, Booking.class);
		String customerMobile = booking__.getCustomerMobile();
		String status = booking__.getStatus();
		return bookingService.getBookingByCustomerMobileAndStatus(customerMobile, status);
	}
	
	@GetMapping(value="/getBookingsHotel")
	public List<Booking> getBookings (@RequestParam int hotelId) {
		return bookingService.getBookingByHotelId(hotelId);
	}
	
	@GetMapping(value="/getBookingStatus")
	public List<Booking> getBookingStatus (@RequestBody JsonNode status) {
		String bookingStatus = status.get("status").asText();
		return bookingService.getBookingByStatus(bookingStatus);
	}
	
	@GetMapping(value="/getGuests")
	public List<Guest> getGuests (@RequestParam int bookingId) {
		return guestService.getGuests(bookingId);
	}
	
	@PostMapping(value="/cancelBooking")
	public Booking cancelBooking (@RequestBody String body) {
		Gson gson = new Gson();
		Booking booking = gson.fromJson(body, Booking.class);
		int bookingId = booking.getBookingId();
		System.out.println(bookingId);
		Booking getBooking = bookingService.getBookingByBookingId(bookingId);
		getBooking.setStatus("Cancelled");
		Booking persistBooking = bookingService.saveBooking(getBooking);
		return persistBooking;
	}
	
	@PostMapping(value ="/changeStay")
	public Booking changeStay(@RequestBody String body) {
		Gson gson = new Gson();
		Booking booking = gson.fromJson(body, Booking.class);
		int bookingId = booking.getBookingId();
		String checkInDate = booking.getCheckInDate();
		String checkOutDate = booking.getCheckOutDate();
		Booking getBooking = bookingService.getBookingByBookingId(bookingId);
		getBooking.setCheckInDate(checkInDate);
		getBooking.setCheckOutDate(checkOutDate);
		Booking persistBooking = bookingService.saveBooking(getBooking);
		return persistBooking;
	}
}
