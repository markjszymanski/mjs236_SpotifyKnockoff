package mjs236_SpotifyKnockoff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.UUID;

public class Artist {

	private String artistID;
	private String firstName;
	private String lastName;
	private String bandName;
	private String bio;
	Hashtable<String, Artist> songArtists;
	
	public Artist(String firstName, String lastName, String bandName, String bio) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bandName = bandName;
		this.bio = bio;
		this.artistID = UUID.randomUUID().toString();
		
		String sql = "INSERT INTO artist (artist_id,first_name,last_name,band_name,bio) ";
		sql += "VALUES (?, ?, ?, ?, ?);";
		
		System.out.println("New artist added to database");
		
		try {
			DbUtilities db = new DbUtilities();
			Connection conn = db.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.artistID);
			ps.setString(2,  this.firstName);
			ps.setString(3, this.lastName);
			ps.setString(4, this.bandName);
			ps.setString(5, this.bio);
			ps.executeUpdate();
			db.closeDbConnection();
			db = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Artist(String artistID) {
		String sql = "SELECT * FROM artist WHERE artist_id = '" + artistID + "';";
		DbUtilities db = new DbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				this.artistID = rs.getString("artist_id");
				this.firstName = rs.getString("first_name");
				this.lastName = rs.getString("last_name");
				this.bandName = rs.getString("band_name");
				this.bio = rs.getString("bio");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteArtist(String artistID) {
		String sql = "DELETE FROM artist WHERE artist_id = '" + artistID + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
	}

	public String getArtistID() {
		return artistID;
	}

	public void setArtistID(String artistID) {
		this.artistID = artistID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}