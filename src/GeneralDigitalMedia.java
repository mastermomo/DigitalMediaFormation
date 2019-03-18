

import java.io.*;
import java.util.*;

/**
 * @author Mohammad Khan
 * @version 1.0
 * 
 * This class represents the generalization of sounds, 
 * images, text, and video available in digital format 
 * for use on a computer system. 
 */

public class GeneralDigitalMedia {
	
	private String name; // An instance variable representing file name and extension.
	private long size; // An instance variable representing file size in bytes.
	
	/**
	 * Constructs a generalization of digital media.
	 * using a specified name and size.
	 * @param nameP The file name and extension.
	 * @param sizeP The file size in bytes.
	 */
	public GeneralDigitalMedia(String nameP, long sizeP) {
		name = nameP;
		size = sizeP;
	}
	
	/**
	 * Retrieves the name of the digital media.
	 * @return The media's file name and extension
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Retrieves the size of the digital media.
	 * @return The media's size in bytes.
	 */
	public long getSize() {
		return size;
	}
	
	/**
	 * Sets the name to the digital media.
	 * @param nameP The file name and extension to be registered.
	 */
	public void setName(String nameP) {
		name = nameP;
	}
	
	/**
	 * Validates that the name is registered.
	 * @param nameP The file name and extension being checked.
	 * @return True if the name is registered, or false if not.
	 */
	private boolean isValidName(String nameP) {
		if (name == nameP) {
			return true;
		}
		else if (nameP == null) {
			return false;
		}
		return false;
	}
	 /**
	  * Sets the size to the digital media.
	  * @param sizeP Files size to be registered.
	  */
	public void setSize(long sizeP) {
		size = sizeP;
	}
	
	/**
	 * Overrides the equals method to compare two DigitalMedia objects.
	 * @Override
	 */
	public boolean equals(Object obj) {
		GeneralDigitalMedia other = (GeneralDigitalMedia) obj; //Right place to put this, or after if?
		
		if(!(obj instanceof GeneralDigitalMedia)) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		return (other.name.compareTo(name) == 0 && other.size == size);
		
	}
	
	/**
	 * Overrides the toString method to concate a string containing
	 * the name and size of the digital medial
	 * @Override
	 * @return The file name and extension, along with the size in bytes, as a string.
	 */
	public String toString() {
		return "\nName: " + name + "\nSize: " + size;
	}
}