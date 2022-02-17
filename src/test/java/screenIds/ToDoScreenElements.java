package screenIds;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement ;
import org.openqa.selenium.support.FindBy;

import widgets.AbstractScreen;


public class ToDoScreenElements extends AbstractScreen{

	public ToDoScreenElements(WebDriver driver) {
		super(driver);
	}

    @FindBy(className="new-todo")
	protected WebElement  NEWTODO;
    
    @FindBy(className="body > section > section > ul > li")
	protected List<WebElement> TODOLIST;
    
    @FindBy(css="body > section > section > ul > li.todo.completed > div > input")
	protected WebElement TODOCOMPLETED;

	@FindBy(css="body > section > section > ul > li:nth-child(1) > div > input")
	protected WebElement TODOITEMCHECKBOX;

	@FindBy(css="body > section > section > ul > li")
	protected List<WebElement>  TODOITEM;

	@FindBy(css="body > section > section > ul > li:nth-child(1) > div > button")
	protected  WebElement DESTROY;

	@FindBy(className="todo")
	protected List<WebElement> ADDEDITEMSLIST;

	@FindBy(css="body > section > section > ul > li.todo.completed")
	protected List<WebElement> DONECHECKBOX;

	@FindBy(css="body > section > section > ul > li:nth-child(1)")
	protected List<WebElement> UNDONECHECKBOX;

}
