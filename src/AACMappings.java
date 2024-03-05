


/**
 * An class to keep track of a coplete set of AAC mappings
 * 
 * @author David Rhoades
 */
public class AACMappings extends java.lang.Object{


  /**
   * Creates a new AACMappings in based on filename
   * @param filename a formatted file
   */
  public AACMappings(String filename) {
    //STUB
  }


  /**
   * Adds the mapping to the current category (or the default category if that is the current category)
   * @param imageLoc
   * @param text
   */
  void add(String imageLoc, String text) {
    //STUB
  }

  /**
   * Gets the current category
   * @return current category
   */
  String getCurrentCategory() {
    return "food";  // STUB
    //STUB
  }

  /**
   * Provides an array of all the images in the current category
   * @return an array of all the images in the current category
   */
  String[] getImageLocs() {
    return new String[] { "img/food/icons8-french-fries-96.png", "img/food/icons8-watermelon-96.png" }; // STUB
  }

  /**
   * returns the text associated with the given image location
   * @param imageLoc image of inquiry
   * @return text associated with imageLoc
   */
  String getText(String imageLoc) {
    return "television";  // STUB
  }

  /**
   * Determines if the image represents a category or text to speak
   * @param imageLoc image of inquiry
   * @return true if the image represents a category or text, false otherwise
   */
  boolean isCategory(String imageLoc) {
    return false;
    //STUB
  }

  /**
   * Resets the current category of the AAC back to the default category
   */
  void reset() {
    //STUB
  }

  /**
   * Writes the ACC mappings stored to a file.
   * @param filename target file
   */
  void writeToFile(String filename) {
    //STUB
  }
}
