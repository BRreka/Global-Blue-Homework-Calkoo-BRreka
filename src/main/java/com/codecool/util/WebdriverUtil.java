package com.codecool.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import java.io.File;
import java.nio.file.*;
import java.util.*;

public class WebdriverUtil {

    private static volatile WebDriver webDriverInstance = null;
    private WebdriverUtil() {}

    public static WebDriver getInstance() {
        WebDriver driver = webDriverInstance;
        if(driver == null) {
            synchronized (WebdriverUtil.class) {
                driver = webDriverInstance;
                if(driver == null) {
                    if(isChromeInstalled()) {
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--remote-allow-origins=*");
                        options.addExtensions(new File("src/main/resources/uBlockChrome.crx"));
                        webDriverInstance = driver = new ChromeDriver(options);
                    } else {
                        throw new RuntimeException("Sorry, your browser isn't supported.");
                    }
                }
            }
        }
        return driver;
    }

    private static boolean isChromeInstalled() {
        Optional<Path> browserPath = WebDriverManager.chromedriver().getBrowserPath();
        return browserPath.isPresent();
    }

    public static void quit() {
        webDriverInstance.quit();
        webDriverInstance = null;
    }
}
