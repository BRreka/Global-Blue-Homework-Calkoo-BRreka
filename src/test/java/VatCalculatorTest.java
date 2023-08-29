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
    }
    @Test
    public void checkIfPageIsLoaded() {
        vatCalculatorPage.acceptCookies();
        vatCalculatorPage.clickOnBody();
        assertTrue(vatCalculatorPage.isCurrentPageLoaded());
    }
/*
    @AfterAll
    public static void tearDown() {
        WebdriverUtil.quit();
    }

 */
}
