package common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestBase {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;

    @BeforeAll
    public static void setUp() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(120));
        page = browser.newPage();
        page.navigate("https://www.trendyol.com");
        page.setViewportSize(width,height);
        assertThat(page.locator("#Rating-Review")).isVisible();
        page.locator("#Rating-Review").click();
    }

    @AfterAll
    public static void tearDown() {
        page.close();
        browser.close();
        playwright.close();
    }
}