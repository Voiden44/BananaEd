package Main;

import Listeners.BeginTest;
import it.sauronsoftware.ftp4j.FTPDataTransferListener;

public class BeginTestTransferListener implements FTPDataTransferListener{

	@Override
	public void aborted() {
		
	}

	@Override
	public void completed() {
		BeginTest.transferComplete();
	}

	@Override
	public void failed() {
		
	}

	@Override
	public void started() {
		
	}

	@Override
	public void transferred(int arg0) {
		
	}

}
