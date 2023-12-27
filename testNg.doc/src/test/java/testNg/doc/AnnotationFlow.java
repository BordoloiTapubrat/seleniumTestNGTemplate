package testNg.doc;

import org.testng.annotations.*;

public class AnnotationFlow {
	

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite");
		
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test");
		
	}
	
	@BeforeGroups
	public void beforeGroups()
	{
		System.out.println("Before Groups");
		
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class");
		
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
		
	}
	@Test
	public void test()
	{
		System.out.println("Test");
		
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
		
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
		
	}
	@AfterGroups
	public void afterGroups()
	{
		System.out.println("After Groups");
		
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");
		
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite");
		
	}
	
	

}
