package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.ScreenManage;

public class ChoiceBPress implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		ScreenManage.homewindow.answerPressed("b");
		System.out.println("Choice B Picked");
	}
}
