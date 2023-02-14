package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{

    @Test(priority = 1)
    @Description("Visit signup page")
    public void visitSignupPage(){
        navPage.signUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }
    @Test(priority = 2)
    @Description("Check input types")
    public void checkInputTypes() {
        navPage.signUpButton().click();
        signupPage.waitForInputs();
        Assert.assertEquals(signupPage.emailField().getAttribute("type"),"email","The type is not email");
        Assert.assertEquals(signupPage.passwordField().getAttribute("type"),"password","The type is not password");
        Assert.assertEquals(signupPage.confirmPasswordField().getAttribute("type"),"password","The confirm password field is not password");
    }
    @Test(priority = 3)
    @Description("Display errors when user already exists")
    public void displayErrorsWhenUserAlreadyExists(){
        navPage.signUpButton().click();
        signupPage.waitForUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
        signupPage.waitForInputs();
        signupPage.nameField().sendKeys("Another User");
        signupPage.emailField().sendKeys("admin@admin.com");
        signupPage.passwordField().sendKeys("12345");
        signupPage.confirmPasswordField().sendKeys("12345");
        signupPage.signMeUpButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.textOfMessage().equals("E-mail already exists"),"The message is not e-mail already exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }
    @Test(priority = 4)
    @Description("Signup")
    public void signup() {
        navPage.signUpButton().click();
        signupPage.waitForInputs();
        signupPage.nameField().sendKeys("Ivan Stojkovic");
        signupPage.emailField().sendKeys("ivan.stojkovic121@itbootcamp.rs");
        signupPage.passwordField().sendKeys("12345");
        signupPage.confirmPasswordField().sendKeys("12345");
        signupPage.signMeUpButton().click();
        messagePopUpPage.waitForVerifyYourAccountPopUp();
        Assert.assertTrue(messagePopUpPage.textFromPopUp().equals("IMPORTANT: Verify your account"));
        messagePopUpPage.closeButtonFromPopUp().click();
        navPage.logoutButton().click();
    }

}
