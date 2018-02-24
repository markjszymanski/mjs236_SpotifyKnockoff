package mjs236_SpotifyKnockoff;

import java.util.UUID;

public class JPATester {

	public static void main(String[] args) {
		
//		Testing SongController
		String songID = UUID.randomUUID().toString();
		
		SongController sc = new SongController();
		
		sc.createSong(songID, "Mark", 11, "1111-11-11", "1111-11-11", "var/test.mp3");
		System.out.print("Song created");
		
		sc.updateSong(songID, "MarkUpdated", 11, "1111-11-11", "1111-11-11", "var/test.mp3");
		System.out.print("Song updated");

		sc.deleteSong(songID);
		System.out.print("Song deleted");
		
//		Testing AlbumController		
		String albumID = UUID.randomUUID().toString();
		
		AlbumController alc = new AlbumController();
		
		alc.createAlbum(albumID, "Mark", "1111-11-11", "Company", 11, "NR", 111);
		System.out.print("Album created");
		
		alc.updateAlbum(albumID, "MarkUpdated", "1111-11-11", "Company", 11, "NR", 111);
		System.out.print("Album updated");
		
		alc.deleteAlbum(albumID);
		System.out.print("Album deleted");
		
//		Testing ArtistController		
		String artistID = UUID.randomUUID().toString();
		
		ArtistController ac = new ArtistController();
		
		ac.createArtist(artistID, "Mark", "test", "test", "testbio");
		System.out.print("Artist created");
		
		ac.updateArtist(artistID, "MarkUpdated", "test", "test", "testbio");
		System.out.print("Artist updated");
		
		ac.deleteArtist(artistID);
		System.out.print("Artist deleted");
	}

}