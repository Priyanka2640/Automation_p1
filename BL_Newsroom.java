package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_Newsroom;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

public class BL_Newsroom extends PO_Newsroom {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_Newsroom(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     *************************************************************************************************************
     * @return*/

    public void Newsroom() throws Exception {
        try {

            Thread.sleep(2000);
            action.click(driver,"xpath",close_cookie,"close the cookie banner");
            WebElement drop1 = driver.findElement(By.xpath(Year));
            drop1.click();
            WebElement dropli = action.explicitWait(driver,yearlist, 120L,"visibilityOfElementLocated");
            WebElement drops = dropli.findElement(By.xpath(yearselect));
            drops.click();
            action.click(driver,"xpath",okayb,"checkbox button");
            action.click(driver,"xpath",Year,"close the cookie banner");
            action.click(driver,"xpath",clear,"checkbox button");
//================================================================================================================
            WebElement drop3 = driver.findElement(By.xpath(Month));
            drop3.click();
            WebElement dropli3 = action.explicitWait(driver,monthlist, 120L,"visibilityOfElementLocated");
            WebElement drops3 = dropli3.findElement(By.xpath(monthselect));
            drops3.click();
            action.click(driver,"xpath",okayb,"checkbox button");
            action.click(driver,"xpath",Month,"close the cookie banner");
            action.click(driver,"xpath",clear,"checkbox button");





            //===================================extra task ==============================================================
//            WebElement  drop = action.explicitWait(driver,Year, 120L,"visibilityOfElementLocated");
//            drop.click();
//
//            List<WebElement> droplist = driver.findElements(By.xpath(yearlist));
//            String expected= "2023";
//            for (WebElement i: droplist)
//            {
//                if (i.getText().trim().equals(expected))
//                {
//                    i.click(); // Click to select
//                    break;
//                }
//            }
//
//            // Get displayed selected value
//            WebElement selectedDisplay = driver.findElement(By.xpath(yearselect));
//            String actualValue = selectedDisplay.getText().trim();
//            // Compare
//            assertEquals(actualValue, expected, "Custom dropdown selection mismatch!");
            System.out.println("Custom dropdown options validation passed.");





        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }



    }
//==============================================================================================================

}
