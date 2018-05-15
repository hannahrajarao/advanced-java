import java.io.*;
import java.util.*;
//what needs to be fixed
//display contacts when user quits
//load contacts from file to map
public class Assignment8
{
	public static void main(String[] args)
	{
		TreeMap<String, Contact> contactList = new TreeMap<String, Contact>();
		String fileName = Input.getString("What is the name of the file you would like");
		String cont = "";
		//read file and put into map
		ObjectInputStream in;
		try
		{
			in  = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName+".dat")));
			for(int i=0;; i++)
			{
				Contact co = (Contact) in.readObject();
				contactList.put(co.getLname(), co);
			}
		}
		catch(Exception e){}
		while(!cont.equals("quit"))
		{
			if(cont.equalsIgnoreCase("add"))
			{
				//add contact to map
				String fname = Input.getString("Enter first name of contact");
				String lname = Input.getString("Enter last name of contact");
				lname = lname.substring(0,1).toUpperCase()+lname.substring(1);
				String p = Input.getString("Enter phone number");
				String e = Input.getString("Enter email address");
				Contact c = new Contact(fname, lname, p, e);
				contactList.put(lname, c);
				//add contact to file
				ObjectOutputStream out = null;
				try
				{
					out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName+".dat")));
					for(Map.Entry contacts : contactList.entrySet())
						out.writeObject(contacts.getValue());
					out.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
			else if(cont.equalsIgnoreCase("delete"))
			{
				//delete from map
				String del = Input.getString("What is the last name of the contact to be removed?");
				del = del.substring(0,1).toUpperCase()+del.substring(1);
				contactList.remove(del);
				//delete from file
				ObjectOutputStream out = null;
				try
				{
					out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName+".dat")));
					for(Map.Entry contacts : contactList.entrySet())
						out.writeObject(contacts.getValue());
					out.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
			else if(cont.equalsIgnoreCase("display"))
			{
				for(Map.Entry contacts : contactList.entrySet())
				{
					Contact c = contactList.get(contacts.getKey());
					System.out.println(c.getFname()+"\t"+c.getLname()+"\t"+c.getPhoneNumber()+"\t"+c.getEmailAddress());
				}
				System.out.println();
			}
			cont = Input.getString("Would you like to add a customer, delete a customer, display all customers, or quit?");
		}
		for(Map.Entry contacts : contactList.entrySet())
		{
			{
				Contact c = contactList.get(contacts.getKey());
				System.out.println(c.getFname()+"\t"+c.getLname()+"\t"+c.getPhoneNumber()+"\t"+c.getEmailAddress());
			}
			System.out.println();
		}
		System.out.println("Program complete!");
	}
}
