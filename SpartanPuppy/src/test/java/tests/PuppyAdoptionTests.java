package tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PuppyAdoptionTests extends HomePage {

    HomePage homePage;
    AdoptPuppyPage adoptPuppyPage;
    PuppyDetailsPage puppyDetailsPage;
    OrderDetailsPage orderDetailsPage;
    PaymentFormPage paymentFormPage;
    @BeforeMethod
    public void setUp()
    {
        Initialization();
        homePage = new HomePage();
        adoptPuppyPage = new AdoptPuppyPage();
        puppyDetailsPage = new PuppyDetailsPage();
        orderDetailsPage = new OrderDetailsPage();
        paymentFormPage = new PaymentFormPage();
    }

    @Test
    public void verifyAdoptPuppyCase1(){
    // Adopt Brook, add a Chewy Toy and a Travel Carrier, pay with Check
        String expectedPuppyName="Brook";
        homePage.goToAdoptPuppyPage();
        String actualPuppyName = adoptPuppyPage.getPuppyNameByIndex(0);
        Assert.assertEquals(actualPuppyName,expectedPuppyName);
        adoptPuppyPage.openPuppyDetailsByIndex(0);
        puppyDetailsPage.clickAdoptMeButton();
        orderDetailsPage.setAdditives(0,false,true,true,false);
        orderDetailsPage.clickCompleteAdoptionButton();
        paymentFormPage.setName("Random Name");
        paymentFormPage.setAddress("New York, Street 1/2 10004 NY");
        paymentFormPage.setEmail("newOrderEmail@gmail.com");
        paymentFormPage.selectPayment("Check");
        paymentFormPage.submitPayment();
        String expectedText = homePage.getNotice();
        Assert.assertEquals(expectedText,"Thank you for adopting a puppy!");
    }
    @Test
    public void verifyAdoptPuppyCase2(){
    // Adopt Sparky, add a Collar & Leash, pay with Credit Card
        String expectedPuppyName="Sparky";
        homePage.goToAdoptPuppyPage();
        adoptPuppyPage.openNextPage();
        String actualPuppyName = adoptPuppyPage.getPuppyNameByIndex(0);
        Assert.assertEquals(actualPuppyName,expectedPuppyName);
        adoptPuppyPage.openPuppyDetailsByIndex(0);
        puppyDetailsPage.clickAdoptMeButton();
        orderDetailsPage.setAdditives(0,true,false,false,true);
        orderDetailsPage.clickCompleteAdoptionButton();
        paymentFormPage.setName("Random Name");
        paymentFormPage.setAddress("New York, Street 1/2 10004 NY");
        paymentFormPage.setEmail("newOrderEmail@gmail.com");
        paymentFormPage.selectPayment("Credit card");
        paymentFormPage.submitPayment();
        String expectedText = homePage.getNotice();
        Assert.assertEquals(expectedText,"Thank you for adopting a puppy!");

    }
    @Test
    public void verifyAdoptPuppyCase3(){
    // Adopt 2 Random Dogs add a Collar & Leash to each, pay with Credit Card
        int firstRandomPuppy = getRandomIntInRange(4);
        int secondRandomPuppy= getRandomIntInRange(4);
        while(secondRandomPuppy==firstRandomPuppy){
            secondRandomPuppy = getRandomIntInRange(4);
        }
        homePage.goToAdoptPuppyPage();
        adoptPuppyPage.openNextPage();
    //add first puppy
        adoptPuppyPage.openPuppyDetailsByIndex(firstRandomPuppy);
        puppyDetailsPage.clickAdoptMeButton();
        orderDetailsPage.clickAdoptAnotherButton();
    //add second puppy
        adoptPuppyPage.openPuppyDetailsByIndex(firstRandomPuppy);
        puppyDetailsPage.clickAdoptMeButton();
    //set additives for puppies
        orderDetailsPage.setAdditives(0,true,false,false,false);
        orderDetailsPage.setAdditives(1,true,false,false,false);
        orderDetailsPage.clickCompleteAdoptionButton();
    //finish adoption
        paymentFormPage.setName("Random Name");
        paymentFormPage.setAddress("New York, Street 1/2 10004 NY");
        paymentFormPage.setEmail("newOrderEmail@gmail.com");
        paymentFormPage.selectPayment("Credit card");
        paymentFormPage.submitPayment();
        String expectedText = homePage.getNotice();
        Assert.assertEquals(expectedText,"Thank you for adopting a puppy!");
    }
    @Test
    public void verifyAdoptPuppyCase4(){
    //Adopt 2 Random Dogs add a 3 Random Accessories to 1, pay with Credit Card
        int firstRandomPuppy = getRandomIntInRange(4);
        int secondRandomPuppy= getRandomIntInRange(4);
        while(secondRandomPuppy==firstRandomPuppy){
            secondRandomPuppy = getRandomIntInRange(4);
        }
        homePage.goToAdoptPuppyPage();
        adoptPuppyPage.openNextPage();
    //add first puppy
        adoptPuppyPage.openPuppyDetailsByIndex(firstRandomPuppy);
        puppyDetailsPage.clickAdoptMeButton();
        orderDetailsPage.clickAdoptAnotherButton();
    //add second puppy
        adoptPuppyPage.openPuppyDetailsByIndex(firstRandomPuppy);
        puppyDetailsPage.clickAdoptMeButton();
    //set 3 random additives for puppies
        orderDetailsPage.setAdditives(0,true,true,true,true);
        orderDetailsPage.clickRandomAdditive(0);
        orderDetailsPage.clickCompleteAdoptionButton();
    //finish adoption
        paymentFormPage.setName("Random Name");
        paymentFormPage.setAddress("New York, Street 1/2 10004 NY");
        paymentFormPage.setEmail("newOrderEmail@gmail.com");
        paymentFormPage.selectPayment("Credit card");
        paymentFormPage.submitPayment();
        String expectedText = homePage.getNotice();
        Assert.assertEquals(expectedText,"Thank you for adopting a puppy!");
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
