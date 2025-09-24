package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_Emailsubcription;
import com.metlife.components.pageobjects.PO_Teladoc;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BL_Teladoc extends PO_Teladoc {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_Teladoc(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     **************************************************************************************************************/

    public void Teladoc() throws Exception {
        try {

            Thread.sleep(2000);
            WebElement ifrm = driver.findElement(By.tagName("Iframe"));
            action.switchToIFrameByFrameElement(driver,ifrm,120L);
            action.click(driver, "xpath", Nutrition, "priyanka");
            action.inputText(driver, "xpath", Firstname, "priyanka", "field");
            action.inputText(driver, "xpath", Lastname, "chaudhary", "field");
            action.inputText(driver, "xpath", mobphone, "0773765420", "field");
            action.inputText(driver, "xpath", emailf, "priya@gmail.com", "field");

            WebElement sub = driver.findElement(By.xpath(calldrop));
            sub.click();
            WebElement sub1 = action.explicitWait(driver,calldroplist, 120L,"visibilityOfElementLocated");
            WebElement sub11 = sub1.findElement(By.xpath(calldropselect));
            sub11.click();

            WebElement drop2 = driver.findElement(By.xpath(countrydrop));
            drop2.click();
            WebElement dropli2 = action.explicitWait(driver,countrydroplist, 120L,"visibilityOfElementLocated");
            WebElement drops2 = dropli2.findElement(By.xpath(countrydropselect));
            drops2.click();

            WebElement drop3 = driver.findElement(By.xpath(selectdrop));
            drop3.click();
            WebElement dropli3 = action.explicitWait(driver,selectdroplist, 120L,"visibilityOfElementLocated");
            WebElement drops3 = dropli3.findElement(By.xpath(selectdropselect));
            drops3.click();
            action.inputText(driver, "xpath", organisation, "Metlife", "field");
            action.click(driver, "xpath", check1, "checkbox1");
            action.click(driver, "xpath", check2, "checkbox2");
            action.click(driver, "xpath", submitb, "submit");







        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }



    }
//==============================================================================================================

}
