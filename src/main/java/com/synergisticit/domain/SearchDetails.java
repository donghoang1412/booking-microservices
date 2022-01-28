package com.synergisticit.domain;

public class SearchDetails {
	private String searchLocation;
	private String checkIn;
	private String checkOut;
	private int noOfRooms;
	private int noOfGuests;
	
	public String getSearchLocation() {
		return searchLocation;
	}
	public void setSearchLocation(String searchLocation) {
		this.searchLocation = searchLocation;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public int getNoOfGuests() {
		return noOfGuests;
	}
	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}
	
	
}