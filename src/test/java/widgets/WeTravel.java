package widgets;

import org.openqa.selenium.WebDriver;

import screens.ToDoScreen;


public class WeTravel {
	private final WebDriver driver;

    public WeTravel(WebDriver driver) {
        this.driver = driver;
    }

    public ToDoScreen toDoScreen() { return new ToDoScreen(driver); }

}
