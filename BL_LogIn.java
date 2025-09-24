package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_Login;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import com.metlife.components.utilities.Excel_Handling;
import org.openqa.selenium.WebDriver;

public class BL_LogIn extends PO_Login {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_LogIn(WebDriver driver, String TC_ID) {
        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * Login() function is used to Log-In into the application and update report based on the login status.
     * @author Gaurav
     **************************************************************************************************************/

    public void loginCDH() throws Exception {
        try {
           // action.waitForPageToLoad(driver, 60L);
            action.inputText(driver, "xpath", username, Excel_Handling.Get_Data(TC_ID, "Username"), "UserName ");
            action.inputText(driver, "xpath", password, action.decryptPassword(Excel_Handling.Get_Data(TC_ID, "Password")), "Password ");
            action.click(driver, "xpath", signIn, " Sign In Button ");
           /* action.getWindowHandle(driver, "CDH Reports");
            driver.manage().window().maximize();
            action.explicitWait(driver, homePageWelcome, 60L, "visibilityOfElementLocated");
            action.isElementDisplayed(driver, "xpath", homePageWelcome, " Home Page");
*/
        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function loginCDH is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }
}