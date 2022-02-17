package screens;
import static org.junit.Assert.*;
import static testdatas.UIConstants.FIRSTITEM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import screenIds.ToDoScreenElements;

public class ToDoScreen extends ToDoScreenElements {

	//methods
	public ToDoScreen(WebDriver driver) {
		super(driver);
	}

	public ToDoScreen isToDoScreen(){
		assertTrue("Todo screen is not visible.", isThere(NEWTODO));
		return this;
	}
	
	public ToDoScreen addToDoItem(String item) {
		elementSendKeys(NEWTODO,item).sendKeys(Keys.ENTER);
  		return this;
	}
	
	public void checkAddedItemOnToDoList(String item){
		assertEquals("Item is  not visible in todo list",TODOITEM.get(FIRSTITEM).getText(), item );
	}

	public ToDoScreen deleteAddedAllItems(){
		//for(WebElement itemDeleteElement : DESTROY){
			//itemDeleteElement.click();
		//}
		return this;
	}

	public void checkNewItemAddedAsLastItem(String item) {
		String lastItemText = ADDEDITEMSLIST.get(ADDEDITEMSLIST.size()-1).getText();
		assertEquals("Added item is not at the end of the list",lastItemText, item );
	}

	public void clickDoneCheckboxAndCheckItemMark() {
		if(DONECHECKBOX.size()>0){ //check if it is already done item
			DONECHECKBOX.get(FIRSTITEM).click(); //undone
		}
		TODOITEMCHECKBOX.click();
		assertTrue("Todo completed is not happening.", DONECHECKBOX.size()>0);
	}

	public void clickUndoneCheckboxAndCheckItemMark() {
		if(isThere(TODOITEMCHECKBOX)){ //check if it is already UNDONE item
			TODOITEMCHECKBOX.click(); //done
		}
		TODOCOMPLETED.click(); // mark as undone
		sleep(3);
		assertTrue("Undone item action is not happening.", UNDONECHECKBOX.size()>0);
	}

	public ToDoScreen deleteSelectedItem(String item) {
		int itemCount=-1;
		for(WebElement itemFromList: TODOLIST) {
			itemCount++;
			if(itemFromList.getText().equals(item)) {
				DESTROY.click();
			}
		}
		assertTrue("Last added item is not desired item.", TODOITEM.get(0).getText().contains(item));
		return this;
	}

	public void checkEmptyTodoList() {
		assertEquals("Todo list is not empty", TODOITEM.size(), 0);
	}

	public void checkDesiredItemOnToDoList(String item) {
		boolean itemFound = false;
		for(WebElement itemFromList: TODOITEM) {
			if(itemFromList.getText().equals(item)) {
				itemFound = true;
			}
		}
		assertTrue("Desired item is not in todo list", itemFound);
	}

	public ToDoScreen addToDoItemWithDoneChecked(String item) {
		elementSendKeys(NEWTODO,item).sendKeys(Keys.ENTER);
		TODOITEMCHECKBOX.click();
		return this;
	}
}
