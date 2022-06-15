package Pages;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class HomePage extends TestBase {



    // NAVIGATION BAR
    public By adoptAPuppy = By.cssSelector("a[name='adopt-a-puppy']");
    public By animalShelters = By.cssSelector("a[name='animal-shelters']");
    public By keyInformation = By.cssSelector("a[name='key-informations']");
    public By messageBoards = By.cssSelector("a[name='message-boards']");
    public By petNews = By.cssSelector("a[name='pet-news']");
    public By successStories = By.cssSelector("a[name='success-stories']");

    //Global elements
    public By search = By.cssSelector(".search");
    public By homePage_button = By.cssSelector("a[title='Home']");
    public By contact_button = By.cssSelector("a[name='contact']");
    public By notice = By.cssSelector("#notice");

    public void goToAdoptPuppyPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(adoptAPuppy));
    }
    public void goToAnimalSheltersPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(animalShelters));
    }
    public void goToKeyInformationPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(keyInformation));
    }
    public void goToMessageBoardPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageBoards));
    }
    public void goToPetNewsPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(petNews));
    }
    public void goToSuccessStoriesPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(successStories));
    }
    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(notice)).getAttribute("innerText");
    }

}
