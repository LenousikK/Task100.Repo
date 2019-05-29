import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Epic("Allure")
@Feature("Login Page")
@ExtendWith(MyTestWatcher.class)
public class LoginToTutByTest extends BeforeAfter {
    private static final String LOGIN_USERNAME = "seleniumtests@tut.by";
    private static final String LOGIN_PASSWORD = "123456789zxcvbn";
    private static final String EXPECTED_TEXT_OF_LABEL_LOGGED_USERNAME = "Selenium Test";

    @Test
    @Description("Verify that User can log in")
    @TmsLink("LP-2")
    @Issue("123333333333334")
    @Story("As a User I can log in")
    public void loginSuccessful() {
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedInPage loggedInPage = loginPage.login(LOGIN_USERNAME, LOGIN_PASSWORD);
        assertEquals(EXPECTED_TEXT_OF_LABEL_LOGGED_USERNAME, loggedInPage.getTextOfLabelLoggedUsername());
    }
}