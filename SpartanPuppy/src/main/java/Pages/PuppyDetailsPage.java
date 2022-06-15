package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PuppyDetailsPage extends TestBase {
		public By adoptMe_button = By.cssSelector(".rounded_button");
		public By returnToList_button = By.cssSelector("div#content a");

		public void clickAdoptMeButton(){
			wait.until(ExpectedConditions.visibilityOfElementLocated(adoptMe_button)).click();
		}
		public void clickReturnToListButton(){
			wait.until(ExpectedConditions.visibilityOfElementLocated(returnToList_button)).click();
		}
}
