package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement newItemButton(){
        return driver.findElement(By.xpath("//button[@class='btnNewItem v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default secondary']"));
    }
    public WebElement searchInput(){
        return driver.findElement(By.xpath("//input[@id='search']"));
    }
    public void waitForEditAndNewItemDialogue(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-card v-sheet theme--light']")));
    }
    public void waitForDeleteDialogue(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-card v-sheet theme--light rounded-0']")));
    }
    public WebElement saveButtonFromEditAndNewItem(){
        return driver.findElement(By.xpath("//button[@class='btnSave v-btn v-btn--text theme--light v-size--default green--text text--lighten3']"));
    }
    public void waitForSaveButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btnSave v-btn v-btn--text theme--light v-size--default green--text text--lighten3']")));
    }
    public WebElement deleteButton(){
        return driver.findElement(By.xpath("//button[@class='v-btn v-btn--text theme--light v-size--default red--text text--lighten3']"));
    }
    public void numberOfRows(int number){
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"),number));
    }
    public WebElement cellFromRow(int row,int cell){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td["+cell+"]"));
    }
    public WebElement editButtonFromRow(int row){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td/div/button[@id='edit']"));
    }
    public WebElement deleteButtonFromRow(int row){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td/div/button[@id='delete']"));
    }
    public WebElement newCity(){
        return driver.findElement(By.xpath("//input[@id='name']"));
    }
    public void waitForNewItemButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btnNewItem v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default secondary']")));
    }
    public void waitForUrl(){
        wait.until(ExpectedConditions.urlContains("/admin/cities"));
    }
    public void waitForSearchInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
    }

}
