package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static Helper.Utility.driver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebPage {
    By usernameInput = By.cssSelector("input#user-name");
    By passwordInput = By.xpath("//*[@id=\"password\"]");
    By buttonLogin = By.id("login-button");

    By productImage = By.id("item_4_img_link");
    By buttonBurgerMenu = By.id("react-burger-menu-btn");
    By buttonDropDown = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    By buttonAddCart = By.id("add-to-cart-sauce-labs-backpack");
    By buttonShoppingCart = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    By buttonRemoveCart = By.id("remove-sauce-labs-backpack");

    public void toLogin(){
        driver.get("https://www.saucedemo.com/");
    }

    public void userInputUsername(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void userInputPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void userClickButtonLogin(){
        driver.findElement(buttonLogin).click();
    }

    public void userCanLogin(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement productElement2 = driver.findElement(productImage);
        assertTrue(productElement2.isDisplayed());
    }

    public void willShowError(String errorMasaage){
        assertTrue(driver.getPageSource().contains(errorMasaage));
    }

    public void userClickButtonBurgermenu(){
        driver.findElement(buttonBurgerMenu).click();
    }

    public void willShowMenuInBurgermenu() throws InterruptedException{
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.id("inventory_sidebar_link")).getText(),"All Items");
        Assert.assertEquals(driver.findElement(By.id("about_sidebar_link")).getText(), "About");
        Assert.assertEquals(driver.findElement(By.id("logout_sidebar_link")).getText(), "Logout");
        Assert.assertEquals(driver.findElement(By.id("reset_sidebar_link")).getText(), "Reset App State");
    }

    public void userClickFiler(){
        driver.findElement(buttonDropDown).click();
    }

    public void willChoseMenuInFilter() throws InterruptedException{
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]")).getText(),"Name (A to Z)");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")).getText(), "Name (Z to A)");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).getText(), "Price (low to high)");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).getText(), "Price (high to low)");
    }

    public void userClickButtonAddtocart(){
        driver.findElement(buttonAddCart).click();
    }

    public void canClickButtonAddtocart(){
        WebElement productElement6 = driver.findElement(buttonShoppingCart);
        assertTrue(productElement6.isDisplayed());
        assertEquals("1", productElement6.getText());
    }

    public void userClickButtonRemove(){
        driver.findElement(buttonRemoveCart).click();
    }

    public void willBackToButtonAddtocart(){
        WebElement product2 = driver.findElement(buttonAddCart);
        assertTrue(product2.isDisplayed());
    }

}
