package com.sac.hashedwheel.timer;

public class TimeoutEntry {
	private TimeoutListener listener;
	private volatile long startTime;
	private volatile long timeoutTime;
	
	public TimeoutEntry(TimeoutListener listener, long startTime, long timeoutTime){
		this.listener = listener;
		this.startTime = startTime;
		this.timeoutTime = timeoutTime;
	}

	public TimeoutListener getListener() {
		return listener;
	}
	public void setListener(TimeoutListener listener) {
		this.listener = listener;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getTimeoutTime() {
		return timeoutTime;
	}
	public void setTimeoutTime(long timeoutTime) {
		this.timeoutTime = timeoutTime;
	}
	
	public void printEntry(){
		System.out.println("startTime ="+startTime+":timeoutTime ="+timeoutTime+":listener ="+listener.toString());
	}
}
