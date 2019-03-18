

/**
 * @author Mohammad Khan
 * @version 1.0
 * 
 * This class represents digital media in the form of songs 
 * with song names, albums, and artists represented. 
 */

public class SongConverter extends GeneralDigitalMedia { 
	private String artist; // An instance variable representing artist name.
	private String album; // An instance variable representing an album of an artist.
	
	
	/**
	 * Calls upon the superclass constructor for 
	 * use in this class.
	 * @param nameP A parameter for the song's name. 
	 * @param sizeP A paremeter for the size of the song in bytes.
	 */
	public SongConverter(String nameP, long sizeP) {
		super(nameP, sizeP);
	}
	
	/**
	 * Constructs a generalization of a song 
	 * and calls upon the superclass parameters.
	 * @param nameP A parameter for the song's name. 
	 * @param sizeP A parameter for the size of the song in bytes.
	 * @param artistP A parameter for the artist's name.
	 * @param albumP A parameter for the album's name.
	 */
	public SongConverter(String nameP, long sizeP, String artistP, String albumP) {
		super(nameP, sizeP);
		artist = artistP;
		album = albumP;
	}
	
	/**
	 * Retrieves the song's title using superclass getName().
	 * @return String of song name.
	 */
	public String getTitle() {
		  return super.getName();// Not really sure if this is right, I'm 
		                   // thinking name is for song title?? 
	}
	
	/**
	 * Retrieves the artist's name on the song.
	 * @return String of artist's name.
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * Retrieves the album name the song belongs to.
	 * @return String of album name.
	 */
	public String getAlbum() {
		return album;
	}
	
	/**
	 * Sets the name to the song using superclass setName().
	 * @param nameP Song name to be registered.
	 */
	public void setTitle(String nameP) { // not sure if I should have this method like this
		super.setName(nameP); // + scanning object?);
	}
	
	/**
	 * Sets the name to the artist.
	 * @param artistP Artist name to be registered.
	 */
	public void setArtist(String artistP) {
		artist = artistP;
	}
	
	/**
	 * Sets the names to the album.
	 * @param albumP Album name to be registered.
	 */
	public void setAlbum(String albumP) {
		album = albumP;
	}
	/**
	 * Overrides the equal method to compare two Song objects.
	 * @Override
	 */
	public boolean equals(Object obj) {
		SongConverter other = (SongConverter) obj; // Right place to put this, or after if?

		if (!(obj instanceof GeneralDigitalMedia)) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		return super.equals(other) && (other.artist.compareTo(artist) == 0 && other.album.compareTo(album) == 0);
	}
	/**
	 * Overrides the toString method to concatenate a string containing
	 * the song name, artist, and album.
	 * @Override
	 * @return The song's name, artist, and album as a string.
	 */
	public String toString() {
		return "\nTitle: " + getTitle().replaceAll(".mp3", "") + "\nArtist: " + album 
				+ "\nAlbum: " + artist; //Should it be the getters of the moethods here? not what's in the methods?
		
	}
}