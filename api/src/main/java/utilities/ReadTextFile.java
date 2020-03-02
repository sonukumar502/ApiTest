package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {
	public static String[] readTextFile(String fileLocation) throws FileNotFoundException {
		File file1=new File(fileLocation);
		Scanner sc1=new Scanner(file1);
		sc1.useDelimiter("\\Z");
		String sc1Str=sc1.next();
		String[] split1=sc1Str.split("\\r?\\n");
		return split1;
		
	}

}
