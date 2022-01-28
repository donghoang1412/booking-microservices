package com.synergisticit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.synergisticit.domain.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	public Booking getBookingByCustomerMobileAndHotelRoomId(String customerMobile, int hotelRoomId);
	
//	@Query(value="select * from booking where customerMobile like %:customerMobile", nativeQuery = true)
	public List<Booking> getBookingByCustomerMobile(@Param("customerMobile") String customerMobile);
	public List<Booking> getBookingByStatus(String status);
	public Booking getBookingByBookingId(int bookingId);
	public List<Booking> getBookingByCustomerMobileAndStatus(String customerMobile, String status);
	public List<Booking> getBookingByHotelId(int hotelId);
}
