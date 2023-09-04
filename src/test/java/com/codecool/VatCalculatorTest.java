package com.codecool;

import com.codecool.pages.VatCalculatorPage;
import com.codecool.util.WebdriverUtil;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VatCalculatorTest {

    private VatCalculatorPage vatCalculatorPage;

    @BeforeEach
    public void setUp() {
        vatCalculatorPage = new VatCalculatorPage();
        vatCalculatorPage.loadCalculatorPage("https://www.calkoo.com/en/vat-calculator");
        vatCalculatorPage.dontConsentToUseData();
        vatCalculatorPage.acceptCookies();
        vatCalculatorPage.clickOnBody();
    }

    //Test if an element is loaded on the page
    @Test
    public void checkIfPageIsLoaded() {
        assertTrue(vatCalculatorPage.isCurrentPageLoaded());
    }

    //Tests for Finland VAT rate
    @Test
    public void testFinlandVatRate10WherePriceWithoutVATValueIs10() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent10();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("10");
        assertEquals("1.00", vatCalculatorPage.getValueFromVatSum());
        assertEquals("11.00",vatCalculatorPage.getValueFromWithVat());
    }
    @Test
    public void testFinlandVatRate10WherePriceWithVATValueIs440() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent10();
        vatCalculatorPage.clickWithVatOption();
        vatCalculatorPage.enterValueWithVat("440");
        assertEquals("400.00", vatCalculatorPage.getValueFromWithoutVat());
        assertEquals("40.00", vatCalculatorPage.getValueFromVatSum());
    }
    @Test
    public void testFinlandVatRate10WhereVATValueIs5dot5() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent10();
        vatCalculatorPage.clickTaxValueOption();
        vatCalculatorPage.enterValueVatSum("5.50");
        assertEquals("55.00", vatCalculatorPage.getValueFromWithoutVat());
        assertEquals("60.50",vatCalculatorPage.getValueFromWithVat());
    }
    @Test
    public void testFinlandVatRate10WherePriceWithoutVATValueIsNegative() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent10();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("-10");
        assertTrue(vatCalculatorPage.isErrorMessagePresent());
    }
    @Test
    public void testFinlandVatRate10WherePriceWithoutVATValueIsMoreThan999999999() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent10();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("1000000000");
        assertTrue(vatCalculatorPage.isErrorMessage2Present());
    }
    @Test
    public void testFinlandVatRate14WherePriceWithVATValueIs79dot8() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent14();
        vatCalculatorPage.clickWithVatOption();
        vatCalculatorPage.enterValueWithVat("79.80");
        assertEquals("70.00", vatCalculatorPage.getValueFromWithoutVat());
        assertEquals("9.80", vatCalculatorPage.getValueFromVatSum());
    }
    @Test
    public void testFinlandVatRate14WhereVATValueIs20() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent14();
        vatCalculatorPage.clickTaxValueOption();
        vatCalculatorPage.enterValueVatSum("20");
        assertEquals("142.86", vatCalculatorPage.getValueFromWithoutVat());
        assertEquals("162.86",vatCalculatorPage.getValueFromWithVat());
    }
    @Test
    public void testFinlandVatRate14WherePriceWithoutVATValueIs20() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent14();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("20");
        assertEquals("2.80", vatCalculatorPage.getValueFromVatSum());
        assertEquals("22.80",vatCalculatorPage.getValueFromWithVat());
    }
    @Test
    public void testFinlandVatRate14WherePriceWithoutVATValueIsNegative() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent14();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("-37");
        assertTrue(vatCalculatorPage.isErrorMessagePresent());
    }
    @Test
    public void testFinlandVatRate14WherePriceWithoutVATValueIsMoreThan999999999() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent14();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("11000000000");
        assertTrue(vatCalculatorPage.isErrorMessage2Present());
    }
    @Test
    public void testFinlandVatRate24WherePriceWithoutVATValueIs300() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent24();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("300");
        assertEquals("72.00", vatCalculatorPage.getValueFromVatSum());
        assertEquals("372.00",vatCalculatorPage.getValueFromWithVat());
    }
    @Test
    public void testFinlandVatRate24WherePriceWithVATValueIs58() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent24();
        vatCalculatorPage.clickWithVatOption();
        vatCalculatorPage.enterValueWithVat("58");
        assertEquals("46.77", vatCalculatorPage.getValueFromWithoutVat());
        assertEquals("11.23", vatCalculatorPage.getValueFromVatSum());
    }
    @Test
    public void testFinlandVatRate24WhereVATValueIs30() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent24();
        vatCalculatorPage.clickTaxValueOption();
        vatCalculatorPage.enterValueVatSum("30");
        assertEquals("125.00", vatCalculatorPage.getValueFromWithoutVat());
        assertEquals("155.00",vatCalculatorPage.getValueFromWithVat());
    }
    @Test
    public void testFinlandVatRate24WherePriceWithoutVATValueIsNegative() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent24();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("-55");
        assertTrue(vatCalculatorPage.isErrorMessagePresent());
    }
    @Test
    public void testFinlandVatRate24WherePriceWithoutVATValueIsMoreThan999999999() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent24();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("2200000000");
        assertTrue(vatCalculatorPage.isErrorMessage2Present());
    }
    @Test
    public void testIfResetButtonWorks() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent14();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("3000");
        vatCalculatorPage.clickResetButton();
        assertTrue(vatCalculatorPage.getValueFromVatSum().isBlank());
        assertTrue(vatCalculatorPage.getValueFromWithoutVat().isBlank());
        assertTrue(vatCalculatorPage.getValueFromWithVat().isBlank());
    }

    @AfterEach
    public void tearDown() {
        WebdriverUtil.quit();
    }
}
