package page;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Локаторы элементов главной страницы
     */

    //URL главной страницы сервиса
    private final static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //Локатор кнопки перехода в Личный кабинет
    @FindBy(linkText = "Личный Кабинет")
    private WebElement profileButton;

    //Локатор кнопки "Войти в аккаунт"
    @FindBy(xpath = ".//button[text() = 'Войти в аккаунт']")
    private WebElement accountEnterButton;

    //Локатор кнопки "Оформить заказ"
    @FindBy(xpath = ".//button[text() = 'Оформить заказ']")
    private WebElement orderButton;

    //Локатор кнопки раздела "Булки"
    @FindBy(xpath = ".//div[@style = 'display: flex;']//div[1]")
    private WebElement bunButton;

    //Локатор кнопки раздела "Соусы"
    @FindBy(xpath = ".//div[@style = 'display: flex;']//div[2]")
    private WebElement sauceButton;

    //Локатор кнопки раздела "Начинки"
    @FindBy(xpath = ".//div[@style = 'display: flex;']//div[3]")
    private WebElement fillingButton;

    /**
     * Методы для взаимодействия с элементами главной страницы
     */

    //Метод вызова главной страницы
    @Step("Calling the main page")
    public MainPage getMainPage() {
        driver.get(MAIN_PAGE_URL);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(profileButton));
        return this;
    }

    //метод проверки отображения главной страницы
    @Step("Checking the display of the main page")
    public MainPage mainPageIsDisplayed() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(orderButton));
        Assert.assertEquals(MAIN_PAGE_URL, driver.getCurrentUrl());
        return this;
    }

    //Метод клика на кнопку перехода в Личный кабинет
    @Step("Click on the button to go to your Personal account")
    public MainPage profileButtonClick() {
        profileButton.click();
        return this;
    }

    //Метод клика на кнопку "Войти в аккаунт"
    @Step("Click on the \"Log in to account\" button")
    public MainPage accountEnterButtonClick() {
        accountEnterButton.click();
        return this;
    }

    //Метод проверки видимости кнопки "Оформить заказ"
    @Step("Checking the visibility of the \"Checkout\" button")
    public MainPage checkOrderButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(orderButton));
        Assert.assertTrue(orderButton.isDisplayed());
        return this;
    }

    //Метод клика на кнопку раздела "Булки"
    @Step("Click on the button of the \"Булки\" section")
    public MainPage bunButtonClick() {
        bunButton.click();
        return this;
    }

    //Метод клика на кнопку раздела "Соусы"
    @Step("Click on the button of the \"Соусы\" section")
    public MainPage sauceButtonClick() {
        sauceButton.click();
        return this;
    }

    //Метод клика на кнопку раздела "Начинки"
    @Step("Click on the button of the \"Начинки\" section")
    public MainPage fillingButtonClick() {
        fillingButton.click();
        return this;
    }

    //Метод проверки изменения класса у активного элемнта "Булки"
    @Step("Checking for class changes in the active element \"Булки\"")
    public MainPage bunScrollCheck() {
        sauceButtonClick();
        bunButtonClick();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(
                        bunButton,
                        "class",
                        "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
        return this;
    }

    //Метод проверки изменения класса у активного элемнта "Соусы"
    @Step("Checking for class changes in the active element \"Соусы\"")
    public MainPage sauceScrollCheck() {
        sauceButtonClick();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(
                        sauceButton,
                        "class",
                        "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
        return this;
    }

    //Метод проверки изменения класса у активного элемнта "Начинки"
    @Step("Checking for class changes in the active element \"Начинки\"")
    public MainPage fillingScrollCheck() {
        fillingButtonClick();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBe(
                        fillingButton,
                        "class",
                        "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
        return this;
    }
}