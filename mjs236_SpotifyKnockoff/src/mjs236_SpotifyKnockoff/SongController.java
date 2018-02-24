package mjs236_SpotifyKnockoff;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SongController {
	
	/**
	 * @param songID
	 * @param title
	 * @param length
	 * @param releaseDate
	 * @param recordDate
	 * @param filePath
	 */
	public void createSong(String songID, String title, double length, String releaseDate, String recordDate, String filePath) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpotifyKnockoffJPA");
		EntityManager emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		Song s = new Song();
		s.setSongID(songID);
		s.setTitle(title);
		s.setLength(length);
		s.setRecordDate(recordDate);
		s.setReleaseDate(releaseDate);
		s.setFilePath(filePath);
		emanager.persist(s);
		emanager.getTransaction().commit();
		emanager.close();
		emfactory.close();
	}
	
	/**
	 * @param songID
	 * @param title
	 * @param length
	 * @param releaseDate
	 * @param recordDate
	 * @param filePath
	 */
	public void updateSong(String songID, String title, double length, String releaseDate, String recordDate, String filePath) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpotifyKnockoffJPA");
		EntityManager emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		Song s = emanager.find(Song.class, songID);
		s.setTitle(title);
		s.setLength(length);
		s.setRecordDate(recordDate);
		s.setReleaseDate(releaseDate);
		s.setFilePath(filePath);
		emanager.persist(s);
		emanager.getTransaction().commit();
		emanager.close();
		emfactory.close();
	}
	
	/**
	 * @param songID
	 */
	public void deleteSong(String songID) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpotifyKnockoffJPA");
		EntityManager emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		Song s = emanager.find(Song.class, songID);
		emanager.remove(s);
		emanager.getTransaction().commit();
		emanager.close();
		emfactory.close();
	}
}
