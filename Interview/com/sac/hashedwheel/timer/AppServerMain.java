package com.sac.hashedwheel.timer;



public class AppServerMain {
	
	private final CommandLineManager commandManager;
	
	AppServerMain(){
		commandManager = new CommandLineManager();		
	}
	
	private void startAppServer(){
		TimeoutManager.getTimeoutManager().startTimeoutThread();
		commandManager.startCommandLineProcessor();
		
	}
	
	public static void main(String[] args){
		AppServerMain main = new AppServerMain();
		main.startAppServer();
	}
}
