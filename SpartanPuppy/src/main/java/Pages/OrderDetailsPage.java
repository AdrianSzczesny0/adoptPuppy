package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderDetailsPage extends TestBase {
	public By collar = By.cssSelector("#collar");
	public By toy = By.cssSelector("#toy");
	public By carrier = By.cssSelector("#carrier");
	public By vet = By.cssSelector("#vet");
	public By cartButtons = By.cssSelector(".rounded_button");

	public void clickCompleteAdoptionButton(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartButtons)).get(0).click();
	}
	public void clickAdoptAnotherButton(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartButtons)).get(1).click();
	}
	public void clickChangeYourMindButton(){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartButtons)).get(2).click();
	}
	public void clickCollarByOrderedPuppyIndex(int index){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(collar)).get(index).click();
	}
	public void clickToyByOrderedPuppyIndex(int index){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(toy)).get(index).click();
	}
	public void clickCarrierByOrderedPuppyIndex(int index){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(carrier)).get(index).click();
	}
	public void clickVetByOrderedPuppyIndex(int index){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(vet)).get(index).click();
	}

	public void setAdditives(int index,boolean _collar,boolean _toy,boolean _carrier, boolean _vet){
		if(_collar){clickCollarByOrderedPuppyIndex(index);}
		if(_toy){clickToyByOrderedPuppyIndex(index);}
		if(_carrier){clickCarrierByOrderedPuppyIndex(index);}
		if(_vet){clickVetByOrderedPuppyIndex(index);}
	}
	public void clickRandomAdditive(int index){
		int excludedAdditive = getRandomIntInRange(4);
		switch (excludedAdditive){
			case 0:{
				clickCollarByOrderedPuppyIndex(index);
				break;
			}
			case 1:{
				clickToyByOrderedPuppyIndex(index);
				break;
			}
			case 2:{
				clickCarrierByOrderedPuppyIndex(index);
				break;
			}
			case 3:{
				clickVetByOrderedPuppyIndex(index);
				break;
			}
		}
	}
}
