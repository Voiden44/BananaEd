package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.ScreenManage;

public class ChoiceAPress implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		ScreenManage.homewindow.answerPressed("a");
		System.out.println("Choice A Picked");
	}
}
