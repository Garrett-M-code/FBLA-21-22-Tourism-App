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
import javax.swing.event.*;

// This imports utilities needed like Hash Maps.
import java.util.*;

public class GUI extends JFrame {
  // This is used to create the GUI orentation when ran.

  static String selectedAttraction = "--:--";
  static String selectedRating = "--:--";
  static String selectedProximity = "--:--";
  static String selectedPrice = "--:--";
  static String selectedHours = "--:--";

  // A list that acts somewhat like a global variable
  LinkedList dataSetList = new LinkedList();

  public GUI() {
    try {
      // parsing file "JSONExample.json"
      Object obj = new JSONParser().parse(new FileReader("locationData.json"));

      // typecasting obj to JSONObject
      JSONObject fileData = (JSONObject) obj;

      // These are non-functioning arrays
      String[] attractionList = { "------", "Hotel", "Entertainment", "Restaurant", "Park", "Shop" };
      String[] ratingList = { "------", "5 Stars", "4 Stars", "3 Stars", "2 Stars", "1 Star" };
      String[] proximityList = { "------", "1 Mile Away", "5 Miles Away", "10 Miles Away", "15 Miles Away" };
      String[] priceList = { "------", "Free", "$", "$$", "$$$" };
      String[] workHoursList = { "------", "Morning", "Afternoon", "Night" };

      // Sets up the basic window properties like exiting, Title, layout style, and
      // background color.
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
        }
      });

      // Creates the header for the second dropdown (Rating).
      JLabel lblRatings = new JLabel("Minimum Rating");
      lblRatings.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
      lblRatings.setBounds(50, 124, 160, 31);
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
        }
      });

      // Creates the header for the third dropdown (Proximity).
      JLabel lblProximity = new JLabel("Minimum Distance");
      lblProximity.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
      lblProximity.setBounds(50, 214, 190, 31);
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
        }
      });

      // Will display a location and its information when a user selects a place.
      JTextPane txtLocationOutput = new JTextPane();
      txtLocationOutput.setEditable(false);
      txtLocationOutput.setText(
          "Please select from the attributes to the left and click the search button above when you are ready! If no locations are listed, try broadening your search.");
      txtLocationOutput.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
      txtLocationOutput.setBackground(Color.LIGHT_GRAY);
      txtLocationOutput.setBounds(317, 364, 601, 124);
      getContentPane().add(txtLocationOutput);

      // It will display all possible choices in a list from which the user can select
      // an option.
      JList resultsListed = new JList();
      resultsListed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      resultsListed.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
      // This is the list that is displayed
      resultsListed.setModel(new AbstractListModel() {
        // Creates a default list for the JList
        String[] values = new String[] {};

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

      // A button that then searches.
      JButton btnRun = new JButton("Search!");
      btnRun.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Checks to see if the attributes selected by the user are teh default values.
          if ((selectedAttraction == "--:--") || (selectedRating == "--:--") || (selectedProximity == "--:--")
              || (selectedPrice == "--:--") || (selectedHours == "--:--")) {

            txtLocationOutput.setText("Make sure you select all options.");

          // Checks to see if the attributes selected by the user are teh default values.
          } else if ((selectedAttraction == "------") || (selectedRating == "------") || (selectedProximity == "------")
              || (selectedPrice == "------") || (selectedHours == "------")) {

            txtLocationOutput.setText("Make sure you select all options.");

          } else {
            // If the user selects attributes, this runs.
            txtLocationOutput.setText("Please select a location to view its information.");

            // This creates a linked list that has all locations
            LinkedList superList = masterList(fileData);
            // This creates a linkedList that has all the attributes
            LinkedList filteringPolicy = Reader();
            // This will produce a list of the items to be used
            LinkedList resultingItems = locationFilter(superList, filteringPolicy);

            dataSetList = resultingItems;

            // This gets the list of just the names
            LinkedList locationNames = nameGen(resultingItems);

            // Sets the display list to the names.
            
            resultsListed.setModel(new AbstractListModel() {
              Object[] array = locationNames.toArray();

              // Dont really know what these do but oh well
              public int getSize() {
                return array.length;
              }

              public Object getElementAt(int index) {
                return array[index];
              }
            });

          } // Ends conditional
        } // Ends action event
      });
      btnRun.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
      btnRun.setBounds(545, 327, 106, 27);
      getContentPane().add(btnRun);

      // Event listener for when an item is selected from the JList property
      resultsListed.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
          // Gets the index
          int selectedOption = resultsListed.getSelectedIndex();

          // Makes sure that negative indexes are not possible.
          if (selectedOption < 0) {
            selectedOption = 0;
          }


          // Runs the function and returns a string
          String selectedListedOption = (String) queryInfo(dataSetList, selectedOption);

          // Displays that to the JTextbox
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

      // This will deal with making all the items into a list.
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

    // Returns a LinkedList that contaians all of the locations and their data.
    return superList;
  } // This iterates through every item in the Json

  public static LinkedList Reader() {
    // A metheod that will determine whether a location passes or fails the attributes.

    // A linked list that can be referenced and will contain all attributes
    LinkedList attributes = new LinkedList();

    try {
      // Declares long integers so that logical operators can be used.
      long selectedProximityLong = 0;
      long selectedRatingLong = 0;

      // Determines what selectedProximityLong will be based on user input.
      if (selectedProximity == "1 Mile Away") {
        selectedProximityLong = 1;
      } else if (selectedProximity == "5 Miles Away") {
        selectedProximityLong = 5;
      } else if (selectedProximity == "10 Miles Away") {
        selectedProximityLong = 10;
      } else if (selectedProximity == "15 Miles Away") {
        selectedProximityLong = 15;
      }

      // Determines what selectedRatingLong will be based on user input.
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

      // This adds all the attributes to a LinkedList for easier accessing.
      attributes.add(selectedProximityLong);
      attributes.add(selectedPrice);
      attributes.add(selectedRatingLong);
      attributes.add(selectedAttraction);
      attributes.add(selectedHours);

    } catch (Exception e) {
      // This prints out the error if the code does not work.
      System.out.println(e);
    }

    // Returns a LinkedList
    return attributes;
  } // Ends Reader class

  public static LinkedList locationFilter(LinkedList superList, LinkedList attributes) {

    LinkedList finalItems = superList;
    LinkedList indexsToRemove = new LinkedList();

    try {

      for (int i = 0; i < superList.size(); i++) {
        // This will deal with running through all the lists contained within the master list (superList).

        Object nestedList = superList.get(i);

        boolean testPass = true;

        // These are nessacary to determine if all tests are passed.
        boolean testPass1 = true;
        boolean testPass2 = true;
        boolean testPass3 = true;
        boolean testPass4 = true;
        boolean testPass5 = true;

        LinkedList innerList = new LinkedList();
        // innerList.add(nestedList);

        // Converts the lists that are nested into LinkedLists and makes innerList equal to them.
        innerList = (LinkedList) nestedList;

        for (int p = 0; p < innerList.size(); p++) {
          // This will deal with running trough all the items on the nested lists.

          Object itemList = innerList.get(p);

          // This code will determine what item in the list is on and determine if it passes that attribute.
          if (p == 0) {
            // Checks proximty
            long tester = (long) attributes.get(0);
            long userSelection = (long) itemList;
            // Creates an integer so that the expression below works.
            if (tester < userSelection) {
              testPass1 = false;
            }

          } else if (p == 1) {
            // Checks the price
            if ((attributes.get(1)).equals(itemList)) {
              testPass2 = true;
            } else {
              testPass2 = false;
            }

          } else if (p == 2) {
            // Checks Rating
            long tester = (long) attributes.get(2);
            long userSelection = (long) itemList;
            // Creates an integer so that the expression below works.
            if (tester > userSelection) {
              testPass3 = false;
            }

          } else if (p == 5) {
            // Checks attraction
            if ((attributes.get(3)).equals(itemList)) {
              testPass4 = true;
            } else {
              testPass4 = false;
            }

          } else if (p == 6) {
            // Checks operating hours
            String userSelection = (String) itemList;
            // Tester will convert the user attribute for hours to a simple morning afternoon evening format (MAE).
            String tester = "";
            if (attributes.get(4) == "Morning") {
              tester = "M";
            } else if (attributes.get(4) == "Afternoon") {
              tester = "A";
            } else if (attributes.get(4) == "Night") {
              tester = "E";
            }

            // Checks hours
            if (userSelection.contains(tester)) {
              testPass5 = true;
            } else {
              testPass5 = false;
            }
          }
        } // Ends item for loop.

        // Checks to make sure every item passed.
        if ((testPass1 == true) && (testPass2 == true) && (testPass3 == true) && (testPass4 == true)
            && (testPass5 == true)) {
          testPass = true;
        } else {
          testPass = false;
        }

        // Adds failed items to a list that will be removed
        if (testPass == false) {
          indexsToRemove.add(i);
        }
      } // Ends list for loop

    } catch (Exception e) {
      // This prints out the error if the code does not work.
      System.out.println(e);
    } // This ends the catch

    // Removes any items that did not pass the tests.
    itemRemover(indexsToRemove, finalItems);
    return finalItems;
  } // This ends the class

  public static void itemRemover(LinkedList<Integer> itemsToRemove, LinkedList finalItems) {
    // A metheod that will remove any items from the JSON file that does not qualify based on selected transferList.

    // A LinkedList will be reversed to stop possible wrong indexes
    LinkedList<Integer> reversed = new LinkedList();

    // This reverses the list
    for (int y = 0, j = itemsToRemove.size(); y < j; y++) {
      reversed.add(itemsToRemove.getLast());
      itemsToRemove.removeLast();
    }

    // This removes the item from the master list and produces a finalized list.
    int randIndex = 0;
    for (int m = 0, n = reversed.size(); m < n; m++) {
      randIndex = reversed.get(m);
      finalItems.remove(randIndex);
    }
  } // Ends Class

  public static LinkedList nameGen(LinkedList resultingItems) {
    // This metheod produces a list of just the names of possible locations that will be listed in the JList.

    // A list where the names will be stored
    LinkedList namesList = new LinkedList();

    // A For loop that will loop through every nested LinkedList.
    for (int i = 0; i < resultingItems.size(); i++) {
      LinkedList individual = (LinkedList) resultingItems.get(i);

      // A For loop that will loop through every item in a LinkedList and save the name or "ID" of a possible location.
      for (int p = 0; p < individual.size(); p++) {
        if (p == 4) {
          namesList.add(individual.get(p));

        } // This ends the if statement
      } // Ends inner for loop
    } // Ends outer for loop

    return namesList;
  } // Ends Class

  public static Object queryInfo(LinkedList resultingItems, int selectedOption) {
    // This metheod get the user selected item, and displays more information in the JText Area

    // This is a linkedList that contains all the location data
    LinkedList information = (LinkedList) resultingItems.get(selectedOption);

    // This is the mega-output statement that will display all the information
    Object outputInformation = information.get(4) + "\n" + information.get(3) + "\n" + "Rating: " + information.get(2)
        + "\tProximity: " + information.get(0) + " Mile(s) Away\nPrice: " + information.get(1) + "\t\tOpen\n";

    // This converts outputInformation to a String
    outputInformation = outputInformation.toString();

    // Will return a string that contains all the information, formatted, that will be displayed.
    return outputInformation;

  } // Ends class

} // Ends program
