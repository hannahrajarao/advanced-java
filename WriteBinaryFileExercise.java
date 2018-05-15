import java.io.*;
import java.util.*;
public class WriteBinaryFileExercise
{
	public static void main(String[] args)
	{
		DataOutputStream out = null;
		int productNumber[] = {110, 520, 178, 172};
		String name[] = {"Hammer","Lawn Mower","Monkey Wrench","Screwdriver"};
		int quantity[] = {20,8,52,150};
		double cost[] = {12.99,79.52,6.95,5.99};
		try
		{
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("products.dat")));
			for(int i = 0;i<cost.length;i++)
			{
				out.writeInt(productNumber[i]);
				out.writeChars(name[i]);
				out.writeInt(quantity[i]);
				out.writeDouble(cost[i]);
			}
			out.close();
		}
		catch(IOException e)
		{
			System.out.println("File not written");
		}
	}
}