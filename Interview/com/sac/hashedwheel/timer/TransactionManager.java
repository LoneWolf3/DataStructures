package com.sac.hashedwheel.timer;

import java.util.HashMap;


public class TransactionManager {
	HashMap<Object, Transaction> threadToTxMap = new HashMap<Object, Transaction>();
	HashMap<Transaction, Object> txToThreadMap = new HashMap<Transaction, Object>();

	private static volatile Object myLock = new Object();
	private static volatile TransactionManager transactionManager;
	private static volatile boolean ready = false;

	public static TransactionManager getTransactionManager() {
		if (!ready) {
			synchronized (myLock) {
				if (!ready) {
					transactionManager = new TransactionManager();
					ready = true;
				}
			}
		}
		return transactionManager;
	}

	public void timeoutTransaction(Transaction tx) {
		// clean up the transaction

	}

	public void startTransaction() {
		Object thread = Thread.currentThread();

		Transaction tx = new Transaction(Transaction.ACTIVE_STATE,
				thread.toString(), System.currentTimeMillis(),
				System.currentTimeMillis() + TimeoutManager.DEFAULT_TIMEOUT);

		threadToTxMap.put(thread, tx);
		txToThreadMap.put(tx, thread);

		TransactionHolder holder = new TransactionHolder(tx);
		TimeoutManager.getTimeoutManager().insertEntry(holder);
	}
}
