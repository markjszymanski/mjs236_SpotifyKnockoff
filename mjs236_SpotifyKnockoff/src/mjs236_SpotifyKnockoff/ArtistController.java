package mjs236_SpotifyKnockoff;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ArtistController {
	
	/**
	 * @param artistID
	 * @param firstName
	 * @param lastName
	 * @param bandName
	 * @param bio
	 */
	public void createArtist(String artistID, String firstName, String lastName, String bandName, String bio) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpotifyKnockoffJPA");
		EntityManager emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		Artist a = new Artist();
		a.setArtistID(artistID);
		a.setFirstName(firstName);
		a.setLastName(lastName);
		a.setBandName(bandName);
		a.setBio(bio);
		emanager.persist(a);
		emanager.getTransaction().commit();
		emanager.close();
		emfactory.close();
	}
	
	/**
	 * @param artistID
	 * @param firstName
	 * @param lastName
	 * @param bandName
	 * @param bio
	 */
	public void updateArtist(String artistID, String firstName, String lastName, String bandName, String bio) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpotifyKnockoffJPA");
		EntityManager emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		Artist a =  emanager.find(Artist.class, artistID);
		a.setFirstName(firstName);
		a.setLastName(lastName);
		a.setBandName(bandName);
		a.setBio(bio);
		emanager.persist(a);
		emanager.getTransaction().commit();
		emanager.close();
		emfactory.close();
	}
	
	/**
	 * @param artistID
	 */
	public void deleteArtist(String artistID) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpotifyKnockoffJPA");
		EntityManager emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		Artist a =  emanager.find(Artist.class, artistID);
		emanager.remove(a);
		emanager.getTransaction().commit();
		emanager.close();
		emfactory.close();
	}
}
