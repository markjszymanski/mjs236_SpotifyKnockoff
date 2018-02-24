package mjs236_SpotifyKnockoff;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlbumController {

	/**
	 * @param albumID
	 * @param title
	 * @param releaseDate
	 * @param recordingCompany
	 * @param numberOfTracks
	 * @param pmrcRating
	 * @param length
	 */
	public void createAlbum(String albumID, String title, String releaseDate, String recordingCompany, int numberOfTracks, String pmrcRating, double length) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpotifyKnockoffJPA");
		EntityManager emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		Album al = new Album();
		al.setAlbumID(albumID);
		al.setTitle(title);
		al.setReleaseDate(releaseDate);
		al.setRecordingCompany(recordingCompany);
		al.setNumberOfTracks(numberOfTracks);
		al.setPmrcRating(pmrcRating);
		al.setLength(length);		
		emanager.persist(al);
		emanager.getTransaction().commit();
		emanager.close();
		emfactory.close();
	}
	
	/**
	 * @param albumID
	 * @param title
	 * @param releaseDate
	 * @param recordingCompany
	 * @param numberOfTracks
	 * @param pmrcRating
	 * @param length
	 */
	public void updateAlbum(String albumID, String title, String releaseDate, String recordingCompany, int numberOfTracks, String pmrcRating, double length) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpotifyKnockoffJPA");
		EntityManager emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		Album al =  emanager.find(Album.class, albumID);
		al.setTitle(title);
		al.setReleaseDate(releaseDate);
		al.setRecordingCompany(recordingCompany);
		al.setNumberOfTracks(numberOfTracks);
		al.setPmrcRating(pmrcRating);
		al.setLength(length);		
		emanager.persist(al);
		emanager.getTransaction().commit();
		emanager.close();
		emfactory.close();
	}
	
	/**
	 * @param albumID
	 */
	public void deleteAlbum(String albumID) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpotifyKnockoffJPA");
		EntityManager emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		Album al =  emanager.find(Album.class, albumID);
		emanager.remove(al);
		emanager.getTransaction().commit();
		emanager.close();
		emfactory.close();
	}		
}