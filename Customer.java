public class Customer
{
	private String name;
	private int time;
	
	Customer(){}
	Customer(String n, int t)
	{
		name = n;
		time = t;
	}
	
	public void setName(String n){name = n;}
	public String getName(){return name;}
	public void setTime(int t){time = t;}
	public int getTime(){return time;}
}