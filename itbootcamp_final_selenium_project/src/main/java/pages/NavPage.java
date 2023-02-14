package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement homeLink(){
        return driver.findElement(By.xpath("//a[@href='/']"));
    }
    public WebElement aboutLink(){
        return driver.findElement(By.xpath("//a[@href='/about']"));
    }
    public WebElement myProfileLink(){
        return driver.findElement(By.xpath("//a[@href='/profile']"));
    }
    public WebElement adminButton(){
        return driver.findElement(By.xpath("//button[@class='btnAdmin hidden-sm-and-down v-btn v-btn--text theme--light v-size--default']"));
    }
    public void waitForAdminButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btnAdmin hidden-sm-and-down v-btn v-btn--text theme--light v-size--default']")));
    }
    public WebElement citiesLinkFromDropDownAdminMenu(){
        return driver.findElement(By.xpath("//a[@href='/admin/cities']"));
    }


    public WebElement usersLinkFromDropDownAdminMenu(){
        return driver.findElement(By.xpath("//a[@href='/admin/users']"));
    }
    public WebElement signUpButton(){
        return driver.findElement(By.xpath("//a[@href='/signup']"));
    }
    public WebElement loginButton(){
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }
    public WebElement logoutButton(){
        return driver.findElement(By.xpath("//button[@class='hidden-sm-and-down btnLogout v-btn v-btn--text theme--light v-size--default']"));
    }
    public WebElement languageButton(){
        return driver.findElement(By.xpath("//button[@class='btnLocaleActivation v-btn v-btn--text theme--light v-size--default']"));
    }
    public WebElement enButton(){
        return driver.findElement(By.xpath("//div[@class='v-list-item v-list-item--link theme--light btnEN']"));
    }
    public WebElement esButton(){
        return driver.findElement(By.xpath("//div[@class='v-list-item v-list-item--link theme--light btnES']"));
    }
    public WebElement frButton(){
        return driver.findElement(By.xpath("//div[@class='v-list-item v-list-item--link theme--light btnFR']"));
    }
    public WebElement cnButton(){
        return driver.findElement(By.xpath("//div[@class='v-list-item v-list-item--link theme--light btnCN']"));
    }
    public WebElement uaButton(){
        return driver.findElement(By.xpath("//div[@class='v-list-item v-list-item--link theme--light btnUA']"));
    }
    public String headerText(){
        return driver.findElement(By.xpath("//h1")).getText();
    }
    public void waitForLogoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='hidden-sm-and-down btnLogout v-btn v-btn--text theme--light v-size--default']")));
    }
    public void waitForUrl(){
        wait.until(ExpectedConditions.urlContains("/login"));
    }
}
