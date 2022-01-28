package com.synergisticit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Guest;
import com.synergisticit.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService{
	
	@Autowired
	private GuestRepository guestRepository;
	@Override
	public Guest saveGuest(Guest guest) {
		return guestRepository.save(guest);
	}
	@Override
	public List<Guest> getGuests(int bookingId) {
		return guestRepository.getGuestsByBookingId(bookingId);
	}

}
