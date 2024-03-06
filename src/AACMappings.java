import structures.NullKeyException;
import structures.KeyNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;



/**
 * An class to keep track of a coplete set of AAC mappings
 * 
 * @author David Rhoades
 */
public class AACMappings extends java.lang.Object{

  PrintWriter pen = new PrintWriter(System.out, true);
  AACCategory homeScreen;
  AACCategory current;
  /**
   * Creates a new AACMappings in based on filename
   * @param filename a formatted file
   */
  public AACMappings(String filename) {
    AACCategory homeScreen = new AACCategory("");
    File txtFile = new File(filename);
    try {
      Scanner input = new Scanner(txtFile);
      while (input.hasNextLine()) {
        String line = input.nextLine();
        //START HERE
        input.close();
      }
    this.current = homeScreen;
    } catch(FileNotFoundException e) {
        pen.println("File Not Found");
    }
  }


  /**
   * Adds the mapping to the current category (or the default category if that is the current category)
   * @param imageLoc
   * @param text
   */
  void add(String imageLoc, String text) {
    try {   
      this.homeScreen.addItem(imageLoc, text);
    } catch(NullKeyException e) {};

    //DO WE NEED TO WORRY ABOUT NULL KEY EXCEPTIONS
    
  }

  /**
   * Gets the current category
   * @return current category
   */
  String getCurrentCategory() {
    return current.getCategory();
  }

  /**
   * Provides an array of all the images in the current category
   * @return an array of all the images in the current category
   */
  String[] getImageLocs() {
    return this.current.getImages();
  }

  /**
   * returns the text associated with the given image location
   * @param imageLoc image of inquiry
   * @return text associated with imageLoc
   */
  String getText(String imageLoc) {
    if(this.current.hasImage(imageLoc)) {
      try {
        return this.current.getText(imageLoc);
      } catch (KeyNotFoundException e){}
    }
    return null;
  }

  /**
   * Determines if the image represents a category or text to speak
   * @param imageLoc image of inquiry
   * @return true if the image represents a category or text, false otherwise
   */
  boolean isCategory(String imageLoc) {
    return this.current.hasImage(imageLoc);
  }

  /**
   * Resets the current category of the AAC back to the default category
   */
  void reset() {
    this.current = homeScreen;
  }

  /**
   * Writes the ACC mappings stored to a file.
   * @param filename target file
   */
  void writeToFile(String filename) {
    //STUB
  }
}
