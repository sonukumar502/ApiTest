package utilities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public class GetAPIDetails {
	public static ArrayList<LinkedHashMap<String, String>> getAPIDetails(String json){
		ArrayList<LinkedHashMap<String, String>> al= new ArrayList<LinkedHashMap<String,String>>();
		if(json!=""){
		JSONObject objA= new JSONObject(json);
		int len=0;
		try {
			len=objA.getJSONArray("data").length();
		}catch(Exception e) {
			//If API contains single data node
			LinkedHashMap<String, String> lhm= new LinkedHashMap<String, String>();
			String b1=objA.getJSONObject("data").toString();
			JSONObject obj1A= new JSONObject(b1);
			lhm.put("id", obj1A.get("id").toString());
			lhm.put("email", obj1A.get("email").toString());
			lhm.put("first_name", obj1A.get("first_name").toString());
			lhm.put("last_name", obj1A.get("last_name").toString());
			lhm.put("avatar", obj1A.get("avatar").toString());
			al.add(lhm);
		}
		//IF API contains multiple data nodes
		for(int i=0;i<len;i++) {
			LinkedHashMap<String, String> lhm= new LinkedHashMap<String, String>();
			String b1=objA.getJSONArray("data").get(i).toString();
			JSONObject obj1A= new JSONObject(b1);
			lhm.put("id", obj1A.get("id").toString());
			lhm.put("email", obj1A.get("email").toString());
			lhm.put("first_name", obj1A.get("first_name").toString());
			lhm.put("last_name", obj1A.get("last_name").toString());
			lhm.put("avatar", obj1A.get("avatar").toString());
			al.add(lhm);
		}}
		return al;
		
	}

}
