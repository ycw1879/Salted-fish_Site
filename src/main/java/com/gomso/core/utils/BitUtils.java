package com.gomso.core.utils;

public class BitUtils {

	
	public static String wrapZeroString(String i, int len) {
		String a = i;
		int curLen = i.length();
		if( curLen < len ) {
			for( ; curLen < len; curLen++ ) {
				a = "0" + a;
			}
		}
		return a;
	}
	
	public static boolean bitsAreOne(int op1, int op2) {
		
		String max = Integer.toBinaryString( Math.max(op1, op2) );
		
		String op1String = wrapZeroString(Integer.toBinaryString(op1), max.length());
		String op2String = wrapZeroString(Integer.toBinaryString(op2), max.length());
		
		for( int i = 0; i < op1String.length(); i++ ) {
			char op1Char = op1String.charAt(i);
			if( op1Char == '1' ) {
				if( op1Char == op2String.charAt(i) ) return true;
			}
		}
		return false;
	}
	
	
}
