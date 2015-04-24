package Graphic;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.*;

public abstract class ObjectManager {
	
	//Declare Objects Array
	private static ArrayList<Component> objects = new ArrayList<Component>();
	
	/**
	 * Removes the passed object from the manager
	 * @param object Object to Remove
	 * @param pane The Windows Layered Pane
	 */
	public static void removeObject(Component object, JLayeredPane pane, Window window){
		//Loop through all objects in array list
		for(int i = 0; i < objects.size(); i++){
			//If one of the objects is equal to the passed object then remove it
			if (objects.get(i).equals(object)){
				//Remove object and break the loop
				pane.remove(object);
				objects.remove(i);
				window.revalidate();
				window.repaint();
				break;
			}
		}
	}
	
	/**
	 * Adds the passed object to the manager
	 * @param object Object to add to the manager
	 */
	public static void addObject(Component object){
		//Add object to manager and print debug log
		System.out.println("Add Object Ran");
		System.out.println(objects.add(object));
	}
	
	/**
	 * Clears all objects on the window
	 * @param pane The Window's Layered Pane
	 * @param window The Window to Clear
	 */
	public static void clearScreen(JLayeredPane pane, Window window){
		//Loop through all Objects
		for(int i = 0; i < objects.size(); i++){
			//System.out.println("For Loop Executed");
			//Sets a temporary variable containing the current object in the loop
			Component object = objects.get(i);
			//Check if the object exists
			if (!object.equals(null)){
				//Remove Object
				System.out.println("Found object not equal to null");
				pane.remove(object);
				System.out.println(objects.remove(object));
			}
		}
		//Revalidate and repaint the window
		window.revalidate();
		window.repaint();
	}
	
	/**
	 * Output all items contained by the ObjectManager
	 */
	public static void debugManager(){
		//Loop through all objects and print them as a string
		for(int i = 0; i < objects.size(); i++){
		 	System.out.println(objects.get(i).toString());
		}
	}
	
}