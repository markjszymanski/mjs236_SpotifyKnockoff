package mjs236_SpotifyKnockoff;

import java.sql.*;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column (name = "album_id")
	private String albumID;
	
	@Column (name = "title")
	private String title;
	
	@Column (name = "release_date")
	private String releaseDate;
	
	@Column (name = "cover_image_path")
	private String coverImagePath;
	
	@Column (name = "recording_company_name")
	private String recordingCompany;
	
	@Column (name = "number_of_tracks")
	private int numberOfTracks;
	
	@Column (name = "PMRC_rating")
	private String pmrcRating;
	
	@Column (name = "length")
	private double length;
	
	@Transient
	Map<String, Song> albumSongs;
	
	public Album() {
		super();
	}
	
	/**
	 * @param title
	 * @param releaseDate
	 * @param recordingCompany
	 * @param numberOfTracks
	 * @param pmrcRating
	 * @param length
	 */
	public Album(String title, String releaseDate, String recordingCompany, int numberOfTracks, String pmrcRating, double length) {
		this.albumID = UUID.randomUUID().toString();
		this.title = title;
		this.releaseDate = releaseDate;
		//this.coverImagePath = coverImagePath;
		this.recordingCompany = recordingCompany;
		this.numberOfTracks = numberOfTracks;
		this.pmrcRating = pmrcRating;
		this.length = length;
		
		albumSongs = new Hashtable<String, Song>();
		
		String sql = "INSERT INTO album (album_id,title,release_date,cover_image_path,recording_company_name,number_of_tracks,PMRC_rating,length) ";
		sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
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

	/**
	 * @param albumID
	 */
	public Album(String albumID) {
		albumSongs = new Hashtable<String, Song>();
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
			}
		} catch (SQLException e) {
			ErrorLogger logger = new ErrorLogger();
			logger.log(e.getMessage());
		}
	}
	
	/**
	 * @param albumID
	 */
	public void deleteAlbum(String albumID) {
		String sql = "DELETE FROM album WHERE album_id = '" + albumID + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
	}

	/**
	 * @param song
	 */
	public void addSong(Song song) {
		albumSongs.put(song.getSongID(), song);
		String sql = "INSERT INTO album_song (fk_album_id,fk_song_id) VALUES (?, ?);";
		
		try {
			DbUtilities db = new DbUtilities();
			Connection conn = db.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.albumID);
			ps.setString(2, song.getSongID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param songID
	 */
	public void deleteSong(String songID) {
		albumSongs.remove(songID);
		String sql = "DELETE FROM album_song WHERE fk_song_id = '" + songID + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
	}

	/**
	 * @return
	 */
	public String getAlbumID() {
		return albumID;
	}

	/**
	 * @param albumID
	 */
	public void setAlbumID(String albumID) {
		String sql = "UPDATE album SET album_id = '" + albumID + "' WHERE album_id = '" + this.albumID + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.albumID = albumID;
	}
	
	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		String sql = "UPDATE album SET title = '" + title + "' WHERE title = '" + this.title + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.title = title;
	}

	/**
	 * @return
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate
	 */
	public void setReleaseDate(String releaseDate) {
		String sql = "UPDATE album SET release_date = '" + releaseDate + "' WHERE release_date = '" + this.releaseDate + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.releaseDate = releaseDate;
	}

	/**
	 * @return
	 */
	public String getCoverImagePath() {
		return coverImagePath;
	}

	/**
	 * @param coverImagePath
	 */
	public void setCoverImagePath(String coverImagePath) {
		String sql = "UPDATE album SET cover_image_path = '" + coverImagePath + "' WHERE cover_image_path = '" + this.coverImagePath + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.coverImagePath = coverImagePath;
	}

	/**
	 * @return
	 */
	public String getRecordingCompany() {
		return recordingCompany;
	}

	/**
	 * @param recordingCompany
	 */
	public void setRecordingCompany(String recordingCompany) {
		String sql = "UPDATE album SET recording_company_name = '" + recordingCompany + "' WHERE recording_company_name = '" + this.recordingCompany + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.recordingCompany = recordingCompany;
	}

	/**
	 * @return
	 */
	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	/**
	 * @param numberOfTracks
	 */
	public void setNumberOfTracks(int numberOfTracks) {
		String sql = "UPDATE album SET number_of_tracks = '" + numberOfTracks + "' WHERE number_of_tracks = '" + this.numberOfTracks + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.numberOfTracks = numberOfTracks;
	}

	/**
	 * @return
	 */
	public String getPmrcRating() {
		return pmrcRating;
	}

	/**
	 * @param pmrcRating
	 */
	public void setPmrcRating(String pmrcRating) {
		String sql = "UPDATE album SET PMRC_rating = '" + pmrcRating + "' WHERE PMRC_rating = '" + this.pmrcRating + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.pmrcRating = pmrcRating;
	}

	/**
	 * @return
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length
	 */
	public void setLength(double length) {
		String sql = "UPDATE album SET length = '" + length + "' WHERE length = '" + this.length + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.length = length;
	}
	
	/**
	 * @return
	 */
	public Map<String, Song> getAlbumSongs() {
		return albumSongs;
	}

	/**
	 * @param albumSongs
	 */
	public void setAlbumSongs(Map<String, Song> albumSongs) {
		this.albumSongs = albumSongs;
	}
}
