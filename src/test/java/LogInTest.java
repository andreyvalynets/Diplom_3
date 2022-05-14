import PageObjects.*;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Login user")
public class LogInTest {
    private final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    private ObjMainPage objMainPage;
    private ObjLoginPage objLoginPage;
    private ObjPersonalAccountPage objPersonalAccountPage;
    private User user;

    @Before
    public void setUp(){
        user = User.getRandom();
        ObjRegisterPage objRegisterPage = open(BASE_URL + "/register", ObjRegisterPage.class);
        objMainPage = page(ObjMainPage.class);
        objLoginPage = page(ObjLoginPage.class);
        objPersonalAccountPage = page(ObjPersonalAccountPage.class);
        objRegisterPage.setNameField(user.getName());
        objRegisterPage.setEmailField(user.getEmail());
        objRegisterPage.setPasswordField(user.getPassword());
        objRegisterPage.clickOnRegisterButton();
        sleep(500);
    }


    @After
    public void teardown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Login user from main page")
    public void loginByClickOnSignInButton() {
        objLoginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        objLoginPage.clickOnLoginButton();
        objMainPage.clickOnPersonalAccountButton();
        objPersonalAccountPage.checkThatUserLogged();

    }

    @Test
    @DisplayName("Login user from personal account page")
    public void loginByClickOnPersonalAccountButton() {
        objLoginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        objLoginPage.clickOnLoginButton();
        objMainPage.clickOnPersonalAccountButton();
        objPersonalAccountPage.checkThatUserLogged();

    }

    @Test
    @DisplayName("Login user from register page")
    public void loginByClickOnLoginLinkFromRegisterPage() {
        ObjRegisterPage objRegisterPage = open(BASE_URL + "/register", ObjRegisterPage.class);
        ObjLoginPage objLoginPage = page(ObjLoginPage.class);
        open(BASE_URL + "/register");
        objRegisterPage.clickOnLoginLink();
        objLoginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        objLoginPage.clickOnLoginButton();
        objMainPage.clickOnPersonalAccountButton();
        objPersonalAccountPage.checkThatUserLogged();

    }

    @Test
    @DisplayName("Login user from forgot password page")
    public void loginByClickOnLoginLinkFromForgotPasswordPage() {
        ObjForgotPasswordPage objForgotPasswordPage = page(ObjForgotPasswordPage.class);
        ObjLoginPage objLoginPage = page(ObjLoginPage.class);
        open(BASE_URL + "/forgot-password");
        objForgotPasswordPage.clickOnLoginLink();
        objLoginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        objLoginPage.clickOnLoginButton();
        objMainPage.clickOnPersonalAccountButton();
        objPersonalAccountPage.checkThatUserLogged();

    }
}
