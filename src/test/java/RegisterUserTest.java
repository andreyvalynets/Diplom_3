import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.PersonalAccountPage;
import pageObjects.RegisterPage;

import static com.codeborne.selenide.Selenide.*;


@DisplayName("Register user")
public class RegisterUserTest {
    private final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    private MainPage mainPage;
    private LoginPage loginPage;
    private PersonalAccountPage personalAccountPage;
    private User user;

    @After
    public void teardown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Register user by valid data")
    public void userCanBeRegisteredByValidData() {
        user = User.getRandom();
        RegisterPage registerPage = open(BASE_URL + "/register", RegisterPage.class);
        mainPage = page(MainPage.class);
        loginPage = page(LoginPage.class);
        personalAccountPage = page(PersonalAccountPage.class);
        registerPage.setNameField(user.getName());
        registerPage.setEmailField(user.getEmail());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickOnRegisterButton();
        open(BASE_URL + "/login");
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnPersonalAccountButton();
        personalAccountPage.checkThatUserLogged();
    }

    @Test
    @DisplayName("Check error message for incorrect password")
    public void userCanNotBeRegisteredByIncorrectPassword() {
        RegisterPage registerPage = open(BASE_URL + "/register", RegisterPage.class);
        registerPage.setNameField(RandomStringUtils.randomAlphabetic(8));
        registerPage.setEmailField(RandomStringUtils.randomAlphabetic(8) + "@yandex.ru");
        registerPage.setPasswordField(RandomStringUtils.randomAlphabetic(5));
        registerPage.clickOnRegisterButton();
        registerPage.availableErrorMessage();
    }

}
