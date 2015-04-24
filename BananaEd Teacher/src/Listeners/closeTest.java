package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.testCreator;

public class closeTest implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		testCreator.close();
	}
}
