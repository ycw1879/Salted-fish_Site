package com.gomso.core.utils;

public class NumericUtil {


	/**
	 * @param min include number
	 * @param max include number
	 * @return
	 */
	public static int randomRange(int min, int max) {
	    return (int) (Math.random() * (max - min + 1)) + min;
	}
	
	
}
