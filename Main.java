import javax.swing.*;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Iterator;
import java.util.Map;


public class Main extends GUI {
  public static void reader() {
    // This will deal with the deployment of the Reader.java file.
    System.out.println("Hello World");
  }

  public static void main(String[] args) throws FileNotFoundException {
    // This code will run automatically
    // This creates a GUI using the GUI.java file.
    GUI instance = new GUI();
    
    // These are the parameters of the application when ran.
    instance.setSize(new Dimension(1000,600));
    instance.setVisible(true);
  }
}
