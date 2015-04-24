/**
 * @author EH
 * @version 1.0
 */
package Graphic;

import javax.imageio.ImageIO;
import javax.media.*;
import javax.swing.*;

import Listeners.ChoiceAPress;
import Listeners.ChoiceBPress;
import Listeners.ChoiceCPress;
import Listeners.ChoiceDPress;
import Listeners.FalseButtonPress;
import Listeners.TrueButtonPress;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;
import java.net.URL;

public class Window extends JFrame{
	
	//Declare Class Variables
	private static final long serialVersionUID = 6417992463021165919L;
	public final JLayeredPane layeredPane;
	private int width;
	private int height;
	private String lastAnswerPressed;
	
	/**
	 * @param title Name of The Window
	 */
	public Window(String title){
		//Set Window Title
		setTitle(title);
		
		//Pack the Window
		pack();
		
		//Set Window to Default Size
		setSize(400, 400);
		
		//Set Class Variables for Width and Height
		width = 400;
		height = 400;
		
		//Set window to be visible
		setVisible(true);
		
		//Disallow resizingg of the window
		setResizable(false);
		
		//Set the window to dispose instead of exiting on close
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Create and setup the layered pane
		layeredPane = new JLayeredPane();
		
		layeredPane.setPreferredSize(new Dimension(1000, 600));
		
		add(layeredPane);
	}
	
