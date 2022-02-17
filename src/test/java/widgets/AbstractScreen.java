package widgets;

import java.awt.Toolkit;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class AbstractScreen {

	protected static WebDriver driver;

	public AbstractScreen(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}

    //send keys element
	public WebElement elementSendKeys(WebElement id, String string) {
    	WebElement element = waitForElement(1, id);
		element.clear();
		element.sendKeys(string);
		sleep(1000);
		return element;
	}
	
   	//wait
   	public WebElement waitForElement(int seconds, WebElement element ) {
   		WebDriverWait wait = new WebDriverWait(driver, seconds, 1000);
   		return wait.until(ExpectedConditions.elementToBeClickable(element));
   	}

    //move to pagedown
	public void moveToUntilSee( WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		sleep(500);
	}

	//select object
	public WebElement selectObject(WebElement element, String value) {
		new Select(element).selectByVisibleText(value);
		return element;
	}

	//click object
	public WebElement elementClick(WebElement element) {
//		waitForElement(3,element);
		sleep(2000);
		element.click();
		sleep(3000);
		return element;
	}
	
	//check visible
	public boolean checkVisible(By by) {
		sleep(2000);
		return driver.findElement(by).isDisplayed();
	}

	//get current url
	public String getCurrentUrl() {
		return driver.getCurrentUrl().trim().toString();
	}

	//go back
	public void goBack() {
		driver.navigate().back();
	}

	//sleep
	public void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}

	public void scrollDownPageUntilView(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
     	js.executeScript("window.scrollTo(0, document.body.scrollHeight/150);");
     	sleep(3000);

	}

	public void scrollUpPage(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}
	
	public void scrollDownPage(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
     	js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}
	
	public void executeJavascript(String script, Object... obj) {
		((JavascriptExecutor) driver).executeScript(script, obj);
	}
	
	public boolean isThere(WebElement element){
		try {
			waitForElement(3, element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementPresentAndDisplay(WebElement element) {
		sleep(1000);
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}


	public void waitForElement(WebDriver driver, int seconds, By elementBy) {
		WebDriverWait wait = new WebDriverWait(driver, seconds, 5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
	}

	public boolean isClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void waitElementClickable(By by){
		WebElement element = (new WebDriverWait(driver, 5))
				   .until(ExpectedConditions.elementToBeClickable(by));
	}


	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		sleep(1000);
	}


	public Object randomGenerate(List<String> list) {
		Random r = new Random();
		int i = r.nextInt(list.size());
		return list.get(i);
	}
	
	public void maximizeScreen(WebDriver driver) {
	    java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Point position = new Point(0, 0);
	    driver.manage().window().setPosition(position);
	    Dimension maximizedScreenSize =
	        new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
	    driver.manage().window().setSize(maximizedScreenSize);
	}
}
