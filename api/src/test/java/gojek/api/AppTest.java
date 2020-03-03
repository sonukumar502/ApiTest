package gojek.api;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import com.mashape.unirest.http.exceptions.UnirestException;

import utilities.CompareAPI;
import utilities.ReadTextFile;


public class AppTest {
	ArrayList<String> allTestForRun1 = new ArrayList<String>();
	ArrayList<String> allTestForRun2 = new ArrayList<String>();
	ArrayList<String> allTestForRun3 = new ArrayList<String>();
	ArrayList<String> allTestForRun4 = new ArrayList<String>();
	ArrayList<String> allTestForRun5 = new ArrayList<String>();
	ArrayList<String> allTestForRun1a = new ArrayList<String>();
	ArrayList<String> allTestForRun2a = new ArrayList<String>();
	ArrayList<String> allTestForRun3a = new ArrayList<String>();
	ArrayList<String> allTestForRun4a = new ArrayList<String>();
	ArrayList<String> allTestForRun5a = new ArrayList<String>();
	int totalIterations = 0;
	long start=0;
	long end=0;
	
	//Generic method to be called in all the tests
	public boolean executor(ArrayList<String> list1,ArrayList<String> list2) throws UnirestException {
		boolean flag=false;
		for(int i=0;i<list1.size();i++) {
			flag=CompareAPI.compareTwoAPI(list1.get(i), list2.get(i));
			}
		return flag;
	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		start = System.currentTimeMillis(); 
		String currentDirectory = System.getProperty("user.dir");
	    String[] file1 = ReadTextFile.readTextFile(currentDirectory+"//src//resources//file1.txt");
		String[] file2 = ReadTextFile.readTextFile(currentDirectory+"//src//resources//file2.txt");
		
		//Getting the count for number of url comparisons
		if (file1.length >= file2.length) {
			totalIterations = file2.length;
		} else {
			totalIterations = file1.length;
		}
		
		//Splitting the urls to 5 parts so that we can run them in parallel
		for (int i = 0; i < totalIterations; i++) {
			if (i % 5 == 0) {
				allTestForRun1.add(file1[i]);
				allTestForRun1a.add(file2[i]);
			}
			if (i % 5 == 1) {
				allTestForRun2.add(file1[i]);
				allTestForRun2a.add(file2[i]);
			}
			if (i % 5 == 2) {
				allTestForRun3.add(file1[i]);
				allTestForRun3a.add(file2[i]);
			}
			if (i % 5 == 3) {
				allTestForRun4.add(file1[i]);
				allTestForRun4a.add(file2[i]);
			}
			if (i % 5 == 4) {
				allTestForRun5.add(file1[i]);
				allTestForRun5a.add(file2[i]);
			}
		}

	}

	@Test
	public void test1() throws UnirestException {
		AppTest at= new AppTest();
		boolean flag=at.executor(allTestForRun1, allTestForRun1a);
		Assert.assertTrue(flag);
	}
	@Test
	public void test2() throws UnirestException {
		AppTest at= new AppTest();
		boolean flag=at.executor(allTestForRun2, allTestForRun2a);
		Assert.assertTrue(flag);
	}
	@Test
	public void test3() throws UnirestException {
		AppTest at= new AppTest();
		boolean flag=at.executor(allTestForRun3, allTestForRun3a);
		Assert.assertTrue(flag);
	}
	@Test
	public void test4() throws UnirestException {
		AppTest at= new AppTest();
		boolean flag=at.executor(allTestForRun4, allTestForRun4a);
		Assert.assertTrue(flag);
	}
	@Test
	public void test5() throws UnirestException {
		AppTest at= new AppTest();
		boolean flag=at.executor(allTestForRun5, allTestForRun5a);
		Assert.assertTrue(flag);
	}
	
	@AfterTest
	public void afterTest(){
		end = System.currentTimeMillis(); 
		System.out.println("Total Urls Compared: "+totalIterations);
		System.out.println("Total Execution Time: "+(end-start)/1000+" secs");
	}
}
