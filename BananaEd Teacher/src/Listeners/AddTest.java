package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Main.ScreenManage;

public class AddTest implements ActionListener{
	
	public void actionPerformed(ActionEvent arg0) {
		ScreenManage.addTest(JOptionPane.showInputDialog("Enter the Test Name: ", "Test Name"));
	}
}
