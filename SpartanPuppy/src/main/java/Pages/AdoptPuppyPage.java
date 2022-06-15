package Pages;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AdoptPuppyPage extends TestBase {

	public By row = By.cssSelector(".puppy_list");
	public By viewDetails_button = By.cssSelector(".rounded_button");
	public By puppyName = By.cssSelector(".name>h3");
	public By previousPage_button = By.cssSelector(".previous_page");
	public By nextPage_button = By.cssSelector(".next_page");


	public List<WebElement> getPuppyList(){
		List<WebElement> list  = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(row));
		return list;
	}
	public WebElement getPuppyByIndex(int index){
		return getPuppyList().get(index);
	}
	public String getPuppyNameByIndex(int index){
		return getPuppyByIndex(index).findElement(puppyName).getAttribute("innerText");
	}
	public void openPuppyDetailsByIndex(int index){
		getPuppyList().get(index).findElement(viewDetails_button).click();
	}
	public void openNextPage(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(nextPage_button)).click();
	}
	public void openPreviousPage(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(previousPage_button)).click();
	}

}
