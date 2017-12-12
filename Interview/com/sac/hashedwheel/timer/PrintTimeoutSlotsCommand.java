package com.sac.hashedwheel.timer;


public class PrintTimeoutSlotsCommand implements Command{
	TimeoutManager timeoutManager;
	
	
	public void process() {
		TimeoutManager.getTimeoutManager().printSlots();
	}
}
