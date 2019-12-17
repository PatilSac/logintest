package com.logintest.pages;
import java.util.Properties;
import org.openqa.selenium.By;
import com.logintest.constants.ConstantPath;
import com.logintest.util.FileOperations;
import com.logintest.base.PredefinedMethods;

public class LoginPage extends PredefinedMethods {
	
	private static LoginPage loginpage = null;
	private static Properties prop;
	
	private LoginPage(){
		prop = FileOperations.LoadFile(ConstantPath.loginProperties);
	}
	
	public static LoginPage getInstance()
	{
		if(loginpage == null)
			loginpage = new LoginPage();
		return loginpage;
	}
	

	
	public static Boolean checkLogin()
	{
		if(!driver.findElements(By.xpath(prop.getProperty("successcheck"))).isEmpty()){
	        return true;
	    }else{
	        return false;
	    }		

//		********** Alternate code **********
//		
//		try 
//		{
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));
//		driver.findElement(By.xpath("//div[@class='product_label']"));
//		System.out.println("Element Found");
//		    
//		return "Success!";
//		    
//		} catch (NoSuchElementException e) 
//		{
//		    System.out.println("Element Not Found");
//		    return "Failed";
//		}
		
		  
	}
	
	
	public void login(String uname, String pwd)
	{
		enterUserName(uname);
		enterPassword(pwd);
		clickLoginButton();
	}
	
	private void enterUserName(String uname) {
		//setText(prop.getProperty("uname"),"xpath", uname);
		driver.findElement(By.xpath(prop.getProperty("uname"))).sendKeys(uname);
		System.out.println("Username entered");

	}
	
	private void enterPassword(String password) {
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(password);
		System.out.println("Password entered");

	}

	private void clickLoginButton() {
		//click(prop.getProperty("loginbutton"), "xpath");
		driver.findElement(By.xpath(prop.getProperty("loginbutton"))).click();
		System.out.println("Login button clicked");
	}
	
	
	
	
}
