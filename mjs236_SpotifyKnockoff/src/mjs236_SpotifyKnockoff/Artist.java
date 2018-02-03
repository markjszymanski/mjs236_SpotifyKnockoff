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
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param bandName
	 * @param bio
	 */
	public Artist(String firstName, String lastName, String bandName, String bio) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bandName = bandName;
		this.bio = bio;
		this.artistID = UUID.randomUUID().toString();
		
		String sql = "INSERT INTO artist (artist_id,first_name,last_name,band_name,bio) ";
		sql += "VALUES (?, ?, ?, ?, ?);";
		
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
	
	/**
	 * @param artistID
	 */
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
	
	/**
	 * @param artistID
	 */
	public void deleteArtist(String artistID) {
		String sql = "DELETE FROM artist WHERE artist_id = '" + artistID + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
	}

	/**
	 * @return
	 */
	public String getArtistID() {
		return artistID;
	}

	/**
	 * @param artistID
	 */
	public void setArtistID(String artistID) {
		String sql = "UPDATE artist SET artist_id = '" + artistID + "' WHERE artist_id = '" + this.artistID + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.artistID = artistID;
	}
	
	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		String sql = "UPDATE artist SET first_name = '" + firstName + "' WHERE first_name = '" + this.firstName + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		String sql = "UPDATE artist SET last_name = '" + lastName + "' WHERE last_name = '" + this.lastName + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public String getBandName() {
		return bandName;
	}

	/**
	 * @param bandName
	 */
	public void setBandName(String bandName) {
		String sql = "UPDATE artist SET band_name = '" + bandName + "' WHERE band_name = '" + this.bandName + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.bandName = bandName;
	}

	/**
	 * @return
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio
	 */
	public void setBio(String bio) {
		String sql = "UPDATE artist SET bio = '" + bio + "' WHERE bio = '" + this.bio + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.bio = bio;
	}
}