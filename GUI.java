import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUI extends JFrame{
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Tourism App");
		getContentPane().setLayout(null);
		
		JLabel titleLbl = new JLabel("Henry County, Ga Visitor Center!");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		titleLbl.setBounds(0, 0, 986, 46);
		getContentPane().add(titleLbl);
		
		JComboBox dropdownOne = new JComboBox();
		dropdownOne.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		dropdownOne.setModel(new DefaultComboBoxModel(new String[] {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"}));
		dropdownOne.setBounds(127, 76, 132, 31);
		getContentPane().add(dropdownOne);
		
		JComboBox dropdownTwo = new JComboBox();
		dropdownTwo.setModel(new DefaultComboBoxModel(new String[] {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"}));
		dropdownTwo.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		dropdownTwo.setBounds(127, 165, 132, 31);
		getContentPane().add(dropdownTwo);
		
		JComboBox dropdownThree = new JComboBox();
		dropdownThree.setModel(new DefaultComboBoxModel(new String[] {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"}));
		dropdownThree.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		dropdownThree.setBounds(127, 253, 132, 31);
		getContentPane().add(dropdownThree);
		
		JComboBox dropdownFour = new JComboBox();
		dropdownFour.setModel(new DefaultComboBoxModel(new String[] {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"}));
		dropdownFour.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		dropdownFour.setBounds(127, 341, 132, 31);
		getContentPane().add(dropdownFour);
		
		JComboBox dropdownFive = new JComboBox();
		dropdownFive.setModel(new DefaultComboBoxModel(new String[] {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"}));
		dropdownFive.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		dropdownFive.setBounds(127, 432, 132, 31);
		getContentPane().add(dropdownFive);
		}

	public static void main(String[] args) {
		GUI instance = new GUI();
		instance.setSize(new Dimension(1000,600));
        instance.setVisible(true);
        
		String[] dropdownOneList = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};
		String[] dropdownTwoList = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};
		String[] dropdownThreeList = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};
		String[] dropdownFourList = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};
		String[] dropdownFiveList = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};
  }
}
