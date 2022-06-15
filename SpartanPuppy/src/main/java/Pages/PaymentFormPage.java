package Pages;
import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PaymentFormPage extends TestBase {

	public By name_input = By.cssSelector("#order_name");
	public By address_textarea = By.cssSelector("#order_address");
	public By email_input = By.cssSelector("#order_email");
	public By paymentType_select = By.cssSelector("#order_pay_type");
	public By placeOrder_button = By.cssSelector(".submit");

	public void setName(String value){
		wait.until(ExpectedConditions.visibilityOfElementLocated(name_input)).sendKeys(value);
	}
	public void setAddress(String value){
		wait.until(ExpectedConditions.visibilityOfElementLocated(address_textarea)).sendKeys(value);
	}
	public void setEmail(String value){
		wait.until(ExpectedConditions.visibilityOfElementLocated(email_input)).sendKeys(value);
	}
	public void selectPayment(String value){
		Select payment = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(paymentType_select)));
		payment.selectByValue(value);
	}
	public void submitPayment(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrder_button)).click();
	}

}
