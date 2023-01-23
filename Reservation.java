// Name :Farouk Kotob  Student Number :501022629

/*
 * A simple class to model an electronic airline flight reservation
 * 
 * This class has been done for you
 */
public class Reservation
{
	private String flightNum;
	private String flightInfo;
	private boolean firstClass;
	
	
	public Reservation(String flightNum, String info, boolean firstClass)
	{
		this.flightNum = flightNum;
		this.flightInfo = info;
		this.firstClass = firstClass;
	}
	
	public boolean isFirstClass()
	{
		return firstClass;
	}

	public void setFirstClass()
	{
		this.firstClass = true;
	}

	public String getFlightNum()
	{
		return flightNum;
	}
	
	public String getFlightInfo()
	{
		return flightInfo;
	}

	public void setFlightInfo(String flightInfo)
	{
		this.flightInfo = flightInfo;
	}

	public void setFlightNum(String flightNum){this.flightNum=flightNum;}

	public void print()
	{
		System.out.println(flightInfo);
	}
}

