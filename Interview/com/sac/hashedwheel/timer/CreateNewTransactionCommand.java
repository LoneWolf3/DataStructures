package com.sac.hashedwheel.timer;


public class CreateNewTransactionCommand implements Command{

	public void process() {
		TransactionManager.getTransactionManager().startTransaction();		
	}

}
