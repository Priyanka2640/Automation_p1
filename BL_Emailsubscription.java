package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_Contactform;
import com.metlife.components.pageobjects.PO_Emailsubcription;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BL_Emailsubscription extends PO_Emailsubcription {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_Emailsubscription(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     ****************************************Form **********************************************************************/

    public void Emailsubscription() throws Exception {
        try {

            Thread.sleep(2000);
            WebElement ifrm = driver.findElement(By.tagName("Iframe"));
            action.switchToIFrameByFrameElement(driver,ifrm,120L);
            action.inputText(driver, "xpath", Namefirst, "priyanka", "field");
            action.inputText(driver, "xpath", Lastname, "chaudhary", "field");
            driver.switchTo().defaultContent();
            action.click(driver,"xpath",close_cookie,"close the cookie banner");
            WebElement ifra = driver.findElement(By.tagName("Iframe"));
            action.switchToIFrameByFrameElement(driver,ifra,120L);
            action.inputText(driver, "xpath", emailf, "priya@gmail.com", "field");

            WebElement sub = driver.findElement(By.xpath(subjecte));
            sub.click();
            WebElement sub1 = action.explicitWait(driver,sublist, 120L,"visibilityOfElementLocated");
            WebElement sub11 = sub1.findElement(By.xpath(subselect));
            sub11.click();
            action.inputText(driver, "xpath", company, "comany ", "field");
            action.inputText(driver, "xpath", titleemail, "title", "field");
            action.inputText(driver, "xpath", comment, "comment", "field");
            WebElement butt = action.explicitWait(driver, submitemail, 160L, "visibilityOfElementLocated");
            butt.click();
            Thread.sleep(6000);




            //========================================h1 tag dropdown====================================================================


        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }



    }
//==============================================================================================================

}
