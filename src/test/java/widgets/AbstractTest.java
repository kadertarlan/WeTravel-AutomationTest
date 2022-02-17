package widgets;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


public abstract class AbstractTest {

	protected WeTravel app;
	protected WebDriver driver;
	public static String baseUrl;


    @Before
    public void setUp() {

		baseUrl = "https://todomvc.com/examples/vue/";

		this.driver = SeleniumDriverBuilder.forLocal().build();
		app = new WeTravel(this.driver);

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

    @After
    public void tearDown() {
        driver.quit();
    }
}