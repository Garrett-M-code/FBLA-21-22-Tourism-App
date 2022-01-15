import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends GUI{
  public static void main(String[] args) {
    // This code is run automatically
    // These are non-functioning arrays
    String[] attractionList = {"------", "Hotel", "Entertainment", "Resturant", "Park", "Shop"};
    String[] ratingList = {"------", "5 Stars", "4 Stars", "3 Stars", "2 Stars", "1 Star"};
    String[] proximityList = {"------", "1 Mile Away", "5 Miles Away", "10 Miles Away", "15 Miles Away"};
    String[] priceList = {"------", "Free", "$", "$$", "$$$"};
    String[] workHoursList = {"------", "Morning", "Afternoon", "Night"};

    // This creates a GUI using the GUI.java file.
    GUI instance = new GUI();
    // These are the parameters of the application when ran.
    instance.setSize(new Dimension(1000,600));
    instance.setVisible(true);
  }
}
