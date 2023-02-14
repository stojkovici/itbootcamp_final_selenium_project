package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement emailField(){
        return driver.findElement(By.xpath("//input[@id='email']"));
    }
    public WebElement passwordField(){
        return driver.findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement loginButton(){
        return driver.findElement(By.xpath("//button[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default secondary']"));
    }
    public void waitForEmailInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
    }
    public void waitForUrlHome(){
        wait.until(ExpectedConditions.urlContains("/home"));
    }

}
