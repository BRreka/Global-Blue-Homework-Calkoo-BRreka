package com.codecool.pages;

import com.codecool.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

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
    @FindBy(id = "VAT_10")
    private WebElement vat10Percent;
    @FindBy(id = "VAT_14")
    private WebElement vat14Percent;
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

    @FindBy(name = "clear")
    private WebElement resetButton;

    //error message
    @FindBy(xpath = "//span[text()='Negative values are invalid for a pie chart.']")
    private WebElement errorMessage;
    @FindBy(xpath = "//span[text()='Values greater than 999.999.999 are invalid for a pie chart.']")
    private WebElement errorMessage2;

    public VatCalculatorPage() {
        PageFactory.initElements(driver, this);
    }
    public void loadCalculatorPage(String url) {
        int numOfSeconds = 30;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(numOfSeconds));
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
        checkNotInteractableElements(priceWithoutVATRadioButton);
    }
    public void clickTaxValueOption() {
        checkNotInteractableElements(valueAddedTaxRadioButton);
    }

    public void clickWithVatOption() {
        checkNotInteractableElements(priceWithVATIncludedRadioButton);
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
    public boolean isErrorMessage2Present() {
        return errorMessage2.isDisplayed();
    }

    //get text of input field
    public String getValueFromWithoutVat() {
        return netPriceField.getAttribute("value");
    }

    public String getValueFromVatSum() {
        return vatSumField.getAttribute("value");
    }

    public String getValueFromWithVat() {
        return priceWithVatField.getAttribute("value");
    }

    public void clickVatPercent10() {
        checkNotInteractableElements(vat10Percent);
    }
    public void clickVatPercent14() {
        checkNotInteractableElements(vat14Percent);
    }
    public void clickVatPercent24() {
        checkNotInteractableElements(vat24Percent);
    }
    private void checkNotInteractableElements(WebElement radioButton) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioButton);
    }
    public void clickResetButton() {
        resetButton.click();
    }
}