import java.io.Serializable;

public class Student implements Serializable
{
	String name;
	String ssn; //social security number
	int coursesCompleted; //array size
	Course[] courses;
	
	Student(){}
	Student(String n, String s, int cc, double[][] c)
	{
		name = n;
		ssn = s;
		coursesCompleted = cc;
		setCourses(c);
	}
	
	public void setName(String n){name = n;}
	public String getName(){return name;}
	public void setSSN(String s){ssn = s;}
	public String getSSN(){return ssn;}
	public void setCoursesCompleted(int c){coursesCompleted = c;}
	public double getCoursesCompleted(){return coursesCompleted;}
	
	public void setCourses(Course[] c)
	{
		courses = c;
	}
	public void setCourses(double[][] array)
	{
		courses = new Course[coursesCompleted];
		for(int i=0;i<array.length;i++)
		{
			courses[i] = new Course(array[i][0], array[i][1]);
		}
	}
	public Course[] getCourses()
	{
		return courses;
	}
	
	public void addCourse(Course c)
	{
		Course[] newCourses = new Course[courses.length+1];
		for(int i=0;i<courses.length;i++)
		{
			newCourses[i] = courses[i];
		}
		newCourses[courses.length] = c;
		courses = newCourses;
	}
	
	public double calculateGPA()
	{
		double sum = 0;
		double divisor = 0;
		for(int i=0; i<courses.length; i++)
		{
			sum += courses[i].getGrade() * courses[i].getCredit();
			divisor += courses[i].getCredit();
		}
		
		return sum/divisor;
	}
}