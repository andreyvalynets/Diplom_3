import pageObjects.*;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Login user")
public class LogInTest {
    private final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    private MainPage mainPage;
    private LoginPage loginPage;
    private PersonalAccountPage personalAccountPage;
    private User user;

    @Before
    public void setUp(){
        user = User.getRandom();
        RegisterPage registerPage = open(BASE_URL + "/register", RegisterPage.class);
        mainPage = page(MainPage.class);
        loginPage = page(LoginPage.class);
        personalAccountPage = page(PersonalAccountPage.class);
        registerPage.setNameField(user.getName());
        registerPage.setEmailField(user.getEmail());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickOnRegisterButton();
    }


    @After
    public void teardown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Login user from main page")
    public void loginByClickOnSignInButton() {
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnPersonalAccountButton();
        personalAccountPage.checkThatUserLogged();

    }

    @Test
    @DisplayName("Login user from personal account page")
    public void loginByClickOnPersonalAccountButton() {
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnPersonalAccountButton();
        personalAccountPage.checkThatUserLogged();

    }

    @Test
    @DisplayName("Login user from register page")
    public void loginByClickOnLoginLinkFromRegisterPage() {
        RegisterPage registerPage = open(BASE_URL + "/register", RegisterPage.class);
        loginPage = page(LoginPage.class);
        open(BASE_URL + "/register");
        registerPage.clickOnLoginLink();
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnPersonalAccountButton();
        personalAccountPage.checkThatUserLogged();

    }

    @Test
    @DisplayName("Login user from forgot password page")
    public void loginByClickOnLoginLinkFromForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        loginPage = page(LoginPage.class);
        open(BASE_URL + "/forgot-password");
        forgotPasswordPage.clickOnLoginLink();
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnPersonalAccountButton();
        personalAccountPage.checkThatUserLogged();

    }
}
