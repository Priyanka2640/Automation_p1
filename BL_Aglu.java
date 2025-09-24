package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_Aglu;
import com.metlife.components.pageobjects.PO_Emailsubcription;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BL_Aglu extends PO_Aglu {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_Aglu(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     ********************************************Form******************************************************************/

    public void Aglu() throws Exception {
        try {

            Thread.sleep(2000);
            WebElement ifrm = driver.findElement(By.tagName("Iframe"));
            action.switchToIFrameByFrameElement(driver,ifrm,120L);
            action.inputText(driver, "xpath", Namefirst, "priyanka", "field");
            action.inputText(driver, "xpath", Lastname, "chaudhary", "field");
            WebElement drop1 = driver.findElement(By.xpath(state));
            drop1.click();
            WebElement dropli = action.explicitWait(driver,statelist, 120L,"visibilityOfElementLocated");
            WebElement drops = dropli.findElement(By.xpath(stateselect));
            drops.click();
            action.inputText(driver, "xpath", mobphone, "0773765420", "field");
            action.inputText(driver, "xpath", emailfield, "priya@gmail.com", "field");
            WebElement drop2 = driver.findElement(By.xpath(preference));
            drop2.click();
            WebElement dropli2 = action.explicitWait(driver,prelist, 120L,"visibilityOfElementLocated");
            WebElement drops2 = dropli2.findElement(By.xpath(preselect));
            drops2.click();
            WebElement drop3 = driver.findElement(By.xpath(dodrop));
            drop3.click();
            WebElement dropli3 = action.explicitWait(driver,dodroplist, 120L,"visibilityOfElementLocated");
            WebElement drops3 = dropli3.findElement(By.xpath(dodropselect));
            drops3.click();
            action.inputText(driver, "xpath", claim, "claim field", "field");
            WebElement drop4 = driver.findElement(By.xpath(request));
            drop4.click();
            WebElement dropli4 = action.explicitWait(driver,reqlist, 120L,"visibilityOfElementLocated");
            WebElement drops4 = dropli4.findElement(By.xpath(requestselect));
            drops4.click();
            action.inputText(driver, "xpath", textarea, "textarea field", "field");
            action.click(driver,"xpath",checkb,"checkbox button");
            action.click(driver,"xpath",submit,"sub button");


            //========================================h1 tag dropdown====================================================================


        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }



    }
//==============================================================================================================

}
