
import com.microsoft.playwright.Page;
import common.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.microsoft.playwright.options.WaitForSelectorState.ATTACHED;

public class LoginTest extends TestBase {

    private LoginPage loginPage;


    @BeforeEach
    public void initialize() {
        loginPage = new LoginPage(page);
    }

    @Test
    public void testLogin() {
        loginPage = new LoginPage(page);
        loginPage.login("emrecnnn5@gmail.com", "TestTest1234*");
        page.waitForSelector("text='Hesabım'", new Page.WaitForSelectorOptions().setState(ATTACHED));
    }
}