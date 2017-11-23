package com.org.json;

import java.io.InputStream;

public class JsonEncodeDemo {

   public static InputStream inputStreamFromFile(String path){
	   try {
		   InputStream inputStream = JsonEncodeDemo.class.getResourceAsStream(path);
		   return inputStream;
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
	   return null;
   }
}