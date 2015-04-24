package Main;

import Graphic.ObjectManager;
import Graphic.Window;
import Listeners.BeginTest;
import Listeners.Continue;
import Listeners.GetTeacherCode;

import java.io.*;
import java.math.RoundingMode;
import java.nio.file.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

public class ScreenManage {
	
	public static Window homewindow;
	private static JButton classIDBTN;
	private static JButton startTestBTN;
	
	public static void createHomeScreen(){
		homewindow = new Window("Banana");
		
		homewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		homewindow.setBkgImage(new File(System.getProperty("user.dir") + "/resources/template.png"), 1280, 800);
	
		classIDBTN = homewindow.addButton(homewindow.getWidth() / 2 - 100, homewindow.getHeight() / 2 - 50, 100, 200, 3, "Login", new GetTeacherCode());
		
		//ScreenManage.loadTest(new File(System.getProperty("user.dir") + "/currenttest.txt").toPath());
	}
	
	public static void createLoggedIn(){
		ObjectManager.clearScreen(homewindow.getWindowLayeredPane(), homewindow);
		ObjectManager.clearScreen(homewindow.getWindowLayeredPane(), homewindow);
		ObjectManager.clearScreen(homewindow.getWindowLayeredPane(), homewindow);
		
		startTestBTN = homewindow.addButton(homewindow.getWidth() / 2 - 100, homewindow.getHeight() / 2 - 50, 100, 200, 3, "Take Test", new BeginTest());
	}
	
	public static void showGrade(double percentGrade){
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		homewindow.addLabel(homewindow.getWidth() / 2 - 125, homewindow.getHeight() / 2 - 112, 100, 300, 3, "Your Grade is: " + df.format(percentGrade * 100) + "%");
		homewindow.addButton(homewindow.getWidth() / 2 - 100, homewindow.getHeight() / 2 + 50, 100, 200, 3, "Continue", new Continue());
	}
	
	public static void loadTest(Path testFile){
		TestDisplayThread displayThread = new TestDisplayThread(homewindow, testFile);
	}
}