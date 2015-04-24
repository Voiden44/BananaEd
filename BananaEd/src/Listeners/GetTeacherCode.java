package Listeners;

import it.sauronsoftware.ftp4j.FTPClient;

import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.JOptionPane;
import Main.ScreenManage;

public class GetTeacherCode implements ActionListener{
	
	private InputStream instream;
	private InputStream instream1;
	private BufferedReader br;
	private BufferedReader br1;
	private FTPClient client;
	private int teacherLnCount;
	private String inputedTeacherCode;
	private String currentCode;
	private boolean foundCode;
	
	public void actionPerformed(ActionEvent arg0) {
		client = new FTPClient();
		foundCode = false;
		try {
			client.connect(Main.Main.ftpIP);
			client.login(Main.Main.ftpName, Main.Main.ftpPass);
			
			client.download("teachercodes.txt", new File(System.getProperty("user.dir") + "/teachercodes.txt"));
			
			inputedTeacherCode = JOptionPane.showInputDialog("Please Enter your Class Code Here:", "Class Code");
			
			instream = Files.newInputStream(FileSystems.getDefault().getPath("teachercodes.txt"));
			br = new BufferedReader(new InputStreamReader(instream));
			
			teacherLnCount = 0;
			while(br.readLine() != null){
				teacherLnCount++;
			}
			
			instream1 = Files.newInputStream(FileSystems.getDefault().getPath("teachercodes.txt"));
			br.close();
			br1 = new BufferedReader(new InputStreamReader(instream1));
			
			for(int i = 0; i <= teacherLnCount; i++){
				currentCode = br1.readLine();
				if(currentCode.equals(inputedTeacherCode)){
					Main.Main.teacherID = inputedTeacherCode;
					foundCode = true;
					ScreenManage.createLoggedIn();
					break;
				}
			}
			if(foundCode == false){
				System.out.println("Teacher Code not Found!");
			}
			new File(System.getProperty("user.dir") + "/teachercodes.txt").delete();
			client.disconnect(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}