package com.meiit.webalk.reservation;

import java.time.LocalDateTime;

import com.meiit.webalk.reservation.domain.*;
import com.meiit.webalk.reservation.service.ReservationService;
import com.meiit.webalk.reservation.service.ReservationServiceIMPL;
import com.meiit.webalk.reservation.view.View;
import com.meiit.webalk.reservation.view.ViewIMPL;

public class App {
	private ReservationService service;
	private View view;
	
	
	public static void main(String[] args) {
		ReservationService service = new ReservationServiceIMPL();
		View view = new ViewIMPL();
		App app = new App(service, view);
		app.book();
	}
	
	public App(ReservationService service,View view) {
		this.service = service;
		this.view = view;
	}
	
	public void createBookingPerson() {
		BookingPerson person = view.readBookingPerson();
		service.saveBookingPerson(person);
		view.printWelcomeMessage(person);
		view.printBalance(person);
	}
	
	public void book() {
		createBookingPerson();
		BookingPerson person = service.findBookingPerson();
		Room room = null;
		boolean quit = false;
		try{
			do {
				view.printRooms(service.findAllHotels());
				room = view.selectRoom(service.findAllHotels());
					if (person.getBalance().compareTo(room.getPrice()) >= 0) {
						Reservation reservation = new Reservation(room.getPrice(), LocalDateTime.now(), false, true, room, person);
						service.saveReservation(reservation);
						view.printReservationSaved(reservation);
						person.setBalance(person.getBalance().subtract(room.getPrice()));
					}else {
						view.printNotEnoughBalance(person);
						room = null;
					}
					view.printBalance(person);
			}while(!quit);
		}catch(NullPointerException e)
		{
			checkIn();
		}
	}
	
	public void checkIn() {
		
	}
	
	public void checkOut() {
		
	}
}
