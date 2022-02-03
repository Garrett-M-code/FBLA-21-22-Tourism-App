// This imports JFram and the rest of the Swing Library.
import javax.swing.*;

// This imports the libraries used for opening files and possible errors.
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

// This imports the libraries required for using JSON.
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

// This imports some Awt libraries that are used with Swing.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

// This imports utilities needed like Hash Maps.
import java.util.Iterator;
import java.util.Map;


public class Main extends GUI {
  public static void main(String[] args) throws FileNotFoundException {
    // This code will run automatically
    // This creates a GUI using the GUI.java file.
    GUI instance = new GUI();
    
    // These are the parameters of the application when ran.
    instance.setSize(new Dimension(1000,600));
    instance.setVisible(true);
  }
}
