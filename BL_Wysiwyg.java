package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_Herohomepage;
import com.metlife.components.pageobjects.PO_Wysiwyg;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BL_Wysiwyg extends PO_Wysiwyg {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_Wysiwyg(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     **************************************************************************************************************/

    public void Wysiwyg() throws Exception {
        try {

            Thread.sleep(2000);

            //=====================================user login========================================================
            action.inputText(driver,"xpath",username,"priyanka.p1@metlife.com","username");
            action.inputText(driver,"xpath",password,"Metlife@123","password");
            action.click(driver,"xpath",btn_submit,"submit");
            //==========================================create page with generic template=============================
            action.click(driver,"xpath",sites,"site icon is clicked");
            action.click(driver,"xpath",btn_create,"Create button");
            action.click(driver,"xpath",create_page,"Create Page");
            action.click(driver,"xpath",Generic_template,"select generic content template");
            action.click(driver,"xpath",btn_next,"click next button");
            //================================================enter title of page======================================
            action.inputText(driver,"xpath",browser_title,"Wysiwygtest","Enter Page title");
            action.inputText(driver,"xpath",page_title,"Wysiwyg","Enter Page title");
            action.click(driver,"xpath",btn_create2,"click create ");
            action.click(driver,"xpath",btn_open,"open page ");
            //=========================================switch to another page =========================================
            action.switchToWindowUsingTitle(driver, "stage");
            Thread.sleep(2000);
            Rerun();
            //=========================================configure the component===========================================
            // action.explicitWait(driver,click_comp, 120L , "visibilityOfElementLocated").click();
            action.click(driver, "xpath", click_comp, "click the component");
            action.click(driver, "xpath", btn_configure, "click configure icon");
            //============================================dropdown ==============================================
            WebElement vari1 = driver.findElement(By.xpath(variation));
            vari1.click();
            WebElement vlist = action.explicitWait(driver,variationlist, 120L , "visibilityOfElementLocated");
            WebElement vcick = vlist.findElement(By.xpath(variationselect));
            vcick.click();
            action.inputText(driver, "xpath", textcontent, "Estimate the amount of monthly income you can expect to receive in retirement and if it will be enough to replace your current paycheck.  the amount of monthly income you can expect to receive in retirement and if it will be enough to replace your current paycheck.", "text content field");
            action.click(driver, "xpath", Done, "save the author page");

            //=================================variation 2=======================================================
            Rerun();
            action.click(driver, "xpath", drag2comp, "click the component");
            action.click(driver, "xpath", btn_configure, "click configure icon");
            //============================================dropdown ==============================================
            WebElement vari2 = driver.findElement(By.xpath(variation));
            vari2.click();
            WebElement vlist2 = action.explicitWait(driver,variationlist, 120L , "visibilityOfElementLocated");
            WebElement vcick2 = vlist2.findElement(By.xpath(variation2));
            vcick2.click();
            action.inputText(driver, "xpath", textcontent, "Estimate the amount of monthly income you can expect to receive in retirement and if it will be enough to replace your current paycheck.  the amount of monthly income you can expect to receive in retirement and if it will be enough to replace your current paycheck.", "text content field");
            action.explicitWait(driver,Done, 120L , "visibilityOfElementLocated").click();
            action.explicitWait(driver,menu, 120L , "visibilityOfElementLocated").click();
            action.explicitWait(driver,publish, 120L , "visibilityOfElementLocated").click();



        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }

        //=============================================================================================================
    }

    public void Rerun() throws Exception
    {
        try {

            Thread.sleep(2000);
            //===================================== select compt from search==========================================
            action.click(driver, "xpath", comp_holder, "click on the overlay");
            action.click(driver, "xpath", add_comp, "click on adding comp icon");
            action.inputText(driver, "xpath", enter_comp, "Wysiwyg", "Enter component name for search");
            action.click(driver, "xpath", select_comp, "wysiwyg select");
            Thread.sleep(2000);
            driver.navigate().refresh();

            } catch (Exception t)
        {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }

    }


}
