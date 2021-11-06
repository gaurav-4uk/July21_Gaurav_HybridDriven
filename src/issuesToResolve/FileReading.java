package issuesToResolve;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReading {
	
	public static void main(String[] args) throws IOException {
		File file = new File("./src/issuesToResolve/testing.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		System.out.println(properties.getProperty("file"));
	}
}
