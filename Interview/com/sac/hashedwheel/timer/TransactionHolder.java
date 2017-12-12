package com.sac.hashedwheel.timer;


public class TransactionHolder implements TimeoutListener{
	
	private Transaction tx;
	
	public TransactionHolder(Transaction tx){
		this.tx = tx;
	}

	public Transaction getTx() {
		return tx;
	}


	public void setTx(Transaction tx) {
		this.tx = tx;
	}


	public void timeout() {
		tx.timeout();
		
	}
	
	public String toString(){
		return tx.toString();
	}

}
