

/**
 * @author Mohammad Khan
 * @version 1.0
 * 
 * This class represents digital media in the form of Images with their
 * title, height, and width represented.
 */

public class ImageConverter extends GeneralDigitalMedia {

	private int width; // An instance variabe representing an image's width.
	private int height; // An instance variabe representing an image's height
	
	/**
	 * Constructs a generalization of an image
	 * and calls upon the superclasss parameters.
	 * @param nameP A parameter for the image's title.
	 * @param sizeP A parameter for the size of the image in bytes.
	 * @param widthP A parameter for the images size in width
	 * @param heightP A parameter for the images size in height
	 */
	public ImageConverter (String nameP, long sizeP, int widthP, int heightP) {
		super(nameP, sizeP);
		width = widthP;
		height = heightP;
	}
	
	/**
	 * Calls upon the superclass constructor 
	 * for use in this class.
	 * @param nameP A parameter for the image's title.
	 * @param sizeP A parameter for the size of the image in bytes.
	 */
	public ImageConverter (String nameP, long sizeP) { 
		super(nameP, sizeP);
	}
	
	/**
	 * Retrieves the images width.
	 * @return Integer of width.
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Retrieves the images height.
	 * @return Integer of height.
	 */
	public int getHeight( ) {
		return height;
	}
	
	/**
	 * Sets the width in integers.
	 * @param widthP Image width to be registered.
	 */
	public void setWidth(int widthP) {
		width = widthP;
	}
	
	/**
	 * Sets the height in integers.
	 * @param widthP Image height to be registered.
	 */
	public void setHeight(int heightP) {
		height = heightP;
	}
	
	/**
	 * Overrides the equals method to compare two Image objects.
	 * 	@Override
	 */
	public boolean equals(Object obj) {
		ImageConverter other = (ImageConverter) obj; // Right place to put this, or after if?

		if (!(obj instanceof ImageConverter)) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		return super.equals(other) && (other.width == width && other.height == height);
	
	}
	/**
	 * Overrides the toString method to concatenate a string containing
	 * the image's title, height, and width.
	 * @Override
	 * @return The image's title, and height, and width as a string.
	 */
	public String toString() {
		return "\nTitle: " + super.getName() +"\nWidth: " + height
				+ "\nHeight: " + width;	
	}
}