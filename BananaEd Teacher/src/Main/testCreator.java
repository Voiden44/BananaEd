package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;

public abstract class testCreator {
	private static FTPClient client;
	private static File testFile;
	private static String testFileStr;
	private static FileWriter writer;
	private static boolean hasInit;
	private static boolean hasFile;
	private static String lastquestion[];
	
	public static void init(){
		client = new FTPClient();
		
		testFile = null;
		
		try {
			client.connect(Main.ftpIP);
			
			client.login(Main.ftpName, Main.ftpPass);
			
			client.setAutoNoopTimeout(30000);
			
			hasInit = true;
			hasFile = false;
		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
			e.printStackTrace();
		}
	}
	
	public static void addTestFile(File newTestFile, String newTestFileStr){
		testFile = newTestFile;
		testFileStr = newTestFileStr;
		
		try {
			if(!newTestFile.exists()){
				newTestFile.createNewFile();
			}
			writer = new FileWriter(newTestFile);
			hasFile = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addMCQuestion(String question, String answer1, String answer2, String answer3, String answer4, int correct){
		try {
			lastquestion = question.split("\\s+");
			writer.write("mc" + System.lineSeparator());
			writer.write(lastquestion.length + System.lineSeparator());
			for(int i = 0; i < lastquestion.length; i++){
				writer.write(lastquestion[i] + System.lineSeparator());
			}
			writer.write(answer1 + System.lineSeparator());
			writer.write(answer2 + System.lineSeparator());
			writer.write(answer3 + System.lineSeparator());
			writer.write(answer4 + System.lineSeparator());
			writer.write(correct + System.lineSeparator());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addTFQuestion(String question, int correct){
		try {
			lastquestion = question.split("\\s+");
			writer.write("tf" + System.lineSeparator());
			writer.write(lastquestion.length + System.lineSeparator());
			for(int i = 0; i < lastquestion.length; i++){
				writer.write(lastquestion[i] + System.lineSeparator());
			}
			writer.write(correct + System.lineSeparator());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static File getTest(){
		return testFile;
	}
	
	public static void close(){
		try {
			client.changeDirectory(Main.teacherID + "/tests/");
			writer.close();
			client.upload(testFile);
			client.disconnect(true);
			System.out.println(testFile.toString());
			testFile.delete();
			testFile = null;
			testFileStr = null;
			writer = null;
			hasInit = false;
			hasFile = false;
			ScreenManage.createLoggedIn();
		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException | FTPDataTransferException | FTPAbortedException e) {
			e.printStackTrace();
		}
	}
}
