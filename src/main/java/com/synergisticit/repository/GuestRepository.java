package com.synergisticit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.synergisticit.domain.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer>{
	@Query(value="select * from guest where guestId in (select guests_guestId from booking_guest where Booking_bookingId=:bookingId)", nativeQuery = true)
	public List<Guest> getGuestsByBookingId(@Param("bookingId") int bookingId);
}
