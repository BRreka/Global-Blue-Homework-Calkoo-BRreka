package com.codecool.pages;

import com.codecool.util.WebdriverUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.time.Duration;

public class VatCalculatorPage {
    WebDriver driver = WebdriverUtil.getInstance();
    public VatCalculatorPage() {
        PageFactory.initElements(driver, this);
    }
    public void loadCalculatorPage(String url) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }
}