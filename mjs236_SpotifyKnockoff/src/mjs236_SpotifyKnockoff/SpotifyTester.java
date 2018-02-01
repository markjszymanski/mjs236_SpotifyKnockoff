package mjs236_SpotifyKnockoff;

import java.sql.*;
import java.util.*;

public class SpotifyTester {

	public static void main(String[] args) {
			
		System.out.println("Testing constructors:");
		
		/*System.out.println("");
		  System.out.println("");
		
		System.out.println("Song constructor to add a song:");
		Song s1 = new Song("1-800-273-8255", 4.10, "2017-01-01", "2016-01-01");
		System.out.println("Data added to database:");
		System.out.println("	SongID: " + s2.getSongID());
		System.out.println("	Title: " + s1.getTitle());
		System.out.println("	Length: " + s1.getLength());
		System.out.println("	filePath: " + s1.getFilePath());
		System.out.println("	releaseDate: " + s1.getReleaseDate());
		System.out.println("	recordDate: " + s1.getRecordDate());
		System.out.println("Song added successfully.");*/
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Song constructor to find a song by SongID:");
		Song s2 = new Song("f999b7f3-994e-4834-a86e-8ff25e62abb2");
		System.out.println("Data from database:");
		System.out.println("	SongID: " + s2.getSongID());
		System.out.println("	Title: " + s2.getTitle());
		System.out.println("	Length: " + s2.getLength());
		System.out.println("	File Path: " + s2.getFilePath());
		System.out.println("	Release Date: " + s2.getReleaseDate());
		System.out.println("	Record Date: " + s2.getRecordDate());
		System.out.println("Song found.");
		
		/*System.out.println("");
		  System.out.println("");
		
		System.out.println("Artist constructor to add an artist:");
		Artist a1 = new Artist("", "", "Logic", "$wag");
		System.out.println("Data added to database:");
		System.out.println("	ArtistID: " + a1.getArtistID());
		System.out.println("	First Name: " + a1.getFirstName());
		System.out.println("	Last Name: " + a1.getLastName());
		System.out.println("	Band Name: " + a1.getBandName());
		System.out.println("	Bio: " + a1.getBio());
		System.out.println("Artist added successfully.");*/
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Artist constructor to find an artist by ArtistID:");
		Artist a2 = new Artist("debd2869-63df-4c8e-98bc-ab6558fb6df2");
		System.out.println("Data from database:");
		System.out.println("	ArtistID: " + a2.getArtistID());
		System.out.println("	First Name: " + a2.getFirstName());
		System.out.println("	Last Name: " + a2.getLastName());
		System.out.println("	Band Name: " + a2.getBandName());
		System.out.println("	Bio: " + a2.getBio());
		System.out.println("Artist found.");
		
		/*System.out.println("");
		  System.out.println("");
		
		System.out.println("Album constructor to add an album:");
		Album a1 = new Album("Everybody", "1971-10-08", "", "VMG", 13, "R", 65.2);
		System.out.println("Data added to database:");
		System.out.println("	AlbumID: " + ab1.getAlbumID());
		System.out.println("	Title: " + ab1.getTitle());
		System.out.println("	Release Date: " + ab1.getReleaseDate());
		System.out.println("	Cover Image Path: " + ab1.getCoverImagePath());
		System.out.println("	Recording Company: " + ab1.getRecordingCompany());
		System.out.println("	Number of Tracks: " + ab1.getNumberOfTracks());
		System.out.println("	PMRC Rating: " + ab1.getPmrcRating());
		System.out.println("	Length: " + ab1.getLength());
		System.out.println("Album added successfully.");*/
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Album constructor to find an album by AlbumID:");
		Album ab2 = new Album("98dcd2a2-05f8-11e8-a67a-005056881e07");
		System.out.println("Data from database:");
		System.out.println("	AlbumID: " + ab2.getAlbumID());
		System.out.println("	Title: " + ab2.getTitle());
		System.out.println("	Release Date: " + ab2.getReleaseDate());
		System.out.println("	Cover Image Path: " + ab2.getCoverImagePath());
		System.out.println("	Recording Company: " + ab2.getRecordingCompany());
		System.out.println("	Number of Tracks: " + ab2.getNumberOfTracks());
		System.out.println("	PMRC Rating: " + ab2.getPmrcRating());
		System.out.println("	Length: " + ab2.getLength());
		System.out.println("Album found.");
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Testing Song methods:");
		
		System.out.println("");
		
		System.out.println("Song method to delete song from database:");
		Song s3 = new Song("a4271448-ec47-4457-8e32-0d142a34c86e");
		System.out.println("Data from database:");
		System.out.println("	SongID: " + s3.getSongID());
		System.out.println("	Title: " + s3.getTitle());
		System.out.println("	Length: " + s3.getLength());
		System.out.println("	File Path: " + s3.getFilePath());
		System.out.println("	Release Date: " + s3.getReleaseDate());
		System.out.println("	Record Date: " + s3.getRecordDate());
		s3.deleteSong("a4271448-ec47-4457-8e32-0d142a34c86e");
		System.out.println("Song deleted from database.");
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Testing Artist methods:");
		
		System.out.println("");
		
		System.out.println("Artist method to delete artist from database:");
		Artist a3 = new Artist("1962c8c4-f71b-4401-b323-ce58f0ac31d0");
		System.out.println("Data from database:");
		System.out.println("	ArtistID: " + a3.getArtistID());
		System.out.println("	First Name: " + a3.getFirstName());
		System.out.println("	Last Name: " + a3.getLastName());
		System.out.println("	Band Name: " + a3.getBandName());
		System.out.println("	Bio: " + a3.getBio());
		a3.deleteArtist("1962c8c4-f71b-4401-b323-ce58f0ac31d0");
		System.out.println("Artist deleted from database.");
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Testing Album methods:");
		
		System.out.println("");
		
		System.out.println("Album method to delete album from database:");
		Album ab3 = new Album("539fdb6c-50a5-44f1-8395-62ec5c39a2cc");
		System.out.println("Data from database:");
		System.out.println("	AlbumID: " + ab3.getAlbumID());
		System.out.println("	Title: " + ab3.getTitle());
		System.out.println("	Release Date: " + ab3.getReleaseDate());
		System.out.println("	Cover Image Path: " + ab3.getCoverImagePath());
		System.out.println("	Recording Company: " + ab3.getRecordingCompany());
		System.out.println("	Number of Tracks: " + ab3.getNumberOfTracks());
		System.out.println("	PMRC Rating: " + ab3.getPmrcRating());
		System.out.println("	Length: " + ab3.getLength());
		ab3.deleteAlbum("539fdb6c-50a5-44f1-8395-62ec5c39a2cc");
		System.out.println("Album deleted from database.");		
		
		
		
		
		//ErrorLogger.log("test");
		
		
		//Song s2 = new Song("a23801e1-56fc-462f-b507-0ab8baac742d");
		//s2.deleteSong("a23801e1-56fc-462f-b507-0ab8baac742d");
		//s2.addArtist(Logic);
		
		//Artist a1 = new Artist("", "", "Logic", "$wag");
		//Artist a2 = new Artist("317d8916-cd26-4807-819a-c88d85cf8445");
		//a2.deleteArtist("317d8916-cd26-4807-819a-c88d85cf8445");
		
//		Song s2 = new Song("f999b7f3-994e-4834-a86e-8ff25e62abb2");
//		Artist a2 = new Artist("d3d42968-c3a1-424e-b25f-35ce8158a370");
//		s2.addArtist(a2);
		
		//Album a1 = new Album("Everybody", "1971-10-08", "VMG", 13, "R", 65.2);
		//Album a2 = new Album("df4d425a-794f-410d-9093-c2b30966435f");
		//a2.deleteAlbum("df4d425a-794f-410d-9093-c2b30966435f");

		//Artist Logic = new Artist("", "", "Logic", "Peace, Love, & Positivity");
		//Song Flexicution = new Song("Flexicution", 3.39, "2017-06-14", "2016-01-01");
		//Artist Logic = new Artist("9eeab0ab-496d-4070-9741-bf946e798797");
		//Song Flexicution = new Song("b76199f8-df83-4c2f-a08f-2fcc1e56bb5a");
//		37fde081-0f7a-4cbb-bbe0-58792f13a5d4
//		72f9b1da-b53d-488e-9eff-b42a14db224e
//		a4271448-ec47-4457-8e32-0d142a34c86e
//		b76199f8-df83-4c2f-a08f-2fcc1e56bb5a
		//Flexicution.addArtist(Logic);
		//System.out.println(Flexicution.getSongArtists());
		
		
		//Artist Logic = new Artist("", "", "Logic", "Peace, Love, & Positivity");
		//Song Flexicution = new Song("Flexicution", 3.39, "2017-06-14", "2016-01-01", "57ed733c-0099-11e8-a67a-005056881e07");
		//Artist Logic = new Artist("9eeab0ab-496d-4070-9741-bf946e798797");
		//Song Flexicution = new Song("a4271448-ec47-4457-8e32-0d142a34c86e");
		//Flexicution.addArtist(Logic);
		
		
//		Hashtable<String, String> testHash = new Hashtable<String, String>();
//		testHash.put("Logic", "Africaryan");
//		testHash.put("J. Cole", "Africaryan");
//		
//		System.out.print(testHash.keySet());
//		System.out.print(testHash.values());
//		
//		testHash.remove("J. Cole");
//		
//		System.out.print(testHash.keySet());
//		System.out.print(testHash.values());
		
		/*
		Map<String, Song> songList = new Hashtable<String, Song>();
		try {
			DbUtilities db = new DbUtilities();
			String sql = "SELECT * FROM song;";
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				Song s = new Song(rs.getString("song_id"));
				songList.put(s.getSongID(), s);
				// System.out.println(s.getTitle());
			}
			db.closeDbConnection();
			db = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Find a song with ID b2dc89b2-205e-40ac-be60-d9b271490458
		
		Song foundSong = songList.get("451adab2-fd56-4c10-bff8-93e7a4b3859e");
		System.out.println(foundSong.getTitle());*/
	}
}