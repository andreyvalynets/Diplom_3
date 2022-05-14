package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class ObjMainPage {

    //кнопка "Войти в Аккаунт"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/section[2]/div/button")
    protected SelenideElement signInButton;

    //кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/header/nav/a/p")
    protected SelenideElement personalAccountButton;

    //кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = ".//a[@href='/']")
    protected SelenideElement constructorButton;

    //таблица "Конструктора"
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    protected SelenideElement burgerTable;

    //кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/section[2]/div/button")
    protected SelenideElement createOrderButton;

    //лого
    @FindBy(how = How.XPATH, using = ".//div/a[@href='/']")
    protected SelenideElement logo;

    //таблица "Конструктора" - вкладка соусы
    @FindBy(how = How.XPATH, using = ".//div/span[text()='Соусы']")
    protected SelenideElement sousesTab;

    //таблица "Конструктора" - вкладка Начинки
    @FindBy(how = How.XPATH, using = ".//div/span[text()='Начинки']")
    protected SelenideElement fillingTab;

    //таблица "Конструктора" - вкладка Булки
    @FindBy(how = How.XPATH, using = ".//div/span[text()='Булки']")
    protected SelenideElement breadTab;

    //таблица "Конструктора" - Соус
    @FindBy(how = How.XPATH, using = ".//img[@alt='Соус Spicy-X']")
    protected SelenideElement souses;

    //таблица "Конструктора" - Начинка
    @FindBy(how = How.XPATH, using = ".//img[@src='https://code.s3.yandex.net/react/code/meat-02.png']")
    protected SelenideElement filling;

    //таблица "Конструктора" - Булка
    @FindBy(how = How.XPATH, using = ".//img[@src='https://code.s3.yandex.net/react/code/bun-01.png']")
    protected SelenideElement bread;

    public void clickOnPersonalAccountButton() {
        $(personalAccountButton).shouldBe(Condition.visible);
        $(personalAccountButton).click();
    }

    public void clickOnSignInButton() {
        $(signInButton).click();
    }

    public void clickOnConstructorButton() {
        $(constructorButton).click();
    }

    public void tableOfConstructorIsDisplayed() {
        $(burgerTable).shouldBe(Condition.visible);
    }

    public void clickOnLogo() {
        $(logo).click();
    }

    public void clickOnSousesTab() {
        $(sousesTab).click();
    }

    public void clickOnFillingTab() {
        $(fillingTab).click();
    }

    public void clickOnBreadTab() {
        $(breadTab).click();
    }

    public void sousesIsDisplayed() {
        $(souses).shouldBe(Condition.visible);
    }

    public void fillingsIsDisplayed() {
        $(filling).shouldBe(Condition.visible);
    }

    public void breadIsDisplayed() {
        $(bread).shouldBe(Condition.visible);
    }
}
