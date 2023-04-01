package GenderMag2;
import java.util.LinkedList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create 3 Song instances with different data types
		Song song1 = new Song("7762291 ", "JailhouseRock ", "Elvis Presley ", "Elvis'Golden Records ","1957");
		Song song2 = new Song("4755879 ","HotelCalifornia ", "Eagles ", "HotelCalifornia(2013Remastered) ", "1976");
		Song song3 = new Song("7827638 ","BillieJean ","Michael Jackson ","Thriller 25 Super Deluxe Edition ","1982");

		System.out.println("[Testing toString() method and DisplayAllSongs() method]\n");
		// print Top 3 Songs on list with  ID
		System.out.println("Top 3 Songs on List With ID: \n---------------------------- \nID, Title, Artist, Album, Year");
		System.out.println(song1.toString());
		System.out.println(song2.toString());
		System.out.println(song3.toString());


		// create a LinkedList of top 3 songs
		LinkedList<Song> songList = new LinkedList<>();
		songList.add(song1);
		songList.add(song2);
		songList.add(song3);

		// LINES 30-32 are not needed, just there to test the display method. 
		// testing the DisplayMethod to show top 3 songs on list without ID
		System.out.println("\nTop 3 Songs Without ID: \n----------------------- \nTitle, Artist, Album");
		Song.displayAllSongs(songList);
		System.out.println("\n");

		//File Path for both ReadSongs METHODS
		String filePath = "C:\\Users\\chris\\eclipse-workspace\\DataStructures\\src\\GenderMag2\\Output.txt";
		System.out.println("[Testing ReadSongLinkedList() method and ReadSongArray() method] \n");
		//LinkedList title to Organize Output
		System.out.println("[LinkedList] \n------------");

		//LinkedList Read() Method for Song text file
		LinkedList<Song> songList1 = Song.readSongsLinkedList(filePath);
		//Display method which prints all songs listed in text file 
		Song.displayAllSongs(songList1);

		//Blank Space 
		System.out.println("\n");	
		System.out.println("[Array] \n-------"); //Makes Output Neat

		//Array Read() Method for Song text file
		Song[] sq = Song.readSongsArray(filePath);
		for(int i = 0; i < sq.length; i++) {
			System.out.println(sq[i].getAlbum());
		}

		//Object of all Songs with their special ID added from the text file list. 
		List<Song> songs = new ArrayList<>();
		songs.add(new Song("","JailhouseRock", "ElvisPresley", "Elvis'GoldenRecords", "1957"));
		songs.add(new Song("","HotelCalifornia", "Eagles", "HotelCalifornia(2013Remastered)", "1976"));
		songs.add(new Song("","BillieJean", "MichaelJackson", "Thriller25SuperDeluxeEdition", "1982"));
		songs.add(new Song("","BohemianRhapsody", "Queen", "ANightAtTheOpera(2011Remastered)", "1975"));
		songs.add(new Song("","LetItBe", "TheBeatles", "LetItBe(Remastered)", "1970"));
		songs.add(new Song("","I Can't Get No Satisfaction", "TheRollingStones", "OutOfOurHeads", "1965"));
		songs.add(new Song("","Africa", "TOTO", "TotoIV", "1982"));
		songs.add(new Song("","MoreThanAFeeling", "Boston", "Boston", "1976"));
		songs.add(new Song("","Stayin'Alive", "BeeGees", "Greatest", "1977"));
		songs.add(new Song("","SmellsLikeTeenSpirit", "Nirvana", "NeverMind(DeluxeEdition)", "1991"));
		songs.add(new Song("","EveryBreathYouTake", "ThePolice", "Synchronicity(Remastered2003)", "1983"));
		songs.add(new Song("","StandByMe", "BenE,king", "DontPlayThatSong(Mono)", "1986"));
		songs.add(new Song("","NothingCompares2U", "SineadO'Connor", "IDoNotWantWhatIHaven'tGotten", "1990"));
		songs.add(new Song("","Don'tStopBelievin'", "Journey", "Escape(BonusTrackVersion)", "1981"));
		songs.add(new Song("","BeforeYourBirth", "TheVices", "LookingForFaces", "2021"));
		songs.add(new Song("","Imagine", "JohnLennon", "Imagine", "1971"));
		songs.add(new Song("","IWasMadeForLovin'You", "KISS", "Dynasty", "1979"));
		songs.add(new Song("","BeatIt", "MichaelJackson", "Thriller25SuperDeluxeVersion", "1982"));
		songs.add(new Song("","DejaVu", "PanArcadia", "DejaVu", "2021"));
		songs.add(new Song("","WholelottaLove", "LedZeppelin", "LedZeppelinII(1994Remastered)", "1969"));
		songs.add(new Song("","TakeonMe", "a-ha", "HuntingHighandLow", "1985"));
		songs.add(new Song("","UndertheBridge", "RedHotChiliPeppers", "BloodSugarSexMagika(DeluxeEdition)", "1991"));
		songs.add(new Song("","Gangsta'sParadise", "Coolio", "Gangsta'sParadise", "1995"));
		songs.add(new Song("","SweetChildO'Mine", "GunsN'Roses", "AppetiteForDestruction", "1987"));
		songs.add(new Song("","IwillAlwaysLoveYou", "WhitneyHouston", "TheBodyguard-OrigionalSoundtrack", "1974"));


		// sort songs by title using NameComparator
		Collections.sort(songs, new NameComparator());
		System.out.println("\n\n[Testing Comparator() methods] \n");
		System.out.println("Songs sorted alphabetically by title: \n-------------------------------------");
		for (Song song : songs) {
			System.out.println(song.toString1());
		}

		// sort songs by year and title using YearNameComparator
		Collections.sort(songs, new YearNameComparator());
		System.out.println("\nSongs sorted in accending order by year/title: \n----------------------------------------------");
		for (Song song : songs) {
			System.out.println(song.toString1());
		}

		//Blank Space 
		System.out.println("\n");
		
		
		//SEARCHSONG() METHOD by [NAME]
		// Open the file containing the song data
		File file = new File("C:\\Users\\chris\\eclipse-workspace\\DataStructures\\src\\GenderMag2\\Songs.txt");

		try {
			// Create a Scanner to read from the file
			Scanner scanner = new Scanner(file);

			// Prompt the user to enter a song name
			System.out.print("Enter a song [name] to search: ");
			Scanner userInput = new Scanner(System.in);
			String SongName = userInput.nextLine();

			// Search for matching songs and print their information
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(",");
				String title = parts[0];
				String artist = parts[1];
				String albumName = parts[2];
				String year = parts[3];

				if (title.equalsIgnoreCase(SongName)) {
					System.out.println("Title: " + title);
					System.out.println("Artist: " + artist);
					System.out.println("Album: " + albumName);
					System.out.println("Year: " + year);
					System.out.println();
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + file.getName());
		}
		
		//SEARCHSONG() METHOD for [YEAR] and [NAME]
		// Load the song text file
		File songFile = new File("C:\\Users\\chris\\eclipse-workspace\\DataStructures\\src\\GenderMag2\\Songs.txt");

		// Scanner to read user input by year and name
		Scanner scanner = new Scanner(System.in);
		// Prompt the user to enter a year or name to search for
		System.out.print("Enter a [year] or song [name]: ");
		String searchTerm = scanner.nextLine();

		// Search for songs that match the user's input
		try {
			Scanner songScanner = new Scanner(songFile);
			while (songScanner.hasNextLine()) {
				String songLine = songScanner.nextLine();
				String[] songData = songLine.split(",");
				String songTitle = songData[0];
				String songArtist = songData[1];
				String songAlbum = songData[2];
				String songYear = songData[3];

				// Check if the song matches the user's search term
				if (songYear.equals(searchTerm) || songTitle.equalsIgnoreCase(searchTerm)) {
					System.out.printf("%s by %s (%s, %s)%n", songTitle, songArtist, songAlbum, songYear);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Failed to read song file: " + e.getMessage());
		}
	}
}