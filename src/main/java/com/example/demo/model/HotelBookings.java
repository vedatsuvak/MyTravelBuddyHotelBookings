package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HotelBookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int hotelId;
	private int userId;
	private String location;
	private String hotelName;
	private String checkInDate;
	private String checkOutDate;
	private double totalPrice;
	private int numberOfRooms;

}
