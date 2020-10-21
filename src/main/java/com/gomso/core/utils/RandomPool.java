package com.gomso.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <pre>
 *
 * </pre>
 * @version 1.0 Since 2014. 3. 21.
 */
public class RandomPool <T> {
	
	private int totalChance = 0;				
	private List<Integer> chanceRange = new ArrayList<Integer>();
	private List<T> pool = new ArrayList<T>(); 

	public void add(T obj, int chance) {
		if(chance <= 0 ) return;
		
		pool.add(obj);
		chanceRange.add( totalChance + chance );
		
		totalChance += chance;
	}
	
	public T get(){
		int targetIndex = getMin();
//		System.out.println("TargetIndex = " + targetIndex );
		if( targetIndex < 0 ) return null; 
		return pool.get(targetIndex);
	}

	private  int getMin(  ){
		if( totalChance <= 0 ) return -1;
		
		Random rand = new Random();								
		int targetPoint = rand.nextInt(totalChance)  ; // 0 ~ totalChance-1 사이의 값.				
		
		for (int i = 0; i < chanceRange.size() ; i++) {
			int max = chanceRange.get(i);
			if( max >= targetPoint ){
				return i;
			}
		}
		return -1;
	}

}
