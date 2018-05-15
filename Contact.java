import java.io.Serializable;
public class Contact implements Serializable
{
	private String fname;
	private String lname;
	private String phoneNumber;
	private String emailAddress;

    Contact(){}
    Contact(String f, String l, String p, String e)
	{
		fname = f;
		lname = l;
		phoneNumber = p;
		emailAddress = e;
	}
	
	public void setFname(String f){fname = f;}
	public String getFname(){return fname;}
    public void setLname(String l){lname = l;}
    public String getLname(){return lname;}
    public void setPhoneNumber(String p){phoneNumber = p;}
    public String getPhoneNumber(){return phoneNumber;}
    public void setEmailAddress(String e){emailAddress = e;}
    public String getEmailAddress(){return emailAddress;}
}