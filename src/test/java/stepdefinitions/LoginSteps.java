package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.esnanta.soucedemo.SauceDemo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    WebDriver driver;

    @Given("user is on login page")
    public void userIsOnLoginPage(){
        SauceDemo sauceDemo = new SauceDemo();
        driver = sauceDemo.getWebDriver();
    }

    @When("user input (.*) as username$")
    public void userInputUsername(String username){
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user input (.*) as password$")
    public void userInputPassword(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user click submit")
    public void userClickSubmit(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("user verify (.*) login result$")
    public void userVerifyLoginResult(String status){
        if(status.equals("success")){
            //success and i can see shopping cart
            driver.findElement(By.xpath("//div[@class='shopping_cart_container']")).getText();
        }
        else{
            //assert error message
            String failMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
            Assert.assertEquals(failMessage,"Epic sadface: Username and password do not match any user in this service");
        }
    }
}
