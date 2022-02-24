# WeTravel-AutomationTest
## Javascript Automation Project - EclecticIQ

------------


### About Project

This project was developed with Java and Selenium

-------------
## Installation

### 1. Open terminal

### 2. Run git init before clone project
> git init
> 
### 3. Clone project from git repository
>git clone https://github.com/kadertarlan/WeTravel-AutomationTest.git

### 4. Go to test Project Directory in Terminal

### 5. Install Apache Maven latest release.
**Go** https://maven.apache.org/download.cgi

**Install** Maven zip file, and unzip it to the folder where we want Maven to live.

### 6. Run commands in terminal 
>java -version

> mkdir -p /usr/local/apache-maven/apache-maven-3.8.4

>sudo unzip apache-maven-3.8.4-bin.zip -d /usr/local/apache-maven/apache-maven-3.8.4

### 7. Adding Maven to the Environment Path
**Open bashrc**  :
>vim ~/.bashrc

**Add Maven-specific lines to the file**:
>export M2_HOME=/usr/local/apache-maven/apache-maven-3.8.4
> 
>export M2=$M2_HOME/bin
> 
>export PATH=$M2:$PATH

**Run commands**:

> source ~/.bashrc

> mvn -version

### 8.Go to test Project Directory in Terminal

### 9.Run tests
>mvn clean test

>mvn clean test -Dtest=ToDoScreenTest



------------
#####Test cases:
-  testAddTodoListItem
    * Given Empty ToDo list
    * When I write "buy some milk" to <text-box> and press <enter>
    * Then I should see "buy some milk" item on ToDo list


-  testAddTodoListItemToExistList
    * Given ToDo list with "buy some milk" item
    * When I write "love this assignment" to <text-box> and press <enter>
    * Then I should see "love this assignment" item added to the ToDo list below "buy some milk" item


-  testMarkToDoItemAsDone
    * Given ToDo list with "buy some milk" item
    * When I click on <checkbox> next to "buy some milk" item
    * Then I should see "buy some milk" item marked as DONE


-  testMarkToDoItemAsUndone
    * Given ToDo list with a marked "buy some milk" item DONE
    * When I click on <checkbox> next to the item
    * Then I should see "buy some milk" item marked as UNDONE


-  testRemoveActionOnTodoListAndCheckEmptyList
    * Given ToDo list with "get some coffee" item
    * When I click on <delete-button> next to "get some coffee" item
    * Then the list should be empty


- testRemoveActionOnTodoListAndCheckLeftItem
    * Given ToDo list with "get some coffee" item and "drink some water" item in order
    * When I click on <delete-button> next to "get some coffee" item
    * Then I should see "drink some water" item on ToDo list





### Tests path:
    src/test/java/tests/ToDoScreenTest.java
