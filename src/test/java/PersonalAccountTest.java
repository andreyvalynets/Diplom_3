import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.PersonalAccountPage;
import pageObjects.RegisterPage;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Open Personal Account page")
public class PersonalAccountTest {

    private final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    private MainPage mainPage;
    private LoginPage loginPage;
    private PersonalAccountPage personalAccountPage;
    private User user;

    @Before
    public void setUp() {
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
    }

    @After
    public void teardown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Personal Account page is opened")
    public void personalAccountPageCanBeOpenedByClickOnPersonalAccountButton() {
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnPersonalAccountButton();
        personalAccountPage.checkThatUserLogged();

    }

    @Test
    @DisplayName("Constructor page is opened from Personal Account page")
    public void constructorPageCanBeOpenedFromPersonalAccountPage() {
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnPersonalAccountButton();
        mainPage.clickOnConstructorButton();
        mainPage.tableOfConstructorIsDisplayed();
    }

    @Test
    @DisplayName("Constructor page is opened by click on logo")
    public void constructorPageCanBeOpenedByClickOnLogo() {
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnPersonalAccountButton();
        mainPage.clickOnLogo();
        mainPage.tableOfConstructorIsDisplayed();
    }

    @Test
    @DisplayName("LogOut user")
    public void userCanBeLogOutedByClickOnLogoutButton() {
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnPersonalAccountButton();
        personalAccountPage.clickOnLogoutButton();
        mainPage.clickOnPersonalAccountButton();
        loginPage.checkLoginButton();
    }

    @Test
    @DisplayName("Souses tab of ingredients is opened")
    public void switchToSousesTabsOfConstructorTable() {
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnSousesTab();
        mainPage.checkShriftOfSousesTab();
    }

    // will be done
    @Test
    @DisplayName("Fillings tab of ingredients is opened")
    public void switchToFillingTabOfConstructorTable() {
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnFillingTab();
        mainPage.checkShriftOfFillingTab();
    }

    // will be done
    @Test
    @DisplayName("Bread tab of ingredients is opened")
    public void switchToBreadTabsOfConstructorTable() {
        loginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickOnLoginButton();
        mainPage.clickOnSousesTab();
        mainPage.clickOnBreadTab();
        mainPage.checkShriftOfBreadTab();
    }
}
