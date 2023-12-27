package testNg.doc;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleDataProviderExcel {
	
	
	//This method will provide data.
	//This method can call other method which is responsible for reading excel data
	//It is named as "provideTestData"
	@DataProvider(name = "provideTestData")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "Cedric", 36 },
	   { "Anne", 37},
	 };
	}
	
	//Parameters is equal to number of columns
	@Test(dataProvider = "provideTestData")
	public void Test_TakeData_From_DataProvider(String Data1, int Data2)
	{
		System.out.println("Reading Data From Data Provider");
		System.out.println("Data1 "+Data1);
		System.out.println("Data2 "+Data2);
		
		Reporter.log("Data1 "+Data1);
	}


}
