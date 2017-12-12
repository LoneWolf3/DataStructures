package com.sac.hashedwheel.timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CommandLineManager {
	Map<String, Command> commandMap = new HashMap<String, Command>();
	
	public CommandLineManager(){
		initializeCommandMap();
	}
	
	public void initializeCommandMap(){
		commandMap.put("print", new PrintTimeoutSlotsCommand());
		commandMap.put("newtx", new CreateNewTransactionCommand());		
	}
	
	private void processCommand(String command){
		Command cmd = commandMap.get(command);
		if(cmd != null)
			cmd.process();
	}
	
	public void startCommandLineProcessor(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command = null;

		// read the username from the command-line; need to use try/catch with
		// the
		// readLine() method
		while(true){
			try {
				command = br.readLine();
			} catch (IOException ioe) {
				System.out.println("IO error trying to read your name!");
				System.exit(1);
			}
			
			if(command == null){
				continue;
			}
			if (command.equalsIgnoreCase("exit")){
				break;
			}else{
				processCommand(command.trim());
			}
		}
	}
}
