import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
  // This is used to create the GUI orentation when ran.

	public GUI() {
    // These are non-functioning arrays
    String[] attractionList = {"------", "Hotel", "Entertainment", "Resturant", "Park", "Shop"};
    String[] ratingList = {"------", "5 Stars", "4 Stars", "3 Stars", "2 Stars", "1 Star"};
    String[] proximityList = {"------", "1 Mile Away", "5 Miles Away", "10 Miles Away", "15 Miles Away"};
    String[] priceList = {"------", "Free", "$", "$$", "$$$"};
    String[] workHoursList = {"------", "Morning", "Afternoon", "Night"};

    // Sets up the basic window properties like exiting, Title, layout style, and background color.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Tourism App");
		getContentPane().setLayout(null);
		
    // Creates the header of the application.
		JLabel titleLbl = new JLabel("Henry County, Ga Visitor Center!");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		titleLbl.setBounds(0, 0, 986, 46);
		getContentPane().add(titleLbl);
		
    // Creates the header for the first dropdown (Attractions).
    JLabel lblAttract = new JLabel("Attraction");
		lblAttract.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblAttract.setBounds(50, 34, 112, 31);
		getContentPane().add(lblAttract);

    // Code for the first dropdown which deals with attraction type.
		JComboBox attraction = new JComboBox();
		attraction.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		attraction.setModel(new DefaultComboBoxModel(attractionList));
		attraction.setBounds(100, 76, 132, 31);
		getContentPane().add(attraction);

    // Creates the header for the second dropdown (Rating).
    JLabel lblRatings = new JLabel("Ratings");
		lblRatings.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblRatings.setBounds(50, 124, 112, 31);
		getContentPane().add(lblRatings);
		
    // Code for the second dropdown which deals with ratings.
		JComboBox rating = new JComboBox();
		rating.setModel(new DefaultComboBoxModel(ratingList));
		rating.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		rating.setBounds(100, 166, 132, 31);
		getContentPane().add(rating);
		
    // Creates the header for the third dropdown (Proximity).
    JLabel lblProximity = new JLabel("Location");
		lblProximity.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblProximity.setBounds(50, 214, 112, 31);
		getContentPane().add(lblProximity);

    // Code for the third dropdown which deals with proximity.
		JComboBox proximity = new JComboBox();
		proximity.setModel(new DefaultComboBoxModel(proximityList));
		proximity.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		proximity.setBounds(100, 256, 132, 31);
		getContentPane().add(proximity);
		
    // Creates the header for the fourth dropdown (Price).
    JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblPrice.setBounds(50, 304, 112, 31);
		getContentPane().add(lblPrice);

    // Code for the fourth dropdown which deals with pricing.
		JComboBox price = new JComboBox();
		price.setModel(new DefaultComboBoxModel(priceList));
		price.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		price.setBounds(100, 346, 132, 31);
		getContentPane().add(price);

    // Creates the header for the fifth dropdown (Hours).
    JLabel lblHours = new JLabel("Open Hours");
		lblHours.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblHours.setBounds(50, 394, 112, 31);
		getContentPane().add(lblHours);
		
    // Code for the fifth dropdown which deals with the operating hours.
		JComboBox workHours = new JComboBox();
		workHours.setModel(new DefaultComboBoxModel(workHoursList));
		workHours.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		workHours.setBounds(100, 436, 132, 31);
		getContentPane().add(workHours);

    // It will display all possible choices in a list from which the user can select an option.
    JList resultsListed = new JList();
		resultsListed.setBackground(Color.GRAY);
    resultsListed.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		resultsListed.setBounds(317, 76, 601, 241);
		getContentPane().add(resultsListed);

    // Will display a location and its information when a user selects a place.
    JTextPane txtLocationOutput = new JTextPane();
		txtLocationOutput.setEditable(false);
		txtLocationOutput.setText("Please select a location to view its information.");
		txtLocationOutput.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		txtLocationOutput.setBackground(Color.LIGHT_GRAY);
		txtLocationOutput.setBounds(317, 364, 601, 124);
		getContentPane().add(txtLocationOutput);
		}
}
