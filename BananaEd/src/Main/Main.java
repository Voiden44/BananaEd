package Main;

public class Main{
	
	public static String teacherID;
	//Add FTP Server IP Here
	public static final String ftpIP = "127.0.0.1:21";
	//Add FTP Server Username Here
	public static final String ftpName = "user";
	//Add FTP Server Password Here
	public static final String ftpPass = "pass";
	
	public static void main(String args[]){
		System.out.println("Program Began Execution");
		teacherID = null;
		ScreenManage.createHomeScreen();
	}
}