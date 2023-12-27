package testNg.doc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Example_Assertions {
	
	@Test
	public void testCaseA()
	{
		
		Assert.assertTrue(true);
		Assert.assertEquals(1, 1);
		Assert.assertFalse(false);
		
	}

}