	/**
	 * Sets the background image
	 * @param file File Initialized with Image
	 * @param Height Height to Size Image and Frame to
	 * @param Width Width to Size Image and Frame to
	 */
	public void setBkgImage(File file, int width, int height){
		//Prints the background image path as debug output
		System.out.println(file.toString());
		
		//Check if the File Exists
		if (file.exists()){
			try {
				//Resize the Image
				BufferedImage img = ImageIO.read(file);
				Image img2 = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				//Create a label containing the image
				JLabel lbl = new JLabel(new ImageIcon(img2));
				//Set the Window Size to match that of the background image
				setSize(width, height);
				//Set the layered pane to have the same size as the background image
				layeredPane.setSize(getWidth(), getHeight());
				layeredPane.add(lbl, new Integer(1));
				//Remove the labels layout
				lbl.setLayout(null);
				//Set the label size
				lbl.setBounds(0, 0, width, height);
				lbl.repaint(0, 0, width, height);
				//Change the class height and width variables
				this.width = width;
				this.height = height;
				//Output debug dialogue
				System.out.println("File Found! Background Should be Set");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			//file didn't exist
			System.out.println("File Doesn't Exist!");
		}
	}
	
	/**
	 * Creates a text box
	 * @param x X Value of Component
	 * @param y Y Value of Component
	 * @param height Height of Text Box
	 * @param width Width of Text Box
	 * @param depth Depth of Text Box
	 * @param defText Default Text of Text Box
	 */
	public JTextField addTxtBox(int x, int y, int width, int height, int depth, String defText){
		//Create the textbox as a variable
		JTextField txt = new JTextField(defText);
		//Add the textbox to the layered pane
		layeredPane.add(txt, new Integer(depth));
		//Set size
		txt.setLayout(null);
		txt.setBounds(x, y, height, width);
		txt.repaint(x, y, height, width);
		//Add to the objectmanager and return
		ObjectManager.addObject(txt);
		return txt;
	}
	
	/**
	 * Creates an instructional video(Probably Doesn't Work as of Now)
	 * @param vidURL URL of Video
	 */
	public Component[] showVideo(URL vidURL, int depth){
		try {
			Player mediaPlayer = Manager.createRealizedPlayer(vidURL);
			
			Component video = mediaPlayer.getVisualComponent();
			Component controls = mediaPlayer.getControlPanelComponent();
			
			if (video != null){
				layeredPane.add(video, new Integer(depth));
			}
			
			if (controls != null){
				layeredPane.add(controls, new Integer(depth));
			}
			
			mediaPlayer.start();
			
			Component returnArray[] = {video, controls};
			
			for(int i = 0; i < returnArray.length; i++){
				ObjectManager.addObject(returnArray[i]);
			}
			
			return returnArray;
			
		} catch (NoPlayerException | CannotRealizeException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Creates a button
	 * @param x X
	 * @param y Y
	 * @param height Height of Button
	 * @param width Width of Button
	 * @param depth Depth of Button
	 * @param text Button Text
	 * @param listener Listener Class for Button
	 * @return Created Button Object
	 */
	public JButton addButton(int x, int y, int width, int height, int depth, String text, ActionListener listener){
		//Add the button as a variable
		JButton btn = new JButton(text);
		//Add the button to the layered pane
		layeredPane.add(btn, new Integer(depth));
		//Set size
		btn.setLayout(null);
		btn.setBounds(x, y, height, width);
		btn.repaint(x, y, height, width);
		//Add the listener
		btn.addActionListener(listener);
		//Add the object to the manager and return
		ObjectManager.addObject(btn);
		return btn;
	}
	
	/**
	 * Create a label
	 * @param x X
	 * @param y Y
	 * @param height Height of Label
	 * @param width Width of Label
	 * @param depth Depth of Label
	 * @param text Label Text
	 * @return Created JLabel Object
	 */
	public JLabel addLabel(int x, int y, int width, int height, int depth, String text){
		//Add the label as a variable
		JLabel lbl = new JLabel(text);
		//Add the label to the layered pane
		layeredPane.add(lbl, new Integer(depth));
		//Set the size
		lbl.setLayout(null);
		lbl.setBounds(x, y, height, width);
		lbl.repaint(x, y, height, width);
		//Add the object to the manager and return
		ObjectManager.addObject(lbl);
		return lbl;
	}
	
	/**
	 * Create a List(No Use as of Yet)
	 * @param x X
	 * @param y Y
	 * @param width Width of List
	 * @param height Height of List
	 * @param depth Depth of List
	 * @param contents Array with Contents of List
	 * @return Created JList
	 */
	public JList<String> addList(int x, int y, int width, int height, int depth, String[] contents){
		//Create the List as a Variable
		JList<String> list = new JList<String>(contents);
		//Add the List to the LayeredPane
		layeredPane.add(list, new Integer(depth));
		//Set the Size
		list.setLayout(null);
		list.setBounds(x, y, height, width);
		list.repaint(x, y, height, width);
		//Add the Object to the Manager and Return
		ObjectManager.addObject(list);
		return list;
	}
	
	/**
	 * Asks a True or False Question
	 * @param question The Question to Ask
	 * @param answer 1 = True, 2 = False
	 * @return Was the Question Created Correctly
	 */
	public boolean askTFQuestion(String question, int answer){
		//add the buttons
		JLabel templbl = this.addLabel(width / 2 - 50, height / 2 - 150, 200, 300, 3, question);
		JButton tempbtn1 = this.addButton(width / 2 - 200 , height / 2, 50, 100, 3, "True", new TrueButtonPress());
		JButton tempbtn2 = this.addButton(width / 2 + 100, height / 2, 50, 100, 3, "False", new FalseButtonPress());
		System.out.println("Added TF Question");
		//Loop until and Answer is Given
		do{
			if(lastAnswerPressed != null){
				//A Correct Answer was Given
				if(lastAnswerPressed == "true" & answer == 1){
					//Remove all Question Components and Return
					lastAnswerPressed = null;
					layeredPane.remove(templbl);
					layeredPane.remove(tempbtn1);
					layeredPane.remove(tempbtn2);
					this.revalidate();
					this.repaint();
					return true;
				}else if(lastAnswerPressed == "false" & answer == 2){
					//Remove all Question Components and Return
					lastAnswerPressed = null;
					layeredPane.remove(templbl);
					layeredPane.remove(tempbtn1);
					layeredPane.remove(tempbtn2);
					this.revalidate();
					this.repaint();
					return true;
				}
			}
		}while(lastAnswerPressed == null);
		//A wrong answer was given remove question and return false
		lastAnswerPressed = null;
		layeredPane.remove(templbl);
		layeredPane.remove(tempbtn1);
		layeredPane.remove(tempbtn2);
		this.revalidate();
		this.repaint();
		return false;
	}
	
	/**
	 * Asks a Multiple Choice Question
	 * @param question The Question to be Asked
	 * @param c1 The First Choice
	 * @param c2 The Second Choice
	 * @param c3 The Third Choice
	 * @param c4 The Fourth Choice
	 * @param answer 1 = First Choice, 2 = Second Choice, etc.
	 * @return Was the Answer Correct
	 */
	public boolean askMCQuestion(String question, String c1, String c2, String c3, String c4, int answer){
		//Add Buttons
		JLabel templbl = this.addLabel(width / 2 - 100, height / 2 - 212, 200, 300, 3, question);
		JButton choiceA = this.addButton(width / 2 - 250, height / 2 - 62, 50, 100, 3, "A. " + c1, new ChoiceAPress());
		JButton choiceB = this.addButton(width / 2 + 150, height / 2 - 62, 50, 100, 3, "B. " + c2, new ChoiceBPress());
		JButton choiceC = this.addButton(width / 2 - 250, height / 2 + 63, 50, 100, 3, "C. " + c3, new ChoiceCPress());
		JButton choiceD = this.addButton(width / 2 + 150, height / 2 + 63, 50, 100, 3, "D. " + c4, new ChoiceDPress());
		choiceA.setToolTipText(c1);
		choiceB.setToolTipText(c2);
		choiceC.setToolTipText(c3);
		choiceD.setToolTipText(c4);
		System.out.println("Added MC Question");
		do{
			if (lastAnswerPressed != null){
				if(lastAnswerPressed.equals("a") & answer == 1){
					//Correct Answer Given Remove Question and Return True
					System.out.println("Correct Answer of A given");
					lastAnswerPressed = null;
					layeredPane.remove(templbl);
					layeredPane.remove(choiceA);
					layeredPane.remove(choiceB);
					layeredPane.remove(choiceC);
					layeredPane.remove(choiceD);
					this.revalidate();
					this.repaint();
					System.out.println("Last Answer Pressed Has Changed");
					return true;
				} else if(lastAnswerPressed.equals("b") & answer == 2){
					//Correct Answer Given Remove Question and Return True
					System.out.println("Correct Answer of B Given");
					lastAnswerPressed = null;
					layeredPane.remove(templbl);
					layeredPane.remove(choiceA);
					layeredPane.remove(choiceB);
					layeredPane.remove(choiceC);
					layeredPane.remove(choiceD);
					this.revalidate();
					this.repaint();
					System.out.println("Last Answer Pressed Has Changed");
					return true;
				} else if(lastAnswerPressed.equals("c") & answer == 3){
					//Correct Answer Given Remove Question and Return True
					System.out.println("Correct answer of C Given");
					lastAnswerPressed = null;
					layeredPane.remove(templbl);
					layeredPane.remove(choiceA);
					layeredPane.remove(choiceB);
					layeredPane.remove(choiceC);
					layeredPane.remove(choiceD);
					this.revalidate();
					this.repaint();
					System.out.println("Last Answer Pressed Has Changed");
					return true;
				} else if(lastAnswerPressed.equals("d") & answer == 4){
					//Correct Answer Given Remove Question and Return True
					System.out.println("Correct Answer of D Given");
					lastAnswerPressed = null;
					layeredPane.remove(templbl);
					layeredPane.remove(choiceA);
					layeredPane.remove(choiceB);
					layeredPane.remove(choiceC);
					layeredPane.remove(choiceD);
					this.revalidate();
					this.repaint();
					System.out.println("Last Answer Pressed Has Changed");
					return true;
				}
			}
		}while(lastAnswerPressed == null);
		//Wrong Answer Given Remove Question and Return False
		System.out.println("Exited Do Loop");
		lastAnswerPressed = null;
		layeredPane.remove(templbl);
		layeredPane.remove(choiceA);
		layeredPane.remove(choiceB);
		layeredPane.remove(choiceC);
		layeredPane.remove(choiceD);
		this.revalidate();
		this.repaint();
		return false;
	}
	
	/**
	 * Called By Listeners to Say an Answer Button was Pressed
	 * @param answerPressed
	 */
	public void answerPressed(String answerPressed){
		lastAnswerPressed = answerPressed;
		System.out.println("lastAnswerPressed Changed");
	}
	
	/**
	 * Returns the Class-Created Layered Pane
	 * @return Returns the Window's Layered Pane
	 */
	public JLayeredPane getWindowLayeredPane(){
		return layeredPane;
	}
}