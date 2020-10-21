package com.gomso.core.jobqueue;

@SuppressWarnings("serial")
public class JobQueueOverflowException extends Exception {

	public JobQueueOverflowException() {
		super();
	}
	
	public JobQueueOverflowException(String msg) {
		super(msg);
	}
	
	

}
