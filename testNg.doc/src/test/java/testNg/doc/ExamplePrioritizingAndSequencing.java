package testNg.doc;

import org.testng.annotations.Test;


//By Default @Test executes Alphabetically
//Priority Starts from 0 to 5

public class ExamplePrioritizingAndSequencing {
	
	@Test(priority=4,description="Test1 - Priority 4", enabled=true)
	public void Test1()
	{
		System.out.println("Test1 - Priority 4");
	}

	@Test(priority=3,description="Test2 - Priority 3", enabled=true)
	public void Test2()
	{
		System.out.println("Test2 - Priority 3");
	}

	
	@Test(priority=2,description="Test3 - Priority 2", enabled=true)
	public void Test3()
	{
		System.out.println("Test3 - Priority 2");
	}

	
	@Test(priority=0,description="Test4 - Priority 0", enabled=true)
	public void Test4()
	{
		System.out.println("Test4 - Priority 0");
	}

}
