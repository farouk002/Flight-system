// Name :Farouk Kotob  
import java.util.ArrayList;
import java.util.Scanner;

// Flight System for one single day at YYZ (Print this in title) Departing flights!!


public class FlightReservationSystem
{
	public static void main(String[] args)
	{
		// Create a FlightManager object
		FlightManager manager = new FlightManager();

		// List of reservations that have been made
		ArrayList<Reservation> myReservations = new ArrayList<Reservation>();	// my flight reservations

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		while (scanner.hasNextLine())
		{
			String inputLine = scanner.nextLine();
			if (inputLine == null || inputLine.equals("")) continue;

			// The command line is a scanner that scans the inputLine string
			// For example: list AC201
			Scanner commandLine = new Scanner(inputLine);
			
			// The action string is the command to be performed (e.g. list, cancel etc)
			String action = commandLine.next();

			if (action == null || action.equals("")) continue;

			if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;
			
			// List all flights
			else if (action.equalsIgnoreCase("LIST"))
			{
				manager.printAllFlights(); //print the flights
			}
			// Reserve a flight based on Flight number string (example input: res AC220)
			else if (action.equalsIgnoreCase("RES"))
			{
				// Get the flight number string from the commandLine scanner (use hasNext() to check if there is a
				// flight number string entered
				
				// call reserveSeatOnFlight() method in manager passing in the flight number string
				// A reference to a Reservation object is returned. Check to make sure it is not == null
				// If it is null, then call manager.getErrorMessage() and print the message
				// If it is not null, add the reservation to the myReservations array list and print the reservation (see class Reservation)
				
				if(commandLine.hasNext())//checks the input
				{
					String flightnumber=commandLine.next();//sets flight num to entered flight num
					Reservation reserveflight=manager.reserveSeatOnFlight(flightnumber, LongHaulFlight.economy);//
					if(reserveflight==null)
					{//if flight null prints error message 
						System.out.println(manager.getErrorMsg());
					}
					else{
						myReservations.add(reserveflight);//adds reservations to myreseavations arraylist
						reserveflight.print();//prints reserved flight
					}
				}
				
	

			}
		  // Reserve a first class seat on a flight based on Flight number string (example input: res AC220)
			else if (action.equalsIgnoreCase("RESFCL"))
			{
				// Same as above except call 
				// manager.reserveSeatOnFlight() and pass in the flight number string as well as the string constant:
				// LongHaulFlight.firstClass (see class LongHaulFlight)
				// Do the LongHaulFlight class and this command after all the basic functionality is working for regular flights

				if(commandLine.hasNext())
				{
					String flightnumber=commandLine.next();//sets the flight num
					Reservation reserveflight=manager.reserveSeatOnFlight(flightnumber, LongHaulFlight.firstClass);
					if(reserveflight==null)//checks if null
					{
						System.out.println(manager.getErrorMsg());//gets the error message
					}
					else{
						myReservations.add(reserveflight);//add to myreservations
						reserveflight.print();//prints the reserved flight
					}
				}
			}
			// Query the flight manager to see if seats are still available for a specific flight (example input: seats AC220)
		  // This one is done for you as a guide for other commands
			else if (action.equalsIgnoreCase("SEATS"))
			{
				String flightNum = null;

				if (commandLine.hasNext())
				{
					flightNum = commandLine.next();

					if (manager.seatsAvailable(flightNum))
					{
						System.out.println("Seats are available");
					}
					else
					{
						System.out.println(manager.getErrorMsg());
					}
				}
			}
			// Cancel an existing reservation (example input: cancel AC220) 
			else if (action.equalsIgnoreCase("CANCEL"))
			{
        // get the flight number string from commandLine scanner (check if there is input first)
				// Use the flight number to find the Reservation object in the myReservations array list
				// If the reservation is found,  
				// 		call cancelReservation() method in the flight manager
				//    remove the reservation from myReservations
				// If the reservation is not found, print a message (see video)
				if(commandLine.hasNext())
				{
					String flighNum=commandLine.next();
					boolean isFound = false;//set isfound to false
					for(int i =0;i<myReservations.size();i++)
					{
						if(flighNum.equals(myReservations.get(i).getFlightNum()))//check if it equals 
						{
							manager.cancelReservation(myReservations.get(i));//call the cancel mehtod
							myReservations.remove(i);//remove it from my arraylist myreservations 
							isFound = true;//set isfound to true
							break;
						}
					}
					if(!isFound) System.out.println(manager.getErrorMsg());

				}
			}
      // Print all the reservations in array list myReservations
			else if (action.equalsIgnoreCase("MYRES"))
			{
				for(int i=0;i<myReservations.size();i++){//loops through the arraylist of myReservations
					myReservations.get(i).print();//prints the res at each index
				}
				
			}
			// Print the list of aircraft (see class Manager)
			else if (action.equalsIgnoreCase("CRAFT"))
		  {
			  manager.printAllAircraft();
			}
			// These commands can be left until we study Java interfaces
			// Feel free to implement the code in class Manager if you already understand interface Comparable
			// and interface Comparator
			else if (action.equalsIgnoreCase("SORTCRAFT"))
		  {
		  	manager.sortAircraft();
		  }
		  else if (action.equalsIgnoreCase("SORTBYDEP"))
		  {
			  manager.sortByDeparture();
			  
		  }
		  else if (action.equalsIgnoreCase("SORTBYDUR"))
		  {
			  manager.sortByDuration();
		  }

		  else if(action.equalsIgnoreCase("RESPSNGR")){

			}
	  
			System.out.print("\n>");
		}
	}

	
}
