// Name :Farouk Kotob 
/*
 * 
 * This class models an aircraft type with a model name, a maximum number of economy seats, and a max number of forst class seats 
 * 
 * Add code such that class Aircraft implements the Comparable interface
 * Compare two Aircraft objects by first comparing the number of economy seats. If the number is equal, then compare the
 * number of first class seats 
 */
public class Aircraft  implements Comparable<Aircraft>
{
  private int numEconomySeats, numFirstClassSeats;
  private String model;
  
  public Aircraft(int seats, String model)
  {
  	this.numEconomySeats = seats;
  	this.numFirstClassSeats = 0;
  	this.model = model;
  }

  public Aircraft(int economy, int firstClass, String model)
  {
  	this.numEconomySeats = economy;   //setting the number of econnmy seats
  	this.numFirstClassSeats = firstClass;//setting the number of firstclass seats
  	this.model = model;//setting the model
  }
  
	public int getNumSeats()
	{
		return numEconomySeats;
	}
	
	public int getTotalSeats()
	{
		return numEconomySeats + numFirstClassSeats;
	}
	
	public int getNumFirstClassSeats()
	{
		return numFirstClassSeats;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public void setNumEconomySeats(int numEconomySeats){this.numEconomySeats = numEconomySeats; }

	public void setNumFirstClassSeats(int numFirstClassSeats){this.numFirstClassSeats = numFirstClassSeats;}

	public void print()
	{
		System.out.println("Model: " + model + "\t Economy Seats: " + numEconomySeats + "\t First Class Seats: " + numFirstClassSeats);
	}

	/*
	 * Write a compareTo method that is part of the Comparable interface
	 */
	public int compareTo(Aircraft other){
		return numEconomySeats == other.numEconomySeats ?
				Integer.compare(numFirstClassSeats,other.numFirstClassSeats) : 
				Integer.compare(numEconomySeats,other.numEconomySeats);
	}
	//comparing two aircrafts first by number of economy seats if both have the same 
	//the we compare number of the first class seats 
	//else we only compare the number of econmy seats only 
}
  
