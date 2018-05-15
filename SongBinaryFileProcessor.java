import java.io.*;
import java.util.*;

public class SongBinaryFileProcessor implements SongReader, SongWriter
{
	private String name;
	private int readCounter = 0; //counts the number of times a file read from
	private String prevName = ""; //stores the name of the file previously read from
	private int songsInFile = 0;
	
	SongBinaryFileProcessor(){}
	SongBinaryFileProcessor(String n){name = n;}
	
	public void setName(String n){name = n;}
	public String getName(){return name;}
	public int getSongsCount(return songsInFile)
	
	public void writeSong(Song sn)
	{
		RandomAccessFile f = null;
		String title = sn.getTitle();
		String album = sn.getAlbum();
		String genre = sn.getGenre();
		try
		{
			f = new RandomAccessFile(name,"rw");
			f.seek(f.length());
			for(int j=0; j<20; j++)
			//write title
			{
				if(j<title.length())
					f.writeChar(title.charAt(j));
				else
					f.writeChar(' ');
			}
			for(int j=0; j<20; j++)
			//write album
			{
				if(j<album.length())
					f.writeChar(album.charAt(j));
				else
					f.writeChar(' ');
			}
			for(int j=0; j<15; j++)
			//write genre
			{
				if(j<genre.length())
					f.writeChar(genre.charAt(j));
				else
					f.writeChar(' ');
			}
			songsInFile++;
		}
		catch(Exception e)
		{
			System.out.println("File not written\nException caught: "+e);
		}
	}
	public Song readSong()
	{
		RandomAccessFile in = null;
		try
		{
			in = new RandomAccessFile(name,"rw");
			
			if(!(prevName.equals(name)))
			//if file has not been read from previously, reset counter to 0
			{
				readCounter = 0;
			}
			
			in.seek(readCounter*55*2); //55 chars in a song 2 bytes in a char
			String output = "";
			for(int i = 0;i<55;i++)
				output += in.readChar();
			String title = output.substring(0,20);
			String album = output.substring(20,40);
			String genre = output.substring(40);
			Song sn = new Song(title,album,genre);
			in.close();
			
			return sn;
		}
		catch(IOException e)
		{
			if(e instanceof EOFException)
				System.out.println("You've reached the end of the file!");
			else
				System.out.println("Exception caught while reading: "+e);
		}
		finally
		{
			readCounter++;
			prevName = name;
		}
		return null;
	}
	public void readWholeSong() //must call readSong()
	{
		//return size of file and calculate number of songs
		
		
		
		
		/*DataInputStream in = null;
		try
		{
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(name)));
			while(in.available() > 0)
			{
				readSong();
			}
		}
		catch(Exception e)
		{
			System.out.println("Song not read");
			System.out.println("Exception caught: "+e);
		}*/
	}
}