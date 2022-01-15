import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
  // This is used to create the GUI orentation when ran.

	public GUI() {
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
		
    // Code for the first dropdown which deals with attraction type.
		JComboBox attraction = new JComboBox();
		attraction.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		attraction.setModel(new DefaultComboBoxModel(new String[] {"------", "Hotel", "Entertainment", "Resturant", "Park", "Shop"}));
		attraction.setBounds(127, 76, 132, 31);
		getContentPane().add(attraction);
		
    // Code for the second dropdown which deals with ratings.
		JComboBox rating = new JComboBox();
		rating.setModel(new DefaultComboBoxModel(new String[] {"------", "5 Stars", "4 Stars", "3 Stars", "2 Stars", "1 Star"}));
		rating.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		rating.setBounds(127, 165, 132, 31);
		getContentPane().add(rating);
		
    // Code for the third dropdown which deals with proximity.
		JComboBox proximity = new JComboBox();
		proximity.setModel(new DefaultComboBoxModel(new String[] {"------", "1 Mile Away", "5 Miles Away", "10 Miles Away", "15 Miles Away"}));
		proximity.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		proximity.setBounds(127, 253, 132, 31);
		getContentPane().add(proximity);
		
    // Code for the fourth dropdown which deals with pricing.
		JComboBox price = new JComboBox();
		price.setModel(new DefaultComboBoxModel(new String[] {"------", "Free", "$", "$$", "$$$"}));
		price.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		price.setBounds(127, 341, 132, 31);
		getContentPane().add(price);
		
    // Code for the fifth dropdown which deals with the operating hours.
		JComboBox workHours = new JComboBox();
		workHours.setModel(new DefaultComboBoxModel(new String[] {"------", "Morning", "Afternoon", "Night"}));
		workHours.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		workHours.setBounds(127, 432, 132, 31);
		getContentPane().add(workHours);
    }
}

