package widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public abstract class SeleniumDriverBuilder<SELF, DRIVER extends WebDriver> {

    protected WebDriver driver;
    
    public static LocalDriverBuilder forLocal() {
        return new LocalDriverBuilder();
    }

    public static class LocalDriverBuilder extends SeleniumDriverBuilder<LocalDriverBuilder, WebDriver> {

		public WebDriver build(){
        	DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("key", System.getProperty("key"));
			capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability("nativeEvents", false);
			capabilities.setCapability("unexpectedAlertBehaviour", "accept");
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			capabilities.setCapability("disable-popup-blocking", true);
			capabilities.setCapability("enablePersistentHover", true);
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			return driver = new ChromeDriver(capabilities);
        }

    }
    public abstract WebDriver build() throws Exception;
}
