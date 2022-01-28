package com.synergisticit.domain;

public class SearchHotelRoomDetails {
	private int hotelId;
	private int hotelRoomId; //set in controller because there can be multiple results
	private String hotelName;
	private String checkInDate;
	private String checkOutDate;
	private int noRooms;
	private int noGuests;
	private String roomType;
	private int maxRooms; //set in controller because there can be multiple results
	
	
	public int getHotelRoomId() {
		return hotelRoomId;
	}
	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}
	public int getMaxRooms() {
		return maxRooms;
	}
	public void setMaxRooms(int maxRooms) {
		this.maxRooms = maxRooms;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getNoRooms() {
		return noRooms;
	}
	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}
	public int getNoGuests() {
		return noGuests;
	}
	public void setNoGuests(int noGuests) {
		this.noGuests = noGuests;
	}
	
	
}