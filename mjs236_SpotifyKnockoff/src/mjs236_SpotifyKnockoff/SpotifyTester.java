package mjs236_SpotifyKnockoff;

import java.sql.*;
import java.util.*;

//This probably should have been broken into separate methods but it's only for testing purposes 
public class SpotifyTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Vector<Vector<String>> songTable = new Vector<>();
		try {
			DbUtilities db = new DbUtilities();
			String sql = "SELECT * FROM song;";
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				
				Song s = new Song(rs.getString("song_id"), 
						rs.getString("title"),
						rs.getDouble("length"),
						rs.getString("release_date"),
						rs.getString("record_date"));
				songTable.add(s.getSongRecord());
				// songList.put(s.getSongID(), s);
				// System.out.println(s.getTitle());
			}
			db.closeDbConnection();
			db = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i<songTable.size(); i++){
			for(int j = 0; j < songTable.get(i).size(); j++){
				System.out.print(songTable.get(i).get(j) + "\t\t\t");
			}
			System.out.println();
		}
		
			
//		System.out.println("Testing Artist Class:");
//		
//		System.out.println("");
//		
//		System.out.println("Artist constructor to add an artist:");
//		Artist a1 = new Artist("", "", "Logic", "Peace, Love, & Positivity.");
//		System.out.println("Data added to database:");
//		System.out.println("	ArtistID: " + a1.getArtistID());
//		System.out.println("	First Name: " + a1.getFirstName());
//		System.out.println("	Last Name: " + a1.getLastName());
//		System.out.println("	Band Name: " + a1.getBandName());
//		System.out.println("	Bio: " + a1.getBio());
//		System.out.println("Artist added successfully.");
//		
//		System.out.println("");
//		
//		System.out.println("Artist constructor to find an artist by ArtistID:");
//		Artist a2 = new Artist(a1.getArtistID());
//		System.out.println("Data from database:");
//		System.out.println("	ArtistID: " + a2.getArtistID());
//		System.out.println("	First Name: " + a2.getFirstName());
//		System.out.println("	Last Name: " + a2.getLastName());
//		System.out.println("	Band Name: " + a2.getBandName());
//		System.out.println("	Bio: " + a2.getBio());
//		System.out.println("Artist found.");
//		
//		System.out.println("");	
//		
//		System.out.println("Artist method to delete artist from database:");
//		Artist a3 = new Artist(a1.getArtistID());
//		System.out.println("Data from database:");
//		System.out.println("	ArtistID: " + a3.getArtistID());
//		System.out.println("	First Name: " + a3.getFirstName());
//		System.out.println("	Last Name: " + a3.getLastName());
//		System.out.println("	Band Name: " + a3.getBandName());
//		System.out.println("	Bio: " + a3.getBio());
//		a3.deleteArtist(a1.getArtistID());
//		System.out.println("Artist deleted from database.");
//		
//		System.out.println("");
//		System.out.println("");
//		
//		System.out.println("Testing Song Class:");
//		
//		System.out.println("");
//		
//		System.out.println("Song constructor to add a song:");
//		Song s1 = new Song("1-800-273-8255", 4.10, "2017-01-01", "2016-01-01");
//		System.out.println("Data added to database:");
//		System.out.println("	SongID: " + s1.getSongID());
//		System.out.println("	Title: " + s1.getTitle());
//		System.out.println("	Length: " + s1.getLength());
//		System.out.println("	filePath: " + s1.getFilePath());
//		System.out.println("	releaseDate: " + s1.getReleaseDate());
//		System.out.println("	recordDate: " + s1.getRecordDate());
//		System.out.println("Song added successfully.");		
//		
//		System.out.println("");
//		
//		System.out.println("Song constructor to find a song by SongID:");
//		Song s2 = new Song(s1.getSongID());
//		System.out.println("Data from database:");
//		System.out.println("	SongID: " + s2.getSongID());
//		System.out.println("	Title: " + s2.getTitle());
//		System.out.println("	Length: " + s2.getLength());
//		System.out.println("	File Path: " + s2.getFilePath());
//		System.out.println("	Release Date: " + s2.getReleaseDate());
//		System.out.println("	Record Date: " + s2.getRecordDate());
//		System.out.println("Song found.");		
//		
//		System.out.println("");
//		
//		System.out.println("Song method to delete song from database:");
//		Song s3 = new Song(s1.getSongID());
//		System.out.println("Data from database:");
//		System.out.println("	SongID: " + s3.getSongID());
//		System.out.println("	Title: " + s3.getTitle());
//		System.out.println("	Length: " + s3.getLength());
//		System.out.println("	File Path: " + s3.getFilePath());
//		System.out.println("	Release Date: " + s3.getReleaseDate());
//		System.out.println("	Record Date: " + s3.getRecordDate());
//		s3.deleteSong(s1.getSongID());
//		System.out.println("Song deleted from database.");
//		
//		System.out.println("");
//		
//		System.out.println("Song method to add artist to song in database:");
//		Artist a4 = new Artist("", "", "Logic", "Peace, Love, & Positivity.");
//		Song s4 = new Song("1-800-273-8255", 4.10, "2017-01-01", "2016-01-01");
//		//Song s4 = new Song("b4a1274f-2f9c-4e7a-a4a7-e33857b2412c");
//		//Artist a4 = new Artist("d3d42968-c3a1-424e-b25f-35ce8158a370");
//		s4.addArtist(a4);
//		System.out.println(a4.getArtistID() + " added to " + s4.getTitle());
//		
//		System.out.println("");
//		
//		System.out.println("Song method to remove artist from song in database (by SongID):");
//		Song s7 = new Song(s4.getSongID());
//		Artist a7 = new Artist(a4.getArtistID());
//		s7.deleteArtist(s4.getSongID());
//		System.out.println(a7.getArtistID() + " removed from " + s7.getTitle());
//		
//		System.out.println("");
//		
//		System.out.println("Song method to remove artist from song in database (by Artist):");
//		Song s8 = new Song("1-800-273-8255", 4.10, "2017-01-01", "2016-01-01");
//		Artist a8 = new Artist("", "", "Logic", "Peace, Love, & Positivity.");
//		//Song s8 = new Song("1e0f5f3b-aee7-46bb-b726-ce2cc7266e9b");
//		//Artist a8 = new Artist("0a6c7704-6933-4975-9c15-b63234388028");
//		s8.deleteArtist(a8);
//		System.out.println(a8.getArtistID() + " removed from " + s8.getTitle());
//		
//		System.out.println("");
//		System.out.println("");
//		
//		System.out.println("Testing Album Class:");
//		
//		System.out.println("");
//		
//		System.out.println("Album constructor to add an album:");
//		Album ab1 = new Album("Everybody", "1971-10-08", "VMG", 13, "R", 65.2);
//		System.out.println("Data added to database:");
//		System.out.println("	AlbumID: " + ab1.getAlbumID());
//		System.out.println("	Title: " + ab1.getTitle());
//		System.out.println("	Release Date: " + ab1.getReleaseDate());
//		System.out.println("	Cover Image Path: " + ab1.getCoverImagePath());
//		System.out.println("	Recording Company: " + ab1.getRecordingCompany());
//		System.out.println("	Number of Tracks: " + ab1.getNumberOfTracks());
//		System.out.println("	PMRC Rating: " + ab1.getPmrcRating());
//		System.out.println("	Length: " + ab1.getLength());
//		System.out.println("Album added successfully.");
//		
//		System.out.println("");
//		
//		System.out.println("Album constructor to find an album by AlbumID:");
//		Album ab2 = new Album(ab1.getAlbumID());
//		System.out.println("Data from database:");
//		System.out.println("	AlbumID: " + ab2.getAlbumID());
//		System.out.println("	Title: " + ab2.getTitle());
//		System.out.println("	Release Date: " + ab2.getReleaseDate());
//		System.out.println("	Cover Image Path: " + ab2.getCoverImagePath());
//		System.out.println("	Recording Company: " + ab2.getRecordingCompany());
//		System.out.println("	Number of Tracks: " + ab2.getNumberOfTracks());
//		System.out.println("	PMRC Rating: " + ab2.getPmrcRating());
//		System.out.println("	Length: " + ab2.getLength());
//		System.out.println("Album found.");
//		
//		System.out.println("");
//		
//		System.out.println("Album method to delete album from database:");
//		Album ab3 = new Album(ab1.getAlbumID());
//		System.out.println("Data from database:");
//		System.out.println("	AlbumID: " + ab3.getAlbumID());
//		System.out.println("	Title: " + ab3.getTitle());
//		System.out.println("	Release Date: " + ab3.getReleaseDate());
//		System.out.println("	Cover Image Path: " + ab3.getCoverImagePath());
//		System.out.println("	Recording Company: " + ab3.getRecordingCompany());
//		System.out.println("	Number of Tracks: " + ab3.getNumberOfTracks());
//		System.out.println("	PMRC Rating: " + ab3.getPmrcRating());
//		System.out.println("	Length: " + ab3.getLength());
//		ab3.deleteAlbum(ab1.getAlbumID());
//		System.out.println("Album deleted from database.");
//		
//		System.out.println("");
//		
//		System.out.println("Album method to add song to album in database (By SongID):");
//		Album ab5 = new Album("Everybody", "1971-10-08", "VMG", 13, "R", 65.2);
//		Song s5 = new Song("1-800-273-8255", 4.10, "2017-01-01", "2016-01-01");
//		//Album ab5 = new Album(ab1.getAlbumID());
//		//Song s5 = new Song("a01538ee-e0ed-43b1-bfd0-89d0ddb48726");
//		ab5.addSong(s5);
//		System.out.println(s5.getSongID() + " added to " + ab5.getTitle());
//		
//		System.out.println("");
//		
//		System.out.println("Album method to remove song from album in database (By SongID):");
//		Album ab6 = new Album(ab5.getAlbumID());
//		Song s6 = new Song(s5.getSongID());
//		ab6.deleteSong("a01538ee-e0ed-43b1-bfd0-89d0ddb48726");
//		System.out.println(s6.getSongID() + " removed from " + ab6.getTitle());
//		
//		
//		System.out.println("");
//		System.out.println("");
//		System.out.println("Done.");

		//Song s6 = new Song("a01538ee-e0ed-43b1-bfd0-89d0ddb48726");
		//s6.setSongID("12asajsdhiasdhiuahsdhaisd");
		
		//ErrorLogger.log("test");
	}
}