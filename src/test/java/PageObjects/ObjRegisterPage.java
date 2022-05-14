package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class ObjRegisterPage {

    //поле "Имя"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/fieldset[1]/div/div/input")
    protected SelenideElement nameField;

    //поле "email"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/fieldset[2]/div/div/input")
    protected SelenideElement emailField;

    //поле "Пароль"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/fieldset[3]/div/div/input")
    protected SelenideElement passwordField;

    //кнопка "Зарегестрироваться"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/button")
    protected SelenideElement registerButton;

    //сообщение "Некорректный пароль"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/fieldset[3]/div/p")
    protected SelenideElement errorMessage;

    //ссылка "Войти"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/div/p/a")
    protected SelenideElement linkLogin;


    public void setNameField(String name) {
        $(nameField).sendKeys(name);
    }

    public void setEmailField(String email) {
        $(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        $(passwordField).sendKeys(password);
    }

    public void clickOnRegisterButton() {
        $(registerButton).click();
    }

    public void availableErrorMessage() {
        $(errorMessage).shouldBe(Condition.visible);
    }

    public void clickOnLoginLink() {
        $(linkLogin).click();
    }

}
