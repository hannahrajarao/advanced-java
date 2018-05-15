import java.util.*;

public class Lecture8_3
{
	public static void main(String[] args)
	{
		LinkedList<Customer> line = new LinkedList<Customer>();
		Random r = new Random(160534928);
		Customer c;
		while(true)
		{
			String cont = Input.getString("Would you like to add a customer or quit?");
			if(cont.equalsIgnoreCase("quit"))
				break;
			else
			{
				String name = Input.getString("Enter name of customer");
				int time = r.nextInt(20)+1;
				c = new Customer(name, time);
				line.add(c);
			}
		}
		for(int i=0;i<line.size();i++)
			System.out.println("Name: "+line.get(i).getName()+"\tService Time: "+line.get(i).getTime());
	}
}