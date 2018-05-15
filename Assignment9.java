import java.util.Random;
public class Assignment9
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		int random = rand.nextInt(1001);
		Thread one = new FindIt(random, 0, 349);
		Thread two = new FindIt(random, 350, 699);
		Thread three = new FindIt(random, 700, 1000);
		
		one.start();
		two.start();
		three.start();
	}
}