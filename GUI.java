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
import java.awt.event.*;
import javax.swing.event.*;

import java.util.*;


public class GUI extends JFrame {
  // This is used to create the GUI orentation when ran.

  static String selectedAttraction = "--:--";
  static String selectedRating = "--:--";
  static String selectedProximity = "--:--";
  static String selectedPrice = "--:--";
  static String selectedHours = "--:--";

	public GUI(){
    try {
      // parsing file "JSONExample.json"
      Object obj = new JSONParser().parse(new FileReader("locationData.json"));
          
      // typecasting obj to JSONObject
      JSONObject fileData = (JSONObject) obj;

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

      // Event listener for when the dropdown is changed
      attraction.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Saves the value lasted picked by the attraction JComboBox
          selectedAttraction = attraction.getSelectedItem().toString();
          System.out.println(selectedAttraction);
        } 
      });

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

      // Event listener for when the dropdown is changed
      rating.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Saves the value lasted picked by the rating JComboBox
          selectedRating = rating.getSelectedItem().toString();
          System.out.println(selectedRating);
        } 
      });
      
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

      // Event listener for when the dropdown is changed
      proximity.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Saves the value lasted picked by the proximity JComboBox
          selectedProximity = proximity.getSelectedItem().toString();
          System.out.println(selectedProximity);
        } 
      });
      
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

      // Event listener for when the dropdown is changed
      price.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Saves the value lasted picked by the price JComboBox
          selectedPrice = price.getSelectedItem().toString();
          System.out.println(selectedPrice);
        } 
      });

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

      // Event listener for when the dropdown is changed
      workHours.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Saves the value lasted picked by the hours JComboBox
          selectedHours = workHours.getSelectedItem().toString();
          System.out.println(selectedHours);
        } 
      });


      // A button that then searches.
      JButton btnRun = new JButton("Search!");
		  btnRun.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
          
          // This creates a linked list that has all locations
          LinkedList superList = masterList(fileData); 
          // This creates a linkedList that has all the attributes
          LinkedList filteringPolicy = Reader();
          // This will produce a list of the items to be used
          LinkedList resultingItems = locationFilter(superList, filteringPolicy);
          System.out.println(resultingItems);
			  }
		  });
		  btnRun.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		  btnRun.setBounds(545, 327, 106, 27);
		  getContentPane().add(btnRun);

      // Will display a location and its information when a user selects a place.
      JTextPane txtLocationOutput = new JTextPane();
      txtLocationOutput.setEditable(false);
      txtLocationOutput.setText("Please select a location to view its information.");
      txtLocationOutput.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
      txtLocationOutput.setBackground(Color.LIGHT_GRAY);
      txtLocationOutput.setBounds(317, 364, 601, 124);
      getContentPane().add(txtLocationOutput);

      // It will display all possible choices in a list from which the user can select an option.
      JList resultsListed = new JList();
      resultsListed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      resultsListed.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
      resultsListed.setModel(new AbstractListModel() {
          String[] values = new String[] {"Item 1", "Item 2", "Item 3 ", "Item 4", "Item 5", "Item 6"};
          public int getSize() {
            return values.length;
          }
          public Object getElementAt(int index) {
            return values[index];
          }
      });
      resultsListed.setBackground(Color.GRAY);
      resultsListed.setBounds(317, 76, 601, 241);
      getContentPane().add(resultsListed);
      
      // Event listener for when an item is selected
      resultsListed.addListSelectionListener(new ListSelectionListener() {
			  public void valueChanged(ListSelectionEvent e) {
          int selectedOption = resultsListed.getSelectedIndex();
          String selectedListedOption = Integer.toString(selectedOption + 1);
          txtLocationOutput.setText(selectedListedOption);
			  }
      });

    } catch (Exception e) {
      // This prints out the error if the code does not work.
      System.out.println(e);
    }
	}

  public static LinkedList masterList(JSONObject fileData) {

      // A temperary list used in filtering
      LinkedList superList = new LinkedList();

    try {
      // This will go through all the locations in the provided JSON file.
      JSONArray id = (JSONArray) fileData.get("Place");
      // Creates the iterator for the while loops and parsing.
      Iterator itr = id.iterator();
      Iterator itr2 = id.iterator();


      // This will deal with making all the items into a list
      while (itr2.hasNext()) {
        // Creates a linked list that will transfer the data from each item.
        LinkedList transferList = new LinkedList();

        // Creates an iterator that will be used to add data to temp list.
        Iterator<Map.Entry> itr3 = ((Map) itr2.next()).entrySet().iterator();

        int firstRecusion = 0;

        while (itr3.hasNext()) {
          // Got to have some good 'ol hash maps
          Map.Entry recursiveData = itr3.next();

          Object tempData = recursiveData.getValue();

          transferList.add(tempData);

          } // This ends the inner while loop

          superList.add(transferList);
          firstRecusion++;

      } // This ends the main while loop

    } catch (Exception e) {
    // This prints out the error if the code does not work.
      System.out.println(e);
    }

    return superList;
  } // This iterates through every item in the Json



  public static LinkedList Reader() {
    // A linked list that can be referenced and will contain all attributes
    LinkedList attributes = new LinkedList();

    try {
      long selectedProximityLong = 0;
      long selectedRatingLong = 0;

      if (selectedProximity == "1 Mile Away") {
        selectedProximityLong = 1;
      } else if (selectedProximity == "5 Miles Away") {
        selectedProximityLong = 5;
      } else if (selectedProximity == "10 Miles Away") {
        selectedProximityLong = 10;
      } else if (selectedProximity == "15 Miles Away") {
        selectedProximityLong = 15;
      }

      if (selectedRating == "5 Stars") {
        selectedRatingLong = 5;
      } else if (selectedRating == "4 Stars") {
        selectedRatingLong = 4;
      } else if (selectedRating == "3 Stars") {
        selectedRatingLong = 3;
      } else if (selectedRating == "2 Stars") {
        selectedRatingLong = 2;
      } else if (selectedRating == "1 Star") {
        selectedRatingLong = 1;
      }

      attributes.add(selectedProximityLong);
      attributes.add(selectedPrice);
      attributes.add(selectedRatingLong);
      attributes.add(selectedAttraction);
      attributes.add(selectedHours);

    } catch (Exception e) {
      // This prints out the error if the code does not work.
      System.out.println(e);
    }

    return attributes;
  } // Ends Reader class




  public static LinkedList locationFilter(LinkedList superList, LinkedList attributes) {

    LinkedList finalItems = superList;

    try {

      for (int i = 0; i < superList.size(); i++ ) {
        // This will deal with running through all the inner lists.
        Object nestedList = superList.get(i);

        boolean testPass = true;

        // These are nessacary to determine if all tests are passed.
        boolean testPass1 = true;
        boolean testPass2 = true;
        boolean testPass3 = true;
        boolean testPass4 = true;
        boolean testPass5 = true;

        int reRun = 0;

        LinkedList innerList = new LinkedList();
        innerList.add(nestedList);



        for (int p = 0; p < innerList.size(); p++ ) {
          // This will deal with running trough all the items on the nested lists

          Object itemList = innerList.get(p);

          /*if (reRun == 0) {
            System.out.println((attributes.get(0)).getClass().getName());
            if ((attributes.get(0)) >= itemList) {
              System.out.println("Test Passed");
            } else {
              testPass1 = false;
            }


          } else if (reRun == 1) {
            if (attributes.get(1) <= itemList) {
              System.out.println("Test Passed");
            } else {
              testPass2 = false;
            }


          } else if (reRun == 2) {
            if (attributes.get(2) == itemList) {
              System.out.println("Test Passed");
            } else {
              testPass3 = false;
            }


          } else if (reRun == 3) {
            System.out.println(itemList);



          } else if (reRun == 4) {
            System.out.println(itemList);



          } else if (reRun == 5) {
            if (attributes.get(3) == itemList) {
              System.out.println("Test Passed");
            } else {
              testPass4 = false;
            }


          } else if (reRun == 6) {
            if (attributes.get(4) == itemList) {
              System.out.println("Test Passed");
            } else {
              testPass5 = false;
            }


          } else {
            System.out.println("Error");
            System.out.println("The testing conditional failed");
          }*/

          reRun++;

        } // Ends item for loop.

        if ((testPass1 == true) && (testPass2 == true) && (testPass3 == true) && (testPass4 == true) && (testPass5 == true)) {
          testPass = true;
        } else {
          testPass = false;
        }

        if (testPass == true) {
          System.out.println("This item Passed");

        } else if (testPass == false) {
          System.out.println("This item failed");
          finalItems.remove(nestedList);
        }


      } // Ends list for loop 


    } catch (Exception e) {
      // This prints out the error if the code does not work.
      System.out.println(e);
    } // This ends the catch

    return finalItems;
  } // This ends the class
} // Ends program
