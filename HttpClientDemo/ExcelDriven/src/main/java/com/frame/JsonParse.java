package com.frame;


import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonParse {
	public static String parsejson(String Str, String key) {
		JsonElement je = new JsonParser().parse(Str);
		String result = null;
		String[] separate = key.split(",");
		try {
			for (int i = 0; i < separate.length; i++) {
				je = je.getAsJsonObject().get(separate[i]);

			}
		} catch (Exception e) {
			System.out.println("Got a Exception：" + e.getMessage());
			e.printStackTrace();
		}

		result = je.toString();
		return result;
	}

//	public static void main(String[] args) {
//		String result = parsejson("abc","a");
//		System.out.println(result);
//	}
}

