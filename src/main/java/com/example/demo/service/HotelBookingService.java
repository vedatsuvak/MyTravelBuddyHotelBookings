package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.HotelBookings;
import com.example.demo.repository.HotelBookingsRepo;

@Service
public class HotelBookingService {

	@Autowired
	private HotelBookingsRepo repo;

	// Insert an Booking
	public HotelBookings bookHotel(HotelBookings booking) {
		return repo.save(booking);
	}

	public List<HotelBookings> getAllHotelBookings() {
		return repo.findAll();
	}

	public Optional<HotelBookings> getHotelBookingById(int id) {
		return repo.findById(id);
	}

	public List<HotelBookings> getHotelsByUserId(int userId) {
		return repo.findByUserId(userId);
	}

	public void updateHotelBooking(HotelBookings hotelBooking) {
		repo.save(hotelBooking);
	}

	public void deleteHotelBooking(int id) {
		repo.deleteById(id);
	}
}
