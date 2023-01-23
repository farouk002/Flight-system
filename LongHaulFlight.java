// Name :Farouk Kotob 

/*
 * A long haul flight is a flight that travels thousands of kilometers and typically has separate seating areas 
 */

public class LongHaulFlight extends Flight
{
	private int numFirstClassPassengers;
	private String seatType;
	
	// Possible seat types
	public static final String firstClass = "First Class Seat";
	public static final String economy 		= "Economy Seat";  
	

	public LongHaulFlight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft, int numFirstClassPassengers, String seatType)
	{
		// use the super() call to initialize all inherited variables
		// also initialize the new instance variables 
		super(flightNum, airline, dest, departure, flightDuration, aircraft);
		this.numFirstClassPassengers=numFirstClassPassengers;
		this.seatType = seatType;
	}

	public LongHaulFlight()
	{
	 // default constructor
	 super();
	 numFirstClassPassengers=0;
	 seatType="";
	 
	}

	public int getNumFirstClassPassengers() {
		return numFirstClassPassengers;
	}

	public void setNumFirstClassPassengers(int numFirstClassPassengers) {
		this.numFirstClassPassengers = numFirstClassPassengers;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	/*
	 * Reserves a seat on a flight. Essentially just increases the number of (economy) passengers
	 */
	public boolean reserveSeat()
	{
		// override the inherited reserveSeat method and call the reserveSeat method below with an economy seatType
		// use the constants defined at the top
		return reserveSeat(economy);
	}

	/*
	 * Reserves a seat on a flight. Essentially just increases the number of passengers, depending on seat type (economy or first class)
	 */
	public boolean reserveSeat(String seatType)
	{
		// if seat type is economy 
		//			call the superclass method reserveSeat() and return the result
		// else if the seat type is first class then 
		// 			check to see if there are more first class seats available (use the aircraft method to get the max first class seats
		// 			of this airplane
		//    	if there is a seat available, increment first class passenger count (see instance variable at the top of the class)
		//    	return true;
		// else return false
		
		// remove this once you have written your code
		if(seatType.equals(economy)){//check seatType is equals economy
			return super.reserveSeat();//call the reserve seat of the super class
		}
		else if(seatType.equals(firstClass)){//check seatType is equals first class
			if(numFirstClassPassengers < getAircraft().getNumFirstClassSeats()){//get the num of first class passengers and compare it to the current num
				numFirstClassPassengers++;//increase by 1
				return true;
			}
			return false;
		}
		return false;
	}
	
	// Cancel a seat 
	public void cancelSeat()
	{
	  // override the inherited cancelSeat method and call the cancelSeat method below with an economy seatType
		// use the constants defined at the top
		cancelSeat(economy);
		//calls cancel seat with the parameter of economy seattype
	}
	
	public void cancelSeat(String seatType)
	{
		// if seat type is first class and first class passenger count is > 0
		//  decrement first class passengers
		// else
		// decrement inherited (economy) passenger count

		if(seatType.equals(economy) && numFirstClassPassengers > 0){//checks if seatype first class
			numFirstClassPassengers--;
		}
		else{
			passengers--;//decrenents economy pssengers
		}
	}

	// return the total passenger count of economy passengers *and* first class passengers
	// use instance variable at top and inherited method that returns economy passenger count
	public int getPassengerCount()
	{
		return passengers + numFirstClassPassengers;
		// passenger is the num of econmy passengers and numFirstClassPassengers is for the firstcalss
		//we return the sum of both 
	}

	public String toString(){
		return super.toString() + " LongHaul";
	}//toString for the longHaulFlight 
}
