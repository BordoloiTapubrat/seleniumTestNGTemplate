package com.implement.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListernerImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart() - "+result.getName());  
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccess() -  "+result.getName());  
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailure() - "+result.getName());  
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSkipped() - "+result.getName());  
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage() - "+result.getName());  
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedWithTimeout() - "+result.getName());  
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart() "+context.getName());  
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onFinish() "+context.getName());  
	}
	
	

}
