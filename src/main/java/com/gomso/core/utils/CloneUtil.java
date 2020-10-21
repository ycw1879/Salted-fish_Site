package com.gomso.core.utils;
import com.rits.cloning.Cloner;

public class CloneUtil {
	private static Cloner cloner = new Cloner();
	
	public static <T> T deepClone(T o){
		return cloner.deepClone(o);
	}
}
