// Name :Farouk Kotob 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


public class FlightManager
{
  // Contains list of Flights departing from Toronto in a single day
	private ArrayList<Flight> flights = new ArrayList<Flight>();
  
  private String[] cities = 	{"Dallas", "New York", "London", "Paris", "Tokyo"};
  private final int DALLAS = 0;  private final int NEWYORK = 1;  private final int LONDON = 2;  private final int PARIS = 3; private final int TOKYO = 4;
  
  // flight times in hours
  private int[] flightTimes = { 3, // Dallas
  											1, // New York
  											7, // London
  											8, // Paris
  											16// Tokyo
  										};
  
  // Contains list of available airplane types and their seat capacity
  private ArrayList<Aircraft> airplanes = new ArrayList<Aircraft>();
  
  private String errorMsg = null; // if a method finds an error (e.g. flight number not found) set this string. See video!
  
  private Random random = new Random(); // random number generator - google "Java class Random". Use this in generateFlightNumber
  
  
  public FlightManager()
  {
  	// DO NOT ALTER THIS CODE - THE TA'S WILL USE IT TO TEST YOUR PROGRAM
  	// IN ASSIGNMENT 2 YOU WILL BE LOADING THIS INFORMATION FROM A FILE
  
  	// Create some aircraft types with max seat capacities
  	airplanes.add(new Aircraft(85, "Boeing 737"));
  	airplanes.add(new Aircraft(180,"Airbus 320"));
  	airplanes.add(new Aircraft(37, "Dash-8 100"));
  	airplanes.add(new Aircraft(12, "Bombardier 5000"));
  	airplanes.add(new Aircraft(592, 14, "Boeing 747"));
  	
  	// Populate the list of flights with some random test flights
  	String flightNum = generateFlightNumber("United Airlines");
  	Flight flight = new Flight(flightNum, "United Airlines", "Dallas", "1400", flightTimes[DALLAS], airplanes.get(0));
  	flights.add(flight);
  	flight.setStatus(Flight.Status.DELAYED);
  	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "London", "2300", flightTimes[LONDON], airplanes.get(1));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "Paris", "2200", flightTimes[PARIS], airplanes.get(1));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("Porter Airlines");
   	flight = new Flight(flightNum, "Porter Airlines", "New York", "1200", flightTimes[NEWYORK], airplanes.get(2));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("United Airlines");
   	flight = new Flight(flightNum, "United Airlines", "New York", "0900", flightTimes[NEWYORK], airplanes.get(3));
   	flights.add(flight);
   	flight.setStatus(Flight.Status.INFLIGHT);
   	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "New York", "0600", flightTimes[NEWYORK], airplanes.get(2));
   	flights.add(flight);
   	flight.setStatus(Flight.Status.INFLIGHT);
   	
   	
   	flightNum = generateFlightNumber("United Airlines");
   	flight = new Flight(flightNum, "United Airlines", "Paris", "2330", flightTimes[PARIS], airplanes.get(0));
   	flights.add(flight);
   	
    /*
     * Add this code back in when you are ready to tackle class LongHaulFlight and have implemented its methods
     */
    flightNum = generateFlightNumber("Air Canada");
   	flight = new LongHaulFlight(flightNum, "Air Canada", "Tokyo", "2200", flightTimes[TOKYO], airplanes.get(4),10,LongHaulFlight.firstClass);
      flights.add(flight);
    //(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft, int numFirstClassPassengers, String seatType)
  }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public int getDALLAS() {
        return DALLAS;
    }

    public int getNEWYORK() {
        return NEWYORK;
    }

    public int getLONDON() {
        return LONDON;
    }

    public int getPARIS() {
        return PARIS;
    }

    public int getTOKYO() {
        return TOKYO;
    }

    public int[] getFlightTimes() {
        return flightTimes;
    }

    public void setFlightTimes(int[] flightTimes) {
        this.flightTimes = flightTimes;
    }

    public ArrayList<Aircraft> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(ArrayList<Aircraft> airplanes) {
        this.airplanes = airplanes;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    /*
   * This private helper method generates and returns a flight number string from the airline name parameter
   * For example, if parameter string airline is "Air Canada" the flight number should be "ACxxx" where xxx is 
   * a random 3 digit number between 101 and 300 (Hint: use class Random - see variable random at top of class)
   * you can assume every airline name is always 2 words. 
   * 
   */
  private String generateFlightNumber(String airline)
  {
    return "" + airline.charAt(0) + airline.charAt(airline.indexOf(" ")+1) + (random.nextInt((300-101)+1)+101);
    // setting the number of flight number through using random 
  }

  // Prints all flights in flights array list (see class Flight toString() method) 
  // This one is done for you!
  public void printAllFlights()
  {
  	for (int i = 0; i < flights.size(); i++)
  	{
          System.out.println(flights.get(i).toString());
          //looping through the flights and printing them all
  	}
  }
  
  // Given a flight number (e.g. "UA220"), check to see if there are economy seats available
  // if so return true, if not return false
  public boolean seatsAvailable(String flightNum)
  {
    // First check for a valid flight number
    // if it is not found, set errorMsg String and return false
    // To determine if the given flightNum is valid, search the flights array list and find 
    // the  Flight object with matching flightNum string
    // Once a Flight object is found, check if seats are available (see class Flight) 
    // if flight is full, set errorMsg to an appropriate message (see video) and return false
    // otherwise return true
    for(int i=0;i<flights.size();i++)//loops through flights 
    {
      if(flights.get(i).getFlightNum().equals(flightNum)){//checks flight num
        if(flights.get(i).seatsAvailable())return true;
        else{
          System.out.println(getErrorMsg());
          return false;
        }
      }
    }
    System.out.println(getErrorMsg());
    return false;
     //gets flight num and checks if seats are availabe on that flight 
  }
 
  
  // Given a flight number string flightNum and a seat type, reserve a seat on a flight
  // If successful, return a Reservation object
  // NOTE: seat types are not used for basic Flight objects (seats are all "Economy Seats")
  // class LongHaulFlight defines two seat types
  // I  suggest you first write this method *without* considering class LongHaulFlight 
  // once that works (test it!!), add the long haul flight code
  public Reservation reserveSeatOnFlight(String flightNum, String seatType)
  {
  	// Check for valid flight number by searching through flights array list
  	// If matching flight is not found, set instance variable errorMsg (see at top) and return null 
  	
  	// If flight found
  	//    
  	//		****beginning of long haul flight code - you may want to skip initially
  	//		check if seat type is first class and check if this is a long haul flight (Hint: use instanceof operator)
  	//    if above is true
  	//			call reserveSeat method in class LongHaulFlight
  	//			if long haul flight first class is not full
  	//				create Reservation object, set firstClass boolean variable to true in Reservation object
  	//				return reference to Reservation object
  	//			else long haul first class is full
  	//				set errorMsg and return null
  	//		***end of long haul flight code
  	//
  	//		else must be economy seat 
  	//			reserve seat on flight (see class Flight reserveSeat() and overridden reserveSeat() in class LongHaulFlight)
  	//      if flight not full
  	//				create Reservation object and return reference to Reservation object 
  	//			else set ErrorMesg (flight full) and return null
      
      for(Flight flight : flights){//looping through the flights 
        if(flight.getFlightNum().equals(flightNum)){//checks the flight num with the one given 
              if(seatType.equals("First Class Seat") && flight instanceof LongHaulFlight){//checks if first class and longhaulflight
                  if(((LongHaulFlight)flight).reserveSeat(LongHaulFlight.firstClass)){
                      return new Reservation(flightNum,flight.toString(),true);//return the reservation info through the toString method
                  }
                  else{
                      setErrorMsg("Flight Full!");//setting error message 
                      return null;
                  }
              }
              else if(seatType.equals(LongHaulFlight.economy)){//runs if its economy
                  if(flight.reserveSeat()){
                      return new Reservation(flightNum,flight.toString(),false);//return the reservation info through the toString method
                  }
                  else{
                      setErrorMsg("Flight Full!");//setting error message 
                      return null;
                  }
              }
        }
    }
      setErrorMsg("Flight Not Found!");//setting error message 
      return null;
  }
  
  /*
   * Given a Reservation object, cancel the seat on the flight
   */
  public boolean cancelReservation(Reservation res)
  {
  	// Get the flight number string from res
  	// Search flights to find the Flight object - if not found, set errorMsg variable and return false
  	// if found, cancel the seat on the flight (see class Flight)
  	
  	// Once you have the above basic functionality working, try to get it working for canceling a first class reservation
  	// If this is a first class reservation (see class Reservation) and the flight is a LongHaulFlight (Hint use instanceof)
  	// then cancel the first class seat on the LongHaulFlight (Hint: you will need to cast)   
  	
    for(Flight flight : flights){
        if(res.isFirstClass() && flight instanceof LongHaulFlight){//check if it is a long haul flight
            ((LongHaulFlight)flight).cancelSeat("First Class Seat");
            return true;
        }
        else if(flight.getFlightNum().equals(res.getFlightNum())){//else cancel seat 
            flight.cancelSeat();
            return true;
        }
    }
    return false;
  }
  
  // Sort the array list of flights by increasing departure time 
  // Essentially one line of code but you will be making use of a Comparator object below
  public void sortByDeparture()
  {
	  flights.sort(new DepartureTimeComparator());
  }
  // Write a simple inner class that implements the Comparator interface (NOTE: not *Comparable*)
  // This means you will be able to compare two Flight objects by departure time
  private class DepartureTimeComparator implements Comparator<Flight>
  {
      @Override
      public int compare(Flight o1, Flight o2) {
          return o1.getDepartureTime().compareTo(o2.getDepartureTime());
          //implementing comparator and overrriding the compare method 
          //compare two flights by depertaure time 
      }
  }
  //Sort the array list of flights by increasing flight duration  
  // Essentially one line of code but you will be making use of a Comparator object below
  public void sortByDuration()
  {
	  flights.sort(new DurationComparator());
  }
  //Write a simple inner class that implements the Comparator interface (NOTE: not *Comparable*)
 // This means you will be able to compare two Flight objects by duration
  private class DurationComparator implements Comparator<Flight>
  {
      @Override
      public int compare(Flight o1, Flight o2) {
          return Integer.compare(o1.getFlightDuration(),o2.getFlightDuration());
      }
      //implementing comparator and overrriding the compare method 
      //comparing the flight duartion of two given flights
  }
  // Prints all aircraft in airplanes array list. 
  // See class Aircraft for a print() method
  public void printAllAircraft()
  {
  	for(Flight flight : flights){
  	    flight.getAircraft().print();
    }
  }
  
  // Sort the array list of Aircraft objects 
  // This is one line of code. Make sure class Aircraft implements the Comparable interface
  public void sortAircraft()
  {
  	airplanes.sort(new SeatsComparator());
  }

  private class SeatsComparator implements Comparator<Aircraft>{
      @Override
      public int compare(Aircraft o1, Aircraft o2) {
          return o1.compareTo(o2);
      }
  }
  //implementing comparator and overrriding the compare method 
  //and then comparing the two aircarfts
}