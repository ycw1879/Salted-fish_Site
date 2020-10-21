package com.gomso.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class StringUtil {

	public static String arrayToString( String[] arr, String deli ){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append( arr[i] );
			
			if( i < arr.length-1 && deli != null ){
				sb.append(deli);
			}		
		}
		
		return sb.toString();		
	}
	
	
	public static String arrayToString( Object[] arr, String deli ){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append( arr[i] );
			
			if( i < arr.length-1 && deli != null ){
				sb.append(deli);
			}		
		}
		
		return sb.toString();		
	}
	
	
	public static String arrayToString( float[] arr, String deli ){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append( arr[i] );
			
			if( i < arr.length-1 && deli != null ){
				sb.append(deli);
			}		
		}
		
		return sb.toString();		
	}
	

//	public static String[] concatArray(String[][] src) {
//		
//		
//		int fullLength = 0;
//		for(String[] srcArr : src){
//			fullLength += srcArr.length;
//		}
//		
//		String[] arr = new String[fullLength];
//		int idx = 0;
//		for(String[] srcArr : src){
//			for (String string : srcArr) {
//				arr[idx] = string;
//				idx++;
//			}
//		}
//		
//		return arr;
//	}
	

	public static String[] concatArray(String[]...src) {
		
		
		int fullLength = 0;
		for(String[] srcArr : src){
			fullLength += srcArr.length;
		}
		
		String[] arr = new String[fullLength];
		int idx = 0;
		for(String[] srcArr : src){
			for (String string : srcArr) {
				arr[idx] = string;
				idx++;
			}
		}
		
		
		return arr;
	}

	
	public static int getHashCode( String...keys ){
		return arrayToString(keys, null).hashCode();
//		return Arrays.deepHashCode( keys );
//		int myHash = Integer.MAX_VALUE;
//		for (String key : keys) {
//			myHash &= key.hashCode();
//		}
//		return myHash;
	}

	public static String[][] multiplyStringArray(String[]...typeArray) {
			
	//		List<String[]> list = new ArrayList<String[]>();
			
			int headerSize=1;
			for(int i=0; i<typeArray.length; i++ ){
				if( typeArray[i].length == 0 ) continue;
				headerSize *= typeArray[i].length;
			}
			String[][] keyArr = new String[headerSize][typeArray.length];
			
			int unitLoopCount = 1;
			for(int i = typeArray.length-1 ; i >= 0 ; i-- ){
				String[] currentRows = typeArray[i];
				if( typeArray[i].length == 0 ) continue;
				
				int allLoopCount = headerSize / (unitLoopCount*currentRows.length);
				int targetIdx = 0;
				for( int allLoopIdx = 0 ; allLoopIdx < allLoopCount; allLoopIdx++ ){
					for( int fieldIdx = 0 ; fieldIdx < currentRows.length; fieldIdx++  ){
						for( int unitLoopIdx = 0 ; unitLoopIdx < unitLoopCount ; unitLoopIdx++ ){
							keyArr[targetIdx][i] = currentRows[fieldIdx] ;
							targetIdx++;
						}
					}
				}
				
				unitLoopCount *= currentRows.length;				
			}
			
			return keyArr;
		}

	public static int parseInt(String src) {
		int val = 0;
		try{
			val = Integer.parseInt( src.replaceAll(",", "") );
		}catch(Exception e){			
		}
		return val;
	}

	public static long parseLong(String src) {
		long val = 0;
		try{			
			val = Long.parseLong( src.replaceAll(",", "") );
		}catch(Exception e){			
		}
		return val;
	}

	public static double parseDouble(String src) {
		double val = 0;
		try{			
			val = Double.parseDouble( src.replaceAll(",", "") );
		}catch(Exception e){			
		}
		return val;
	}
	public static float parseFloat(String src) {
		float val = 0;
		try{			
			val = Float.parseFloat( src.replaceAll(",", "") );
		}catch(Exception e){			
		}
		return val;
	}
	
	
	@SuppressWarnings("rawtypes")
	public static List splitAndList(String str, String delimeter) {
		return Arrays.asList(str.split(delimeter));
	}
	
	public static String listToString(List<String> list, String delimeter) {
		
		String result = "";
		for( String str : list ) {
			result += str + delimeter;
		}
		return result.substring( result.lastIndexOf(delimeter), 1 );
	}


	public static String formatFilledZero(int val, int length) {
		StringBuilder sb = new StringBuilder(String.valueOf(val));
		while( sb.length() < length ){
			sb.insert(0, "0");
		}
		return sb.toString();
	}


	public static String nullCheck(String src) {
		return src==null?"":src;
	}

	public static String getDateFormatStringByLength(int len) {
		switch( len ) {
			case 17:
				return "yyyyMMddHHmmssSSS";
			case 14:
				return "yyyyMMddHHmmss";
			case 12:
				return "yyyyMMddHHmm";
			case 10:
				return "yyyyMMddHH";
			case 8:
				return "yyyyMMdd";
			case 6:
				return "yyyyMM";
		}
		return "";
	}
	
	public static String getFormattedTime(String str) {
		
		String formattedTime = "";
		SimpleDateFormat wantFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		SimpleDateFormat sourceFormat = new SimpleDateFormat(StringUtil.getDateFormatStringByLength(str.length()));
		if ( "".equals(StringUtil.getDateFormatStringByLength(str.length())) ) {
			return str;
		}
		try {
			Date parsedDate = sourceFormat.parse(str);
			formattedTime = wantFormat.format(parsedDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return str;
		}
		return formattedTime;
	}


	public static String trim(String string) {
		if( string == null ) return null;
		else return string.trim();		
	}


	public static String cutString(String str, int size, String tail) {
		if( str != null && str.length() > size){
			return str.substring(0,size) + tail;
		}else{
			return str;	
		}		
	}
	
	public static String removeDateTimeFormat(String dateTime) {
		return dateTime.replaceAll("-", "").replaceAll(":", "");
	}
	
	public static String removeLastDelimeter(String str, String delimeter) {
		if( str != null && str.length() > 0 ){
			return str.substring(0, str.lastIndexOf( delimeter ) );
		}else{
			return str;	
		}		
	}
	
	
	public static String removeHTML(String htmlString) {
          // Remove HTML tag from java String    
        String noHTMLString = htmlString.replaceAll("\\<.*?\\>", "");

        // Remove Carriage return from java String
        noHTMLString = noHTMLString.replaceAll("\r", "<br/>");

        // Remove New line from java string and replace html break
        noHTMLString = noHTMLString.replaceAll("\n", " ");
        noHTMLString = noHTMLString.replaceAll("\'", "&#39;");
        noHTMLString = noHTMLString.replaceAll("\"", "&quot;");
        return noHTMLString;
    }
	
	
	public static String mailTextToSMSText(String htmlString, int[] stripLines) {
        // Remove HTML tag from java String    
      String noHTMLString = htmlString.replaceAll("<br>", "\n");
      noHTMLString = noHTMLString.replaceAll("</br>", "\n");
      noHTMLString = noHTMLString.replaceAll("<br/><br/>", "\n");
      noHTMLString = noHTMLString.replaceAll("\\<.*?\\>", "");

      // Remove New line from java string and replace html break
      noHTMLString = noHTMLString.replaceAll(" ", "");
      noHTMLString = noHTMLString.replaceAll("\'", "&#39;");
      noHTMLString = noHTMLString.replaceAll("\"", "&quot;");
      
     
      String[] splitted = noHTMLString.split("\n");
      String resultLine = "";
      int lineCount = 0;
      
      for( String line : splitted ) {
    	  outer:
    	  for( int lineNumber : stripLines ) {
        	  if( lineNumber == lineCount++ ) {
        		  continue outer;
        	  }
          }
    	  resultLine += line + "\n";
	  }
      return resultLine;
  }
	
	
	public static String stackToString(Map<Thread, StackTraceElement[]> stackMap) {
		
		Iterator<Thread> iters = stackMap.keySet().iterator();
		StringBuffer sBuf = new StringBuffer();
		while( iters.hasNext() ) {
			Thread t = iters.next();
			StackTraceElement[] eles = stackMap.get(t);
			for( StackTraceElement st : eles ) {
				if( !st.isNativeMethod() && !st.getClassName().startsWith("java.lang.") ) {
					sBuf.append(st.getClassName() + "." + st.getMethodName() + " at : "+ st.getLineNumber()+ "\n" );
				}
			}
		}
		return sBuf.toString();
	}
	
	public static String stackToString(StackTraceElement[] stackMap) {
		
		StringBuffer sBuf = new StringBuffer();
		for( StackTraceElement st : stackMap ) {
			if( !st.isNativeMethod() && !st.getClassName().startsWith("java.lang.") ) {
				sBuf.append(st.getClassName() + "." + st.getMethodName() + " at : "+ st.getLineNumber()+ "\n" );
			}
		}
		return sBuf.toString();
	}
	
	
	public static String changeQueryStringParameter(String queryString, String paramName, String replacement) {
		if( queryString.indexOf("?") > -1 ) {
			queryString = queryString.substring( queryString.indexOf("?") + 1 );
		}
		
		String[] params = queryString.split("&");
		
		
		String replacedQueryString = "";
		for ( String param : params ) {
			String replaced = param + "&";
			
			String fieldName = param.split("=")[0];
			if( fieldName.equals( paramName ) ) {
				replaced = fieldName + "=" + replacement + "&";
			}
			replacedQueryString += replaced;
		}
		
		return removeLastDelimeter(replacedQueryString, "&");
	}
	
	public static String[] splitWithLength(String src, int len) {
		List<String> stringList = new ArrayList<String>();
		if( StringUtils.isEmpty(src) ) {
			return new String[0];
		} else {
			if( src.length() < len ) {
				String[] strs = new String[1];
				strs[0] = src;
				return strs;
			}
			int i = 0;
			String str = "";
			for(; i < src.length(); i++ ) {
				char ch = src.charAt(i);
				
				if( i != 0 && (i % len == 0) && (i+1) != src.length() ) {
					stringList.add(str);
					str = "";
				}
				str += ch;
				if( i+1 == src.length() ) {
					stringList.add(str);
					str = "";
				}
			}
		}
		return stringList.toArray(new String[0]);
	}


	public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }


	public static String formatNumber(long generateTime) {
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(generateTime);
	}
	public static String formatNumber(int generateTime) {
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(generateTime);
	}
	
	public static String getYString(String str) {
		return "X".equals(str) ? "Y" : StringUtils.stripToEmpty(str);
	}
	
	
	/**
	 * 랜덤 문자열 생성
	 * 길이만큼 자름
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length){
		String[] rStrArr = UUID.randomUUID().toString().split("-");
		Arrays.sort(rStrArr);
		
		StringBuffer sb = new StringBuffer();
		for(String str : rStrArr){
			sb.append(str);
		}
		
		int randomIndex = (new Random()).nextInt(sb.length() - length);
		return sb.substring(randomIndex, randomIndex + length);
	}
	
	
	
	
	/**
	 * 문자열 검증 함수
	 */
	
	public enum VALIDATION_WORD{
		ENG, NUMBER, PASSWORD, EMAIL, PHONE
	}
	
	private static Map<VALIDATION_WORD, String> VALIDATION_PATTERN = new HashMap<VALIDATION_WORD, String>(){{
		put(VALIDATION_WORD.ENG, "a-zA-Z");
		put(VALIDATION_WORD.NUMBER, "0-9");
		put(VALIDATION_WORD.PASSWORD, "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$");
		put(VALIDATION_WORD.EMAIL, "^[a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
		put(VALIDATION_WORD.PHONE, "^\\d{3}\\d{3,4}\\d{4}$");
	}};
	
	private static String makePattern(VALIDATION_WORD... patternWord){
		StringBuffer sb = new StringBuffer();
		for(VALIDATION_WORD word : patternWord){
			sb.append(VALIDATION_PATTERN.get(word));
		}
		return sb.toString();
	}
	
	public static boolean isValidation(String validateStr, int minLength, int maxLength, VALIDATION_WORD... patternWords){
		String regex = "";
		if(minLength <= 0){
			regex = makePattern(patternWords);
		}else {
			regex = String.format("^[%s]{%d,%d}$", makePattern(patternWords), minLength, maxLength);
		}
		return Pattern.compile(regex).matcher(validateStr).find();
	}
	// END
	
	public static String errorLogString(String uuid, String errorCode, String msg){
		return String.format("[%s] %s - %s", uuid, errorCode, msg);
	}
}
