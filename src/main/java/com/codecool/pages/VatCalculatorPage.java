package com.codecool.pages;

import com.codecool.util.WebdriverUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.*;

public class VatCalculatorPage {
    private final WebDriver driver = WebdriverUtil.getInstance();

    //get country selection options
    @FindBy(name = "Country")
    private Select countries;

    //group select VAT percent option fields
    @FindBy(name = "VAT")
    private List<WebElement> vatPercentOptions;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    public void selectCountry(String country) {
        countries.selectByVisibleText(country);
    }

    public WebElement selectVatPercent(String value) {
        WebElement currentVat = null;
        for (WebElement vat : vatPercentOptions) {
            if(vat.getAttribute(value).equals(value)) {
                currentVat = vat;
            }
        }
        return currentVat;
    }

    public void clickWithoutVatOption() {
        priceWithoutVATRadioButton.click();
    }
    public void clickTaxValueOption() {
        valueAddedTaxRadioButton.click();
    }

    public void clickWithVatOption() {
        priceWithVATIncludedRadioButton.click();
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
        return vatSumField.getText();
    }

    public String getValueFromWithVat() {
        return priceWithVatField.getText();
    }
}