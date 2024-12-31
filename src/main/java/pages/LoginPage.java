package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import common.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage extends BasePage {

    private String usernameInput = "#login-email";
    private String passwordInput = "#login-password-input";
    private String loginButton = ".q-primary.q-fluid.q-button-medium.q-button.submit";
    private String spinner = ".q-loader-parent";

    public LoginPage(Page page) {
        super(page);
    }

    public void login(String username, String password) {

        Locator lc = page.locator("p", new Page.LocatorOptions().setHasText("Giriş Yap"));
        assertThat(lc).isVisible();
        lc.hover();
        lc = page.locator(".login-button");
        lc.click();

        page.locator(usernameInput).fill(username);
        page.locator(passwordInput).fill(password);
        assertThat(page.locator(loginButton)).isVisible();
        page.locator(loginButton).click();
        page.locator(spinner).waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.DETACHED));
    }
}