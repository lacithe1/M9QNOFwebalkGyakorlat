package com.meiit.webalk.reservation.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.WingType;

public class ReservationServiceIMPL implements ReservationService {
	private BookingPerson person;
	
	@Override
	public void saveBookingPerson(BookingPerson person) {
		this.person = person;
	}

	@Override
	public BookingPerson findBookingPerson() {
		return person;
	}
	
	private Hotel h = new Hotel();
	private Hotel h1 = new Hotel();
	private Hotel h2 = new Hotel();
	private Hotel h3 = new Hotel();
	
	@Override
	public ArrayList<Hotel> findAllHotels() {
		BigDecimal b1 = new BigDecimal("500");
		BigDecimal b2 = new BigDecimal("1500");
		BigDecimal b3 = new BigDecimal("200");
		BigDecimal b4 = new BigDecimal("500");
		
		ArrayList<Hotel> lh = new ArrayList<Hotel>();
		h.setNumber(1);
		h.setBeds(2);
		h.setPrice(b1);
		h.setType(WingType.NORTH);
		h.setFloorNumber(1);
		h.setName("Hilton");
		lh.add(h);
		h1.setNumber(2);
		h1.setBeds(4);
		h1.setPrice(b2);
		h1.setType(WingType.NORTH);
		h1.setFloorNumber(1);
		h1.setName("Hilton");
		lh.add(h1);
		h2.setNumber(3);
		h2.setBeds(1);
		h2.setPrice(b3);
		h2.setType(WingType.NORTH);
		h2.setFloorNumber(1);
		h2.setName("Hilton");
		lh.add(h2);
		h3.setNumber(4);
		h3.setBeds(2);
		h3.setPrice(b4);
		h3.setType(WingType.NORTH);
		h3.setFloorNumber(1);
		h3.setName("Hilton");
		lh.add(h3);
		
		return lh;
	}

	@Override
	public void saveReservation(Reservation res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reservation> findAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkOut() {
		// TODO Auto-generated method stub
		
	}
	
}
