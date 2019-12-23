package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import ApiBase.BaseTest;

public class DataUtility extends BaseTest{
	// we created seperate utility here and it is very effective for multiple test data with different sheet name
	// to get sheet name give method name and sheet name same and use method.
	@DataProvider(name="data")
	public Object[][] getData(Method m) {
		String SheetName = m.getName();
		  int rowCount = excel.getRowCount(SheetName);
		  int columnCount = excel.getColumnCount(SheetName);
		 
		Object[][] data= new Object[rowCount-1][columnCount];
		
		for (int RowNum = 2; RowNum <= rowCount; RowNum++) {
			for (int ColumnNum = 0; ColumnNum < columnCount; ColumnNum++) {
				data[RowNum-2][ColumnNum] = excel.getCellData(SheetName, ColumnNum, RowNum);
				
			}
			
		}
	
return data;
	}
}
