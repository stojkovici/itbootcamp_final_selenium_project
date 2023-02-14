package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 1)
    @Description("Set locale to ES")
    public void setLocaleToEs(){
        navPage.languageButton().click();
        navPage.esButton().click();
        Assert.assertTrue(navPage.headerText().contains("Página de aterrizaje"),"The headers text does not contains Página de aterrizaje");
    }
    @Test(priority = 2)
    @Description("Set locale to EN")
    public void setLocaleToEn(){
        navPage.languageButton().click();
        navPage.enButton().click();
        Assert.assertTrue(navPage.headerText().contains("Landing"),"The headers text does not contains Landing");
    }
    @Test(priority = 3)
    @Description("Set locale to CN")
    public void setLocaleToCn(){
        navPage.languageButton().click();
        navPage.cnButton().click();
        Assert.assertTrue(navPage.headerText().contains("首页"),"The headers text does not contains 首页");
    }
    @Test(priority = 4)
    @Description("Set locale to FR")
    public void setLocaleToFr(){
        navPage.languageButton().click();
        navPage.frButton().click();
        Assert.assertTrue(navPage.headerText().contains("Page d'atterrissage"),"The headers text does not contains Page d'atterrissage");
    }
    @Test(priority = 5)
    @Description("Set locale to UA")
    public void setLocaleToUa(){
        navPage.languageButton().click();
        navPage.uaButton().click();
        Assert.assertTrue(navPage.headerText().contains("Лендінг"),"The headers text does not contains Лендінг");
    }

}
