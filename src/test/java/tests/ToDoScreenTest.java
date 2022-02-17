package tests;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import widgets.AbstractTest;

import static testdatas.UIConstants.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ToDoScreenTest extends AbstractTest{

	/**
	 * Given Empty ToDo list
	 * When I write "buy some milk" to <text-box> and press <enter>
	 * Then I should see "buy some milk" item on ToDo list
	*/
	@Test
	public void testAddTodoListItem() {
		app.toDoScreen()
				.isToDoScreen()
				.deleteAddedAllItems()
				.addToDoItem(BUYSOMEMILK)
				.checkAddedItemOnToDoList(BUYSOMEMILK);
	}

	/**
	 * Given ToDo list with "buy some milk" item
	 * When I write "love this assignment" to <text-box> and press <enter>
	 * Then I should see "love this assignment" item added to the ToDo list below "buy some milk" item
	 */
	@Test
	public void testAddTodoListItemToExistList() {
		app.toDoScreen()
				.isToDoScreen()
				.addToDoItem(LOVETHISASSIGNMENT)
				.checkNewItemAddedAsLastItem(LOVETHISASSIGNMENT);
	}

	/**
	 * Given ToDo list with "buy some milk" item
	 * When I click on <checkbox> next to "buy some milk" item
	 * Then I should see "buy some milk" item marked as DONE
	 */
	@Test
	public void testMarkToDoItemAsDone() {
		app.toDoScreen()
				.isToDoScreen()
				.deleteAddedAllItems()
				.addToDoItem(BUYSOMEMILK)
				.clickDoneCheckboxAndCheckItemMark();
	}

	/**
	 * Given ToDo list with a marked "buy some milk" item DONE
	 * When I click on <checkbox> next to the item
	 * Then I should see "buy some milk" item marked as UNDONE
	 */
	@Test
	public void testMarkToDoItemAsUndone() {
		app.toDoScreen()
				.addToDoItemWithDoneChecked(BUYSOMEMILK)
				.clickUndoneCheckboxAndCheckItemMark();
	}

	/**
	 * Given ToDo list with "get some coffee" item
	 * When I click on <delete-button> next to "get some coffee" item
	 * Then the list should be empty
	 */
	@Test
	public void testRemoveActionOnTodoListAndCheckEmptyList() {
		app.toDoScreen()
				.isToDoScreen()
				.deleteAddedAllItems()
				.addToDoItem(GETSOMECOFFE)
				.deleteSelectedItem(GETSOMECOFFE)
				.checkEmptyTodoList();
	}

	/**
	 * Given ToDo list with "get some coffee" item and "drink some water" item in order
	 * When I click on <delete-button> next to "get some coffee" item
	 * Then I should see "drink some water" item on ToDo list
	 */
	@Test
	public void testRemoveActionOnTodoListAndCheckLeftItem() {
		app.toDoScreen()
				.isToDoScreen()
				.addToDoItem(GETSOMECOFFE)
				.addToDoItem(DRINKSOMEWATER)
				.deleteSelectedItem(GETSOMECOFFE)
				.checkDesiredItemOnToDoList(DRINKSOMEWATER);
	}
}
