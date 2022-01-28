package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Guest;

public interface GuestService {
	public Guest saveGuest (Guest guest);
	public List<Guest> getGuests (int bookingId);
}
