import java.io.*;
import java.util.*;
public class WriteBinaryFileExercise2
{
	public static void main( String [] args )
	{
		int [] productNums = { 110, 520, 178, 172 };
		String [] productNames = { "Hammer ", "Lawn Mower ", "Monkey Wrench ", "Screwdriver " };
		int [] quantity = { 20, 8, 53, 150 };
		double [] cost = { 12.99, 79.52, 6.95, 5.99 };
		DataOutputStream out = null;
		try
		{
			out = new DataOutputStream(
			new BufferedOutputStream( new FileOutputStream( "products.dat" ) ));
			for ( int i = 0; i < 4; i++ )
			{
				out.writeInt( productNums[ i ] );
				//out.writeChars( productNames[ i ] );
				String name = productNames[i];
				for(int j=0; j<15; j++)
				{
					if(j<name.length())
						out.writeChar(name.charAt(j));
					else
						out.writeChar(' ');
				}
				out.writeInt( quantity[ i ] );
				out.writeDouble( cost[ i ] );
			}
			out.close();
		}
		catch( Exception e )
		{
			System.out.println( "Error writing to file" );
			e.printStackTrace();
		}
	}
	

}
