import java.io.*;
import java.util.*;
public class CreateClass
{
	public static void main(String[] args)
	{
		String name = Input.getString("What is the name of the class you would like to create?");
		
		int varNum = Input.getInt("How many variables would you like in this class?");
		String[][] vars = new String[varNum][2]; //array contain variable types and name
		for(int i=0;i<varNum;i++)
		{
			vars[i][0] = Input.getString("Enter variable type");
			vars[i][1] = Input.getString("Enter variable name");
		}
		PrintWriter out = null;
		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(name+".java")));
			out.println("public class "+name+"\n{");
			//declare variables
			for(int i = 0;i<varNum;i++)
			{
				out.println("\tprivate "+vars[i][0]+" "+vars[i][1]+";");
			}
			out.println();
			out.println("\t"+name+"(){}"); //default constructor
			out.print("\t"+name+"("); //parameterized constructor
			for(int i=0;i<varNum;i++)//arguments of parameterized constructor
			{
				if(i==varNum-1) //do not print comma at the last iteration
					out.print(vars[i][0]+" "+vars[i][1].charAt(0));
				else
					out.print(vars[i][0]+" "+vars[i][1].charAt(0)+", ");
			}
			out.println("){}");
			for(int i=0;i<varNum;i++)
			{
				out.println(vars[i][1]+" = "+vars[i][1].substring(0,1)+";");
			}
			for(int i=0;i<varNum;i++)//setter and getter methods
			{
				String cap = vars[i][1].substring(0,1).toUpperCase();
				String f = Character.toString(vars[i][1].charAt(0));
				String rest = vars[i][1].substring(1);
				out.println("\tpublic void set"+cap+rest+"("+vars[i][0]+" "+f+"){"+vars[i][1]+" = "+f+";}");
				out.println("\tpublic "+vars[i][0]+" get"+cap+rest+"(){return "+vars[i][1]+";}");
			}
			out.println("}");
			out.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			out.close();
		}
	}
}