
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    ChromeDriver driver;
    String BASE_URL = "https://test-dev.coconutbox.com/login/    ";
    public static final String VALID_EMAIL = "v.rudenko@cokuna.com";
    public static final String INVALID_EMAIL = "v.rudenko(cokuna.com";
    public static final String EMPTY_EMAIL = "";
    public static final String VALID_PASSWORD = "i6r3cvl5wtr2iv3tlbv28i3";
    public static final String INVALID_PASSWORD = "r2iv3tlbv28i3";
    public static final String EMPTY_PASSWORD = "";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}