// Name :Farouk Kotob 
/* 
 *  Class to model an airline flight. In this simple system, all flights originate from Toronto
 *  
 *  This class models a simple flight that has only economy seats
 */
public class Flight
{
	public enum Status {DELAYED, ONTIME, ARRIVED, INFLIGHT};

	private String flightNum, airline, origin, dest, departureTime;
	private Status status; // see enum Status above. google this to see how to use it
	private int flightDuration;
	private Aircraft aircraft;
	protected int passengers; // count of (economy) passengers on this flight - initially 0
  
	public Flight()
	{
		// write code to initialize instance variables to default values
		flightNum=""; 
		airline="";
		origin="";
		dest="";
		departureTime="";
		status=null;
		flightDuration=0;
		aircraft=null;
		passengers=0;
		//sets the strings to ""  integer to 0
	}
	
	public Flight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft)
	{
		this.flightNum = flightNum;
		this.airline = airline;
		this.dest = dest;
		this.origin = "Toronto";
		this.departureTime = departure;
		this.flightDuration = flightDuration;
		this.aircraft = aircraft;
		passengers = 0;
		status = Status.ONTIME;
		
	}
	public String getFlightNum()
	{
		return flightNum;
	}
	public void setFlightNum(String flightNum)
	{
		this.flightNum = flightNum;
	}

	public String getAirline()
	{
		return airline;
	}
	public void setAirline(String airline)
	{
		this.airline = airline;
	}

	public String getOrigin()
	{
		return origin;
	}
	public void setOrigin(String origin)
	{
		this.origin = origin;
	}

	public String getDest()
	{
		return dest;
	}
	public void setDest(String dest)
	{
		this.dest = dest;
	}

	public String getDepartureTime()
	{
		return departureTime;
	}
	public void setDepartureTime(String departureTime)
	{
		this.departureTime = departureTime;
	}

	public Status getStatus()
	{
		return status;
	}
	public void setStatus(Status status)
	{
		this.status = status;
	}

	public int getFlightDuration()
	{
		return flightDuration;
	}
	public void setFlightDuration(int dur)
	{
		this.flightDuration = dur;
	}

	public Aircraft getAircraft(){return aircraft;}
	public void setAircraft(Aircraft aircraft) {this.aircraft = aircraft;}
	
	public int getPassengers()
	{
		return passengers;
	}
	public void setPassengers(int passengers)
	{
		this.passengers = passengers;
	}
	
	// Check to see if there is room on this flight - compare current passenger count
	// with aircraft max capacity of economy seats
	public boolean seatsAvailable()
	{
		// your code here
		if(passengers<aircraft.getNumSeats()){
			return true;
		}
		return false;
		//checks if seats are available for economy class by returning true or false
	}
	
	/*
	 * Cancel a seat - essentially reduce the passenger count by 1. Make sure the count does not
	 * fall below 0 (see instance variable passenger)
	 */
	public void cancelSeat()
	{
		// your code here
		if(!(passengers-1<0)){
			passengers-=1;
		}
		//cancel seat (passenger number is decreased by 1 evettime cancelSeat() is called)
	}
	
	/*
	 * reserve a seat on this flight - essentially increases the passenger count by 1 only if there is room for more
	 * economy passengers on the aircraft used for this flight (see instance variables above)
	 */
	public boolean reserveSeat()
	{
		// your code here
		if(passengers+1<aircraft.getNumSeats()){
			passengers+=1;
			return true;
		}
		return false;
		//increase the number of passengers by 1 everytime this is called unless the flight is full then it returns false
	}
	
	public String toString()
	{
		 return airline + "\t Flight:  " + flightNum + "\t Dest: " + dest + "\t Departing: " + departureTime + "\t Duration: " + flightDuration + "\t Status: " + status;
		
	}//toString retutns the flight info

  
}