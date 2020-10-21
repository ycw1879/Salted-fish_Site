package com.gomso.core.jobqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JobQueue {
	
	
	private String name;
	private int workerSize;
	private int queueMaxSize;
	
	private List<Job> queue;
	private Map<Job, TaskCallback> callbackMap;	
		
	private List<Worker> workers;
	private boolean keepGoing = false;
		
	
	public JobQueue(String name, int queueMaxSize, int workerSize) {
		this.name = name;		
		this.queueMaxSize = queueMaxSize;
		this.workerSize = workerSize;
		log.debug( String.format(" JobQueue[%s] is created.  QueueSize=%d, Worker=%d ", name, queueMaxSize, workerSize) );
		
		queue = new ArrayList<Job>();
		callbackMap = new HashMap<Job, TaskCallback>();
		workers = new ArrayList<Worker>();
	}
	
	
	public int getMax() {
		return queueMaxSize;
	}

	public void start(){
		synchronized (queue) {
			keepGoing = true;
			
			for (int i = 0; i < workerSize ; i++) {
				Worker aWorker = new Worker( this , "JobQueueWorker[" + name + "-"  + (i+1) + "]" ); 
				workers.add( aWorker );
				aWorker.setDaemon(true);
				aWorker.start();
			}			
		}
	}

	public void stop(){
		synchronized (queue) {
			this.keepGoing = false;
			queue.clear();
			queue.notifyAll();
		}
	}
	
	
	public void push(Job job) throws JobQueueOverflowException {
		push(job, null);
	}



	public void push(Job job , TaskCallback taskCallback) throws JobQueueOverflowException {
		
		synchronized (queue) {
			
			if( queue.size() >= queueMaxSize ){				
				throw new JobQueueOverflowException("Current Queue Size : " + queue.size() );				
			}
			queue.add(job);
			
			if( taskCallback != null ) callbackMap.put(job, taskCallback);
			
			queue.notifyAll();	//Job은 하나씩 요청                                                                                                                                                                                                                                                                                                                                                                                     되기 때문에 notifyAll()을 할 필요가 없다.
		}
	}
	
	public int getWaitingCount() {
		int waiting = 0; 
		synchronized (queue) {
			waiting = queue.size();
		}		
		return waiting;
	}
	
	public int getIdleCount() {		
		int count = 0; 
		synchronized (queue) {
			count = queueMaxSize - queue.size();
		}		
		return count;
	}

	
	

	/**
	 * Worker Class
	 *
	 */
	class Worker extends Thread {
		
		
//		JobQueue jobQueue;
		String name;

		public Worker(JobQueue jobQueue, String name) {
//			this.jobQueue = jobQueue;
			super(name);
			this.name =  name;
			
		}
		
		@Override
		public void run() {
		
			log.debug( name + " is started.");
			Job aJob = null;
			
			while(keepGoing){
				aJob = null;
				
				synchronized( queue ){
					if( queue.size() > 0  ) {
						aJob = queue.remove(0);
					}else {
						try {
							log.debug(name + " is waiting...");
							queue.wait();
							log.debug(name + " is awakened. ");
						} catch (InterruptedException e) {
							log.debug(name + " is awakened.(Interrupted) ");
						}
					}
				}
				

				
				try{					
					
					if( aJob != null ){
						log.debug( name + " recieved Job ");
						aJob.execute();
						
						TaskCallback callback = callbackMap.remove(aJob);
						if(callback!=null) callback.onSuccess( aJob );
					}
					
				}catch(Exception e){
					try{
						if( aJob != null ){
							TaskCallback callback = callbackMap.remove(aJob);
							if(callback!=null) callback.onError( aJob, e );							
						}
					}catch(Exception ie){
						//TOOD:logg
					}
					
				}finally {
				}

				
			}
			
			
			log.debug( name + " terminate.");
		}
	}
	
	

	public void contextInitialized() {
		this.start();		
		log.info(String.format("JobQueue[%s] is contextInitialized !! ", name ));
	}
	
	
	public void contextDestroyed() {		
		this.stop();
		log.info(String.format("JobQueue[%s] is contextDestroyed !! ", name ));
	}	

	
}
