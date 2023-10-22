package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.esnanta.soucedemo.SauceDemo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveCartSteps {
    WebDriver driver;
    @Given("user at homepage after authorization")
    public void userAtHomepageAfterAuthorization() {
        SauceDemo sauceDemo = new SauceDemo();
        driver = sauceDemo.getWebDriver();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @And("user click Add To Cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }
    @Then("cart will be added with one item")
    public void cartWillBeAddedWithItem() {
        String qtyCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals(qtyCart,"1");
    }
    @And("user click Add To Cart button for other item")
    public void userClickAddToCartButtonForOtherItem() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
    }
    @Then("cart will have two items")
    public void cartWillHaveTwoItems() {
        String qtyCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals(qtyCart,"2");
    }
    @And("user click Remove button for item added to cart")
    public void userClickRemoveButtonForItemAddedToCart() {
        String captionRemove = driver.findElement(By.xpath("//button[@data-test='remove-sauce-labs-bolt-t-shirt']")).getText();
        Assert.assertEquals(captionRemove,"Remove");
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
    }
    @Then("quantity in cart will be decreased by one")
    public void quantityInCartWillBeDecreasedByOne() {
        String qtyCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals(qtyCart,"1");
    }
}
