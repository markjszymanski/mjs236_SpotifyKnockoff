package mjs236_SpotifyKnockoff;

import java.sql.*;
import java.util.*;

public class SpotifyTester {

	public static void main(String[] args) {

		//Song s1 = new Song("Everybody", 8.02, "1971-10-08", "1971-05-07", "57ed733c-0099-11e8-a67a-005056881e07");
		//Song s2 = new Song("a23801e1-56fc-462f-b507-0ab8baac742d");
		//s2.deleteSong("a23801e1-56fc-462f-b507-0ab8baac742d");
		//s2.addArtist(Logic);
		
		//Artist a1 = new Artist("", "", "Logic", "$wag");
		//Artist a2 = new Artist("317d8916-cd26-4807-819a-c88d85cf8445");
		//a2.deleteArtist("317d8916-cd26-4807-819a-c88d85cf8445");
		
		
		//Album a1 = new Album("Everybody", "1971-10-08", "VMG", 13, "R", 65.2);
		//Album a2 = new Album("df4d425a-794f-410d-9093-c2b30966435f");
		//a2.deleteAlbum("df4d425a-794f-410d-9093-c2b30966435f");

		
		
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
