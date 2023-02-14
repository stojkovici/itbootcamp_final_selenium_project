package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{

    @Test(priority = 1)
    @Description("Forbit visits to home url if not authenticated")
    public void forbitVisitsToHomeUrlIfNotAuthenticated(){
        driver.get(baseUrl+"/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test(priority = 2)
    @Description("Forbit visits to profile url if not authenticated")
    public void forbitVisitsToProfileUrlIfNotAuthenticated(){
        driver.get(baseUrl+"/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test(priority = 3)
    @Description("Forbit visits to admin cities url if not authenticated")
    public void forbitVisitsToAdminCitiesUrlIfNotAuthenticated(){
        driver.get(baseUrl+"/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test(priority = 4)
    @Description("Forbit visits to admin users url if not authenticated")
    public void forbitVisitsToAdminUsersUrlIfNotAuthenticated(){
        driver.get(baseUrl+"/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
