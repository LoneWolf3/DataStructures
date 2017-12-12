package com.sac.hashedwheel.timer;

public class Transaction{
	public static final String ACTIVE_STATE = "TX_ACTIVE_STATE";
	public static final String TIMED_OUT_STATE = "TX_TIMED_STATE";
	public static final String COMPLETED_STATE = "TX_COMPLETED_STATE";
		
	private volatile String state;
	private String thread;
	private long startTime;
	private long timeoutTime;
	
	

	public Transaction(String state, String thread, long startTime,
			long timeoutTime) {
		super();
		this.state = state;
		this.thread = thread;
		this.startTime = startTime;
		this.timeoutTime = timeoutTime;
	}

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
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

	public synchronized String getState() {
		return state;
	}

	public synchronized void setState(String state) {
		this.state = state;
	}
	
	public synchronized void timeout(){
		if (state.equalsIgnoreCase(ACTIVE_STATE)){
			state = TIMED_OUT_STATE;
			TransactionManager.getTransactionManager().timeoutTransaction(this);
		}
	}
	
	public String toString(){
		return "thread="+thread+":state="+state+":start="+startTime+":timeout="+timeoutTime;
	}
}
