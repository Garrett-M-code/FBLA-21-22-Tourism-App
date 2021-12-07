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
