package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-snack__wrapper v-sheet theme--dark error']")));
    }
    public String textOfMessage(){
        return driver.findElement(By.xpath("//div[@class='v-snack__wrapper v-sheet theme--dark error']/div[@class='v-snack__content']/ul/li")).getText();
    }
    public WebElement closeButton(){
        return driver.findElement(By.xpath("//button[@class='v-btn v-btn--text theme--dark v-size--default']"));
    }
    public void waitErrorPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-snack__wrapper v-sheet theme--dark error']/div[@class='v-snack__content']/ul/li")));
    }
    public void waitForVerifyYourAccountPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-card v-sheet theme--light']/div[@class='v-card__title headline grey lighten-2 black--text dlgVerifyAccount']")));
    }
    public String textFromPopUp(){
        return driver.findElement(By.xpath("//div[@class='v-card v-sheet theme--light']/div[@class='v-card__title headline grey lighten-2 black--text dlgVerifyAccount']")).getText();

    }
    public WebElement closeButtonFromPopUp(){
        return driver.findElement(By.xpath("//button[@class='btnClose v-btn v-btn--text theme--light v-size--default primary--text']"));
    }
    public WebElement successMessage(){
        return driver.findElement(By.xpath("//div[@class='v-snack__wrapper v-sheet theme--dark success']"));
    }
    public void waitForSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-snack__wrapper v-sheet theme--dark success']")));
    }
    public String succesMessageText(){
        return driver.findElement(By.xpath("//div[@class='v-snack__wrapper v-sheet theme--dark success']/div[@class='v-snack__content']")).getText();
    }


}
