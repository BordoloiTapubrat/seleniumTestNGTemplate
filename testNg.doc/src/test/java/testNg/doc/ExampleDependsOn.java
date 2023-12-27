package testNg.doc;

import org.testng.annotations.Test;

public class ExampleDependsOn {
	
	@Test(dependsOnMethods = {"parentFunction"})
	public void childFunction()
	{
		System.out.println("Child Function Excecute Second");
	}
	
	@Test
	public void parentFunction()
	{
		System.out.println("Parent Function Execute First");
	}
	
	@Test(dependsOnMethods = {"childFunction"})
	public void child2Function()
	{
		System.out.println("Child 2 Function Execute Third");
	}

}
