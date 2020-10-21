package com.gomso.core.jobqueue;

public interface TaskCallback {

	void onSuccess(Job srcJob);
	void onError(Job srcJob, Throwable e);
	
}
