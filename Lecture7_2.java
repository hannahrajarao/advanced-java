import java.io.*;
import java.util.*;

public class Lecture7_2
{
	public static void main(String[] args)
	{
		int[] pnumber = {110,520,178,172};
		String[] name = {"Hammer     ","Lawn Mower","Monkey Wrench","Screwdriver"};
		int[] quantity = {20,8,52,150};
		double[] cost = {12.99,79.52,6.95,5.99};
		
		Product[] products = new Product[4];
		
		for(int i=0;i<products.length;i++)
			products[i] = new Product(pnumber[i],name[i],quantity[i],cost[i]);
		
		/*products[0] = new Product(pnumber[0],name[0],quantity[0],cost[0]);
		products[1] = new Product(pnumber[1],name[1],quantity[1],cost[1]);
		products[2] = new Product(pnumber[2],name[2],quantity[2],cost[2]);
		products[3] = new Product(pnumber[3],name[3],quantity[3],cost[3]);
		
		
		Product [] products = { new Product( 110, "Hammer      ", 20, 12.99 ),
								new Product( 520, "Lawn Mower ", 8, 79.52 ),
								new Product( 178, "Monky Wrench ", 52, 6.95 ),
								new Product( 172, "Screwdriver ", 150, 5.99 )
								};*/

		ObjectOutputStream out = null;
		try
		{
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("objectfile.dat")));
			for(int i = 0; i < 4; i++)
			{
				out.writeObject(products[i]);
			}
			out.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		ObjectInputStream in = null;
		try
		{
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("objectfile.dat")));
			for(int i = 0; i < 4; i++)
			{
				Product p = (Product) in.readObject();
				System.out.println(p.getProductNumber()+"\t"+p.getName()+"\t"+p.getQuantity()+"\t"+p.getCost());
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}