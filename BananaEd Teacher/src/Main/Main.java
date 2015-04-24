package Main;

public class Main{
	
	public static String teacherID;
	//Add FTP Server IP Here
	public static final String ftpIP = "127.0.0.1:21";
	public static final String ftpName = "user";
	public static final String ftpPass = "pass";
	
	public static void main(String args[]){
		System.out.println("Program Began Execution");
		testCreator.init();
		teacherID = null;
		ScreenManage.createHomeScreen();
	}
}