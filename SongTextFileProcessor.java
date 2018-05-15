import java.io.*;
import java.util.*;
public class SongTextFileProcessor implements SongReader, SongWriter
{
	private String name;
	
	SongTextFileProcessor() {}
	SongTextFileProcessor(Song s) {}

	public void setName(String n) {name = n;}
	public String getName() {return name;}
	
	public void writeSong(Song sn)
	{
		PrintWriter out = null;
		
		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(name, true)));
			out.println(sn.getTitle() +" - " + sn.getAlbum() + " - " + sn.getGenre()+"\n");
			
		}
		catch(IOException e)
		{
			System.out.println("Song not added");
		}
		finally
		{
			out.close();
		}
	}
	
	public Song readSong()
	{
		BufferedReader in = null;
		String line = null;
		try
		{
			in = new BufferedReader(new FileReader(name));
			while((line = in.readLine()) != null)
			{
				System.out.println(line);
			}
			in.close();
		}
		catch(Exception e)
		{
			System.out.println("File unable to be read");
		}
	}
}