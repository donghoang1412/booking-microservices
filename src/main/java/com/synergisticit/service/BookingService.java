package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Booking;

public interface BookingService {
	public Booking saveBooking(Booking booking);
	public Booking getBookingByCustomerMobileAndHotelRoomId(String customerMobile, int hotelRoomId);
	public List<Booking> getBookingByCustomerMobile(String customerMobile);
	public List<Booking> getBookingByStatus(String status);
	public Booking getBookingByBookingId(int bookingId);
	public List<Booking> getBookingByCustomerMobileAndStatus(String customerMobile, String status);
	public List<Booking> getBookingByHotelId(int hotelId);
}
