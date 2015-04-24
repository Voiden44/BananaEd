package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.ScreenManage;

public class ChoiceDPress implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		ScreenManage.homewindow.answerPressed("d");
		System.out.println("Choice D Picked");
	}
}
