import java.io.Serializable;
public class Course implements Serializable
{
	double grade;
	double credit;
	
	Course(){}
	Course(double g, double c)
	{
		grade = g;
		credit = c;
	}
	
	public void setGrade(double g){grade = g;}
	public double getGrade(){return grade;}
	public void setCredit(double c){credit = c;}
	public double getCredit(){return credit;}
}