public class TextFilePractice
{
	public static void main(String[] args)
	{
		PrintWriter out = null;
		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter("fileName.txt")));
			out.println("This is a practice file writing program. I plan to write a program to read this later");
		}
		catch(IOException e)
		{
			System.out.println("Exception caught: "+e);
		}
		finally
		{
			out.close();
		}
	}
}