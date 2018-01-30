package mjs236_SpotifyKnockoff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.UUID;

public class Album {
	
	private String albumID;
	private String title;
	private String releaseDate;
	private String coverImagePath;
	private String recordingCompany;
	private int numberOfTracks;
	private String pmrcRating;
	private double length;
	Hashtable<Song, String> albumSongs;
	
	public Album(String title, String releaseDate, String recordingCompany, int numberOfTracks, String pmrcRating, double length) {
		this.albumID = UUID.randomUUID().toString();
		this.title = title;
		this.releaseDate = releaseDate;
		//this.coverImagePath = coverImagePath;
		this.recordingCompany = recordingCompany;
		this.numberOfTracks = numberOfTracks;
		this.pmrcRating = pmrcRating;
		this.length = length;
		
		
		String sql = "INSERT INTO album (album_id,title,release_date,cover_image_path,recording_company_name,number_of_tracks,PMRC_rating,length) ";
		sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		System.out.println("New album added to database");
		
		try {
			DbUtilities db = new DbUtilities();
			Connection conn = db.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.albumID);
			ps.setString(2,  this.title);
			ps.setString(3, this.releaseDate);
			ps.setString(4, "");
			ps.setString(5, this.recordingCompany);
			ps.setInt(6, this.numberOfTracks);
			ps.setString(7, this.pmrcRating);
			ps.setDouble(8, this.length);
			ps.executeUpdate();
			db.closeDbConnection();
			db = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Album(String albumID) {
		String sql = "SELECT * FROM album WHERE album_id = '" + albumID + "';";
		DbUtilities db = new DbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				this.albumID = rs.getString("album_id");
				this.title = rs.getString("title");
				this.releaseDate = rs.getDate("release_date").toString();
				this.coverImagePath = rs.getString("cover_image_path");
				this.recordingCompany = rs.getString("recording_company_name");
				this.numberOfTracks = rs.getInt("number_of_tracks");
				this.pmrcRating = rs.getString("PMRC_rating");
				this.length = rs.getDouble("length");
				System.out.println("Album title from database: " + this.title);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAlbum(String albumID) {
		String sql = "DELETE FROM album WHERE album_id = '" + albumID + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		System.out.println("Album deleted from database.");
	}

	public void addSong(Song song) {
		albumSongs.put(song, this.albumID);
		System.out.println("Added song to " + this.title);
	}
	
	public void deleteSong(String songID) {
		Song song = new Song(songID);
		albumSongs.remove(song);
		System.out.println("Deleted song from " + this.title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCoverImagePath() {
		return coverImagePath;
	}

	public void setCoverImagePath(String coverImagePath) {
		this.coverImagePath = coverImagePath;
	}

	public String getRecordingCompany() {
		return recordingCompany;
	}

	public void setRecordingCompany(String recordingCompany) {
		this.recordingCompany = recordingCompany;
	}

	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}

	public String getPmrcRating() {
		return pmrcRating;
	}

	public void setPmrcRating(String pmrcRating) {
		this.pmrcRating = pmrcRating;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void deleteSong(Song song) {
		albumSongs.remove(song);
		System.out.println("Deleted song from " + this.title);
	}
}
