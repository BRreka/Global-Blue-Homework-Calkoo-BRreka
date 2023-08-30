package com.codecool.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtil {
    public static void waitUntilClickable(WebDriver driver, WebElement element) {
        int numOfSeconds = 45;
        new WebDriverWait(driver, Duration.ofSeconds(numOfSeconds)).until(ExpectedConditions.elementToBeClickable(element));
    }
}
