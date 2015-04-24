package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Main.testCreator;

public class addTFQuestion implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		testCreator.addTFQuestion(JOptionPane.showInputDialog("Enter the Question:", "Question"),
				Integer.parseInt(JOptionPane.showInputDialog("Enter 1 for True, 2 for False", "1 or 2")));
	}
}
