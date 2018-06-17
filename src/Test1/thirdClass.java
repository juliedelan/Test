package Test1;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class thirdClass {

public WebDriver driverChrome;
	
@BeforeTest
public void setUP (){
			
			// set chrome driver"
					System.setProperty("webdriver.chrome.driver","C:\\Users\\Vaio\\Downloads\\chromedriver_win32\\chromedriver.exe");
					driverChrome= new ChromeDriver();
					//go to expedia website
					driverChrome.get("http://qaclickacademy.com/practice.php");
						//FindLinksAndPrint validateInput= new FindLinksAndPrint();
			//validateInput.findAllLinks(driverChrome);
			//validateInput.findFooterLinks(driverChrome);
			//driverChrome.close();
					
		}//end setup

		
@Test		
public void findAllLinks()
		
		{
			//Maximize window		    
		    driverChrome.manage().window().maximize() ;
			List<WebElement> Alllinks= driverChrome.findElements(By.tagName("a"));
			int linkNumber= Alllinks.size();
			System.out.println(linkNumber);
			for(int i=0; i<linkNumber; i++)
			{
				//get each element and get the text of it
				String s= Alllinks.get(i).getText();
				System.out.println(s);
			}//end for
								
		}//end method findAllLinks

@Test
public void findFooterLinks ()
		
		{
			//find the footer and return as 
			WebElement footerElement = driverChrome.findElement(By.id("gf-BIG"));
			
			List<WebElement> footerLinks= footerElement.findElements(By.tagName("a"));
			int numlink= footerLinks.size();
			System.out.println(numlink);
			
			for(int j=0; j<numlink; j++) {
				//get all links hrefs inside the a
				String l= footerLinks.get(j).getAttribute("href");
				System.out.println(l);
			}//end for
			
		}//end findFooterLinks method
		
@AfterTest
public void closeBrowser() {
driverChrome.quit();
}

	}//end class

