package com.meiit.webalk.reservation;

import java.awt.List;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.service.ReservationService;
import com.meiit.webalk.reservation.service.ReservationServiceIMPL;
import com.meiit.webalk.reservation.view.View;
import com.meiit.webalk.reservation.view.ViewIMPL;
import java.util.ArrayList;

public class App {
	private ReservationService service;
	private View view;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ReservationService service = new ReservationServiceIMPL();
		View view = new ViewIMPL();
		App app = new App(service, view);

		app.book();
		sc.close();
	}
	
	public App(ReservationService service,View view) {
		this.service = service;
		this.view = view;
	}
	
	public void createBookingPerson() {
		BookingPerson person = view.readBookingPerson();
		service.saveBookingPerson(person);
	}
	
	public void book() {
		createBookingPerson();
		BookingPerson person = service.findBookingPerson();
		view.printWelcomeMessage(person);
		view.printBalance(person);
		
		ArrayList<Hotel> l = new ArrayList<Hotel>();
		l = (ArrayList<Hotel>) service.findAllHotels();
			view.printRooms(l);
	}
	
	
	public void checkIn() {
		
	}
	
	public void checkOut() {
		
	}
}
