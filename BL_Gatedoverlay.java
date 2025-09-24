package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_Gatedoverlay;
import com.metlife.components.pageobjects.PO_Herocategorydialog;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BL_Gatedoverlay extends PO_Gatedoverlay {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_Gatedoverlay(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     **************************************************************************************************************/

    public void Gatedoverlay() throws Exception {
        try {

            Thread.sleep(2000);

            action.explicitWait(driver, clickbutton, 160L, "visibilityOfElementLocated").click();
            //====================================swicth to form=========================================================
            WebElement ifrm = driver.findElement(By.tagName("Iframe"));
            action.switchToIFrameByFrameElement(driver,ifrm,120L);
            //==========================================dropdown for form============================================

            WebElement reach = driver.findElement(By.xpath(reachdrop));
            reach.click();
            WebElement r1 = action.explicitWait(driver,reachlist, 120L,"visibilityOfElementLocated");
            WebElement re1 = r1.findElement(By.xpath(reachselect));
            re1.click();
            //================================================field======================================================
            action.inputText(driver, "xpath", fieldtwo, "priyanka", "field");
            action.inputText(driver, "xpath", fieldthree, "data for testing", "field");
            action.inputText(driver, "xpath", fieldfour, "prianka@gmail.com", "field");
            action.inputText(driver, "xpath", fieldfive, "data for gated", "field");
            //===========================come out of iframe==============================================================
            driver.switchTo().defaultContent();
            WebElement cook = action.explicitWait(driver, cookie, 160L, "visibilityOfElementLocated");
            cook.click();
            //=========================================swicth to iframe ================================================
            WebElement ifra = driver.findElement(By.tagName("Iframe"));
            action.switchToIFrameByFrameElement(driver,ifra,120L);
            action.inputText(driver, "xpath", fieldsix, "Overlay field", "field");
            WebElement sub = action.explicitWait(driver, submit, 160L, "visibilityOfElementLocated");
            sub.click();
            Thread.sleep(1000);


            //========================================h1 tag dropdown====================================================================


        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }



    }
//==============================================================================================================

}
