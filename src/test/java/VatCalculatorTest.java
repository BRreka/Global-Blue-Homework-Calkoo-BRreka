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
    }



    @AfterAll
    public static void tearDown() {
        WebdriverUtil.quit();
    }
}
