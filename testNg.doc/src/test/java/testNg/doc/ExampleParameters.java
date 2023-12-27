package testNg.doc;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExampleParameters {
	
	@Test
	@Parameters({"userName","password"})
	public void TestA(String userName, String password)
	{
		System.out.println("Sending Parameters");
		System.out.println("UserName "+userName);
		System.out.println("Password "+password);
		
	}
	
	@Test
	@Parameters({"uName","pword"})
	public void TestB(String uName, String pword)
	{
		System.out.println("Sending Parameters");
		System.out.println("UserName "+uName);
		System.out.println("Password "+pword);
		
	}

}
