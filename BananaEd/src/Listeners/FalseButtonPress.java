package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.ScreenManage;

public class FalseButtonPress implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		ScreenManage.homewindow.answerPressed("false");
	}
}
