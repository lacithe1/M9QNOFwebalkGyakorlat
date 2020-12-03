package com.meiit.webalk.reservation.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.*;

public class ViewIMPL implements View {
	
	static public List<Hotel> Test() {
	List<Hotel> hotels = new ArrayList<Hotel>();
	List<Floor> floors = new ArrayList<Floor>();
	List<Wing> wings = new ArrayList<Wing>();
	List<Room> rooms = new ArrayList<Room>();
	
	Hotel hotel = new Hotel("Hilton", "Somewhere", 4, floors);
	
	Floor Floor1 = new Floor(1, hotel, wings);
	
	Wing Wing1 = new Wing("North", Floor1, WingType.NORTH, rooms);
	
	Room Room1 = new Room(1, 2, true, BigDecimal.valueOf(500), Wing1);
	rooms.add(Room1);

	Room Room2 = new Room(2, 4, true, BigDecimal.valueOf(1500), Wing1);
	rooms.add(Room2);

	Room Room3 = new Room(3, 1, true, BigDecimal.valueOf(200), Wing1);
	rooms.add(Room3);

	Room Room4 = new Room(4, 2, true, BigDecimal.valueOf(500), Wing1);
	rooms.add(Room4);

	Wing1.setRooms(rooms);
	wings.add(Wing1);

	Floor1.setWings(wings);
	floors.add(Floor1);

	hotel.setFloors(floors);
	hotels.add(hotel);
	return hotels;
	}
	
	Scanner sc = new Scanner(System.in);
	int jumper;
	
	@Override
	public BookingPerson readBookingPerson() {
		System.out.println("Whats your name?");
		BookingPerson person = new BookingPerson();
		person.setName(sc.next());
		System.out.println("Mennyi a zsé");
		person.setBalance(sc.nextBigDecimal());
		System.out.println("Currency?");
		person.setCurrency(Currency.valueOf(sc.next()));
		System.out.println(person);
		return person;
	}

	@Override
	public void printWelcomeMessage(BookingPerson person) {
		System.out.println("Welcome " + person.getName() );
	}

	@Override
	public void printBalance(BookingPerson person) {
		System.out.println("Your balance is: " + person.getBalance() + person.getCurrency());
	}

	@Override
	public void printRooms(List<Hotel> hotels) {
		System.out.println("Where do you want to book? (Choose a number or press q for quit)");
		jumper = 0;
		for(Hotel h : hotels) {
			for(Floor f : h.getFloors()) {
				for(Wing w : f.getWings()) {
					for(Room r : w.getRooms()) {
						jumper++;
						System.out.println(jumper +": Hotel name: "+h.getName()+", Floor: "+ f.getFloorNumber()+", Wing: "+w.getWingtype()+", Room number: "+r.getNumber()+", Beds: "+r.getBeds()+", Room Price: "+r.getPrice());			
					}
				}
			}
		}
		
	}

	@Override
	public Room selectRoom(List<Hotel> hotels) {
		return null;
	}

	@Override
	public void printReservationSaved(Reservation res) {
		
	}

	@Override
	public void printNotEnoughBalance(BookingPerson person) {
		
	}

	@Override
	public void printCheckIn(Reservation res) {
		
		
	}

	@Override
	public void printCheckOut(Reservation res, BookingPerson person) {
		// TODO Auto-generated method stub
		
	}
	
}
