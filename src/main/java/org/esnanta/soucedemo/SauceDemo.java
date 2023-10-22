package org.esnanta.soucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class SauceDemo {

    WebDriver driver;

    public SauceDemo() {
        WebDriverManager.firefoxdriver().setup(); // setup driver automatically using web driver manager
        FirefoxOptions opt = new FirefoxOptions(); //create object to set up option
        opt.setHeadless(false); //set driver to not using headless mode

        driver = new FirefoxDriver(opt); //apply driver setup to driver
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // time out for web driver on waiting element
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    public WebDriver getWebDriver(){
        return driver;
    }
}