package com.gomso.core.utils;


import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings({"unchecked","rawtypes","unused"})
@Slf4j
public class JsonBuilder {

	

	private JsonBuilder(){
	}

	
/*
	public static List jsonArrayToList(JSONArray srcJson) throws JSONException {

		List list = new ArrayList();
		
		for(int i=0 ; i< srcJson.length() ; i++){

			Object obj = srcJson.get(i);
			
			if( obj instanceof String ){
				list.add( obj );				
			}else if( obj instanceof JSONObject ){
				list.add( jsonObjectToMap( (JSONObject)obj) );				
			}else if( obj instanceof JSONArray ){
				JSONArray arr = (JSONArray)obj;				
				list.add( jsonArrayToList(arr) );
			}			
		}
		
		return list;
	}*/
	/*
	public static Map<String,Object> jsonObjectToMap(JSONObject srcJson) throws JSONException {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		Iterator keys = srcJson.keys();
		while( keys.hasNext()){
			String key = (String)keys.next();

			
			Object obj = srcJson.get(key);

			if( obj instanceof JSONObject ){
				map.put(key, jsonObjectToMap( (JSONObject)obj)  );
			}else if( obj instanceof JSONArray ){
				JSONArray arr = (JSONArray)obj;				
				map.put(key, jsonArrayToList(arr));

			}else{
				map.put(key, obj);
			}
		}
				
		return map;
	}
*/
	/*
	public static Map parseJsonStringToMap(String jsonSourceString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonSourceString);
		Map returnMap = jsonObjectToMap( jsonObject ); 
		return returnMap;		
	}
	*/
/*
	public static String parseMapToJsonString(Map sourceMap) throws JSONException {
		removeNullValue(sourceMap);
		JSONObject jsonObject = new JSONObject(sourceMap);		 
		return jsonObject.toString();		
	}*/
	/*
	public static String parseCollectionToJsonString(Collection collecion ) throws JSONException {
		
		JSONArray jsonObject = new JSONArray(collecion);
//		JSONObject jsonObject = new JSONObject(collecion);		 
		return jsonObject.toString();		
	}*/


	public static String printPretty( String jsonString ){
		ObjectMapper mapper = new ObjectMapper();
		Object json;
		try {
			json = mapper.readValue(jsonString, HashMap.class);
			String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
			return indented;
		} catch (Exception e) {
			e.printStackTrace();
		} 		
		return null;
	}

	private static void removeNullValue(Map sourceMap) {
		if( sourceMap == null ){
			throw new IllegalArgumentException("JsonBuilder removeNullValue :: parameters is null");
		}
		Iterator ks = sourceMap.keySet().iterator();
		while ( ks.hasNext() ) {
			String k = (String) ks.next();
			Object val = sourceMap.get(k);
			if( val == null && val instanceof String ){
				sourceMap.put(k, "");
			}
		}
	}



	public static String objectToJson(Object obj) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(obj);
		return jsonInString;
	}

}


