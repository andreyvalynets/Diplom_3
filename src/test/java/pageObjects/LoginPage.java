package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    //поле "email"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/fieldset[1]/div/div/input")
    protected SelenideElement emailField;

    //поле "Пароль"
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    protected SelenideElement passwordField;

    //кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    protected SelenideElement loginButton;

    public void setEmailAndPassword(String email, String password){
        $(emailField).sendKeys(email);
        $(passwordField).sendKeys(password);
    }

    public void clickOnLoginButton(){
        $(loginButton).click();
    }

    public void checkLoginButton(){
        $(loginButton).shouldBe(Condition.visible);
    }

}
