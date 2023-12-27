package testNg.doc;

import org.testng.Assert;

import org.testng.annotations.Test;


public class ExampleListeners_Interface {
	
	@Test  
	public void sum()  
	{  
	int sum=0;  
	int a=5;  
	int b=7;  
	sum=a+b;  
	System.out.println("The sum is "+sum);  
	}  
	@Test  
	public void testtofail()  
	{  
	System.out.println("Test case has been failed");  
	Assert.assertTrue(false);  
	}  

}
