package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Main.testCreator;

public class addMCQuestion implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		testCreator.addMCQuestion(JOptionPane.showInputDialog("Enter the Question:", "Question"),
				JOptionPane.showInputDialog("Enter the First Answer:", "Answer"),
				JOptionPane.showInputDialog("Enter the Second Answer:", "Answer"),
				JOptionPane.showInputDialog("Enter the Third Answer:", "Answer"),
				JOptionPane.showInputDialog("Enter the Fourth Answer:", "Answer"),
				Integer.parseInt(JOptionPane.showInputDialog("Enter the Number of the Correct Answer", "Number 1-4")));
	}
}
