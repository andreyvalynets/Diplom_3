package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage {

    //кнопка "Выйти"
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    protected SelenideElement logoutButton;

    public void checkThatUserLogged() {
        $(logoutButton).shouldBe(Condition.visible);
    }

    public void clickOnLogoutButton() {
        $(logoutButton).click();
    }

    public void checkThatUserNotLogged() {
        $(logoutButton).shouldNotBe(Condition.visible);
    }
}
