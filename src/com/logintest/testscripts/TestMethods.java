package com.logintest.testscripts;

import com.logintest.base.PredefinedMethods;
import com.logintest.pages.LoginPage;

public class TestMethods {
	
	void initialize(String browser)
	{
		PredefinedMethods.start(browser);
	}
	
	void teardown()
	{
		PredefinedMethods.close();
		
	}
	
	void takeScreenShot(String name, String status)
	{
		PredefinedMethods.takeScreenShot(name,status);
		
	}
	LoginPage login()
	{
		//RegistrationPage registration = new RegistrationPage();
		LoginPage login = LoginPage.getInstance();
		
		return login;
	}

}
