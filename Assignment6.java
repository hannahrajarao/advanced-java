public class Assignment6
{
	public static void main(String[] args)
	{
		SongBinaryFileProcessor s = new SongBinaryFileProcessor();
		String name = Input.getString("Enter name of the file");
		s.setName(name);
		String cont = "";
		while(!cont.equalsIgnoreCase("exit"))
		{
			cont = Input.getString("Would like to exit program, read or write a song");
			if(cont.equalsIgnoreCase("write"))
			{
				String title = Input.getString("Enter title of song");
				String album = Input.getString("Enter album of song");
				String genre = Input.getString("Enter genre of song");
				Song sn = new Song(title,album,genre);
				s.writeSong(sn);
			}
			if(cont.equalsIgnoreCase("read"))
			{
				char read = Input.getChar("Would you like to read the whole file or just one song?\nEnter w or o");
				if(read == 'w'||read == 'W')
					s.readWholeSong();
				Song sn = null;
				if(read == 'o'||read == 'O')
					sn = s.readSong();
				if(sn != null)
					sn.display();
			}
		}
		System.out.println("Program complete!");
	}
}