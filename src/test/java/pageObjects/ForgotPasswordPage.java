package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    //ссылка "Войти"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/div/p/a")
    protected SelenideElement LoginLink;

    public void clickOnLoginLink() {
        $(LoginLink).click();
    }
}
