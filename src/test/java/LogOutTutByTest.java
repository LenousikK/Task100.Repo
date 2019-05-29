import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Allure")
@Feature("Logout Page")
@ExtendWith(MyTestWatcher.class)
public class LogOutTutByTest extends BeforeAfter {
    private static final String LOGIN_USERNAME = "seleniumtests@tut.by";
    private static final String LOGIN_PASSWORD = "123456789zxcvbn";
    private static final String EXPECTED_TEXT_OF_LABEL_LOGGED_OUT = "ВойтиTEST";

    @Test
    @Description("Verify that User can log out")
    @TmsLink("LP-1")
    @Issue("123333333333333")
    @Story("As a User I can log out")
    @Severity(SeverityLevel.CRITICAL)
    public void logoutSuccessful() {
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedInPage loggedInPage = loginPage.login(LOGIN_USERNAME, LOGIN_PASSWORD);
        loginPage = loggedInPage.logout();
        assertEquals(EXPECTED_TEXT_OF_LABEL_LOGGED_OUT, loginPage.getTextOfLabelLoggedOut());
    }
}