package Listeners;

import it.sauronsoftware.ftp4j.FTPClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import Main.BeginTestTransferListener;
import Main.ScreenManage;

public class BeginTest implements ActionListener{

	private FTPClient client;
	private String testpath;
	private static boolean transferCompleted;
	
	public void actionPerformed(ActionEvent arg0) {
		client = new FTPClient();
		
		try {
			BeginTest.transferCompleted = false;
			client.connect(Main.Main.ftpIP);
			client.login(Main.Main.ftpName, Main.Main.ftpPass);
			testpath = JOptionPane.showInputDialog("Please Enter your Teacher's Test Name Here:", "Test Name");
			testpath = Main.Main.teacherID + "/tests/" + testpath + ".txt";
			client.download(testpath, new File(System.getProperty("user.dir") + "/currenttest.txt"), new BeginTestTransferListener());
			client.disconnect(true);
			do{
				if(transferCompleted == true){
					System.out.println("File Transfer Completed and loadTest being run");
					ScreenManage.loadTest(new File(System.getProperty("user.dir") + "/currenttest.txt").toPath());
				}
			}while(!transferCompleted);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void transferComplete(){
		BeginTest.transferCompleted = true;
	}

}
