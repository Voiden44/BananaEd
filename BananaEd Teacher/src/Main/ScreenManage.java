package Main;

import java.io.File;

import Graphic.ObjectManager;
import Graphic.Window;
import Listeners.AddTest;
import Listeners.GetTeacherCode;
import Listeners.RemoveTest;
import Listeners.addMCQuestion;
import Listeners.addTFQuestion;
import Listeners.closeTest;

import javax.swing.*;

public class ScreenManage {
	
	public static Window homewindow;
	
	public static void createHomeScreen(){
		homewindow = new Window("Banana");
		
		homewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		homewindow.setBkgImage(new File(System.getProperty("user.dir") + "/resources/template.png"), 1280, 800);
	
		homewindow.addButton(homewindow.getWidth() / 2 - 100, homewindow.getHeight() / 2 - 50, 100, 200, 3, "Login", new GetTeacherCode());
	}

	public static void createLoggedIn() {
		ObjectManager.clearScreen(homewindow.getWindowLayeredPane(), homewindow);
		ObjectManager.clearScreen(homewindow.getWindowLayeredPane(), homewindow);
		homewindow.addButton(homewindow.getWidth() / 2 - 200, homewindow.getHeight() / 2 - 50, 100, 200, 3, "Add a Test", new AddTest());
		homewindow.addButton(homewindow.getWidth() / 2 + 100, homewindow.getHeight() / 2 - 50, 100, 200, 3, "Remove a Test", new RemoveTest());
	}
	
	public static void addTest(String testName){
		ObjectManager.clearScreen(homewindow.getWindowLayeredPane(), homewindow);
		ObjectManager.clearScreen(homewindow.getWindowLayeredPane(), homewindow);
		testCreator.init();
		testCreator.addTestFile(new File(System.getProperty("user.dir") + "/" + testName + ".txt"), testName);
		homewindow.addButton(homewindow.getWidth() / 2 - 300, homewindow.getHeight() / 2 - 50, 100, 200, 3, "Add MC Question", new addMCQuestion());
		homewindow.addButton(homewindow.getWidth() / 2 + 100, homewindow.getHeight() / 2 - 50, 100, 200, 3, "Add TF Question", new addTFQuestion());
		homewindow.addButton(homewindow.getWidth() / 2 - 100, homewindow.getHeight() / 2 + 100, 100, 200, 3, "Finish Writing Test", new closeTest());
	}
}