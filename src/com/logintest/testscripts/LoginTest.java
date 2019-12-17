package com.logintest.testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.logintest.pages.LoginPage;
import com.logintest.util.ExcelDataOperations;



public class LoginTest extends TestMethods
{	
	
	@Test (dataProvider = "ExcelReadForLogin")
	public void loginTest(String uname, String pwd, String expectedResult, String browser) throws IOException
	{	
		System.out.println(uname + ":" + pwd);
		System.out.println("Start : Login Test");
		
		initialize(browser);
		LoginPage loginpage = login();
		loginpage.login(uname, pwd);
		
//		String actualResult = LoginPage.checkLogin();
//		
//		Assert.assertTrue(actualResult.contains(expectedResult));
		Assert.assertTrue(LoginPage.checkLogin());

	}

	@DataProvider(name = "ExcelReadForLogin")
	public String[][] provideLoginTestDataFromExcel() throws IOException {


		String[][] data = ExcelDataOperations.getData("./src/com/logintest/resources/LoginTestData.xlsx",
				"Data");
		return data;

	}

	
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			String status = "fail";
			takeScreenShot(result.getMethod().getMethodName(), status);
		}
		teardown();
	}

	
	
}
