package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 1)
    @Description("Visit the admin cities page and list cities")
    public void visitTheAdminCitiesPafeAndListCities() {
        navPage.loginButton().click();
        loginPage.waitForEmailInput();
        loginPage.emailField().sendKeys("admin@admin.com");
        loginPage.passwordField().sendKeys("12345");
        loginPage.loginButton().click();
        navPage.waitForAdminButton();
        navPage.adminButton().click();
        navPage.citiesLinkFromDropDownAdminMenu().click();
        citiesPage.waitForUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),"The url is does not contains /admin/cities");
    }
    @Test(priority = 2)
    @Description("Check input types for create/edit new city")
    public void checkInputTypesForCreateOrEditNewCity(){
        navPage.waitForAdminButton();
        navPage.adminButton().click();
        navPage.citiesLinkFromDropDownAdminMenu().click();
        citiesPage.waitForNewItemButton();
        citiesPage.newItemButton().click();
        citiesPage.waitForEditAndNewItemDialogue();
        Assert.assertEquals(citiesPage.newCity().getAttribute("type"),"text","The attribute is not text");
    }
    @Test(priority = 3)
    @Description("Create a new city")
    public void createANewCity()  {
        navPage.waitForAdminButton();
        navPage.adminButton().click();
        navPage.citiesLinkFromDropDownAdminMenu().click();
        citiesPage.waitForNewItemButton();
        citiesPage.newItemButton().click();
        citiesPage.waitForEditAndNewItemDialogue();
        citiesPage.newCity().sendKeys("Ivan Stojkovic's city");
        citiesPage.waitForSaveButton();
        citiesPage.saveButtonFromEditAndNewItem().click();
        messagePopUpPage.waitForSuccessMessage();
        Assert.assertTrue(messagePopUpPage.succesMessageText().contains("Saved successfully"),"The message does not contains save successfully");
    }
    @Test(priority = 4)
    @Description("Edit city")
    public void editCity() throws InterruptedException {
        navPage.waitForAdminButton();
        navPage.adminButton().click();
        navPage.citiesLinkFromDropDownAdminMenu().click();
        citiesPage.waitForSearchInput();
        citiesPage.searchInput().sendKeys("Ivan Stojkovic's city");
        citiesPage.numberOfRows(1);
        citiesPage.editButtonFromRow(1).click();
        citiesPage.waitForEditAndNewItemDialogue();
        citiesPage.newCity().sendKeys(" Edited");
        citiesPage.waitForSaveButton();
        citiesPage.saveButtonFromEditAndNewItem().click();
        messagePopUpPage.successMessage();
        Thread.sleep(1000);
        Assert.assertTrue(messagePopUpPage.succesMessageText().contains("Saved successfully"),"This message does not contains Saved successfully");
    }
    @Test(priority = 5)
    @Description("Search city")
    public void searchCity() {
        navPage.waitForAdminButton();
        navPage.adminButton().click();
        navPage.citiesLinkFromDropDownAdminMenu().click();
        citiesPage.waitForSearchInput();
        citiesPage.searchInput().sendKeys("Ivan Stojkovic's city Edited");
        citiesPage.numberOfRows(1);
        Assert.assertEquals(citiesPage.cellFromRow(1,2).getText(),"Ivan Stojkovic's city Edited","The text from cell number 2 does not match with search input");
    }
    @Test(priority = 6)
    @Description("Delete city")
    public void deleteCity()  {
        navPage.waitForAdminButton();
        navPage.adminButton().click();
        navPage.citiesLinkFromDropDownAdminMenu().click();
        citiesPage.waitForSearchInput();
        citiesPage.searchInput().sendKeys("Ivan Stojkovic's city Edited");
        citiesPage.numberOfRows(1);
        Assert.assertEquals(citiesPage.cellFromRow(1, 2).getText(), "Ivan Stojkovic's city Edited", "The text from cell number 2 does not match with search input");
        citiesPage.deleteButtonFromRow(1).click();
        citiesPage.waitForDeleteDialogue();
        citiesPage.deleteButton().click();
        messagePopUpPage.waitForSuccessMessage();
        Assert.assertTrue(messagePopUpPage.successMessage().getText().contains("Deleted successfully"),"The message is does not contains deleted successfully");
    }


}
