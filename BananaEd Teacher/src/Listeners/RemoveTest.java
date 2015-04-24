package Listeners;

import it.sauronsoftware.ftp4j.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

public class RemoveTest implements ActionListener{

	private String testName;
	private FTPClient ftpClient;
	
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			ftpClient = new FTPClient();
			
			testName = JOptionPane.showInputDialog("Enter Name of Test to Remove: ", "Test Name");
			
			ftpClient.connect(Main.Main.ftpIP);
			
			ftpClient.login("commanderej44@gmail.com", "bananaEducate");
			
			ftpClient.deleteFile(Main.Main.teacherID + "/tests/" + testName + ".txt");
			
			ftpClient.disconnect(true);
		} catch (IllegalStateException | IOException | FTPIllegalReplyException
				| FTPException e) {
			e.printStackTrace();
		}
	}
}
