package com.gomso.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArrayUtil {

	
	public static String[] removeDuplicateValue(String[] values) {
		Map<String, String> valueMap = new HashMap<String, String>();
		for( String value : values ) {
			if( !StringUtils.isEmpty(value.trim()) ) {
				valueMap.put(value, value);
			}
		}
		return valueMap.keySet().toArray(new String[0]);
	}
	
	public static String toString(String[] values) {
		String valueString = Arrays.toString(values);
		return valueString.substring( 1, valueString.length()-1 );
	}
	
	public static String removeDuplicateValues(String[] values) {
		return toString( removeDuplicateValue(values) );
	}
	
	public static String removeDuplicateValues(String valueString, String delimeter) {
		if(StringUtils.isEmpty(valueString)) return "";
		String[] arr = removeDuplicateValue(  StringUtils.splitPreserveAllTokens( valueString, delimeter) );
		Arrays.sort(arr);
		
		return toString(arr);
	}
	
	public static int[] toIntArray(String[] strArr){
		int[] arr = new int[strArr.length];
		for(int i=0; i< strArr.length ; i++){
			try{
				arr[i] = Integer.parseInt( strArr[i] );	
			}catch(Exception e){
				arr[i] = 0;
			}
			
			
		}
		return arr;
	}

	public static int[] toIntArray(List<String> daubedIndex) {
		int[] arr = new int[daubedIndex.size()];
		for(int i=0; i< daubedIndex.size() ; i++){
			try{
				arr[i] = Integer.parseInt( daubedIndex.get(i) );	
			}catch(Exception e){
				arr[i] = 0;
			}
			
			
		}
		return arr;
	}
	
}
