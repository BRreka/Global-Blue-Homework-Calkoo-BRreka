import com.codecool.pages.VatCalculatorPage;
import com.codecool.util.WebdriverUtil;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
public class VatCalculatorTest {

    private VatCalculatorPage vatCalculatorPage;

    @BeforeEach
    public void setUp() {
        vatCalculatorPage = new VatCalculatorPage();
        vatCalculatorPage.loadCalculatorPage("https://www.calkoo.com/en/vat-calculator");
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
    public void testFinlandVatRate10WherePriceWithoutVATValueIsNegative() {
        vatCalculatorPage.selectCountry("Finland");
        vatCalculatorPage.clickVatPercent10();
        vatCalculatorPage.clickWithoutVatOption();
        vatCalculatorPage.enterValueWithoutVat("-10");
        assertTrue(vatCalculatorPage.isErrorMessagePresent());
    }

    @AfterEach
    public void tearDown() {
        WebdriverUtil.quit();
    }

}
