package com.synergisticit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Booking;
import com.synergisticit.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository bookingRepository;
	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	@Override
	public Booking getBookingByCustomerMobileAndHotelRoomId(String customerMobile, int hotelRoomId) {
		return bookingRepository.getBookingByCustomerMobileAndHotelRoomId(customerMobile, hotelRoomId);
	}
	@Override
	public List<Booking> getBookingByCustomerMobile(String customerMobile) {
		return bookingRepository.getBookingByCustomerMobile(customerMobile);
	}
	@Override
	public List<Booking> getBookingByStatus(String status) {
		return bookingRepository.getBookingByStatus(status);
	}
	@Override
	public Booking getBookingByBookingId(int bookingId) {
		return bookingRepository.getBookingByBookingId(bookingId);
	}
	@Override
	public List<Booking> getBookingByCustomerMobileAndStatus(String customerMobile, String status) {
		return bookingRepository.getBookingByCustomerMobileAndStatus(customerMobile, status);
	}
	@Override
	public List<Booking> getBookingByHotelId(int hotelId) {
		return bookingRepository.getBookingByHotelId(hotelId);
	}

}
