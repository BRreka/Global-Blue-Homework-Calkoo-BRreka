package com.codecool.pages;

import com.codecool.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.*;

public class VatCalculatorPage {
    private final WebDriver driver = WebdriverUtil.getInstance();

    //cookie option
    @FindBy(id = "cookieconsent:desc")
    private WebElement cookieBox;
    @FindBy(linkText = "I Accept!")
    private WebElement cookie;

    //Vat calculator body
    @FindBy(id = "vatcalculator")
    private WebElement vCalcBody;

    //get country selection options
    @FindBy(name = "Country")
    private WebElement countriesOrigin;

    //vat options **separate**
    @FindBy(id = "VAT_5")
    private WebElement vat5Percent;
    @FindBy(id = "VAT_8")
    private WebElement vat8Percent;
    @FindBy(id = "VAT_10")
    private WebElement vat10Percent;
    @FindBy(id = "VAT_14")
    private WebElement vat14Percent;
    @FindBy(id = "VAT_20")
    private WebElement vat20Percent;
    @FindBy(id = "VAT_24")
    private WebElement vat24Percent;

    //radio button options for calculating VAT
    @FindBy(id = "F1")
    private WebElement priceWithoutVATRadioButton;
    @FindBy(id = "F2")
    private WebElement valueAddedTaxRadioButton;
    @FindBy(id = "F3")
    private WebElement priceWithVATIncludedRadioButton;

    //input fields for radio button options
    @FindBy(id = "NetPrice")
    private WebElement netPriceField;
    @FindBy(id = "VATsum")
    private WebElement vatSumField;
    @FindBy(id = "Price")
    private WebElement priceWithVatField;

    //error message
    @FindBy(xpath = "//span[text()='Negative values are invalid for a pie chart.']")
    private WebElement errorMessage;

    public VatCalculatorPage() {
        PageFactory.initElements(driver, this);
    }
    public void loadCalculatorPage(String url) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(url);
    }


    public void acceptCookies() {
        WaitUtil.waitUntilClickable(driver, cookieBox);
        cookieBox.click();
        WaitUtil.waitUntilClickable(driver, cookie);
        cookie.click();
    }

    public void clickOnBody() {
        WaitUtil.waitUntilClickable(driver, vCalcBody);
        vCalcBody.click();
    }

    public boolean isCurrentPageLoaded() {
        WaitUtil.waitUntilClickable(driver, vCalcBody);
        return vCalcBody.isDisplayed();
    }

    public void selectCountry(String country) {
        WaitUtil.waitUntilClickable(driver, countriesOrigin);
        Select countries = new Select(countriesOrigin);
        countries.selectByVisibleText(country);
        }

    public void clickWithoutVatOption() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", priceWithoutVATRadioButton);
    }
    public void clickTaxValueOption() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", valueAddedTaxRadioButton);
    }

    public void clickWithVatOption() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", priceWithVATIncludedRadioButton);
    }

    public void enterValueWithoutVat(String value) {
        netPriceField.sendKeys(value);
    }
    public void enterValueVatSum(String value) {
        vatSumField.sendKeys(value);
    }
    public void enterValueWithVat(String value) {
        priceWithVatField.sendKeys(value);
    }
    public boolean isErrorMessagePresent() {
        return errorMessage.isDisplayed();
    }

    //get text of input field
    public String getValueFromWithoutVat() {
        return netPriceField.getText();
    }

    public String getValueFromVatSum() {
        return vatSumField.getAttribute("value");
    }

    public String getValueFromWithVat() {
        return priceWithVatField.getAttribute("value");
    }

    public void clickVatPercent5() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", vat5Percent);
    }
    public void clickVatPercent8() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", vat8Percent);
    }
    public void clickVatPercent10() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", vat10Percent);
    }
    public void clickVatPercent14() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", vat14Percent);
    }
    public void clickVatPercent20() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", vat20Percent);
    }
    public void clickVatPercent24() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", vat24Percent);
    }
}