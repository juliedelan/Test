package Test1;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FistClassNG {

	WebDriver driverChrome;
	
	@Parameters({ "username", "password" })
	@Test //this command needed if you want to run this test via TestNG
	public void testLogin(String username, String password) { //begin method
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vaio\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverChrome=new ChromeDriver();
		driverChrome.get("https://login.salesforce.com");
		Assert.assertEquals(driverChrome.getCurrentUrl(), "https://login.salesforce.com/");
	//passing user name by using id finder
	driverChrome.findElement(By.id("username")).sendKeys(username);
	//passing password by using name finder
	driverChrome.findElement(By.name("pw")).sendKeys(password);
	//clicking on submit button by xpath using tag name -- tag name is "input".  xpath need //
	driverChrome.findElement(By.xpath("//input[@name='Login']")).click();
	//catch the error message by cssselector tag name -- tag name is "div" cssselector don't need // and @
	//store the error message in a sting call "errortext"
	String errortext=driverChrome.findElement(By.cssSelector("div[id='error']")).getText();
	
	//print this error message
	String errortext1=errortext+"\n";
	System.out.println(errortext1);
	Assert.assertEquals(errortext, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	//driverChrome.close();
	} // end login  method



@AfterTest
public void closeBrowser(){
	driverChrome.close();
}//end closeBrowser method

} // end class
