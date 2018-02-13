package mjs236_SpotifyKnockoff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Spotify {
	
	private static Spotify spotify;
	
	private Spotify() {
		
	}
	
	public static Spotify getInstance() {
		if (spotify == null) {
			spotify = new Spotify();
		}
		return spotify;
	}
	
	public DefaultTableModel getSongData(String searchTerm){
		String sql = "SELECT song_id, title, length, release_date, record_date FROM song ";
		if(!searchTerm.equals("")) {
			sql += " WHERE title LIKE '%" + searchTerm + "%';";
		}
		try {
			DbUtilities db = new DbUtilities();
			String[] columnNames = {"Song ID", "Title", "Length", "Release Date", "Record Date"};
			return db.getDataTable(sql, columnNames);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(SpotifyGUI.getFrame(), "Unable to connect to database");
			ErrorLogger.log(e.getMessage());
		}
		return null;
	}
	
	public DefaultTableModel getArtistData(String searchTerm){
//		String sql = "INSERT INTO artist (artist_id,first_name,last_name,band_name,bio) ";
//		sql += "VALUES (?, ?, ?, ?, ?);";
//		
//		try {
//			DbUtilities db = new DbUtilities();
//			Connection conn = db.getConn();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, this.artistID);
//			ps.setString(2,  this.firstName);
//			ps.setString(3, this.lastName);
//			ps.setString(4, this.bandName);
//			ps.setString(5, this.bio);
//			ps.executeUpdate();
//			db.closeDbConnection();
//			db = null;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		String sql = "SELECT artist_id, first_name, last_name, band_name FROM artist ";
		if(!searchTerm.equals("")) {
			sql += "WHERE first_name LIKE '%" + searchTerm + "%' OR last_name LIKE '%" + searchTerm + "%' OR band_name LIKE '%" + searchTerm + "%';";
		}
		try {
			DbUtilities db = new DbUtilities();
			String[] columnNames = {"Artist ID", "First Name", "Last Name", "Band"};
			return db.getDataTable(sql, columnNames);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(SpotifyGUI.getFrame(), "Unable to connect to database");
			ErrorLogger.log(e.getMessage());
		}
		return null;
	}
	
	public DefaultTableModel getAlbumData(String searchTerm){
		String sql = "SELECT album_id, title, release_date, cover_image_path, recording_company_name, number_of_tracks, PMRC_rating, length FROM album ";
		if(!searchTerm.equals("")) {
			sql += " WHERE title LIKE '%" + searchTerm + "%';";
		}
		try {
			DbUtilities db = new DbUtilities();
			String[] columnNames = {"Album ID", "Title", "Release Date", "Cover Image Path", "Recording Comapny", "Number of Tracks", "PMRC Rating", "Length"};
			return db.getDataTable(sql, columnNames);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(SpotifyGUI.getFrame(), "Unable to connect to database");
			ErrorLogger.log(e.getMessage());
		}
		return null;
	}
}
