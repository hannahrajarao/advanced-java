public class CalculateGPA
{
	public static void main(String[] args)
	{
		Student[] students = new Student[3];
		for(int i=0;i<3;i++)
		{
			String name = Input.getString("Enter name");
			String ssn = Input.getString("Enter social security number");
			int coursesCompleted = Input.getInt("Enter number of courses completed");
			Course[][] courses = new Course[coursesCompleted][2];
			for(int j=0;j<coursesCompleted;j++)
			{
				courses[j][0] = Input.getInt("Enter name for course "+(j+1));
				courses[j][1] = Input.getInt("Enter credits for course" (j+1));
			}
			students[i] = new Student(name, ssn, coursesCompleted);
		}
		for(int i=0;i<3;i++)
			System.out.println(students[i].getName()+"\t"+students[i].calculateGPA());
	}
}