package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HotelBookings;
import com.example.demo.service.HotelBookingService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class HotelBookingController {

	private final HotelBookingService hotelBookingService;

	@Autowired
	public HotelBookingController(HotelBookingService hotelBookingService) {
		this.hotelBookingService = hotelBookingService;
	}

	// Done
	@PostMapping("/bookHotel")
	public ResponseEntity<HotelBookings> bookHotel(@RequestBody HotelBookings hotelBooking) {
		System.out.println(hotelBooking);
		HotelBookings createdHotelBooking = hotelBookingService.bookHotel(hotelBooking);
		return new ResponseEntity<>(createdHotelBooking, HttpStatus.CREATED);
	}

	// Done
	@GetMapping("/getAll")
	public ResponseEntity<List<HotelBookings>> getAllHotelBookings() {
		List<HotelBookings> hotelBookings = hotelBookingService.getAllHotelBookings();
		return new ResponseEntity<>(hotelBookings, HttpStatus.OK);
	}

	// Done
	@GetMapping("/getById/{id}")
	public ResponseEntity<HotelBookings> getHotelBookingById(@PathVariable int id) {
		Optional<HotelBookings> hotelBookings = hotelBookingService.getHotelBookingById(id);
		return hotelBookings.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// Done
	@GetMapping("/userBooking/{userId}")
	public ResponseEntity<List<HotelBookings>> getHotelsByUserId(@PathVariable int userId) {
		List<HotelBookings> hotelBookings = hotelBookingService.getHotelsByUserId(userId);
		return new ResponseEntity<>(hotelBookings, HttpStatus.OK);
	}

	// Done
	@PutMapping("/update")
	public ResponseEntity<Void> updateHotelBooking(@RequestBody HotelBookings hotelBookings) {
		hotelBookingService.updateHotelBooking(hotelBookings);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// Done
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteHotelBooking(@PathVariable int id) {
		hotelBookingService.deleteHotelBooking(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
