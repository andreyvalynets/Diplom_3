import PageObjects.ObjLoginPage;
import PageObjects.ObjMainPage;
import PageObjects.ObjPersonalAccountPage;
import PageObjects.ObjRegisterPage;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Open Personal Account page")
public class PersonalAccountTest {

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
    @DisplayName("Personal Account page is opened")
    public void personalAccountPageCanBeOpenedByClickOnPersonalAccountButton() {
        objLoginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        objLoginPage.clickOnLoginButton();
        objMainPage.clickOnPersonalAccountButton();
        objPersonalAccountPage.checkThatUserLogged();

    }

    @Test
    @DisplayName("Constructor page is opened from Personal Account page")
    public void constructorPageCanBeOpenedFromPersonalAccountPage() {
        objLoginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        objLoginPage.clickOnLoginButton();
        objMainPage.clickOnPersonalAccountButton();
        objMainPage.clickOnConstructorButton();
        objMainPage.tableOfConstructorIsDisplayed();
    }

    @Test
    @DisplayName("Constructor page is opened by click on logo")
    public void constructorPageCanBeOpenedByClickOnLogo() {
        objLoginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        objLoginPage.clickOnLoginButton();
        objMainPage.clickOnPersonalAccountButton();
        objMainPage.clickOnLogo();
        objMainPage.tableOfConstructorIsDisplayed();
    }

    @Test
    @DisplayName("LogOut user")
    public void userCanBeLogOutedByClickOnLogoutButton() {

        objLoginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        objLoginPage.clickOnLoginButton();
        objMainPage.clickOnPersonalAccountButton();
        objPersonalAccountPage.clickOnLogoutButton();
        objMainPage.clickOnPersonalAccountButton();
        objLoginPage.checkLoginButton();
    }

    @Test
    @DisplayName("All tabs of ingredients are available")
    public void switchBetweenTabsOfConstructorTable() {
        objLoginPage.setEmailAndPassword(user.getEmail(), user.getPassword());
        objLoginPage.clickOnLoginButton();
        objMainPage.clickOnSousesTab();
        objMainPage.sousesIsDisplayed();
        objMainPage.clickOnFillingTab();
        objMainPage.fillingsIsDisplayed();
        objMainPage.clickOnBreadTab();
        objMainPage.breadIsDisplayed();
    }
}
