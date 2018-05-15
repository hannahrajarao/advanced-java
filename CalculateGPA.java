import java.io.*;
import java.util.*;

public class CalculateGPA
{
	public static void main(String[] args)
	{
		ObjectInputStream in = null;
		try
		{
			in = new ObjectInputStream(new BufferedInputStream (new FileInputStream("students.dat")));
			for(int i=0; i<3; i++)
			{
				Student s = (Student) in.readObject();
				System.out.println(s.getName()+"\t"+s.calculateGPA());
			}
			in.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}