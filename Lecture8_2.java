import java.util.*;
public class Lecture8_2
{
	public static void main(String[] args)
	{
		ArrayList<GroceryItem> cart = new ArrayList<GroceryItem>(50);
		GroceryItem g;
		final long seed = 823007475;
		Random r = new Random(seed);
		int s;
		for(int i=0;i<cart.size(); i++)
		{
			s = r.nextInt(30) + 1;
			g = new GroceryItem(i, s);
			cart.add(g);
		}
		ArrayList<GroceryItem> lowShelfLife = new ArrayList<GroceryItem>();
		ArrayList<GroceryItem> highShelfLife = new ArrayList<GroceryItem>();
		
		for(int i=0;i<cart.size(); i++)
		{
			if(cart.get(i).getShelfLife()>7)
				highShelfLife.add(cart.get(i));
			else
				lowShelfLife.add(cart.get(i));
		}
		for(int i=0;i<highShelfLife.size();i++)
			highShelfLife.get(i).display();
		
		for(int i=0;i<lowShelfLife.size();i++)
			lowShelfLife.get(i).display();
	}
}