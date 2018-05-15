public class Song
{
	private String title;
	private String album;
	private String genre;
	
	Song() //default constructor
	{
		
	}
	Song(String t, String a, String g) //parameterized constructor
	{
		title = t;
		album = a;
		genre = g;
	}
	
	public void setTitle(String t) {title = t;}
	public String getTitle() {return title;}
	public void setAlbum(String a) {album = a;}  //getter and setter methods
	public String getAlbum() {return album;}
	public void setGenre(String g) {genre = g;}
	public String getGenre() {return genre;}
	
	public void display()
	{
		System.out.printf("%-20s %-20s %-15s %n",title, album, genre);
	}
}