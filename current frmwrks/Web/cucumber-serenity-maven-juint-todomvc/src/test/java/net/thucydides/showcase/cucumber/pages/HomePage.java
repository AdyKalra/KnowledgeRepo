package net.thucydides.showcase.cucumber.pages;

import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@DefaultUrl("http://todomvc.com/examples/react/")
public class HomePage extends PageObject {

    @FindBy(className = "new-todo")
    WebElementFacade searchQueryBox;

    @FindBy(css = "todo-list li:not(.hidden)")
    public List<WebElement> visibleTodoItems;

    @FindBy(how= How.CSS, using="ul#todo-list li.completed:not(.hidden)")
    public List<WebElement> visibleCompletedTodoItems;

    @FindBy(how= How.CSS, using="ul#todo-list li:not(.completed):not(.hidden)")
    public List<WebElement> visibleActiveTodoItems;

    @FindBy(how = How.ID, using="new-todo")
    private WebElement createTodo;

    @FindBy(how = How.ID, using="footer")
    private WebElement footer;

    @FindBy(how = How.ID, using="main")
    private WebElement main;

    @FindBy(how = How.CSS, using="#todo-count strong")
    private WebElement countElement;

    @FindBy(xpath = "//footer/span/strong")
    WebElementFacade countElementStrong;

    @FindBy(how = How.CSS, using="#filters li a")
    List<WebElement> filters;

    @FindBy(how = How.ID, using="clear-completed")
    List<WebElement> clearCompletedAsList;

    @FindBy(how = How.ID, using="clear-completed")
    WebElement clearCompletedButton;

    private final By DESTROY_BUTTON = By.cssSelector("button.destroy");
    private final By EDIT_FIELD = By.cssSelector("input.edit");
    private final By INPUT_TOGGLE = By.cssSelector("input.toggle");

    public void enterSearchTerms(String keyword) {
        searchQueryBox.click();
        searchQueryBox.type(keyword);
        //searchQueryBox.sendKeys(keyword);
        //withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//*[@title='" + keyword + "']"));
        //waitForKeywordToBeUpdatedTo(keyword);
    }

    private void waitForKeywordToBeUpdatedTo(String keyword) {
        waitForCondition()
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(250, TimeUnit.MILLISECONDS)
                .until(keywordFieldIsUpdatedTo(keyword));
    }

    private Function<? super WebDriver, Boolean> keywordFieldIsUpdatedTo(String keyword) {
        return webDriver -> searchQueryBox.getValue().equalsIgnoreCase(keyword);
    }

    public void add() {
        searchQueryBox.sendKeys(Keys.RETURN);
    }

    public int getCountOfTodo(ItemsInState state) {
        return getTodoItems(state).size();
    }

    public String getToDoText(int itemIndex) {
        java.util.List<WebElement> items = getTodoItems(ItemsInState.VISIBLE);
        return items.get(itemIndex).getText();
    }

    public java.util.List<WebElement> getTodoItems(ItemsInState state) {
        List<WebElement> returnList = null;

        switch (state){
            case VISIBLE:
                returnList = visibleTodoItems;
                break;

            case VISIBLE_COMPLETED:
                returnList = visibleCompletedTodoItems;
                break;

            case VISIBLE_ACTIVE:
                returnList = visibleActiveTodoItems;
                break;
        }

        return returnList;
    }

    public void typeIntoNewToDo(CharSequence... keysToSend) {
        createTodo.click();
        createTodo.sendKeys(keysToSend);
    }

    public void get() {
        //driver.get(todoMVCSite.getURL());
    }

    public boolean isFooterVisible() {
        return footer.isDisplayed();
    }

    public boolean isMainVisible() {
        return main.isDisplayed();
    }

    public void deleteTodoItem(int todoIndex) {

        WebElement todoListItem = visibleTodoItems.get(todoIndex);

        todoListItem.click(); // enable the destroy button

        // because this is relative to a dynamically populate item it can't be declared
        // as an @FindBy
        WebElement destroyButton = todoListItem.findElement(DESTROY_BUTTON);
        destroyButton.click();
    }

    public void editItem(int itemIndex, String editTheTitleTo) {
        WebElement todoListItem = visibleTodoItems.get(itemIndex);
        // have no choice but to use actions here
        new Actions(getDriver()).doubleClick(todoListItem.findElement(By.cssSelector("div > label"))).perform();

        WebElement editfield = todoListItem.findElement(EDIT_FIELD);
        editfield.click();
        editfield.clear();
        editfield.sendKeys(editTheTitleTo);
        editfield.sendKeys(Keys.ENTER);
    }


    public Integer getCountInFooter() {
        return Integer.valueOf(countElementStrong.getText());
    }

    public String getCountTextInFooter() {
        String countText = countElement.getText();

        // remove the number from the string
        return countText.replace(getCountInFooter() + " ", "");
    }

    public void clickOnFilter(Filter filter) {
        filters.get(filter.index()).click();
    }

    public void toggleCompletionOfItem(int itemIndex) {

        WebElement todoListItem = visibleTodoItems.get(itemIndex);
        //wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        WebElement checkbox = todoListItem.findElement(INPUT_TOGGLE);
        checkbox.click();
    }

    public boolean isClearCompletedVisible() {
        // it may or may not be in the dom
        if(clearCompletedAsList.size()==0){return false;}

        return clearCompletedAsList.get(0).isDisplayed();
    }

    public Integer getClearCompletedCount() {
        Integer clearCompletedCount=0;

        if(isClearCompletedVisible()){
            String clearCompletedText = clearCompletedButton.getText();
            Pattern completedText = Pattern.compile("Clear completed \\((.+)\\)");
            Matcher matcher = completedText.matcher(clearCompletedText);

            if(matcher.matches()){
                return Integer.valueOf(matcher.group(1));
            }
        }

        return clearCompletedCount;
    }

    public void clickClearCompleted() {
        clearCompletedButton.click();
    }





    //==========================================================================================================
    public static enum Filter {
        ALL(0), ACTIVE(1), COMPLETED(2);

        private int filterIndex;
        Filter(int index){
            this.filterIndex = index;
        }

        public int index(){
            return filterIndex;
        }
    }

    /**
     * The Structural Factory example doesn't need the enum constructor and this could have been...
     *     public static enum ItemsInState {
     VISIBLE,
     VISIBLE_COMPLETED,
     VISIBLE_ACTIVE;
     }
     for that example only
     */
    public static enum ItemsInState {
        VISIBLE("ul.todo-list li:not(.hidden)"),
        VISIBLE_COMPLETED("ul.todo-list li.completed:not(.hidden)"),
        VISIBLE_ACTIVE("ul.todo-list li:not(.completed):not(.hidden)");

        private String cssselector;

        ItemsInState(String cssselector) {
            this.cssselector = cssselector;
        }

        public String cssSelector(){
            return this.cssselector;
        }
    }


}