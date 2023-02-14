package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasicTest{

    @Test(priority = 1)
    @Description("Visit the login page")
    public void visitTheLoginPage(){
        navPage.languageButton().click();
        navPage.enButton().click();
        navPage.loginButton().click();
        navPage.waitForUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test(priority = 2)
    @Description("Check input types")
    public void checkInputTypes(){
        navPage.loginButton().click();
        loginPage.waitForEmailInput();
        String emailType=loginPage.emailField().getAttribute("type");
        Assert.assertEquals(emailType,"email","The type is not email");
        String passwordType=loginPage.passwordField().getAttribute("type");
        Assert.assertEquals(passwordType,"password","The type is not password");
    }
    @Test(priority = 3)
    @Description("Display errors when user does not exist")
    public void displayErrorsWhenUserDoesNotExist(){
        navPage.loginButton().click();
        loginPage.waitForEmailInput();
        loginPage.emailField().sendKeys("non-existing-user@gmal.com");
        loginPage.passwordField().sendKeys("password123");
        loginPage.loginButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.textOfMessage().equals("User does not exists"),"The message is not the same.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"The url does not contains /login");
    }
    @Test(priority = 4)
    @Description("Display errors when password is wrong")
    public void displayErrorsWhenPasswordIsWrong() {
        navPage.loginButton().click();
        loginPage.waitForEmailInput();
        loginPage.emailField().sendKeys("admin@admin.com");
        loginPage.passwordField().sendKeys("password123");
        loginPage.loginButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.textOfMessage().equals("Wrong password"),"The message is not the same.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"The url does not contains /login");
    }
    @Test(priority = 5)
    @Description("Login")
    public void login() {
        navPage.loginButton().click();
        loginPage.waitForEmailInput();
        loginPage.emailField().sendKeys("admin@admin.com");
        loginPage.passwordField().sendKeys("12345");
        loginPage.loginButton().click();
        loginPage.waitForUrlHome();
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),"The url is does not contains /home");
    }
    @Test(priority = 6)
    @Description("Logout")
    public void logout() {
        navPage.waitForLogoutButton();
        Assert.assertTrue(navPage.logoutButton().isDisplayed());
        navPage.logoutButton().click();
    }


}
