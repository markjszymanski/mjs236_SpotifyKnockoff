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
@Table (name = "song")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column (name = "song_id")
	private String songID;
	
	@Column (name = "title")
	private String title;
	
	@Column (name = "length")
	private double length;
	
	@Column (name = "file_path")
	private String filePath;
	
	@Column (name = "release_date")
	private String releaseDate;
	
	@Column (name = "record_date")
	private String recordDate;
	
	@Transient
	Map<String, Artist> songArtists;
	
	public Song() {
		super();
	}
	
	/**
	 * @param title
	 * @param length
	 * @param releaseDate
	 * @param recordDate
	 */
	public Song(String title, double length, String releaseDate, String recordDate) {
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		this.songID = UUID.randomUUID().toString();
		
		songArtists = new Hashtable<String, Artist>();
		
//		String sql = "INSERT INTO song (song_id,title,length,file_path,release_date,record_date) ";
//		sql += "VALUES (?, ?, ?, ?, ?, ?);";
//		
//		try {
//			DbUtilities db = new DbUtilities();
//			Connection conn = db.getConn();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, this.songID);
//			ps.setString(2, this.title);
//			ps.setDouble(3, this.length);
//			ps.setString(4, "");
//			ps.setString(5, this.releaseDate);
//			ps.setString(6, this.recordDate);
//			ps.executeUpdate();
//			db.closeDbConnection();
//			db = null;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
	}
	
	public Song(String songID, String title, double length, String releaseDate, String recordDate){
		
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		this.songID = songID;
		
		songArtists = new Hashtable<String, Artist>();
	}
	
	/**
	 * @param songID
	 */
	public Song(String songID){
		songArtists = new Hashtable<String, Artist>();
		String sql = "SELECT * FROM song WHERE song_id = '" + songID + "';";
		DbUtilities db = new DbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				this.songID = rs.getString("song_id");
				this.title = rs.getString("title");
				this.releaseDate = rs.getDate("release_date").toString();
				this.recordDate = rs.getDate("record_date").toString();
				this.length = rs.getDouble("length");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * @param songID
	 */
	public void deleteSong(String songID) {
		String sql = "DELETE FROM song WHERE song_id = '" + songID + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
	}

	/**
	 * @param artist
	 */
	public void addArtist(Artist artist) {
		songArtists.put(artist.getArtistID(), artist);
		String sql = "INSERT INTO song_artist (fk_song_id,fk_artist_id) VALUES (?, ?);";
		
		try {
			DbUtilities db = new DbUtilities();
			Connection conn = db.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.songID);
			ps.setString(2, artist.getArtistID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param artistID
	 */
	public void deleteArtist(String artistID) {
		songArtists.remove(artistID);
		String sql = "DELETE FROM song_artist WHERE fk_artist_id = '" + artistID + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
	}

	/**
	 * @param artist
	 */
	public void deleteArtist(Artist artist) {
		songArtists.remove(artist.getArtistID());
		String sql = "DELETE FROM song_artist WHERE fk_artist_id = '" + artist.getArtistID() + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
	}

	/**
	 * @return
	 */
	public String getSongID() {
		return songID;
	}

	/**
	 * @param songID
	 */
	public void setSongID(String songID) {
		String sql = "UPDATE song SET song_id = '" + songID + "' WHERE song_id = '" + this.songID + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.songID = songID;
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
		String sql = "UPDATE song SET title = '" + title + "' WHERE title = '" + this.title + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.title = title;
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
		String sql = "UPDATE song SET length = '" + length + "' WHERE length = '" + this.length + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.length = length;
	}

	/**
	 * @return
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		String sql = "UPDATE song SET file_path = '" + filePath + "' WHERE file_path = '" + this.filePath + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.filePath = filePath;
	}
	
	Vector<String> getSongRecord(){
		Vector<String> songRecord = new Vector<>();
		songRecord.add(this.songID);
		songRecord.add(this.title);
		songRecord.add(this.filePath);
		songRecord.add(String.valueOf(this.length));
		songRecord.add(this.releaseDate);
		songRecord.add(this.recordDate);
		return songRecord;
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
		String sql = "UPDATE song SET release_date = '" + releaseDate + "' WHERE release_date = '" + this.releaseDate + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.releaseDate = releaseDate;
	}

	/**
	 * @return
	 */
	public String getRecordDate() {
		return recordDate;
	}

	/**
	 * @param recordDate
	 */
	public void setRecordDate(String recordDate) {
		String sql = "UPDATE song SET record_date = '" + recordDate + "' WHERE record_date = '" + this.recordDate + "';";
		DbUtilities db = new DbUtilities();
		db.executeQuery(sql);
		this.recordDate = recordDate;
	}

	/**
	 * @return
	 */
	public Map<String, Artist> getSongArtists() {
		return songArtists;
	}

	/**
	 * @param songArtists
	 */
	public void setSongArtists(Map<String, Artist> songArtists) {
		this.songArtists = songArtists;
	}
}