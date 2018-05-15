import java.io.*;
import java.util.*;
public class UpdateRandomAccessFileExercise
{
	public static void main( String [] args )
	{
		RandomAccessFile f = null;
		try
		{
			f = new RandomAccessFile( "products.dat", "rws" );
			f.seek( 126 ); // position to where quantity is stored
			f.writeInt( 48 ); // update quantity
			f.seek( f.length() ); // position pointer to end of file
			// add new record
			f.writeInt( 100 );
			f.writeChars( "Roofing Tacks " );
			f.writeInt( 1500 );
			f.writeDouble( 7.95 );
			f.close();
		}
		catch( Exception e )
		{
			System.out.println( "Error Updating file" );
		}
	}
} 