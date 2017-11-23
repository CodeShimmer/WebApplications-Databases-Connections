package com.org.json;
import java.io.*;
import java.util.*;
import org.json.*;

public class JSONUtils {
	public static String getJSONStringFromFile(String path) {
		Scanner scanner;
		InputStream in = JsonEncodeDemo.inputStreamFromFile(path);
		scanner = new Scanner(in);
		String json = scanner.useDelimiter("\\z").next();
		scanner.close();
		return json;
	}
	public static JSONObject getJSONObjectFromFile(String path) {
		return new JSONObject(getJSONStringFromFile(path));
	}

	public static boolean ObjectExists(JSONObject jsonObject, String key) {
		Object o;
		try {
			o=jsonObject.get(key);
			
		} catch(Exception e) {
			return false;
			
		}
		return o!= null;
	}
	
		
}
