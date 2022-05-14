import PageObjects.ObjRegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;


@DisplayName("Register user")
public class RegisterUserTest {
    private final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @Test
    @DisplayName("Register user by valid data")
    public void userCanBeRegisteredByValidData() {
        ObjRegisterPage objRegisterPage = open(BASE_URL + "/register", ObjRegisterPage.class);
        objRegisterPage.setNameField(RandomStringUtils.randomAlphabetic(8));
        objRegisterPage.setEmailField(RandomStringUtils.randomAlphabetic(8) + "@yandex.ru");
        objRegisterPage.setPasswordField(RandomStringUtils.randomAlphabetic(8));
        objRegisterPage.clickOnRegisterButton();
    }

    @Test
    @DisplayName("Check error message for incorrect password")
    public void userCanNotBeRegisteredByIncorrectPassword() {
        ObjRegisterPage objRegisterPage = open(BASE_URL + "/register", ObjRegisterPage.class);
        objRegisterPage.setNameField(RandomStringUtils.randomAlphabetic(8));
        objRegisterPage.setEmailField(RandomStringUtils.randomAlphabetic(8) + "@yandex.ru");
        objRegisterPage.setPasswordField(RandomStringUtils.randomAlphabetic(5));
        objRegisterPage.clickOnRegisterButton();
        objRegisterPage.availableErrorMessage();
    }

}
