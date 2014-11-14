package test.hello.arena;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloArena {
	// Passo 12	
	WebDriver driver = null;
	FluentWait<WebDriver> wait = null;
	final int timeOut = 15;
	final int refreshRate = 1;
	final String initialUrl = "http://google.com/";

	@Before
	public void setUp() throws Exception {
		// Passo 13
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, timeOut).pollingEvery(refreshRate,TimeUnit.SECONDS);
	}

	//Passo 15
	@After
	public void tearDown() throws Exception {
		if(driver != null){
			driver.quit();
		}
	}

	// Passo 16
	@Test
	public void test() {
		//fail("Not yet implemented");
		driver.get(initialUrl);
		findElement(By.name("q")).sendKeys("seleniumhq");
		findElement(By.name("btnG")).click();
		String searchResultTitle = findElement(By.xpath("//h3[@class='r']")).getText();
		Assert.assertEquals("Validando resultado da busca", "Selenium - Web Browser Automation", searchResultTitle);
		findElement(By.xpath("//h3[@class='r']")).click();		
		String siteTitle = findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Validando título do site", "Browser Automation", siteTitle);
	}

	// Passo 14
	private WebElement findElement(By locator){
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}

