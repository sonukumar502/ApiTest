package utilities;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RunAPI {
	public static String runAPI(String url) throws UnirestException {
		String responseString=null;
		HttpResponse<String> response=null;
		try {
		if(!url.equals(null)) {
			response=Unirest.get(url).asString();
		}}catch(Exception e){
			
		}
		if(response!=null) {
			responseString=response.getBody();
		}
		else {
			responseString="";
		}
		return responseString;
	} 

}
