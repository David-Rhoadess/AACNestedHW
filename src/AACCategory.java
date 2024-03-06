import structures.AssociativeArray;
import structures.KeyNotFoundException;
import structures.NullKeyException;

/**
 * Represents the mappings for a single page of items that should be displayed
 * 
 * @author David Rhoades
 *
 */
public class AACCategory extends java.lang.Object{

  String name;
  AssociativeArray<String, String> imageMap = new AssociativeArray<String, String>();


  /**
   * Creates a new empty category with the given name
   * 
   * @param name the desired name for the new AACCategory
   */
  AACCategory(String name) {
    this.name  = name;
  }


  /**
   * Adds the mapping of the imageLoc to the text to the category
   * 
   * @param imageLoc image to be mapped
   * @param text text to be mapped
   */
  void addItem(String imageLoc, String text) throws NullKeyException {
    this.imageMap.set(imageLoc, text);
  }


  /**
   * 	
   * Returns the name of the category
   * 
   * @return the name of the category
   */
  String getCategory() {
    return this.name;
  }


  /**
   * Returns an array of all the images in the category
   * 
   * @return array of all images in the category
   */
  String[] getImages() {
    return this.imageMap.getImageLocs();
  }

  /**
   * Returns the text associated with the given image loc in this category
   * 
   * @param imageLoc the location of the desired image
   * @return the text associated with the image at imageloc
   */
  String getText(String imageLoc) throws KeyNotFoundException{
    return this.imageMap.get(imageLoc);
  }

  /**
   * Determines if the provided image is stored in the category
   * 
   * @param imageLoc the image under consideration
   * @return true if there is an image stored in the category, returns false otherwise
   */
  boolean hasImage(String imageLoc) {
    return this.imageMap.hasKey(imageLoc);
  }
}
