package testNg.doc;

import org.testng.annotations.Test;

public class ExampleGrouping {
	
	@Test(groups={"regression"})
	public void regression1()
	{
		System.out.println("Regression_1");
	}
	
	
	@Test(groups={"smoke"})
	public void smoke1()
	{
		System.out.println("smoke_1");
	}
	
	@Test(groups={"functional"})
	public void functional1()
	{
		System.out.println("functional_1");
	}
	
	@Test(groups={"regression"})
	public void regression2()
	{
		System.out.println("Regression_2");
	}
	
	@Test(groups={"smoke","regression"})
	public void smoke2()
	{
		System.out.println("smoke_2");
	}
	
	@Test(groups={"functional"})
	public void functional2()
	{
		System.out.println("functional_2");
	}
	
	@Test(groups={"regression"})
	public void regression3()
	{
		System.out.println("Regression_3");
	}
	
	@Test(groups={"functional"})
	public void functional3()
	{
		System.out.println("functional_3");
	}

}
