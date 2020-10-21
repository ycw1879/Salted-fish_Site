package com.gomso.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

@SuppressWarnings({"unchecked","rawtypes"})
public class MapUtil {
	
	/**
	 * convert ResourceBundle to Map
	 * @param resource
	 * @return
	 */
	public static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
		
		Map<String, String> map = new HashMap<String, String>();
		 
		Enumeration<String> keys = resource.getKeys();
		
		while (keys.hasMoreElements()) {
			
			String key = keys.nextElement();
			map.put(key, resource.getString(key));
			
		}
		 
		return map;
	}
	
	public static Map<String, Object> convertKeyCase( String type, Map<String, Object> map) {
		
		Iterator<String> iters = map.keySet().iterator();
		Map<String, Object> newMap = new HashMap<String, Object>();
		while( iters.hasNext() ) {
			String key = iters.next();
			if( "lower".equals( type ) ) {
				newMap.put( key.toLowerCase(), map.get(key) );
			} else {
				newMap.put( key.toUpperCase(), map.get(key) );
			}
		}
		
		return newMap;
	}
	
	public static List<Map<String, Object>> convertMapListKeyCase( String type, List<Map<String, Object>> list) {
		
		List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
		for( Map<String, Object> map : list ) {
			Iterator<String> iters = map.keySet().iterator();
			Map<String, Object> newMap = new HashMap<String, Object>();
			while( iters.hasNext() ) {
				String key = iters.next();
				if( "lower".equals( type ) ) {
					newMap.put( key.toLowerCase(), map.get(key) );
				} else {
					newMap.put( key.toUpperCase(), map.get(key) );
				}
			}
			newList.add(newMap);
		}
		return newList;
		
	}
	
	/**
	 * null is empty ("") value return
	 * @param map
	 * @param key
	 * @return
	 */
	public static String toString(Map map, String key){
		Object val = map.get(key);
		if( val == null ){
			return "";
		}		
		return val.toString();
	}	
	
	public static String getString(Map map, String key){
		Object val = map.get(key);
		if(val==null){
			return "";
		}		
		return (String) val;
	}
	
	public static int getInt(Map map, String key, int defaultVal){
		Object val = map.get(key);

		int returnVal = defaultVal;
		try{
			if(val instanceof Integer){
				returnVal = ((Integer) val).intValue();
			}else{
				returnVal = Integer.parseInt( val.toString() );	
			}			
		}catch(Exception e){}
		
		return returnVal ;
	}
	
	public static long getLong(Map map, String key){
		Object val = map.get(key);
		return ((Long) val).longValue();
	}
	
	public static float getFloat(Map map, String key, float defaultVal){
		Object val = map.get(key);

		float returnVal = defaultVal;
		try{
			returnVal = Float.parseFloat( val.toString() );
		}catch(Exception e){}
		
		return returnVal ;
	}
	
	public static String getQueryString(Map map) {
		String queryString = "";
		Iterator<String> iters = map.keySet().iterator();
		while( iters.hasNext() ) {
			String key = iters.next();
			queryString += (key + "=" + map.get(key) + "&");
		}
		if( !StringUtils.isEmpty(queryString)) {
			queryString = StringUtil.removeLastDelimeter(queryString, "&");
		}
		return queryString;
	}
	
	
	public static void primitiveToString( Map map ){
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();
			Object val = map.get(key);
			
			if( val instanceof Integer || val instanceof Float || val instanceof Long ){				
				map.put(key, val.toString() );				
			}
		}		
	}
	
	public static Map generateMap( String[] args ){
		if( args == null || args.length % 2 != 0 ){
			return null;
		}
		Map resultMap = new HashMap();
		for ( int i = 1; i < args.length; i += 2 ) {
			String key = args[i - 1];
			String val = args[i];
			resultMap.put(key, val);
		}
		
		return resultMap;
	}

	public static String toString(Map<String, Object> paramMap) {
		StringBuilder sb = new StringBuilder("{");
		
		Iterator<String> keys = paramMap.keySet().iterator();
		while( keys.hasNext() ){
			String key = keys.next();
			Object val = paramMap.get(key);
			sb.append( key + "=" + (val==null?"":val.toString())  );
			sb.append("\n");
		}
		sb.append("}");
		
		return sb.toString();
	}	
}
