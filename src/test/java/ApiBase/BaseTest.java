package ApiBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;


import io.restassured.RestAssured;
import utilities.ExcelReader;

public class BaseTest {
public	Properties configs= new Properties();
private FileInputStream fis;
public static ExcelReader excel= new ExcelReader(".\\src\\test\\resources\\excel\\TestData.xlsx");
	
	@BeforeSuite
	public void setUp() throws IOException {
		
	 fis=new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
		configs.load(fis);
		RestAssured.baseURI=configs.getProperty("baseURI");
		RestAssured.basePath=configs.getProperty("basePath");
		
	}
	
public void tearDown() {
	
}
}
