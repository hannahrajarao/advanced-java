import java.io.*;
import java.util.*;

public class Assignment7
{
	public static void main(String[] args)
	{
		Student[] students = new Student[3];
		for(int i=0;i<students.length;i++)
		{
			String name = Input.getString("Enter name");
			String ssn = Input.getString("Enter social security number");
			int coursesCompleted = Input.getInt("Enter number of courses completed");
			double[][] courses = new double[coursesCompleted][2];
			for(int j=0;j<coursesCompleted;j++)
			{
				courses[j][0] = Input.getDouble("Enter grade for course "+(j+1));
				courses[j][1] = Input.getDouble("Enter credits for course "+(j+1));
			}
			students[i] = new Student(name, ssn, coursesCompleted, courses);
		}
		
		ObjectOutputStream out = null;
		try
		{
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("students.dat")));
			for(int i=0;i<students.length;i++)
			{
				out.writeObject(students[i]);
			}
			out.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}