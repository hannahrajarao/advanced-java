import java.io.*;
import java.util.*;

public class Lecture6_1
{
	public static void main(String[] args)
	{
		int x = 10;
		double d = 133.34;
		char c = 'A';
		File f = new File("mybinarydata.dat");
		DataOutputStream out = null;
		try
		{
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			out.writeInt(x);
			out.writeDouble(d);
			out.writeChar(c);
			System.out.println(out.size()+" bytes written");
		}
		catch(IOException e)
		{
			System.out.println("IOException thrown");
		}
	}
}