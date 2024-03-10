//START HERE the save function wokrs but the add one does not

import structures.NullKeyException;
import structures.AssociativeArray;
import structures.KeyNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

//START HERE, buttons dont work, look at actionperformed method in AAC.

/**
 * An class to keep track of a complete set of AAC mappings
 * 
 * @author David Rhoades
 */
public class AACMappings extends java.lang.Object{

  PrintWriter pen = new PrintWriter(System.out, true);
  AACCategory homeScreen;
  AACCategory current;
  AssociativeArray<String, AACCategory> allCategories;
  /**
   * Creates a new AACMappings in based on filename
   * @param filename a formatted file
   */
  public AACMappings(String filename) throws Exception{
    this.homeScreen = new AACCategory("");
    this.allCategories = new AssociativeArray<String, AACCategory>();
    File txtFile = new File(filename);
    try {
      Scanner input = new Scanner(txtFile);
      while (input.hasNextLine()) {
        String line = input.nextLine();
        String[]splitLine = line.split(" ", 2);
        if(line.charAt(0) != '>') {
          current = this.homeScreen;
          this.add(splitLine[0], splitLine[1]);
          
          current = this.allCategories.get(splitLine[0]);
          
        } else {
          this.add(splitLine[0].substring(1), splitLine[1]);
        }
      }
    input.close();
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
    if (this.getCurrentCategory() == "") {
      try {   
        this.homeScreen.addItem(imageLoc, text);
        this.allCategories.set(imageLoc, new AACCategory(text));
      } catch(NullKeyException e) {};
    }
    else {
      try {   
        this.current.addItem(imageLoc, text);
      } catch(NullKeyException e) {};
    }
    
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
      try {
        String cur = this.current.getText(imageLoc);
        if (this.getCurrentCategory() == "") {
          this.current = this.allCategories.get(imageLoc);
        }
        return cur;
      } catch(KeyNotFoundException e) {
        pen.println(e);
        pen.flush();
        return null;
    }
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
    AACCategory tempCurrent;
    File newFile = new File(filename);
    PrintWriter filePen;
    try {
      filePen = new PrintWriter(newFile);
    } catch(FileNotFoundException e) {
        filePen = new PrintWriter(System.out, true);
        filePen.println("Invalid file name");
        pen.flush();
        return;
    }
    for (int i = 0; i < this.allCategories.size(); i++) {
      try{
        tempCurrent = this.homeScreen;
        filePen.println(this.getImageLocs()[i] + " " + tempCurrent.getText(this.getImageLocs()[i]));
          tempCurrent = this.allCategories.get(getImageLocs()[i]);
        String[] images = tempCurrent.getImages();
        for (int j = 0; j < images.length; j++) {
          filePen.println(">" + images[j] + " " + tempCurrent.getText(images[j]));
        }
      } catch (KeyNotFoundException e) {
          return;
      }
    }
    filePen.flush();
  }
}
