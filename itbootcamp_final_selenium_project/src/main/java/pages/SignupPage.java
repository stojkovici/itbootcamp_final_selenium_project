package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement nameField(){
        return driver.findElement(By.xpath("//input[@name='name']"));
    }
    public WebElement emailField(){
        return driver.findElement(By.xpath("//input[@name='email']"));
    }
    public WebElement passwordField(){
        return driver.findElement(By.xpath("//input[@name='password']"));
    }
    public WebElement confirmPasswordField(){
        return driver.findElement(By.xpath("//input[@name='confirmPassword']"));
    }
    public WebElement signMeUpButton(){
        return driver.findElement(By.xpath("//button[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default secondary']"));
    }
    public void waitForInputs(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
    }
    public void waitForUrl(){
        wait.until(ExpectedConditions.urlContains("/signup"));
    }
}
