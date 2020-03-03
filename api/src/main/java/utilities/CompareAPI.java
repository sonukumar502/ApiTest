package utilities;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.mashape.unirest.http.exceptions.UnirestException;

import junit.framework.Assert;

public class CompareAPI {
	public static boolean compareTwoAPI(String url1, String url2) throws UnirestException {
		boolean flag=false;
		if(!url1.trim().toLowerCase().equals(url2.trim().toLowerCase())) {
		String apiJSON1=RunAPI.runAPI(url1.trim());
		String apiJSON2=RunAPI.runAPI(url2.trim());
		ArrayList<LinkedHashMap<String, String>> api1=GetAPIDetails.getAPIDetails(apiJSON1);
		ArrayList<LinkedHashMap<String, String>> api2=GetAPIDetails.getAPIDetails(apiJSON2);
		if(api1.equals(api2)) {
			System.out.println(url1+" EQUALS "+url2);
			flag=true;
			//Assert.assertTrue(url1+" EQUALS "+url2, flag);
		}else {
			System.out.println(url1+" NOT EQUALS "+url2);
			flag=false;
			//Assert.assertTrue(url1+" NOT EQUALS "+url2, flag);
		}
		}
		else {
			System.out.println(url1+" EQUALS "+url2);
			flag=true;
			//Assert.assertTrue(url1+" EQUALS "+url2, flag);
		}
		//Assert.assertTrue("", flag);
		return flag;
		
	}

}
