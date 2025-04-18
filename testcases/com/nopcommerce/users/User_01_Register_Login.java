package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class User_01_Register_Login {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("https://yasai-console-dev.yakuodo-info.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Register(){

    }

    @Test
    public void TC_02_Login(){
        driver.quit();
    }

    @AfterClass
    public void afterClass(){

    }
}
