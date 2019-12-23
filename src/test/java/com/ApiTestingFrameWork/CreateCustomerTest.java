package com.ApiTestingFrameWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ApiBase.BaseTest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateCustomerTest extends BaseTest {
	@Test(dataProviderClass = DataProvider.class ,dataProvider = "Data")
	public void validateCreateCustomer(String name,String email,String description) {
		
		Response post = given().auth().basic(configs.getProperty("validSecretKey"), "").formParam("name",name ).
		formParam("email", email).
		formParam("description", description).post(configs.getProperty("customerAPIEndPoint"));
		
		post.prettyPrint();
		System.out.println(post.statusCode());
	}
		
		@Test(dataProviderClass = DataProvider.class ,dataProvider = "Data")
		public void InvalidateCreateCustomer(String name,String email,String description) {
			
			Response post = given().auth().basic(configs.getProperty("InvalidSecretKey"), "").formParam("name",name ).
			formParam("email", email).
			formParam("description", description).post(configs.getProperty("customerAPIEndPoint"));
			
			post.prettyPrint();
			System.out.println(post.statusCode());
		
		
		
	}
		// Below code is usesful when v have only test case with single sheetname 
	/*@DataProvider
	public Object[][] getData() {
		
		  String SheetName="APITest"; 
		  int rowCount = excel.getRowCount(SheetName);
		  int columnCount = excel.getColumnCount(SheetName);
		 
		Object[][] data= new Object[rowCount-1][columnCount];
		
		for (int RowNum = 2; RowNum <= rowCount; RowNum++) {
			for (int ColumnNum = 0; ColumnNum < columnCount; ColumnNum++) {
				data[RowNum-2][ColumnNum] = excel.getCellData(SheetName, ColumnNum, RowNum);
				
			}
			
			
		}
		
		
		return data;*/
		
		
	}
	


